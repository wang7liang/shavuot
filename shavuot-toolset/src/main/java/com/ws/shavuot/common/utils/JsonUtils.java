package com.ws.shavuot.common.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ws.shavuot.common.constants.Constants;
import com.ws.shavuot.common.exception.ExceptionStatus;
import com.ws.shavuot.common.exception.ProcessorException;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

/**
 * Created by chimywang on 16/4/19.
 */
public class JsonUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtils.class);

//    private static JsonUtils instance = new JsonUtils();
//    private JsonUtils (){}
//    public static JsonUtils getJsonUtils() {
//        return instance;
//    }

//    private static JsonUtils instance;
//    private JsonUtils (){}
//    public static synchronized JsonUtils getJsonUtils() {
//        if (instance == null) {
//            instance = new JsonUtils();
//        }
//        return instance;
//    }
    private volatile static JsonUtils jsonUtils;
    private JsonUtils (){}
    public static JsonUtils getJsonUtils() {
        if (jsonUtils == null) {
            synchronized (JsonUtils.class) {
                if (jsonUtils == null) {
                    jsonUtils = new JsonUtils();
                }
            }
        }
        return jsonUtils;
    }

    public String getJson(String resource){
        //返回读取指定资源的输入流 可用于jar中资源读取
        InputStream is = JsonUtils.class.getClassLoader().getResourceAsStream(resource);
        try {
            return IOUtils.toString(is,Constants.LANG_UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("读取controller中的JSON文件错误:", e);
            throw new ProcessorException(ExceptionStatus.EX_2001);
        }
//        BufferedReader br= null;
//        try {
//            br = new BufferedReader(new InputStreamReader(is, Constants.LANG_UTF_8));
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        StringBuffer stf = new StringBuffer();
//        String tempStr = "";
//        try {
//            while ((tempStr = br.readLine()) != null) {
//                stf.append(tempStr);
//            }
//        } catch (IOException e) {
//            LOGGER.error("读取controller中的JSON文件错误:", e);
//            e.printStackTrace();
//        }
//        try {
//            br.close();
//            is.close();
//        } catch (IOException e) {
//            LOGGER.error("读取controller中的JSON文件关闭流错误:", e);
//            e.printStackTrace();
//        }
//        return stf.toString();
    }

    public boolean checkExist(String resource)
    {
        InputStream is = JsonUtils.class.getClassLoader().getResourceAsStream(resource);
        return is!=null;
    }

    /**
     * 根据不同的item返回不同的schema json
     *
     * @param json
     * @param items
     * @return
     */
    public static String getSchemaStr(String json, Set<String> items) {
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(json);
        JsonObject jsonObject = (JsonObject) jsonElement;
        JsonArray jsonArray = jsonObject.getAsJsonArray("items");
        if(jsonArray == null){
            return  "";
        }
        for (  int i = 0; i <  jsonArray.size(); i++) {
            JsonObject js = (JsonObject) jsonArray.get(i);
            if (!items.contains(js.get("itemName").getAsString())) {
                jsonArray.remove(i);
                i--;
            }
        }
        return jsonObject.toString();
    }

}
