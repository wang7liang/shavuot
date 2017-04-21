package com.ws.shavuot.security.auth.impl;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.ws.shavuot.common.exception.ExceptionStatus;
import com.ws.shavuot.common.exception.ProcessorException;
import com.ws.shavuot.common.utils.HttpClientUtil;
import com.ws.shavuot.common.utils.StringUtils;
import com.ws.shavuot.security.auth.LoginService;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenqian on 2016/5/23.
 */
@Service("loginService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class LoginServiceImpl implements LoginService {
    /**
     * itslaw的IP地址
     */
    @Value("${itslawyer.IPAdress}")
    private String ipAdress;
    /**
     * itslaw的用户登录的URL
     */
    @Value("${itslawyer.userLoginUrl}")
    private String userLoginUrl;
    /**
     * itslaw 验证电话号码是否存在
     */
    @Value("${itslawyer.checkPhoneUrl}")
    private String checkPhoneUrl;

    /**
     * 根据用户名及密码验证是否登陆成功.
     * @param userName 用户名
     * @param password 密码
     * @return 是否登陆成功
     */
    @Override
    public Map isLogin(String userName, String password) {
        if (userName == null || password == null || "".equals(password) || "".equals(userName)) {
            throw new ProcessorException(ExceptionStatus.EX_1002, "用户名密码不能为空");
        }
        Gson gson = new Gson();
        Map inputParams = new HashMap<>();
        inputParams.put("userName", userName);
        inputParams.put("password", password);
        inputParams.put("isAutoLogin", true);
        HttpResponse httpResponse = HttpClientUtil.doPost(ipAdress + userLoginUrl, gson.toJson(inputParams), null);
        Map resultMap = new HashMap<>();
        JsonParser jsonParser = new JsonParser();
        String jsonString = HttpClientUtil.getResponseString(httpResponse);
        JsonElement jsonElement = jsonParser.parse(jsonString);
        Integer isloginStatus = jsonElement.getAsJsonObject().get("result").getAsJsonObject().get("code").getAsInt();
        if (isloginStatus == 0) {
            Header[] headers = httpResponse.getHeaders("Set-Cookie");
            for (Header header : headers) {
                String headerValueArray = header.getValue();
                String[] headerValueItems = headerValueArray.split(";")[0].split("=");
                switch (headerValueItems[0]) {
                    case "userId":
                        resultMap.put("userId", headerValueItems[1]);
                        break;
                    case "identifier":
                        resultMap.put("identifier", headerValueItems[1]);
                        break;
                    case "persistenceId":
                        resultMap.put("persistenceId", headerValueItems[1]);
                        break;
                    default: break;
                }
            }
            String isWusongLawyer = jsonElement.getAsJsonObject().get("data").getAsJsonObject()
                    .get("loginInfo").getAsJsonObject().get("profileId").getAsString();
            resultMap.put("isLogin", true);
            if (!"".equals(isWusongLawyer)) {
                resultMap.put("isWusongLawyer", true);
            } else {
                resultMap.put("isWusongLawyer", false);
            }
        } else {
            resultMap.put("isLogin", false);
        }

        return resultMap;
    }

    /**
     * 验证电话号码是否存在
     * @param phoneNum 电话号码
     * @return 是否存在
     */
    @Override
    public boolean isPhoneExist(String phoneNum) {
        if (StringUtils.isMobile(phoneNum)) {
            throw new ProcessorException(ExceptionStatus.EX_1002, "手机号不能为空");
        }
        HttpResponse httpResponse = HttpClientUtil.doGet(checkPhoneUrl + phoneNum, null);
        JsonParser jsonParser = new JsonParser();
        String jsonString = HttpClientUtil.getResponseString(httpResponse);
        JsonElement jsonElement = jsonParser.parse(jsonString);
        boolean isloginStatus = jsonElement.getAsJsonObject().get("data").getAsJsonObject().get("phoneNumberExists").getAsBoolean();
        return isloginStatus;
    }
}
