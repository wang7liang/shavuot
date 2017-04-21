package com.ws.shavuot.dao;


import com.ws.shavuot.domain.MyIdentitylink;

import java.util.List;

/**
 * Created by wangqiliang on 17/3/27.
 */
public interface MyIdentitylinkMapper {

    /**
     * 根据流程实例id和任务id(用逗号分割),返回关系列表
     *
     * @param taskIdList            List
     * @return List String
     */
    List<MyIdentitylink> listIndentitylinkByTaskId(List<String> taskIdList);
}
