package com.ws.shavuot.controller;

import com.ws.shavuot.domain.mysql.CaseEntrust;
import com.ws.shavuot.domain.mysql.WorkflowTask;
import com.ws.shavuot.dto.cases.CaseEntrustTaskDto;
import com.ws.shavuot.dto.cases.ImageTaskDto;
import com.ws.shavuot.service.entrust.CaseEntrustService;
import com.ws.shavuot.service.workflow.WorkflowService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangqiliang on 17/3/23.
 */
@RestController
public class TestWorkflowController {
    /**
     *
     */
    @Resource
    private WorkflowService workflowService;


    /**
     *
     */
    @Resource
    private CaseEntrustService caseEntrustService;


    /**
     * 查询待接任务列表
     *
     * @param request HttpServletRequest
     * @return String
     */
    @RequestMapping("/task/listCandidate")
    public String listCandidate(HttpServletRequest request) {
        String result = "";
        String userId = request.getParameter("userId");
        Map<String, String> map = new HashMap<>();
        map.put("userId", userId);
        List<CaseEntrustTaskDto> caseEntrustTaskDtos = caseEntrustService.listCandidateTaskByUserId(map);
        for (CaseEntrustTaskDto caseEntrustTaskDto : caseEntrustTaskDtos) {
            result += caseEntrustTaskDto.toString();
        }

        return result;
    }


    /**
     * 查询待办任务列表
     *
     * @param request HttpServletRequest
     * @return String
     */
    @RequestMapping("/task/listTodo")
    public String listTodo(HttpServletRequest request) {
        String result = "";
        String userId = request.getParameter("userId");
        Map<String, String> map = new HashMap<>();
        map.put("userId", userId);
        List<CaseEntrustTaskDto> caseEntrustTaskDtos = caseEntrustService.listTodoTaskByUserId(map);
        for (CaseEntrustTaskDto caseEntrustTaskDto : caseEntrustTaskDtos) {
            result += caseEntrustTaskDto.toString();
        }

        return result;
    }

    /**
     * 查询待办任务列表(排除超时任务)
     *
     * @param request HttpServletRequest
     * @return String
     */
    @RequestMapping("/task/listTodoExcludeOvertime")
    public String listTodoExcludeOvertime(HttpServletRequest request) {
        String result = "";
        String userId = request.getParameter("userId");
        Map<String, String> map = new HashMap<>();
        map.put("userId", userId);
        List<CaseEntrustTaskDto> caseEntrustTaskDtos = caseEntrustService.listTodoTaskExcludeOvertimeTaskByUserId(map);
        for (CaseEntrustTaskDto caseEntrustTaskDto : caseEntrustTaskDtos) {
            result += caseEntrustTaskDto.toString();
        }

        return result;
    }

    /**
     * 查询超时任务列表
     *
     * @param request HttpServletRequest
     * @return String
     */
    @RequestMapping("/task/listOvertime")
    public String listOvertime(HttpServletRequest request) {
        String result = "";
        String userId = request.getParameter("userId");
        Map<String, String> map = new HashMap<>();
        map.put("userId", userId);
        List<CaseEntrustTaskDto> caseEntrustTaskDtos = caseEntrustService.listOvertimeTaskByUserId(map);
        for (CaseEntrustTaskDto caseEntrustTaskDto : caseEntrustTaskDtos) {
            result += caseEntrustTaskDto.toString();
        }

        return result;
    }

    /**
     * 认领任务
     *
     * @param request HttpServletRequest
     * @return String
     */
    @RequestMapping("/task/claim")
    public String claim(HttpServletRequest request) {
        String result = "";

        String taskId = request.getParameter("taskId");
        String userId = request.getParameter("userId");
        workflowService.claim(taskId, userId);

        Map<String, String> map = new HashMap<>();
        map.put("userId", userId);

        List<CaseEntrustTaskDto> caseEntrustTaskDtos = caseEntrustService.listCandidateTaskByUserId(map);
        for (CaseEntrustTaskDto caseEntrustTaskDto : caseEntrustTaskDtos) {
            result += caseEntrustTaskDto.toString();
        }

        return result;
    }

    /**
     * 完成任务
     *
     * @param request HttpServletRequest
     * @return String
     */
    @RequestMapping("/task/complete")
    public String complete(HttpServletRequest request) {
        String result = "";

        String userId = request.getParameter("userId");
        String taskId = request.getParameter("taskId");
        workflowService.complete(taskId, null);


        Map<String, String> map = new HashMap<>();
        map.put("userId", userId);
        List<CaseEntrustTaskDto> caseEntrustTaskDtos = caseEntrustService.listTodoTaskByUserId(map);
        for (CaseEntrustTaskDto caseEntrustTaskDto : caseEntrustTaskDtos) {
            result += caseEntrustTaskDto.toString();
        }

        return result;

    }

    /**
     * 完成任务
     *
     * @param request HttpServletRequest
     * @return String
     */
    @RequestMapping("/task/create")
    public String create(HttpServletRequest request) {
        String result = "";

        String userId1 = request.getParameter("userId1");
        String userId2 = request.getParameter("userId2");
        String taskName = request.getParameter("taskName");
        Long businessKey = Long.valueOf(request.getParameter("businessKey"));
        Long dueDate = new Date().getTime();

        List<String> userIds = new ArrayList<>();
        userIds.add(userId1);
        userIds.add(userId2);
        workflowService.create(userIds, taskName, dueDate, businessKey);


        Map<String, String> map = new HashMap<>();
        map.put("userId", userId1);
        List<CaseEntrustTaskDto> caseEntrustTaskDtos = caseEntrustService.listTodoTaskByUserId(map);
        for (CaseEntrustTaskDto caseEntrustTaskDto : caseEntrustTaskDtos) {
            result += caseEntrustTaskDto.toString();
        }

        return result;

    }


    /**
     * 查看任务
     *
     * @param request HttpServletRequest
     * @return String
     */
    @RequestMapping("/task/status")
    public String taskStatus(HttpServletRequest request) {
        String result = "";

        String userId = request.getParameter("userId");
        String taskId = request.getParameter("taskId");
        WorkflowTask workflowTask = workflowService.getWorkflowTaskById(taskId);

        result += workflowTask.toString();

        return result;

    }


    /**
     * 启动流程
     *
     * @return String
     */
    @RequestMapping("/process/startProcess")
    public String startProcess() {
        CaseEntrust caseEntrust = new CaseEntrust();
        caseEntrust.setTest01("案件:" + new Date().toLocaleString());
        caseEntrustService.insertSelective(caseEntrust);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        Map<String, String> variables = new HashMap<>();
        variables.put("v1", "value1");
        variables.put("v2", "value2");
        variables.put("v3", "value3");
        variables.put("receivingCaseDueDate", sdf.format(new Date()));

        caseEntrustService.startCaseEntrustProcess(caseEntrust.getId(), "sys", variables);

        return "success";
    }


    /**
     * 挂起流程
     *
     * @param request HttpServletRequest
     * @return String
     */
    @RequestMapping("/process/suspend")
    public String suspend(HttpServletRequest request) {

        String processInstanceId = request.getParameter("processInstanceId");
        workflowService.suspendProcess(processInstanceId);

        return "success";
    }


    /**
     * 恢复流程
     *
     * @param request HttpServletRequest
     * @return String
     */
    @RequestMapping("/process/activate")
    public String activate(HttpServletRequest request) {

        String processInstanceId = request.getParameter("processInstanceId");
        workflowService.activateProcess(processInstanceId);

        return "success";
    }


    /**
     * 查看流程已完成任务
     *
     * @param request HttpServletRequest
     * @return String
     */
    @RequestMapping("/process/completeTask")
    public String completeTask(HttpServletRequest request) {
        String result = "";

        String businessKey = request.getParameter("businessKey");
        List<WorkflowTask> workflowTaskList = workflowService.selectCompleteTaskByBusinessKey(businessKey);
        for (WorkflowTask workflowTask : workflowTaskList) {
            result += workflowTask.toString();
        }


        return result;

    }

    /**
     * 查看流程未完成任务
     *
     * @param request HttpServletRequest
     * @return String
     */
    @RequestMapping("/process/notCompleteTask")
    public String notCompleteTask(HttpServletRequest request) {
        String result = "";

        String businessKey = request.getParameter("businessKey");
        List<WorkflowTask> workflowTaskList = workflowService.selectNotCompleteTaskByBusinessKey(businessKey);
        for (WorkflowTask workflowTask : workflowTaskList) {
            result += workflowTask.toString();
        }


        return result;

    }

    /**
     * 查看流程图列表
     *
     * @param request HttpServletRequest
     * @return String
     */
    @RequestMapping("/process/listImageTask")
    public String listImageTask(HttpServletRequest request) {
        String result = "";

        Long businessKey = Long.valueOf(request.getParameter("businessKey"));
        List<ImageTaskDto> imageTaskDtoList = caseEntrustService.listProcessImage(businessKey);

        for (ImageTaskDto imageTaskDto : imageTaskDtoList) {
            result += imageTaskDto.toString();
        }

        return result;

    }


}
