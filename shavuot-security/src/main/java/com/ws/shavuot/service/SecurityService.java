package com.ws.shavuot.service;

import com.ws.shavuot.domain.mysql.User;
import com.ws.shavuot.domain.mysql.UserLoginInfo;
import com.ws.shavuot.domain.mysql.UserRoleRelation;


/**
 * Created by wangqiliang on 17/4/17.
 */
public interface SecurityService {

    /**
     * 新增用户.
     *
     * @param record 实体
     * @return 主键
     */
    int insertSelectiveUser(User record);

    /**
     * 新增用户角色关系.
     *
     * @param record 实体
     * @return 主键
     */
    int insertSelectiveUserRoleRelation(UserRoleRelation record);


    /**
     * 根据手机号查询用户
     *
     * @param mobile String
     * @return User
     */
    User getUserByMobile(String mobile);

    /**
     * 根据用户ID获取默认的角色.
     *
     * @param userId Long
     * @return Integer
     */
    Integer getUserDefautRoleById(Long userId);


    /**
     * @param userLoginInfo UserLoginInfo
     */
    void saveUserLoginInfo(UserLoginInfo userLoginInfo);


}
