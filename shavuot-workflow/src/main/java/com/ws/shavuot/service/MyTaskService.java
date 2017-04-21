package com.ws.shavuot.service;

import com.ws.shavuot.dto.TaskDto;

import java.util.List;
import java.util.Map;

/**
 * Created by wangqiliang on 17/3/23.
 */
public interface MyTaskService {

    List<TaskDto> listTodoTaskByUserId(String userId);

    List<TaskDto> listCandidateTaskByUserId(String userId);

    public void claim(String taskId, String userId);

    public void complete(String taskId,Map<String, Object> variables);
}
