package com.ws.shavuot.controller;

import com.ws.shavuot.service.workflow.WorkflowXxxService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangqiliang on 17/4/19.
 */
@RestController
public class TestController {

    /**
     *
     */
    @Resource
    private WorkflowXxxService workflowXxxService;


    /**
     * 微服务事务测试
     *
     * @param request HttpServletRequest
     * @return String
     */
    @RequestMapping("/test01")
    public String test01(HttpServletRequest request) {
        String result = "success";
        hello("wang7liang");
        Map<String, String> map = new HashMap<>();
        map.put("t1", "t1");
        map.put("t2", "t2");
        long id = 11;
        workflowXxxService.startProcess("aa", id, "wang", map);

        return result;
    }

    /**
     * @param name String
     * @return String
     */
    public String hello(String name) {
        return "hello " + name;
    }
}
