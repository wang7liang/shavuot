package com.ws.shavuot.service.mq;

import com.ws.shavuot.dto.mq.MqDto;

/**
 * Created by wangqiliang on 17/4/21.
 */
public interface MqService {

    /**
     * @param topic   String
     * @param message String
     * @return boolean
     */
    void saveRemote(String topic, String message) throws Exception;


    /**
     *
     * @param mqDto
     * @throws Exception
     */
    void saveRemote(MqDto mqDto) throws Exception;
}
