package com.ws.shavuot.controller;

import com.ws.shavuot.common.entity.ReturnMessage;
import com.ws.shavuot.common.utils.ResponseUtils;
import com.ws.shavuot.dto.mq.MqDto;
import com.ws.shavuot.service.mq.EventRemoteInfoService;
import com.ws.shavuot.service.mq.MqService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * Created by wangqiliang on 17/4/19.
 */
@RestController
public class MqController {

    @Resource
    private MqService mqService;

    /**
     *
     * @param mqDto
     * @return
     */
    @RequestMapping(value = "/mqReceiver", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> test01(@RequestBody MqDto mqDto) {
        String result = "success";
        System.out.println(mqDto.toString());

        try {
            mqService.saveRemote(mqDto.getTopic(),mqDto.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseUtils.OK(new ReturnMessage("kafka消息接收成功"));
    }
}
