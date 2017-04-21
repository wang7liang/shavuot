package com.ws.shavuot.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.ws.shavuot.service.UserRoleRelationService;
import com.ws.shavuot.model.UserRoleRelation;
import com.ws.shavuot.dao.UserRoleRelationMapper;
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
public class UserRoleRelationServiceImpl implements UserRoleRelationService {

    /**
     * UserRoleRelationMapper
     */
    @Resource
    private UserRoleRelationMapper userRoleRelationMapper;

    /**
     * 新增用户角色关系.
     *
     * @param record 实体
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public int insertSelective(UserRoleRelation record) {
        try {
            return userRoleRelationMapper.insertSelective(record);
        } catch (Exception e) {
            log.error("新增用户角色关系:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据新增异常");
        }
    }

    /**
     * 根据主键返回用户角色关系实体.
     *
     * @param id  主键
     * @return UserRoleRelation
     */
    @Override
    public UserRoleRelation selectByPrimaryKey(Integer id) {
        try {
            return userRoleRelationMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            log.error("查询用户角色关系异常:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据查询异常");
        }
    }

    /**
     * 选择更新用户角色关系.
     *
     * @param record  实体
     * @return 更新状态
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(UserRoleRelation record)  {
        try {
            return userRoleRelationMapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            log.error("更新用户角色关系异常:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据更新异常");
        }
    }

    /**
     * 全量更新用户角色关系.
     *
     * @param record  实体
     * @return 更新状态
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public int updateByPrimaryKey(UserRoleRelation record)  {
        try {
            return userRoleRelationMapper.updateByPrimaryKey(record);
        } catch (Exception e) {
            log.error("更新用户角色关系异常:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据更新异常");
        }
    }

    /**
     * 批量插入用户角色关系.
     *
     * @param list 实体用户角色关系列表
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public void insertBatch(List<UserRoleRelation> list) {
        try {
            userRoleRelationMapper.insertBatch(list);
        } catch (Exception e) {
            log.error("插入用户角色关系异常:" + e);
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
    public int deleteByPrimaryKey(Integer id) {
        try {
            return userRoleRelationMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            log.error("删除用户角色关系异常:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据删除异常");
        }
    }


    /**
     * 根据查询条件查询出列表.
     *
     * @param map  参数集合
     * @return 用户角色关系列表
     */
    @Override
    public List<UserRoleRelation> selectBySelective(Map map) {
        try {
            return userRoleRelationMapper.selectBySelective(map);
        } catch (Exception e) {
            log.error("查询用户角色关系异常:" + e);
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
            return userRoleRelationMapper.selectBySelectiveCount(map);
        } catch (Exception e) {
            log.error("查询用户角色关系异常:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据查询异常");
        }
    }
}
