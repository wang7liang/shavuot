package com.ws.shavuot.security.auth;

import java.util.Map;

/**
 * Created by chenqian on 2016/5/23.
 */
public interface LoginService {
    /**
     * 判断登录状态
     *
     * @param phoneNum
     * @param password
     * @return
     */
    Map isLogin(String phoneNum, String password);

    /**
     * 手机号码是否存在
     *
     * @param phoneNum
     * @return
     */
    boolean isPhoneExist(String phoneNum);
}
