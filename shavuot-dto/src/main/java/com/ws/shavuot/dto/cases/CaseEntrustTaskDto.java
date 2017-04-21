package com.ws.shavuot.dto.cases;

import lombok.Data;

import java.util.Date;

/**
 * Created by wangqiliang on 17/4/7.
 */
@Data
public class CaseEntrustTaskDto {
    /**
     * 案件id
     */
    private Long caseEntrustId;

    /**
     *
     */
    private String test01;


    /**
     * 任务id
     */
    private String taskId;


    /**
     * 任务名称
     */
    private String name;


    /**
     * 任务执行者
     */
    private String assignee;


    /**
     * 任务创建时间
     */
    private Date createTime;

    /**
     * 任务到期时间
     */
    private Date dueDate;


}
