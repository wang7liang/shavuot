package com.ws.shavuot.service;

import com.ws.shavuot.model.RoleMenuRelation;

import java.util.List;
import java.util.Map;


/**
* 角色菜单关系Service.
*/
public interface RoleMenuRelationService {

    /**
     * 新增角色菜单关系.
     *
     * @param record 实体
     * @return 主键
     */
    int insertSelective(RoleMenuRelation record);

    /**
     * 根据主键返回角色菜单关系实体.
     *
     * @param id  主键
     * @return RoleMenuRelation
     */
    RoleMenuRelation selectByPrimaryKey(Integer id);

    /**
     * 选择更新角色菜单关系.
     *
     * @param record  实体
     * @return 更新状态
     */
    int updateByPrimaryKeySelective(RoleMenuRelation record);

    /**
     * 全量更新角色菜单关系.
     *
     * @param record  实体
     * @return 更新状态
     */
    int updateByPrimaryKey(RoleMenuRelation record);

    /**
     * 批量插入角色菜单关系.
     *
     * @param list 实体角色菜单关系列表
     */
    void insertBatch(List<RoleMenuRelation> list);

    /**
     * 根据主键删除数据.
     *
     * @param id  主键
     * @return 删除成功标志位
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 根据查询条件查询出列表.
     *
     * @param map  参数集合
     * @return 角色菜单关系列表
     */
    List<RoleMenuRelation> selectBySelective(Map map);

    /**
     * 根据查询条件查询出数据集合的条数.
     *
     * @param map  参数集合
     * @return 条数
     */
    Integer selectBySelectiveCount(Map map);
}
