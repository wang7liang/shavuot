package com.ws.shavuot.service.workflow;


import com.ws.shavuot.domain.mysql.WorkflowTask;

import java.util.List;
import java.util.Map;

/**
 * Created by wangqiliang on 17/3/31.
 */
public interface WorkflowXxxService {
    /**
     * 发起流程
     *
     * @param key         流程定义key
     * @param businessKey 业务数据id
     * @param userId      流程启动人id
     * @param variables   流程变量

     */
    void startProcess(String key, Long businessKey, String userId, Map<String, String> variables);

}
