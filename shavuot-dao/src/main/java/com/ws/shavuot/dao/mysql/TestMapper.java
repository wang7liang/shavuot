package com.ws.shavuot.dao.mysql;


import java.util.List;
import java.util.Map;

import com.ws.shavuot.domain.mysql.Test;
import org.apache.ibatis.annotations.Param;

/**
* 测试Dao.
*/
public interface TestMapper {
    /**
     * 新增测试.
     *
     * @param record 实体
     * @return 主键
     */
    int insertSelective(Test record);

    /**
     * 根据主键返回测试实体.
     *
     * @param id  主键
     * @return Test
     */
    Test selectByPrimaryKey(@Param("id") Integer id);

    /**
     * 选择更新测试.
     *
     * @param record  实体
     * @return 更新状态
     */
    int updateByPrimaryKeySelective(Test record);

    /**
     * 全量更新测试.
     *
     * @param record  实体
     * @return 更新状态
     */
    int updateByPrimaryKey(Test record);

    /**
     * 批量插入测试.
     *
     * @param list 实体测试列表
     */
    void insertBatch(List<Test> list);

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
     * @return 测试列表
     */
    List<Test> selectBySelective(Map map);

     /**
     * 根据查询条件查询出数据集合的条数.
     *
     * @param map  参数集合
     * @return 条数
     */
    Integer selectBySelectiveCount(Map map);
}
