package com.ws.shavuot.common.utils;

import com.ws.shavuot.common.constants.Constants;

/**
 * Created by wghxynn on 2016/11/9.
 */
public class PageUtil {
    /**
     * 处理分页开始页数据
     * @param pageIndex
     * @return
     */
    public static Integer getPageIndex(Integer pageIndex){
        return pageIndex == null || pageIndex < Constants.PAGESIZE_1 ? pageIndex = Constants.PAGESIZE_1 : pageIndex;
    }
    /**
     * 处理每页显示数据3
     * @param pageSize
     * @return
     */
    public static Integer getPageSize_3(Integer pageSize){
        return pageSize == null || pageSize < Constants.PAGESIZE_1 ? pageSize = Constants.PAGESIZE_3 : pageSize;
    }
    /**
     * 处理每页显示数据5
     * @param pageSize
     * @return
     */
    public static Integer getPageSize_5(Integer pageSize){
        return pageSize == null || pageSize < Constants.PAGESIZE_1 ? pageSize = Constants.PAGESIZE_5 : pageSize;
    }

    /**
     * 处理每页显示数据10
     * @param pageSize
     * @return
     */
    public static Integer getPageSize_10(Integer pageSize){
        return pageSize == null || pageSize < Constants.PAGESIZE_1 ? pageSize = Constants.PAGESIZE_10 : pageSize;
    }

}
