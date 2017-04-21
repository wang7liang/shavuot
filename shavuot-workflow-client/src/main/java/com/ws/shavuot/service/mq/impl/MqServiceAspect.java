package com.ws.shavuot.service.mq.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by wangqiliang on 17/4/21.
 */
@Aspect
@Component
public class MqServiceAspect {
    public MqServiceAspect() {
        System.out.println("aaaaa");
    }

    @Pointcut("@annotation(com.ws.shavuot.common.annotation.ts.TsCheck)")
    public void AuthCheckAspect() {

    }

    @AfterReturning(value = "AuthCheckAspect()")
    public void afterTs() {
        System.out.println("事务结束，开始向kafka服务发送消息");
    }


    @Pointcut("execution(public  * com.ws.shavuot.controller..*.*(..))")
    public void webLog() {
    }


    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("事务结束，开始向kafka服务发送消息");

    }
}
