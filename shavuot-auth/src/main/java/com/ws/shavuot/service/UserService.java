package com.ws.shavuot.service;

import com.ws.shavuot.model.User;

import java.util.List;
import java.util.Map;


/**
 * 用户Service.
 */
public interface UserService {

    /**
     * 新增用户.
     *
     * @param record 实体
     * @return 主键
     */
    int insertSelective(User record);

    /**
     * 根据主键返回用户实体.
     *
     * @param id 主键
     * @return User
     */
    User selectByPrimaryKey(Long id);

    /**
     * 选择更新用户.
     *
     * @param record 实体
     * @return 更新状态
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * 全量更新用户.
     *
     * @param record 实体
     * @return 更新状态
     */
    int updateByPrimaryKey(User record);

    /**
     * 批量插入用户.
     *
     * @param list 实体用户列表
     */
    void insertBatch(List<User> list);

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
     * @return 用户列表
     */
    List<User> selectBySelective(Map map);

    /**
     * 根据查询条件查询出数据集合的条数.
     *
     * @param map 参数集合
     * @return 条数
     */
    Integer selectBySelectiveCount(Map map);

    /**
     * @param mobile
     * @return
     */
    User getUserByMobile(String mobile);

    /**
     * 根据用户ID获取默认的角色.
     *
     * @param userId
     * @return
     */
    Integer getUserDefautRoleById(Long userId);
}
