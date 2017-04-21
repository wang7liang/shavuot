package com.ws.shavuot.service.impl;

import com.ws.shavuot.common.exception.ExceptionStatus;
import com.ws.shavuot.common.exception.ProcessorException;
import com.ws.shavuot.dao.mysql.UserLoginInfoMapper;
import com.ws.shavuot.dao.mysql.UserMapper;
import com.ws.shavuot.dao.mysql.UserRoleRelationMapper;
import com.ws.shavuot.domain.mysql.User;
import com.ws.shavuot.domain.mysql.UserLoginInfo;
import com.ws.shavuot.domain.mysql.UserRoleRelation;
import com.ws.shavuot.service.SecurityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by
 */
@Service
@Slf4j
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SecurityServiceImpl implements SecurityService {

    /**
     * UserMapper
     */
    @Resource
    private UserMapper userMapper;

    /**
     * UserRoleRelationMapper
     */
    @Resource
    private UserRoleRelationMapper userRoleRelationMapper;

    /**
     * UserLoginInfoMapper
     */
    @Resource
    private UserLoginInfoMapper userLoginInfoMapper;


    /**
     * 新增用户.
     *
     * @param record 实体
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public int insertSelectiveUser(User record) {
        try {
            return userMapper.insertSelective(record);
        } catch (Exception e) {
            log.error("新增用户:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据新增异常");
        }
    }

    /**
     * 新增用户角色关系.
     *
     * @param record 实体
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public int insertSelectiveUserRoleRelation(UserRoleRelation record) {
        try {
            return userRoleRelationMapper.insertSelective(record);
        } catch (Exception e) {
            log.error("新增用户角色关系:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据新增异常");
        }
    }

    @Override
    public User getUserByMobile(String mobile) {
        User user = userMapper.getUserByMobile(mobile);
        return user;
    }

    @Override
    public Integer getUserDefautRoleById(Long userId) {
        Integer defaultRoleId = userMapper.getUserDefautRoleById(userId);
        return defaultRoleId;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = RuntimeException.class)
    public void saveUserLoginInfo(UserLoginInfo userLoginInfo) {
        try {
            userLoginInfoMapper.insertSelective(userLoginInfo);
        } catch (Exception ex) {
            log.error("根据ID查询数据信息:", ex);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据库查询异常");
        }
    }


}
