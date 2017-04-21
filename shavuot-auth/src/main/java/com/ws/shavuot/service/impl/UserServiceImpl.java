package com.ws.shavuot.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.ws.shavuot.service.UserService;
import com.ws.shavuot.model.User;
import com.ws.shavuot.dao.UserMapper;
import lombok.extern.slf4j.Slf4j;
import com.ws.shavuot.common.exception.ExceptionStatus;
import com.ws.shavuot.common.exception.ProcessorException;
import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

/**
 * Created by
 */
@Service
@Slf4j
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

    /**
     * UserMapper
     */
    @Resource
    private UserMapper userMapper;

    /**
     * 新增用户.
     *
     * @param record 实体
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public int insertSelective(User record) {
        try {
            return userMapper.insertSelective(record);
        } catch (Exception e) {
            log.error("新增用户:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据新增异常");
        }
    }

    /**
     * 根据主键返回用户实体.
     *
     * @param id  主键
     * @return User
     */
    @Override
    public User selectByPrimaryKey(Long id) {
        try {
            return userMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            log.error("查询用户异常:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据查询异常");
        }
    }

    /**
     * 选择更新用户.
     *
     * @param record  实体
     * @return 更新状态
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(User record)  {
        try {
            return userMapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            log.error("更新用户异常:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据更新异常");
        }
    }

    /**
     * 全量更新用户.
     *
     * @param record  实体
     * @return 更新状态
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public int updateByPrimaryKey(User record)  {
        try {
            return userMapper.updateByPrimaryKey(record);
        } catch (Exception e) {
            log.error("更新用户异常:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据更新异常");
        }
    }

    /**
     * 批量插入用户.
     *
     * @param list 实体用户列表
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public void insertBatch(List<User> list) {
        try {
            userMapper.insertBatch(list);
        } catch (Exception e) {
            log.error("插入用户异常:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据插入异常");
        }
    }

    /**
     * 根据主键删除数据.
     *
     * @param id  主键
     * @return 删除成功标志位
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public int deleteByPrimaryKey(Long id) {
        try {
            return userMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            log.error("删除用户异常:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据删除异常");
        }
    }


    /**
     * 根据查询条件查询出列表.
     *
     * @param map  参数集合
     * @return 用户列表
     */
    @Override
    public List<User> selectBySelective(Map map) {
        try {
            return userMapper.selectBySelective(map);
        } catch (Exception e) {
            log.error("查询用户异常:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据查询异常");
        }
    }

    /**
     * 根据查询条件查询出数据集合的条数.
     *
     * @param map  参数集合
     * @return 条数
     */
    @Override
    public Integer selectBySelectiveCount(Map map) {
        try {
            return userMapper.selectBySelectiveCount(map);
        } catch (Exception e) {
            log.error("查询用户异常:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据查询异常");
        }
    }

    @Override
    public User getUserByMobile(String mobile) {
        return null;
    }

    @Override
    public Integer getUserDefautRoleById(Long userId) {
        return null;
    }
}
