package com.ws.shavuot.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.ws.shavuot.service.RoleMenuRelationService;
import com.ws.shavuot.model.RoleMenuRelation;
import com.ws.shavuot.dao.RoleMenuRelationMapper;
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
public class RoleMenuRelationServiceImpl implements RoleMenuRelationService {

    /**
     * RoleMenuRelationMapper
     */
    @Resource
    private RoleMenuRelationMapper roleMenuRelationMapper;

    /**
     * 新增角色菜单关系.
     *
     * @param record 实体
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public int insertSelective(RoleMenuRelation record) {
        try {
            return roleMenuRelationMapper.insertSelective(record);
        } catch (Exception e) {
            log.error("新增角色菜单关系:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据新增异常");
        }
    }

    /**
     * 根据主键返回角色菜单关系实体.
     *
     * @param id  主键
     * @return RoleMenuRelation
     */
    @Override
    public RoleMenuRelation selectByPrimaryKey(Integer id) {
        try {
            return roleMenuRelationMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            log.error("查询角色菜单关系异常:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据查询异常");
        }
    }

    /**
     * 选择更新角色菜单关系.
     *
     * @param record  实体
     * @return 更新状态
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(RoleMenuRelation record)  {
        try {
            return roleMenuRelationMapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            log.error("更新角色菜单关系异常:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据更新异常");
        }
    }

    /**
     * 全量更新角色菜单关系.
     *
     * @param record  实体
     * @return 更新状态
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public int updateByPrimaryKey(RoleMenuRelation record)  {
        try {
            return roleMenuRelationMapper.updateByPrimaryKey(record);
        } catch (Exception e) {
            log.error("更新角色菜单关系异常:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据更新异常");
        }
    }

    /**
     * 批量插入角色菜单关系.
     *
     * @param list 实体角色菜单关系列表
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public void insertBatch(List<RoleMenuRelation> list) {
        try {
            roleMenuRelationMapper.insertBatch(list);
        } catch (Exception e) {
            log.error("插入角色菜单关系异常:" + e);
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
            return roleMenuRelationMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            log.error("删除角色菜单关系异常:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据删除异常");
        }
    }


    /**
     * 根据查询条件查询出列表.
     *
     * @param map  参数集合
     * @return 角色菜单关系列表
     */
    @Override
    public List<RoleMenuRelation> selectBySelective(Map map) {
        try {
            return roleMenuRelationMapper.selectBySelective(map);
        } catch (Exception e) {
            log.error("查询角色菜单关系异常:" + e);
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
            return roleMenuRelationMapper.selectBySelectiveCount(map);
        } catch (Exception e) {
            log.error("查询角色菜单关系异常:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据查询异常");
        }
    }
}
