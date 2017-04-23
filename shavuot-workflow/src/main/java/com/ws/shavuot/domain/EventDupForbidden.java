package com.ws.shavuot.domain;

import lombok.Data;

import java.util.Date;

/**
* 幂等性记录表
*/
@Data
public class EventDupForbidden {

    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private String source;

    /**
     * 
     */
    private String seq;


}
