package com.ws.shavuot.dao;

import com.ws.shavuot.model.Role;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
* 角色Dao.
*/
public interface RoleMapper {
    /**
     * 新增角色.
     *
     * @param record 实体
     * @return 主键
     */
    int insertSelective(Role record);

    /**
     * 根据主键返回角色实体.
     *
     * @param id  主键
     * @return Role
     */
    Role selectByPrimaryKey(@Param("id") Integer id);

    /**
     * 选择更新角色.
     *
     * @param record  实体
     * @return 更新状态
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     * 全量更新角色.
     *
     * @param record  实体
     * @return 更新状态
     */
    int updateByPrimaryKey(Role record);

    /**
     * 批量插入角色.
     *
     * @param list 实体角色列表
     */
    void insertBatch(List<Role> list);

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
     * @return 角色列表
     */
    List<Role> selectBySelective(Map map);

     /**
     * 根据查询条件查询出数据集合的条数.
     *
     * @param map  参数集合
     * @return 条数
     */
    Integer selectBySelectiveCount(Map map);
}
