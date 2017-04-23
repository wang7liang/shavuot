package com.ws.shavuot.service.impl;


import com.ws.shavuot.service.MyRuntimeService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by macmini-g1hw on 17/3/7.
 */
@Service
public class MyRuntimeServiceImpl implements MyRuntimeService {
    public static final Logger LOGGER = LoggerFactory.getLogger(MyRuntimeServiceImpl.class);

    @Resource
    private RuntimeService runtimeService;
    @Resource
    private TaskService taskService;

    @Override
    public void startProcessByKey(String key, Map<String,Object> variables) {
        LOGGER.info("开始根据key{"+key+"}启动流程");
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(key, variables);
        LOGGER.info("结束根据key{"+key+"}启动流程");
    }

    @Override
    public void startProcessByKeyAndBusinessKey(String key, String businessKey, Map<String, Object> variables) {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(key, businessKey, variables);
    }
}


