package com.ws.shavuot.service.mq;

/**
 * Created by wangqiliang on 17/4/21.
 */
public interface MqService {
    /**
     * @param topic   String
     * @param message String
     * @return boolean
     */
    void saveLocal(String topic, String message) throws Exception;

    /**
     * @param topic String
     * @param obj   Object
     * @return boolean
     */
    void saveLocal(String topic, Object obj) throws Exception;

}
