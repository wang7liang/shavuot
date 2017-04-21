package com.ws.shavuot.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Ø
 * <p>Description：String相关的工具方法</p>
 * <p>Author：FranklinD</p>
 * <p>Date：2016年03月26日 11:03</p>
 * <p>Version 1.0</p>
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {
    /**
     * 验证字符串是否是手机号码.
     * CommonUtil.isMobile()<BR>
     * <P>Author :  FranklinD </P>
     * <P>Date : 2016年3月19日 </P>
     *
     * @param str 电话号码
     * @return true或者False
     */
    public static boolean isMobile(String str) {
        if (isBlank(str)) {
            return false;
        }
        Pattern p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
        Matcher m = p.matcher(str);

        return m.matches();
    }

    /**
     * 判断是否为电子邮件.
     *
     * @param str 邮箱
     * @return true或者false
     */
    public static boolean isEmail(String str) {
        if (isBlank(str)) {
            return false;
        }
        Pattern p = Pattern.
                compile("^[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?$"); // 验证手机号
        Matcher m = p.matcher(str);
        return m.matches();
    }
}
