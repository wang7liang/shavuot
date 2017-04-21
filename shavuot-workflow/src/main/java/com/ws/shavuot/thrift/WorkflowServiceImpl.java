package com.ws.shavuot.thrift;

import com.ws.shavuot.common.utils.StringUtils;
import com.ws.shavuot.dao.MyIdentitylinkMapper;
import com.ws.shavuot.dao.MyTaskMapper;
import com.ws.shavuot.domain.MyIdentitylink;
import com.ws.shavuot.domain.MyTask;
import com.ws.shavuot.thrift.workflow.CreateTaskStruct;
import com.ws.shavuot.thrift.workflow.ErrorCode;
import com.ws.shavuot.thrift.workflow.IdentitylinkStruct;
import com.ws.shavuot.thrift.workflow.ReturnStruct;
import com.ws.shavuot.thrift.workflow.StartProcessStruct;
import com.ws.shavuot.thrift.workflow.TaskStruct;
import com.ws.shavuot.thrift.workflow.WorkflowException;
import com.ws.shavuot.thrift.workflow.WorkflowService;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by wangqiliang on 17/3/24.
 */
@Component
@Slf4j
public class WorkflowServiceImpl implements WorkflowService.Iface {

    /**
     *
     */
    @Resource
    private IdentityService identityService;

    /**
     *
     */
    @Resource
    private RuntimeService runtimeService;

    /**
     *
     */
    @Resource
    private TaskService taskService;

    /**
     *
     */
    @Resource
    private MyTaskMapper myTaskMapper;

    /**
     *
     */
    @Resource
    private MyIdentitylinkMapper myIdentitylinkMapper;

    @Transactional
    @Override
    public ReturnStruct startProcess(StartProcessStruct startProcessStruct) throws WorkflowException {
        log.info("startProcess开始");

        if (null == startProcessStruct) {
            throw new WorkflowException()
                    .setErrorCode(ErrorCode.EX_1002)
                    .setDescription("startProcess error")
                    .setCaseInfo("startProcessStruct is null");
        }

        log.info("startProcessStruct:{}", startProcessStruct.toString());

        ReturnStruct returnStruct = new ReturnStruct();

        // 取得入参
        String key = startProcessStruct.getKey();
        String businessKey = startProcessStruct.getBusinessKey();
        String userId = startProcessStruct.getUserId();

        // 取得流程变量
        Map<String, Object> variables = new HashMap();
        Map<String, String> map = startProcessStruct.getVariables();
        if (map != null) {
            Set<Map.Entry<String, String>> entries = map.entrySet();
            for (Map.Entry<String, String> entrie : entries) {
                variables.put(entrie.getKey(), entrie.getValue());
            }
        }

        // 设置流程启动人
        if (StringUtils.isNotEmpty(userId)) {
            identityService.setAuthenticatedUserId(userId);
        }

        // 启动流程
        ProcessInstance processInstance = null;
        if (StringUtils.isNotEmpty(businessKey)) {
            processInstance = runtimeService.startProcessInstanceByKey(key, businessKey, variables);
        } else {
            processInstance = runtimeService.startProcessInstanceByKey(key, variables);
        }
        returnStruct.setProcessInstanceId(processInstance.getId());


        // 自定义查询,返回当前任务
        List<MyTask> myTaskList = myTaskMapper.listRuntimeTaskByProcessInstanceId(processInstance.getId());
        List<String> taskIdList = new ArrayList<>();
        List<TaskStruct> taskStructList = new ArrayList<>();
        for (MyTask myTask : myTaskList) {
            TaskStruct taskStruct = new TaskStruct();

            BeanUtils.copyProperties(myTask, taskStruct);

            if (myTask.getCreateTime() != null) {
                taskStruct.setCreateTime(myTask.getCreateTime().getTime());
            }
            if (myTask.getDueDate() != null) {
                taskStruct.setDueDate(myTask.getDueDate().getTime());
            }

            taskStructList.add(taskStruct);
            taskIdList.add(myTask.getId());
        }
        returnStruct.setTaskStructList(taskStructList);


        // 自定义查询，返回关联关系
        List<MyIdentitylink> myIdentitylinkList = myIdentitylinkMapper.listIndentitylinkByTaskId(taskIdList);
        List<IdentitylinkStruct> identitylinkStructList = new ArrayList<>();
        for (MyIdentitylink myIdentitylink : myIdentitylinkList) {
            IdentitylinkStruct identitylinkStruct = new IdentitylinkStruct();
            BeanUtils.copyProperties(myIdentitylink, identitylinkStruct);
            identitylinkStructList.add(identitylinkStruct);
        }
        returnStruct.setIdentitylinkStructList(identitylinkStructList);


        log.info("startProcess结束");

        return returnStruct;
    }

    @Override
    public void suspendProcess(String processInstanceId) throws WorkflowException {
        log.info("suspendProcess开始");
        log.info("processInstanceId:{}", processInstanceId);

        runtimeService.suspendProcessInstanceById(processInstanceId);

        log.info("suspendProcess结束");
    }

    @Override
    public void activateProcess(String processInstanceId) throws WorkflowException {
        log.info("activateProcess开始");
        log.info("processInstanceId:{}", processInstanceId);

        runtimeService.activateProcessInstanceById(processInstanceId);

        log.info("activateProcess结束");
    }

    @Override
    public void claim(String taskId, String userId) throws WorkflowException {
        log.info("claim开始");
        log.info("taskId:{},userId:{}", taskId, userId);

        taskService.claim(taskId, userId);

        log.info("claim结束");
    }

    @Override
    public ReturnStruct complete(String taskId, Map<String, String> map) throws WorkflowException {
        log.info("complete开始");
        log.info("taskId:{}", taskId);
        ReturnStruct returnStruct = new ReturnStruct();

        Task completeTask = taskService.createTaskQuery().taskId(taskId).singleResult();

        // 取得流程变量
        Map<String, Object> variables = new HashMap();
        if (map != null) {
            Set<Map.Entry<String, String>> entries = map.entrySet();
            for (Map.Entry<String, String> entrie : entries) {
                variables.put(entrie.getKey(), entrie.getValue());
            }
        }

        taskService.complete(taskId, variables);


        // 自定义查询,返回当前任务
        List<MyTask> myTaskList = myTaskMapper.listRuntimeTaskByExecutionId(completeTask.getExecutionId());
        List<String> taskIdList = new ArrayList<>();
        List<TaskStruct> taskStructList = new ArrayList<>();
        for (MyTask myTask : myTaskList) {
            TaskStruct taskStruct = new TaskStruct();

            BeanUtils.copyProperties(myTask, taskStruct);

            if (myTask.getCreateTime() != null) {
                taskStruct.setCreateTime(myTask.getCreateTime().getTime());
            }
            if (myTask.getDueDate() != null) {
                taskStruct.setDueDate(myTask.getDueDate().getTime());
            }

            taskStructList.add(taskStruct);
            taskIdList.add(myTask.getId());
        }
        returnStruct.setTaskStructList(taskStructList);


        // 自定义查询，返回关联关系
        List<MyIdentitylink> myIdentitylinkList = new ArrayList<>();
        if (taskIdList.size() > 0) {
            myIdentitylinkList = myIdentitylinkMapper.listIndentitylinkByTaskId(taskIdList);
        }
        List<IdentitylinkStruct> identitylinkStructList = new ArrayList<>();
        for (MyIdentitylink myIdentitylink : myIdentitylinkList) {
            IdentitylinkStruct identitylinkStruct = new IdentitylinkStruct();
            BeanUtils.copyProperties(myIdentitylink, identitylinkStruct);
            identitylinkStructList.add(identitylinkStruct);
        }
        returnStruct.setIdentitylinkStructList(identitylinkStructList);


        log.info("complete结束");

        return returnStruct;
    }

    @Override
    public ReturnStruct createTask(CreateTaskStruct createTaskStruct) throws WorkflowException {
        log.info("createTask开始");

        if (null == createTaskStruct) {
            throw new WorkflowException()
                    .setErrorCode(ErrorCode.EX_1002)
                    .setDescription("createTask error")
                    .setCaseInfo("createTaskStruct is null");
        }

        log.info("createTaskStruct:{}", createTaskStruct.toString());

        ReturnStruct returnStruct = new ReturnStruct();

        // 返回当前任务
        List<String> taskIdList = new ArrayList<>();
        List<TaskStruct> taskStructList = new ArrayList<>();
        List<String> userIdList = createTaskStruct.getUserIds();
        for (String userId : userIdList) {
            Task newTask = taskService.newTask();
            newTask.setAssignee(userId);
            newTask.setName(createTaskStruct.getName());
            newTask.setDueDate(new Date(createTaskStruct.getDueDate()));
            taskService.saveTask(newTask);

            TaskStruct taskStruct = new TaskStruct();
            BeanUtils.copyProperties(newTask, taskStruct);

            if (newTask.getCreateTime() != null) {
                taskStruct.setCreateTime(newTask.getCreateTime().getTime());
            }
            if (newTask.getDueDate() != null) {
                taskStruct.setDueDate(newTask.getDueDate().getTime());
            }

            taskStructList.add(taskStruct);
            taskIdList.add(newTask.getId());
        }
        returnStruct.setTaskStructList(taskStructList);


        // 自定义查询，返回关联关系
        List<MyIdentitylink> myIdentitylinkList = myIdentitylinkMapper.listIndentitylinkByTaskId(taskIdList);
        List<IdentitylinkStruct> identitylinkStructList = new ArrayList<>();
        for (MyIdentitylink myIdentitylink : myIdentitylinkList) {
            IdentitylinkStruct identitylinkStruct = new IdentitylinkStruct();
            BeanUtils.copyProperties(myIdentitylink, identitylinkStruct);
            identitylinkStructList.add(identitylinkStruct);
        }
        returnStruct.setIdentitylinkStructList(identitylinkStructList);


        log.info("createTask结束");

        return returnStruct;

    }


}
