package com.ws.shavuot.service;

import java.util.Map;

/**
 * Created by wangqiliang on 17/3/23.
 */
public interface MyRuntimeService {
    // 根据流程定义key启动流程
    public void startProcessByKey(String key, Map<String, Object> variables);

    // 根据流程定义key与业务key启动流程
    public void startProcessByKeyAndBusinessKey(String key, String businessKey, Map<String, Object> variables);
}
