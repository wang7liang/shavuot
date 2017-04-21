package com.ws.shavuot.service.workflow.impl;

import com.wealoha.thrift.ThriftClient;
import com.wealoha.thrift.ThriftClientPool;
import com.ws.shavuot.common.exception.ExceptionStatus;
import com.ws.shavuot.common.exception.ProcessorException;
import com.ws.shavuot.common.utils.DateUtils;
import com.ws.shavuot.dao.mysql.WorkflowIdentitylinkMapper;
import com.ws.shavuot.dao.mysql.WorkflowTaskMapper;
import com.ws.shavuot.domain.mysql.WorkflowIdentitylink;
import com.ws.shavuot.domain.mysql.WorkflowTask;
import com.ws.shavuot.service.workflow.WorkflowService;
import com.ws.shavuot.thrift.workflow.CreateTaskStruct;
import com.ws.shavuot.thrift.workflow.IdentitylinkStruct;
import com.ws.shavuot.thrift.workflow.ReturnStruct;
import com.ws.shavuot.thrift.workflow.StartProcessStruct;
import com.ws.shavuot.thrift.workflow.TaskStruct;
import com.ws.shavuot.thrift.workflow.WorkflowException;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangqiliang on 17/4/1.
 */
@Service
@Slf4j
public class WorkflowServiceImpl implements WorkflowService {

    /**
     *
     */
    @Resource
    private WorkflowTaskMapper workflowTaskMapper;

    /**
     *
     */
    @Resource
    private WorkflowIdentitylinkMapper workflowIdentitylinkMapper;

    /**
     *
     */
    @Resource(name = "thriftClient1Pool")
    private ThriftClientPool<com.ws.shavuot.thrift.workflow.WorkflowService.Client> thriftClient1Pool;


    @Transactional
    @Override
    public String startProcess(String key, Long businessKey, String userId, Map<String, String> variables) {
        log.info("");
        String processInstanceId = "";

        try (ThriftClient<com.ws.shavuot.thrift.workflow.WorkflowService.Client> client = thriftClient1Pool.getClient()) {
            com.ws.shavuot.thrift.workflow.WorkflowService.Iface iFace = client.iFace();

            // 设置入参
            StartProcessStruct startProcessStruct = new StartProcessStruct();
            startProcessStruct.setKey("caseEntrustProcess");
            startProcessStruct.setBusinessKey(String.valueOf(businessKey));
            startProcessStruct.setUserId(userId);
            startProcessStruct.setVariables(variables);

            // 取得返回值
            ReturnStruct returnStruct = iFace.startProcess(startProcessStruct);
            processInstanceId = returnStruct.getProcessInstanceId();

            // 取得任务列表
            List<TaskStruct> taskStructList = returnStruct.getTaskStructList();
            for (TaskStruct taskStruct : taskStructList) {
                WorkflowTask workflowTask = new WorkflowTask();

                BeanUtils.copyProperties(taskStruct, workflowTask);
                if (taskStruct.getCreateTime() != 0) {
                    workflowTask.setCreateTime(new Date(taskStruct.getCreateTime()));
                }
                if (taskStruct.getDueDate() != 0) {
                    workflowTask.setDueDate(new Date(taskStruct.getDueDate()));
                }
                workflowTask.setBusinessKey(Long.valueOf(taskStruct.getBusinessKey()));

                workflowTaskMapper.insertSelective(workflowTask);
            }

            // 取得关系列表
            List<IdentitylinkStruct> identitylinkStructList = returnStruct.getIdentitylinkStructList();
            for (IdentitylinkStruct identitylinkStruct : identitylinkStructList) {
                WorkflowIdentitylink workflowIdentitylink = new WorkflowIdentitylink();

                BeanUtils.copyProperties(identitylinkStruct, workflowIdentitylink);

                workflowIdentitylinkMapper.insertSelective(workflowIdentitylink);
            }

            //finish must be called at last
            client.finish();
        } catch (WorkflowException e) {
            e.printStackTrace();
            log.error(e.getDescription());
            log.error(e.getCaseInfo());
        } catch (TException e) {
            e.printStackTrace();
            throw new ProcessorException(ExceptionStatus.EX_2001);
        }

        log.info("");
        return processInstanceId;
    }

    @Override
    public void suspendProcess(String processInstanceId) {
        log.info("");

        try (ThriftClient<com.ws.shavuot.thrift.workflow.WorkflowService.Client> client = thriftClient1Pool.getClient()) {
            com.ws.shavuot.thrift.workflow.WorkflowService.Iface iFace = client.iFace();

            // 取得返回值
            iFace.suspendProcess(processInstanceId);

            //finish must be called at last
            client.finish();
        } catch (WorkflowException e) {
            e.printStackTrace();
            log.error(e.getDescription());
            log.error(e.getCaseInfo());
        } catch (TException e) {
            e.printStackTrace();
            throw new ProcessorException(ExceptionStatus.EX_2001);
        }

        log.info("");
    }

    @Override
    public void activateProcess(String processInstanceId) {
        log.info("");

        try (ThriftClient<com.ws.shavuot.thrift.workflow.WorkflowService.Client> client = thriftClient1Pool.getClient()) {
            com.ws.shavuot.thrift.workflow.WorkflowService.Iface iFace = client.iFace();

            // 取得返回值
            iFace.activateProcess(processInstanceId);

            //finish must be called at last
            client.finish();
        } catch (WorkflowException e) {
            e.printStackTrace();
            log.error(e.getDescription());
            log.error(e.getCaseInfo());
        } catch (TException e) {
            e.printStackTrace();
            throw new ProcessorException(ExceptionStatus.EX_2001);
        }

        log.info("");
    }

    @Transactional
    @Override
    public void claim(String taskId, String userId) {
        log.info("");

        try (ThriftClient<com.ws.shavuot.thrift.workflow.WorkflowService.Client> client = thriftClient1Pool.getClient()) {
            com.ws.shavuot.thrift.workflow.WorkflowService.Iface iFace = client.iFace();

            iFace.claim(taskId, userId);

            // 设置任务执行者
            WorkflowTask workflowTask = new WorkflowTask();
            workflowTask.setId(taskId);
            workflowTask.setAssignee(userId);
            workflowTaskMapper.updateByPrimaryKeySelective(workflowTask);

            //finish must be called at last
            client.finish();
        } catch (WorkflowException e) {
            e.printStackTrace();
            log.error(e.getDescription());
            log.error(e.getCaseInfo());
        } catch (TException e) {
            e.printStackTrace();
            throw new ProcessorException(ExceptionStatus.EX_2001);
        }

        log.info("");
    }

    @Transactional
    @Override
    public void complete(String taskId, Map<String, String> variables) {
        log.info("");

        try (ThriftClient<com.ws.shavuot.thrift.workflow.WorkflowService.Client> client = thriftClient1Pool.getClient()) {
            com.ws.shavuot.thrift.workflow.WorkflowService.Iface iFace = client.iFace();

            ReturnStruct returnStruct = iFace.complete(taskId, variables);

            // 取得任务列表
            List<TaskStruct> taskStructList = returnStruct.getTaskStructList();
            for (TaskStruct taskStruct : taskStructList) {
                WorkflowTask workflowTask = new WorkflowTask();
                BeanUtils.copyProperties(taskStruct, workflowTask);
                if (taskStruct.getCreateTime() != 0) {
                    workflowTask.setCreateTime(new Date(taskStruct.getCreateTime()));
                }
                if (taskStruct.getDueDate() != 0) {
                    workflowTask.setDueDate(new Date(taskStruct.getDueDate()));
                }
                workflowTask.setBusinessKey(Long.valueOf(taskStruct.getBusinessKey()));

                workflowTaskMapper.insertSelective(workflowTask);


            }

            //  取得关系列表
            List<IdentitylinkStruct> identitylinkStructList = returnStruct.getIdentitylinkStructList();
            for (IdentitylinkStruct identitylinkStruct : identitylinkStructList) {
                WorkflowIdentitylink workflowIdentitylink = new WorkflowIdentitylink();
                BeanUtils.copyProperties(identitylinkStruct, workflowIdentitylink);

                workflowIdentitylinkMapper.insertSelective(workflowIdentitylink);
            }


            // 设置结束时间
            WorkflowTask workflowTask = new WorkflowTask();
            workflowTask.setId(taskId);
            workflowTask.setEndDate(DateUtils.getCurrentTime());
            workflowTaskMapper.updateByPrimaryKeySelective(workflowTask);

            //finish must be called at last
            client.finish();
        } catch (WorkflowException e) {
            e.printStackTrace();
            log.error(e.getDescription());
            log.error(e.getCaseInfo());
        } catch (TException e) {
            e.printStackTrace();
            throw new ProcessorException(ExceptionStatus.EX_2001);
        }

        log.info("");
    }

    @Override
    public void create(List<String> userIds, String name, Long dueDate, Long businessKey) {
        log.info("");

        try (ThriftClient<com.ws.shavuot.thrift.workflow.WorkflowService.Client> client = thriftClient1Pool.getClient()) {
            com.ws.shavuot.thrift.workflow.WorkflowService.Iface iFace = client.iFace();

            CreateTaskStruct createTaskStruct = new CreateTaskStruct();
            createTaskStruct.setUserIds(userIds);
            createTaskStruct.setName(name);
            createTaskStruct.setDueDate(dueDate);

            ReturnStruct returnStruct = iFace.createTask(createTaskStruct);

            // 取得任务列表
            List<TaskStruct> taskStructList = returnStruct.getTaskStructList();
            for (TaskStruct taskStruct : taskStructList) {
                WorkflowTask workflowTask = new WorkflowTask();
                BeanUtils.copyProperties(taskStruct, workflowTask);
                if (taskStruct.getCreateTime() != 0) {
                    workflowTask.setCreateTime(new Date(taskStruct.getCreateTime()));
                }
                if (taskStruct.getDueDate() != 0) {
                    workflowTask.setDueDate(new Date(taskStruct.getDueDate()));
                }
                workflowTask.setBusinessKey(businessKey);

                workflowTaskMapper.insertSelective(workflowTask);


            }

            //  取得关系列表
            List<IdentitylinkStruct> identitylinkStructList = returnStruct.getIdentitylinkStructList();
            for (IdentitylinkStruct identitylinkStruct : identitylinkStructList) {
                WorkflowIdentitylink workflowIdentitylink = new WorkflowIdentitylink();
                BeanUtils.copyProperties(identitylinkStruct, workflowIdentitylink);

                workflowIdentitylinkMapper.insertSelective(workflowIdentitylink);
            }


            //finish must be called at last
            client.finish();
        } catch (WorkflowException e) {
            e.printStackTrace();
            log.error(e.getDescription());
            log.error(e.getCaseInfo());
        } catch (TException e) {
            e.printStackTrace();
            throw new ProcessorException(ExceptionStatus.EX_2001);
        }

        log.info("");
    }

    @Override
    public WorkflowTask getWorkflowTaskById(String taskId) {
        WorkflowTask workflowTask = workflowTaskMapper.selectByPrimaryKey(taskId);
        return workflowTask;
    }

    @Override
    public List<WorkflowTask> selectCompleteTaskByBusinessKey(String businessKey) {
        Map<String, String> map = new HashMap();
        map.put("businessKey", businessKey);
        List<WorkflowTask> workflowTaskList = workflowTaskMapper.selectCompleteTaskByBusinessKey(map);
        return workflowTaskList;
    }

    @Override
    public List<WorkflowTask> selectNotCompleteTaskByBusinessKey(String businessKey) {
        Map<String, String> map = new HashMap();
        map.put("businessKey", businessKey);
        List<WorkflowTask> workflowTaskList = workflowTaskMapper.selectNotCompleteTaskByBusinessKey(map);
        return workflowTaskList;
    }
}
