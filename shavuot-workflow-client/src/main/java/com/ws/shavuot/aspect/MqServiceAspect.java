package com.ws.shavuot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by wangqiliang on 17/4/21.
 */
@Aspect
@Component
public class MqServiceAspect {
//
//    @Pointcut("@annotation(com.ws.shavuot.common.annotation.ts.TsCheck)")
//    public void TsAspect() {
//
//    }
//
//    @AfterReturning(value = "TsAspect()")
//    public void afterTs() {
//
//        System.out.println("事务结束，开始向kafka服务发送消息");
//        int i = 1/0;
//
//        List<Long> ids = MqUtil.getIds();
//        for(Long id: ids){
//            System.out.println(id+",");
//        }
//        MqUtil.clear();
//    }


}
