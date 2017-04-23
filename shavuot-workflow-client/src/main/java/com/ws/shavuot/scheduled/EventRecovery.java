package com.ws.shavuot.scheduled;

import com.google.gson.Gson;
import com.ws.shavuot.common.utils.HttpClientUtil;
import com.ws.shavuot.domain.mysql.EventLocalInfo;
import com.ws.shavuot.dto.mq.MqDto;
import com.ws.shavuot.service.mq.EventLocalInfoService;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wang7liang on 2017/4/23.
 */
@Component
public class EventRecovery {
    @Value("${mq.url}")
    private String url;

    @Resource
    private EventLocalInfoService eventLocalInfoService;

    @Scheduled(fixedDelay=5000)
    //@Scheduled(fixedRate=5000)
    public void executeEventRecoveryTask(){

        // 间隔2分钟,执行本地事件恢复任务
        Thread current = Thread.currentThread();
        System.out.println("定时任务1:"+current.getId());

        // 查询重试次数小于最大重试次数的数据
        Map<String,String> map = new HashMap<>();
        map.put("status","wait");
        List<EventLocalInfo> eventLocalInfos = eventLocalInfoService.selectBySelective(map);

        Gson gson = new Gson();
        for (EventLocalInfo eventLocalInfo : eventLocalInfos) {
            try {
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
                // 在此处应该增加重试次数，并记录错误原因
                e.printStackTrace();
                continue;
            }
        }
    }
}
