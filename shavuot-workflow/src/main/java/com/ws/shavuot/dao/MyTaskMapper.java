package com.ws.shavuot.dao;

import com.ws.shavuot.domain.MyTask;

import java.util.List;

/**
 * Created by wangqiliang on 17/3/27.
 */
public interface MyTaskMapper {

    /**
     * 根据流程实例id，返回存活任务
     * @param processInstanceId String
     * @return List
     */
    List<MyTask> listRuntimeTaskByProcessInstanceId(String processInstanceId);


    /**
     * 根据执行路径id，返回存活任务
     * @param executionId String
     * @return List
     */
    List<MyTask> listRuntimeTaskByExecutionId(String executionId);
}
