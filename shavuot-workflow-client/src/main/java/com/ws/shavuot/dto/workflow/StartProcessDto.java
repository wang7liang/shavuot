package com.ws.shavuot.dto.workflow;

import lombok.Data;

import java.util.Map;

/**
 * Created by wangqiliang on 17/4/21.
 */
@Data
public class StartProcessDto {
    /**
     *
     */
    private String key; // required

    /**
     *
     */
    private String userId; // optional

    /**
     *
     */
    private String businessKey; // optional

    /**
     *
     */
    private Map<String, String> variables; // optional
}
