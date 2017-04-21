package com.ws.shavuot.dto.mq;

import lombok.Data;

/**
 * Created by wangqiliang on 17/4/21.
 */
@Data
public class MqDto {
    /**
     *
     */
    private String topic;

    /**
     *
     */
    private String message;

}
