package com.ws.shavuot.controller;

import com.ws.shavuot.common.entity.ReturnMessage;
import com.ws.shavuot.common.utils.ResponseUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by wangqiliang on 17/4/19.
 */
@RestController
public class MqController {


    /**
     * 微服务事务测试
     *
     * @param object Object
     * @return String
     */
    @RequestMapping(value = "/mqReceiver", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> test01(@RequestBody @Valid Object object) {
        String result = "success";

        System.out.println(object.toString());

        return ResponseUtils.OK(new ReturnMessage("kafka消息接收成功"));
    }
}
