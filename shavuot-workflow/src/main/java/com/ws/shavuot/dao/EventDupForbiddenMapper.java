package com.ws.shavuot.dao;


import com.ws.shavuot.domain.EventDupForbidden;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
* 本地事件Dao.
*/
public interface EventDupForbiddenMapper {
    /**
     * 新增本地事件.
     *
     * @param record 实体
     * @return 主键
     */
    int insertSelective(EventDupForbidden record);

    /**
     * 根据主键返回本地事件实体.
     *
     * @param id  主键
     * @return EventLocalInfo
     */
    EventDupForbidden selectByPrimaryKey(@Param("id") Long id);

    /**
     * 选择更新本地事件.
     *
     * @param record  实体
     * @return 更新状态
     */
    int updateByPrimaryKeySelective(EventDupForbidden record);

    /**
     * 全量更新本地事件.
     *
     * @param record  实体
     * @return 更新状态
     */
    int updateByPrimaryKey(EventDupForbidden record);

    /**
     * 批量插入本地事件.
     *
     * @param list 实体本地事件列表
     */
    void insertBatch(List<EventDupForbidden> list);

    /**
     * 根据主键删除数据.
     *
     * @param id  主键
     * @return 删除成功标志位
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 根据查询条件查询出列表.
     *
     * @param map  参数集合
     * @return 本地事件列表
     */
    List<EventDupForbidden> selectBySelective(Map map);

     /**
     * 根据查询条件查询出数据集合的条数.
     *
     * @param map  参数集合
     * @return 条数
     */
    Integer selectBySelectiveCount(Map map);
}
