package com.ws.shavuot.service.impl;

import com.ws.shavuot.model.Menu;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.ws.shavuot.service.RoleService;
import com.ws.shavuot.model.Role;
import com.ws.shavuot.dao.RoleMapper;
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
public class RoleServiceImpl implements RoleService {

    /**
     * RoleMapper
     */
    @Resource
    private RoleMapper roleMapper;

    /**
     * 新增角色.
     *
     * @param record 实体
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public int insertSelective(Role record) {
        try {
            return roleMapper.insertSelective(record);
        } catch (Exception e) {
            log.error("新增角色:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据新增异常");
        }
    }

    /**
     * 根据主键返回角色实体.
     *
     * @param id  主键
     * @return Role
     */
    @Override
    public Role selectByPrimaryKey(Integer id) {
        try {
            return roleMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            log.error("查询角色异常:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据查询异常");
        }
    }

    /**
     * 选择更新角色.
     *
     * @param record  实体
     * @return 更新状态
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(Role record)  {
        try {
            return roleMapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            log.error("更新角色异常:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据更新异常");
        }
    }

    /**
     * 全量更新角色.
     *
     * @param record  实体
     * @return 更新状态
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public int updateByPrimaryKey(Role record)  {
        try {
            return roleMapper.updateByPrimaryKey(record);
        } catch (Exception e) {
            log.error("更新角色异常:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据更新异常");
        }
    }

    /**
     * 批量插入角色.
     *
     * @param list 实体角色列表
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public void insertBatch(List<Role> list) {
        try {
            roleMapper.insertBatch(list);
        } catch (Exception e) {
            log.error("插入角色异常:" + e);
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
            return roleMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            log.error("删除角色异常:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据删除异常");
        }
    }


    /**
     * 根据查询条件查询出列表.
     *
     * @param map  参数集合
     * @return 角色列表
     */
    @Override
    public List<Role> selectBySelective(Map map) {
        try {
            return roleMapper.selectBySelective(map);
        } catch (Exception e) {
            log.error("查询角色异常:" + e);
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
            return roleMapper.selectBySelectiveCount(map);
        } catch (Exception e) {
            log.error("查询角色异常:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据查询异常");
        }
    }
}
