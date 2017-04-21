package com.ws.shavuot.service.impl;


import com.ws.shavuot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangqiliang on 17/3/23.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    public static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public List<String> getGroupUsers(String groupName) {
        LOGGER.info("开始根据组名{"+groupName+"}查找组中用户");
        List<String> usernameList = new ArrayList<>();

        if("案件管理组".equals(groupName)){
            usernameList.add("manager01");
            usernameList.add("manager02");
            usernameList.add("manager03");
        }else{
            LOGGER.error("传入组名不是案件管理组");
        }

        LOGGER.info("结束根据组名{"+groupName+"}查找组中用户");

        return usernameList;
    }


}
