package com.ws.shavuot.service.workflow.impl;

import com.ws.shavuot.common.annotation.ts.TsCheck;
import com.ws.shavuot.common.constants.TopicConstant;
import com.ws.shavuot.dto.workflow.StartProcessDto;
import com.ws.shavuot.service.mq.MqService;
import com.ws.shavuot.service.workflow.WorkflowXxxService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by wangqiliang on 17/4/1.
 */
@Service
@Slf4j
public class WorkflowXxxServiceImpl implements WorkflowXxxService {

    /**
     *
     */
    @Resource
    private MqService mqService;

    @Transactional
    @Override
    public void startProcess(String key, Long businessKey, String userId, Map<String, String> variables) throws Exception {
        System.out.println("name02"+ TransactionSynchronizationManager.getCurrentTransactionName());

        // 调用服务1
        StartProcessDto startProcessDto = new StartProcessDto();
        startProcessDto.setKey("caseEntrustProcess");
        startProcessDto.setBusinessKey(String.valueOf(businessKey));
        startProcessDto.setUserId(userId);
        startProcessDto.setVariables(variables);
        mqService.saveLocal(TopicConstant.WF_START_TOPIC, startProcessDto);

        // 调用服务2
        startProcessDto = new StartProcessDto();
        startProcessDto.setKey("xxx");
        startProcessDto.setBusinessKey(String.valueOf(businessKey));
        startProcessDto.setUserId(userId);
        startProcessDto.setVariables(variables);
        mqService.saveLocal(TopicConstant.WF_START_TOPIC, startProcessDto);

        // 调用服务3
        startProcessDto = new StartProcessDto();
        startProcessDto.setKey("yyy");
        startProcessDto.setBusinessKey(String.valueOf(businessKey));
        startProcessDto.setUserId(userId);
        startProcessDto.setVariables(variables);
        mqService.saveLocal(TopicConstant.WF_START_TOPIC, startProcessDto);
    }
}
