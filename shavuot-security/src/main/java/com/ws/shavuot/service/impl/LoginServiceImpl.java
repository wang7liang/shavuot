package com.ws.shavuot.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.ws.shavuot.common.exception.ExceptionStatus;
import com.ws.shavuot.common.exception.ProcessorException;
import com.ws.shavuot.common.utils.HttpClientUtil;
import com.ws.shavuot.common.utils.StringUtils;
import com.ws.shavuot.service.LoginService;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangqiliang on 17/4/17.
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class LoginServiceImpl implements LoginService {
    /**
     *
     */
    @Value("${itslawyer.IPAdress}")
    private String ipAdress;

    /**
     *
     */
    @Value("${itslawyer.userLoginUrl}")
    private String userLoginUrl;

    /**
     *
     */
    @Value("${itslawyer.checkPhoneUrl}")
    private String checkPhoneUrl;


    //只实现第三方的认证
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
                    default:
                }
            }
            String isWusongLawyer = jsonElement.getAsJsonObject()
                    .get("data").getAsJsonObject()
                    .get("loginInfo")
                    .getAsJsonObject()
                    .get("profileId")
                    .getAsString();
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

    @Override
    public boolean isPhoneExist(String phoneNum) {
        if (StringUtils.isBlank(phoneNum)) {
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
