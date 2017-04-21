package com.ws.shavuot.common.exception;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wghxynn on 16/4/8.
 */
public enum ExceptionStatus {
    /**
     * 服务器异常
     */
    EX_2001("应用服务器内部异常", 2001),
    /**
     * 用户认证失败
     */
    EX_2002("用户认证失败", 2002),
    /**
     * 不支持的MediaType
     */
    EX_2003("请求方法的MediaType不支持", 2003),
    /**
     * 服务不可用
     */
    EX_2004("服务不可用", 2004),
    /**
     * 远程服务不可用
     */
    EX_2005("远程服务不可用", 2005),
    /**
     * 解析远程接口返回信息时出现异常
     */
    EX_2006("解析远程接口返回信息时出现异常", 2006),
    /**
     * 发送消息到kafka服务失败
     */
    EX_2007("发送消息到kafka服务失败", 2007),
    /**
     * 添加数据主键冲突
     */
    EX_1001("添加数据主键冲突", 1001),
    /**
     * 请求参数异常
     */
    EX_1002("请求参数异常", 1002),
    /**
     * 无权操作
     */
    EX_1003("无权操作", 1003),
//    /**
//     * 没有找到数据
//     */
//    EX_1004("没有找到请求的数据", 1004),
    /**
     * 数据已被删除
     */
    EX_1005("请求的数据已被删除", 1005),
    /**
     * 未正常返回id
     */
    EX_1006("未正常返回id", 1006),
    /**
     * 数据已被更改
     */
    EX_1007("请求数据已被更改", 1007),
    /**
     * 返回值与期望不符
     */
    EX_1008("返回值与期望不符", 1008),
    /**
     * 返回值与期望不符
     */
    EX_1009("数据库操作异常", 1009),
    /**
     * 业务逻辑异常
     */
    EX_1010("业务逻辑异常", 1010),
    /**
     * 业务逻辑异常
     */
    EX_1011("数据处理异常", 1011),
    /**
     * 上传的文件太大
     */
    EX_3001("上传的文件太大", 3001),
    /**
     * 上传文件类型错误
     */
    EX_3002("上传文件类型错误", 3002),
    /**
     * 上传文件读取信息错误
     */
    EX_3003("上传文件读取信息错误", 3003),
    /**
     * 上传文件读取信息错误
     */
    EX_3004("创建文件夹参数错误", 3004),
    /**
     * 创建文件夹失败
     */
    EX_3005("创建文件夹失败", 3005),
    /**
     * 上传文件已存在
     */
    EX_3006("上传文件已存在", 3006),
    /**
     * 文件服务器异常
     */
    EX_3007("文件服务器异常", 3007),
    /**
     * 文件服务器异常
     */
    EX_3008("上传文件过程异常", 3008),
    /**
     * 律师相关
     */
    EX_6001("律师已经被停用",6001),
    /**
     * 案件想关
     */
    EX_4001("案件已结案",4001);

    private String title;
    private int index;



    private ExceptionStatus(String title, int index){
        this.title = title;
        this.index = index;
    }

    public int getIndex(){
        return this.index;
    }
    public String getTitle(){
        return this.title;
    }

    public static String getTitle(int index){
        String title = "";
        for (ExceptionStatus exceptionStatus : ExceptionStatus.values()) {
            if(index == exceptionStatus.index){
                title = exceptionStatus.title;
            }
        }
        return title;
    }

    public static String getTitle(Long index){
        return getTitle(index.intValue());
    }

    public static Map<String,String> getExceptionStatusMap(){
        Map<String,String> map = new HashMap<String, String>();
        for (ExceptionStatus exceptionStatus : ExceptionStatus.values()) {
            map.put(String.valueOf(exceptionStatus.index), exceptionStatus.title);
        }
        return map;
    }
}
