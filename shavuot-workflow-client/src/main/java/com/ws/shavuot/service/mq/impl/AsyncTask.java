package com.ws.shavuot.service.mq.impl;

import com.google.gson.Gson;
import com.ws.shavuot.aspect.MqUtil;
import com.ws.shavuot.common.constants.TopicConstant;
import com.ws.shavuot.common.utils.HttpClientUtil;
import com.ws.shavuot.domain.mysql.EventLocalInfo;
import com.ws.shavuot.dto.mq.MqDto;
import com.ws.shavuot.service.mq.EventLocalInfoService;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wang7liang on 2017/4/22.
 */
@Component
public class AsyncTask {

    @Resource
    private EventLocalInfoService eventLocalInfoService;

    /**
     *
     */
    @Value("${mq.url}")
    private String url;

    @Async("myAsync")
    public void sendMessage(List<Long> ids) throws Exception {
        // 这个方法不需要事务，可分为3种情况
        // 1.kafka服务器成功返回，设置本地事件表数据状态为complete
        // 2.kafka服务器成功返回，本地失败
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("新线程");

        // 应为定时与此方法可能同时在不同线程操作相同数据，对数据的操作采用乐观锁
        Gson gson = new Gson();
        for (Long id : ids) {
            try {
                EventLocalInfo eventLocalInfo = eventLocalInfoService.selectByPrimaryKey(id);

                MqDto mqDto = new MqDto();
                mqDto.setTopic(eventLocalInfo.getTopic());
                mqDto.setMessage(eventLocalInfo.getMessage());

                HttpResponse httpResponse = HttpClientUtil.doPost(url, gson.toJson(mqDto), null);
                if (httpResponse.getStatusLine().getStatusCode() != 200) {
                    throw new Exception("向kafka传送事件失败");
                } else {
                    eventLocalInfo.setStatus("complete");
                    eventLocalInfoService.updateByPrimaryKeySelective(eventLocalInfo);
                }
            }catch (Exception e){
                e.printStackTrace();
                continue;
            }
        }

    }
}
