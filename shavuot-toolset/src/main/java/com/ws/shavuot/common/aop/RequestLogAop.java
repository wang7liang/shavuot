package com.ws.shavuot.common.aop;

import com.ws.shavuot.common.utils.JsonUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/***
 * Controller 统一日志记录
 */
@Aspect
@Component
//@Order(4)
public class RequestLogAop {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestLogAop.class);

    /***
     * 拦截所有controller中的方法的切面
     */
    @Pointcut("execution( * com.ws.kislev.controller.*.*(..))")
    public void pointCutAt() {
    }

//    @Before("pointCutAt()")
//    public void beforeAction() {
//        logger.info("在处理请求前，必须经过我！！！");
//    }

    /***
     * Controller业务处理的logger处理
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("pointCutAt()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        final String ip = request.getRemoteAddr();
        final String url = request.getRequestURL().toString();
        final String method = request.getMethod();
        final String uri = request.getRequestURI();
        final String contentType = request.getContentType();
        final String queryString = request.getQueryString();
        final String uuid = request.getHeader("Request-UUID");

        //logger.info("请求开始, 各个参数, url: {}, method: {}, uri: {}, params: {}", url, method, uri, queryString);
        LOGGER.info("请求 {} 开始, 各个参数, request ip: {}, url: {}, method: {}, uri: {}, Content-Type: {}, params: {}",uuid,ip,url,method,uri,contentType,queryString);
        //LOGGER.info("请求开始, 各个参数, request ip:" + ip + " url: " + url + ", method: " + method + ", uri: " + uri + ", Content-Type:" + contentType +", params: " + queryString);

        // result的值就是被拦截方法的返回值
        Object result = pjp.proceed();
        LOGGER.info("请求 {} 结束，controller的返回值是\n {}", uuid,JsonUtil.beanToJson(result));
        return result;
    }

    /**
     * Controller异常
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(pointcut = "pointCutAt()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //request.getHeader()
        LOGGER.info("请求 {} 发生异常，异常代码:{}", request.getHeader("Request-UUID"),e.getClass().getName());
        LOGGER.info("异常信息:{}", e.getMessage());
        LOGGER.info("异常方法:{}", joinPoint.getSignature().toLongString());
        LOGGER.info("请求参数:{}", Arrays.toString(joinPoint.getArgs()));
    }
}
