package com.ws.shavuot.service.mq.impl;

import com.google.gson.Gson;
import com.ws.shavuot.aspect.MqUtil;
import com.ws.shavuot.domain.mysql.EventLocalInfo;
import com.ws.shavuot.service.mq.EventLocalInfoService;
import com.ws.shavuot.service.mq.MqService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wangqiliang on 17/4/19.
 */
@Service
public class MqServiceImpl implements MqService {

    /**
     *
     */
    @Resource
    private EventLocalInfoService eventLocalInfoService;

    @Resource
    private AsyncTask asyncTask;

    @Override
    @Transactional(propagation = Propagation.MANDATORY, readOnly = false)
    public void saveLocal(String topic, String message) throws Exception {
        System.out.println("xx" + TransactionSynchronizationManager.getCurrentTransactionName());
        EventLocalInfo eventLocalInfo = new EventLocalInfo();
        eventLocalInfo.setTopic(topic);
        eventLocalInfo.setMessage(message);
        eventLocalInfo.setStatus("wait");
        eventLocalInfoService.insertSelective(eventLocalInfo);

        MqUtil.putId(eventLocalInfo.getId());
        MqUtil.putTsa(new TransactionSynchronizationAdapter() {

            @Override
            public void afterCommit() {
                System.out.println("本地事务存储结束,开启新线程发送事件");
                System.out.println(TransactionSynchronizationManager.getCurrentTransactionName());

                List<Long> ids = MqUtil.getIds();
                try {
                    asyncTask.sendMessage(ids);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                MqUtil.clearIds();
                MqUtil.clearTsa();
            }
        });

        TransactionSynchronizationManager.registerSynchronization(MqUtil.getTsa());
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY, readOnly = false)
    public void saveLocal(String topic, Object obj) throws Exception {
        boolean result = false;
        Gson gson = new Gson();
        saveLocal(topic, gson.toJson(obj));
    }

}
