package com.ws.shavuot.domain.mysql;

import lombok.Data;

import java.util.Date;

/**
 * 任务.
 */
@Data
public class WorkflowTask {

    /**
     * 任务id
     */
    private String id;

    /**
     * 执行路径id
     */
    private String executionId;

    /**
     * 流程实例id
     */
    private String processInstanceId;

    /**
     * 流程定义id
     */
    private String processDefinitionId;

    /**
     * 任务名称
     */
    private String name;

    /**
     * 任务描述
     */
    private String description;

    /**
     * 任务定义key
     */
    private String taskDefinitionKey;

    /**
     * 任务拥有者
     */
    private String owner;

    /**
     * 任务执行者
     */
    private String assignee;

    /**
     * 任务优先级
     */
    private Integer priority;

    /**
     * 任务创建时间
     */
    private Date createTime;

    /**
     * 任务到期时间
     */
    private Date dueDate;

    /**
     * 任务完成时间
     */
    private Date endDate;

    /**
     *
     */
    private String category;

    /**
     *
     */
    private String parentTaskId;

    /**
     *
     */
    private String tenantId;

    /**
     *
     */
    private String formKey;

    /**
     * 业务数据id
     */
    private Long businessKey;

}
