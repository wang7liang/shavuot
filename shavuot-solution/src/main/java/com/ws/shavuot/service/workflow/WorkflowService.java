package com.ws.shavuot.service.workflow;


import com.ws.shavuot.domain.mysql.WorkflowTask;

import java.util.List;
import java.util.Map;

/**
 * Created by wangqiliang on 17/3/31.
 */
public interface WorkflowService {

    /**
     * 发起流程
     *
     * @param key         流程定义key
     * @param businessKey 业务数据id
     * @param userId      流程启动人id
     * @param variables   流程变量
     * @return 流程实例id
     */
    String startProcess(String key, Long businessKey, String userId, Map<String, String> variables);


    /**
     * 挂起流程
     *
     * @param processInstanceId 流程实例id
     */
    void suspendProcess(String processInstanceId);

    /**
     * 恢复流程
     *
     * @param processInstanceId 流程实例id
     */
    void activateProcess(String processInstanceId);

    /**
     * 认领任务
     *
     * @param taskId 任务id
     * @param userId 用户id
     */
    void claim(String taskId, String userId);


    /**
     * 完成任务
     *
     * @param taskId    任务id
     * @param variables 流程变量
     */
    void complete(String taskId, Map<String, String> variables);


    /**
     * 创建任务
     *
     * @param userIds     用户id
     * @param name        任务名称
     * @param dueDate     到期时间
     * @param businessKey 业务数据id
     */
    void create(List<String> userIds, String name, Long dueDate, Long businessKey);


    /**
     * 查询任务
     *
     * @param taskId 任务id
     * @return WorkflowTask 任务
     */
    WorkflowTask getWorkflowTaskById(String taskId);


    /**
     * 根据业务id查询已完成任务列表
     *
     * @param businessKey 业务数据id
     * @return List 任务列表
     */
    List<WorkflowTask> selectCompleteTaskByBusinessKey(String businessKey);


    /**
     * 根据业务id查询未完成任务列表
     *
     * @param businessKey 业务数据id
     * @return List 任务列表
     */
    List<WorkflowTask> selectNotCompleteTaskByBusinessKey(String businessKey);

}
