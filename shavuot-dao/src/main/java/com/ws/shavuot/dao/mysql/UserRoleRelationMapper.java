package com.ws.shavuot.dao.mysql;

import com.ws.shavuot.domain.mysql.UserRoleRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
* 用户角色关系Dao.
*/
public interface UserRoleRelationMapper {
    /**
     * 新增用户角色关系.
     *
     * @param record 实体
     * @return 主键
     */
    int insertSelective(UserRoleRelation record);

    /**
     * 根据主键返回用户角色关系实体.
     *
     * @param id  主键
     * @return UserRoleRelation
     */
    UserRoleRelation selectByPrimaryKey(@Param("id") Integer id);

    /**
     * 选择更新用户角色关系.
     *
     * @param record  实体
     * @return 更新状态
     */
    int updateByPrimaryKeySelective(UserRoleRelation record);

    /**
     * 全量更新用户角色关系.
     *
     * @param record  实体
     * @return 更新状态
     */
    int updateByPrimaryKey(UserRoleRelation record);

    /**
     * 批量插入用户角色关系.
     *
     * @param list 实体用户角色关系列表
     */
    void insertBatch(List<UserRoleRelation> list);

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
     * @return 用户角色关系列表
     */
    List<UserRoleRelation> selectBySelective(Map map);

     /**
     * 根据查询条件查询出数据集合的条数.
     *
     * @param map  参数集合
     * @return 条数
     */
    Integer selectBySelectiveCount(Map map);
}
