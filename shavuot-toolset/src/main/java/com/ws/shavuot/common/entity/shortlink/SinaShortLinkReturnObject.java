package com.ws.shavuot.common.entity.shortlink;

import java.io.Serializable;

/**
 * Created by zhangchuanxing on 2016/12/16.
 */
public class SinaShortLinkReturnObject implements Serializable {
    /**
     * 短链接地址
     */
    private String url_short;
    /**
     * 长链接地址
     */
    private String url_long;
    /**
     * 类型
     */
    private Integer type;


    public String getUrl_short() {
        return url_short;
    }

    public void setUrl_short(String url_short) {
        this.url_short = url_short;
    }

    public String getUrl_long() {
        return url_long;
    }

    public void setUrl_long(String url_long) {
        this.url_long = url_long;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
