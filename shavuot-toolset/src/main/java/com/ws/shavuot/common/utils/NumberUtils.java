package com.ws.shavuot.common.utils;

import com.ws.shavuot.common.constants.Constants;

import java.math.BigDecimal;

/**
 * <p>Description：数字相关工具类</p>
 * <p>Author：FranklinD</p>
 * <p>Date：2016年03月26日 11:36</p>
 * <p>Version 1.0</p>
 */
public class NumberUtils extends org.apache.commons.lang3.math.NumberUtils{

    /**
     * 汉语中数字大写
     */
    private static final String[] CN_UPPER_NUMBER = { "零", "壹", "贰", "叁", "肆",
            "伍", "陆", "柒", "捌", "玖" };
    /**
     * 汉语中货币单位大写，这样的设计类似于占位符
     */
    private static final String[] CN_UPPER_MONETRAY_UNIT = { "", "", "",
            "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "兆", "拾",
            "佰", "仟" };
    /**
     * 特殊字符：负
     */
    private static final String CN_NEGATIVE = "负";

    /**
     * 把输入的数字转换为汉语中的大写
     *
     * @param longNumber
     * @return 对应的汉语大写
     */
    public static String number2Upper(long longNumber) {
        BigDecimal bigDecimalNumber=new BigDecimal(longNumber);
        //bigNumber=new BigDecimal(bigNumber.intValue());
        StringBuffer sb = new StringBuffer();
        // -1, 0, or 1 as the value of this BigDecimal is negative, zero, or
        // positive.
        int signum = bigDecimalNumber.signum();
        // 零元整的情况
        if (signum == 0) {
            return CN_UPPER_NUMBER[0];
        }
        //这里会进行四舍五入
        long number = bigDecimalNumber.movePointRight(2)
                .setScale(0, BigDecimal.ROUND_HALF_UP).abs().longValue();
        // 得到小数点后两位值
        long scale = number % 100;
        int numUnit = 0;
        int numIndex = 0;
        boolean getZero = false;
        // 判断最后两位数，一共有四中情况：00 = 0, 01 = 1, 10, 11
        if (!(scale > 0)) {
            numIndex = 2;
            number = number / 100;
            getZero = true;
        }
        if ((scale > 0) && (!(scale % 10 > 0))) {
            numIndex = 1;
            number = number / 10;
            getZero = true;
        }
        int zeroSize = 0;
        while (true) {
            if (number <= 0) {
                break;
            }
            // 每次获取到最后一个数
            numUnit = (int) (number % 10);
            if (numUnit > 0) {
                if ((numIndex == 9) && (zeroSize >= 3)) {
                    sb.insert(0, CN_UPPER_MONETRAY_UNIT[6]);
                }
                if ((numIndex == 13) && (zeroSize >= 3)) {
                    sb.insert(0, CN_UPPER_MONETRAY_UNIT[10]);
                }

                sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
                sb.insert(0, CN_UPPER_NUMBER[numUnit]);
                getZero = false;
                zeroSize = 0;
            } else {
                ++zeroSize;
                if (!(getZero)) {
                    sb.insert(0, CN_UPPER_NUMBER[numUnit]);
                }
                if (((numIndex - 2) % 4 == 0) && (number % 1000 > 0)) {
                    sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
                }
                getZero = true;
            }
            // 让number每次都去掉最后一个数
            number = number / 10;
            ++numIndex;
        }
        // 如果signum == -1，则说明输入的数字为负数，就在最前面追加特殊字符：负
        if (signum == -1) {
            sb.insert(0, CN_NEGATIVE);
        }
        return sb.toString();
    }


    /**
     * 根据总条数以及每页行数计算总页数
     * @param totalCount
     * @param pageSize
     * @return
     */
    public static int getPageCount(int totalCount , int pageSize){
        if(totalCount <= pageSize){
            return 1;
        }
        return totalCount % pageSize == 0 ? totalCount/pageSize : (totalCount/pageSize + 1);
    }

    /**
     * 是否不是负数
     * @param num
     * @return
	 */
    public static boolean isNotNegative(Integer num){
        return !isNegative(num);
    }

	/**
     * 判断是负数
     * @param num
     * @return
     */
    public static boolean isNegative(Integer num){
        if(num != null && num < 0){
            return true;
        }
        return false;
    }

	/**
     * 处理分页参数信息
     * @param pageIndex
     * @param pageSize
     */
    public static void processPageInfo(Integer pageIndex,Integer pageSize){
        if(pageIndex == null || pageIndex < Constants.PAGESIZE_1){
            pageIndex = Constants.PAGESIZE_1;
        }
        if(pageSize == null || pageSize < Constants.PAGESIZE_1 || pageSize > Constants.PAGESIZE_30){
            pageSize = Constants.PAGESIZE_10;
        }
    }

    public static String getRandomNum( int num){

        StringBuilder bu = new StringBuilder();

        bu.append( (int)(Math.random()*9+1));

        for(int i = 0; i < num-1; i++){

            bu.append((int)(Math.random()*10));

        }

        return bu.toString();

    }

}
