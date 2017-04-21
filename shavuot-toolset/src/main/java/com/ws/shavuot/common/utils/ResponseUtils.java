package com.ws.shavuot.common.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * 返回值相关工具类
 * Created by FranklinD on 2016/3/27.
 */
public class ResponseUtils {
    /**
     * 创建一个状态为成功的响应结果
     * @param <T>
     * @return ResponseEntity<T>
     */
    public static <T> ResponseEntity<T> OK(){
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
        return new ResponseEntity<T>(headers, HttpStatus.OK);
    }

    /**
     * 创建一个带有响应实体的成功响应结果
     * @param obj 响应实体
     * @param <T> 响应类型
     * @return ResponseEntity<T>
     */
    public static <T> ResponseEntity<T> OK(T obj){
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
        return new ResponseEntity<T>(obj, headers, HttpStatus.OK);
    }

    /**
     * 创建一个状态为成功且带有提示信息的响应结果
     * @param msg 提示信息
     * @return ResponseEntity<String>
     */
    public static ResponseEntity<String> OK(String msg){
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
        return new ResponseEntity<String>(msg, headers, HttpStatus.OK);
    }

    /**
     * 自定义异常信息
     * @param obj
     * @param status
     * @param <T>
     * @return
     */
    public static <T> ResponseEntity ERROR(T obj, HttpStatus status){
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
        return new ResponseEntity<T>(obj, headers, status);
    }

    /**
     * 因参数异常出现的请求错误 400
     * @param msg
     * @return
     */
    public static ResponseEntity<String> BAD_REQUEST(String msg){
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
        return new ResponseEntity<String>(String.format("请求参数%s传值异常", msg), headers, HttpStatus.BAD_REQUEST);
    }

}
