package com.ws.shavuot.common.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ws.shavuot.common.constants.Constants;
import com.ws.shavuot.common.entity.shortlink.SinaShortLinkReturnObject;
import org.apache.http.HttpResponse;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangchuanxing on 2016/12/16.
 */
@Component
public class SinaShortLinkUtil {
    public String getShortLink(String url) {
        Map map=new HashMap<>();
        map.put("source", Constants.sinaAppKey);
        map.put("url_long",url);
        HttpResponse httpResponse = HttpClientUtil.doGet(Constants.sinaShortUrl,null, map);
        String returnMsg = HttpClientUtil.getResponseString(httpResponse);
        Gson gson = new Gson();
        List<SinaShortLinkReturnObject> shortLinkList = gson.fromJson(returnMsg,
                new TypeToken<List<SinaShortLinkReturnObject>>() {
                }.getType());
        return shortLinkList.get(0).getUrl_short();
    }
}
