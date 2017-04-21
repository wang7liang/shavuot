package com.ws.shavuot.service.impl;


import com.ws.shavuot.dto.TaskDto;
import com.ws.shavuot.service.MyTaskService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by wangqiliang on 17/3/23.
 */
@Service
public class MyTaskServiceImpl implements MyTaskService {
    public static final Logger LOGGER = LoggerFactory.getLogger(MyTaskServiceImpl.class);

    @Resource
    private TaskService taskService;

    @Override
    public List<TaskDto> listTodoTaskByUserId(String userId) {
        List<Task> taskList = taskService.createTaskQuery().taskAssignee(userId).orderByTaskDueDate().list();

        List<TaskDto> taskDtoList = new ArrayList<TaskDto>();
        for(Task task : taskList){
            TaskDto taskDto = new TaskDto();
            taskDto.setTaskId(task.getId());
            taskDto.setTaskName(task.getName());
        }

        return taskDtoList;
    }

    @Override
    public List<TaskDto> listCandidateTaskByUserId(String userId) {
        List<Task> taskList = taskService.createTaskQuery().taskCandidateUser(userId).orderByTaskDueDate().list();

        List<TaskDto> taskDtoList = new ArrayList<TaskDto>();
        for(Task task : taskList){
            TaskDto taskDto = new TaskDto();
            taskDto.setTaskId(task.getId());
            taskDto.setTaskName(task.getName());
        }

        return taskDtoList;
    }

    @Override
    public void claim(String taskId, String userId) {
        taskService.claim(taskId,userId);
    }

    @Override
    public void complete(String taskId,Map<String, Object> variables) {
        taskService.complete(taskId,variables);
    }

}
