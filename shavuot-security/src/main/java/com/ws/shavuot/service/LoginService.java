package com.ws.shavuot.service;

import java.util.Map;

/**
 * Created by wangqiliang on 17/4/17.
 */
public interface LoginService {
    /**
     * 判断登录状态
     *
     * @param phoneNum String
     * @param password String
     * @return Map
     */
    Map isLogin(String phoneNum, String password);

    /**
     * 手机号码是否存在
     *
     * @param phoneNum String
     * @return boolean
     */
    boolean isPhoneExist(String phoneNum);
}
