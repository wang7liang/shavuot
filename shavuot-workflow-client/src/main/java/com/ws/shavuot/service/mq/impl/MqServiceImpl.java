package com.ws.shavuot.service.mq.impl;

import com.google.gson.Gson;
import com.ws.shavuot.domain.mysql.EventLocalInfo;
import com.ws.shavuot.service.mq.EventLocalInfoService;
import com.ws.shavuot.service.mq.MqService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by wangqiliang on 17/4/19.
 */
@Service
@Transactional(propagation = Propagation.MANDATORY, readOnly = false)
public class MqServiceImpl implements MqService {
    /**
     *
     */
//    @Value("${mq.url}")
//    private String url;

    /**
     *
     */
    @Resource
    private EventLocalInfoService eventLocalInfoService;

    @Override
    public boolean saveLocal(String topic, String message) {

        EventLocalInfo eventLocalInfo = new EventLocalInfo();
        eventLocalInfo.setTopic(topic);
        eventLocalInfo.setMessage(message);

        eventLocalInfoService.insertSelective(eventLocalInfo);

        return true;
    }

    @Override
    public boolean saveLocal(String topic, Object obj) {
        boolean result = false;
        Gson gson = new Gson();
        return saveLocal(topic, gson.toJson(obj));
    }



    @Override
    public boolean sendMessage() {
        boolean result = false;



//        Gson gson = new Gson();
//
//        MqDto mqDto = new MqDto();
//        mqDto.setTopic(TopicConstant.WF_START_TOPIC);
//        mqDto.setMessage(message);
//
//        HttpResponse httpResponse = HttpClientUtil.doPost(url, gson.toJson(mqDto), null);
//        if (httpResponse.getStatusLine().getStatusCode() == 200) {
//            result = true;
//        } else {
//            result = false;
//        }

        return result;
    }
}
