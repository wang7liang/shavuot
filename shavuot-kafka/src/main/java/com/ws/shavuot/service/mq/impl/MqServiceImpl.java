package com.ws.shavuot.service.mq.impl;

import com.google.gson.Gson;
import com.ws.shavuot.domain.mysql.EventRemoteInfo;
import com.ws.shavuot.dto.mq.MqDto;
import com.ws.shavuot.service.mq.EventRemoteInfoService;
import com.ws.shavuot.service.mq.MqService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.annotation.Resource;

/**
 * Created by wangqiliang on 17/4/19.
 */
@Service
public class MqServiceImpl implements MqService {

    @Resource
    private EventRemoteInfoService eventRemoteInfoService;

    @Resource
    private KafkaTemplate kafkaTemplate;


    @Override
    public void saveRemote(String topic, String message) throws Exception {
        System.out.println("xx" + TransactionSynchronizationManager.getCurrentTransactionName());

        EventRemoteInfo eventRemoteInfo = new EventRemoteInfo();
        eventRemoteInfo.setTopic(topic);
        eventRemoteInfo.setMessage(message);
        eventRemoteInfo.setStatus("wait");
        eventRemoteInfoService.insertSelective(eventRemoteInfo);


        kafkaTemplate.send(topic,message);
    }

    @Override
    public void saveRemote(MqDto mqDto) throws Exception {
        saveRemote(mqDto.getTopic(),mqDto.getMessage());
    }


}
