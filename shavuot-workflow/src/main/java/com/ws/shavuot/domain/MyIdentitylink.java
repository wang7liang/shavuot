package com.ws.shavuot.domain;

import lombok.Data;

/**
 * 身份关系.
 */
@Data
public class MyIdentitylink {

    /**
     *
     */
    private String id;

    /**
     *
     */
    private Integer rev;

    /**
     *
     */
    private String groupId;

    /**
     *
     */
    private String type;

    /**
     *
     */
    private String userId;

    /**
     *
     */
    private String taskId;

    /**
     *
     */
    private String processInstanceId;

    /**
     *
     */
    private String processDefinitionId;

}
