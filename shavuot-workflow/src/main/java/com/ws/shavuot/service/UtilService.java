package com.ws.shavuot.service;

import java.util.Date;

/**
 * Created by wangqiliang on 17/4/7.
 */
public interface UtilService {

    /**
     * 将时间字符串转换为日期类型(yyyy-MM-dd HH:mm:ss)
     *
     * @param date String
     * @return Date
     */
    Date convertToDate(String date);
}
