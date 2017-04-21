package com.ws.shavuot.service;

import com.ws.shavuot.model.Menu;

import java.util.List;
import java.util.Map;


/**
* 菜单Service.
*/
public interface MenuService {

    /**
     * 新增菜单.
     *
     * @param record 实体
     * @return 主键
     */
    int insertSelective(Menu record);

    /**
     * 根据主键返回菜单实体.
     *
     * @param id  主键
     * @return Menu
     */
    Menu selectByPrimaryKey(Integer id);

    /**
     * 选择更新菜单.
     *
     * @param record  实体
     * @return 更新状态
     */
    int updateByPrimaryKeySelective(Menu record);

    /**
     * 全量更新菜单.
     *
     * @param record  实体
     * @return 更新状态
     */
    int updateByPrimaryKey(Menu record);

    /**
     * 批量插入菜单.
     *
     * @param list 实体菜单列表
     */
    void insertBatch(List<Menu> list);

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
     * @return 菜单列表
     */
    List<Menu> selectBySelective(Map map);

    /**
     * 根据查询条件查询出数据集合的条数.
     *
     * @param map  参数集合
     * @return 条数
     */
    Integer selectBySelectiveCount(Map map);
    /**
     * 根据角色获取菜单列表.
     * @param roleId  角色Id
     * @return 菜单列表
     */
    List<Menu> getMenuByRole(Integer roleId);
}
