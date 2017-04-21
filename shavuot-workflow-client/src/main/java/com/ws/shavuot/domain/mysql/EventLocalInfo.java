package com.ws.shavuot.domain.mysql;

import lombok.Data;
import java.util.Date;
/**
* 本地事件.
*/
@Data
public class EventLocalInfo {

    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private String topic;

    /**
     * 
     */
    private String message;

    /**
     * 
     */
    private String status;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 
     */
    private Long createBy;

    /**
     * 
     */
    private Long updateBy;

    /**
     * 
     */
    private String remark;

}
