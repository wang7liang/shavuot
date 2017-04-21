package com.ws.shavuot.service;

import java.util.List;

/**
 * Created by wangqiliang on 17/3/23.
 */
public interface UserService {
    /**
     * 根据组名取得组成员userId
     * @param groupName
     * @return
     */
    public List<String> getGroupUsers(String groupName);

}
