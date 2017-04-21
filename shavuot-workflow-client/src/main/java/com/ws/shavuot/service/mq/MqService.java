package com.ws.shavuot.service.mq;

/**
 * Created by wangqiliang on 17/4/21.
 */
public interface MqService {
    /**
     * @param topic String
     * @param message String
     * @return boolean
     */
    boolean saveLocal(String topic, String message);

    /**
     *
     * @param topic String
     * @param obj Object
     * @return boolean
     */
    boolean saveLocal(String topic, Object obj);


    boolean sendMessage();
}
