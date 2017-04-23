package com.ws.shavuot.consumer;

import com.google.gson.Gson;
import com.ws.shavuot.domain.EventDupForbidden;
import com.ws.shavuot.dto.StartProcessDto;
import com.ws.shavuot.service.EventDupForbiddenService;
import com.ws.shavuot.service.MyRuntimeService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * Created by wang7liang on 2017/4/22.
 */
@Component
public class StartProcessConsumer {
    @Resource
    private EventDupForbiddenService eventDupForbiddenService;

    @Resource
    private MyRuntimeService myRuntimeService;

    @KafkaListener(topics = {"test01"})
    public void listen(ConsumerRecord<?, ?> record){
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            String message = (String)kafkaMessage.get();
            System.out.println("listen1 " + message);
            Gson gson = new Gson();

            StartProcessDto startProcessDto = gson.fromJson(message, StartProcessDto.class);
            System.out.println("listen2 " + startProcessDto.toString());

            Map<String,String> map = new HashMap<>();
            map.put("source","startProcess");
            map.put("seq",startProcessDto.getBusinessKey());

            Integer count = eventDupForbiddenService.selectBySelectiveCount(map);
            if(count>0){
                System.out.println("数据已经存在");
            }else{
                // 取得流程变量
                Map<String, Object> variables = new HashMap();
                Map<String, String> m = startProcessDto.getVariables();
                if (m != null) {
                    Set<Map.Entry<String, String>> entries = m.entrySet();
                    for (Map.Entry<String, String> entrie : entries) {
                        variables.put(entrie.getKey(), entrie.getValue());
                    }
                }
                myRuntimeService.startProcessByKeyAndBusinessKey(startProcessDto.getKey(),startProcessDto.getBusinessKey(),variables);

                EventDupForbidden eventDupForbidden = new EventDupForbidden();
                eventDupForbidden.setSource("startProcess");
                eventDupForbidden.setSeq(startProcessDto.getBusinessKey());
                eventDupForbiddenService.insertSelective(eventDupForbidden);
            }
        }
    }
}
