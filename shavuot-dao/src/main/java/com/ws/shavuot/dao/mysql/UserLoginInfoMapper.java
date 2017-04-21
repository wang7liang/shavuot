package com.ws.shavuot.dao.mysql;


import java.util.List;
import java.util.Map;

import com.ws.shavuot.domain.mysql.UserLoginInfo;
import org.apache.ibatis.annotations.Param;

/**
 * 用户登陆信息Dao.
 */
public interface UserLoginInfoMapper {
    /**
     * 新增用户登陆信息.
     *
     * @param record 实体
     * @return 主键
     */
    int insertSelective(UserLoginInfo record);

    /**
     * 根据主键返回用户登陆信息实体.
     *
     * @param id 主键
     * @return UserLoginInfo
     */
    UserLoginInfo selectByPrimaryKey(@Param("id") Long id);

    /**
     * 选择更新用户登陆信息.
     *
     * @param record 实体
     * @return 更新状态
     */
    int updateByPrimaryKeySelective(UserLoginInfo record);

    /**
     * 全量更新用户登陆信息.
     *
     * @param record 实体
     * @return 更新状态
     */
    int updateByPrimaryKey(UserLoginInfo record);

    /**
     * 批量插入用户登陆信息.
     *
     * @param list 实体用户登陆信息列表
     */
    void insertBatch(List<UserLoginInfo> list);

    /**
     * 根据主键删除数据.
     *
     * @param id 主键
     * @return 删除成功标志位
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 根据查询条件查询出列表.
     *
     * @param map 参数集合
     * @return 用户登陆信息列表
     */
    List<UserLoginInfo> selectBySelective(Map map);

    /**
     * 根据查询条件查询出数据集合的条数.
     *
     * @param map 参数集合
     * @return 条数
     */
    Integer selectBySelectiveCount(Map map);
}
