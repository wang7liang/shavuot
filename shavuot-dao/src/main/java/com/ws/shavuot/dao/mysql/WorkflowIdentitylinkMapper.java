package com.ws.shavuot.dao.mysql;


import java.util.List;
import java.util.Map;

import com.ws.shavuot.domain.mysql.WorkflowIdentitylink;
import org.apache.ibatis.annotations.Param;

/**
 * 身份关系Dao.
 */
public interface WorkflowIdentitylinkMapper {
    /**
     * 新增身份关系.
     *
     * @param record 实体
     * @return 主键
     */
    int insertSelective(WorkflowIdentitylink record);

    /**
     * 根据主键返回身份关系实体.
     *
     * @param id 主键
     * @return WorkflowIdentitylink
     */
    WorkflowIdentitylink selectByPrimaryKey(@Param("id") String id);

    /**
     * 选择更新身份关系.
     *
     * @param record 实体
     * @return 更新状态
     */
    int updateByPrimaryKeySelective(WorkflowIdentitylink record);

    /**
     * 全量更新身份关系.
     *
     * @param record 实体
     * @return 更新状态
     */
    int updateByPrimaryKey(WorkflowIdentitylink record);

    /**
     * 批量插入身份关系.
     *
     * @param list 实体身份关系列表
     */
    void insertBatch(List<WorkflowIdentitylink> list);

    /**
     * 根据主键删除数据.
     *
     * @param id 主键
     * @return 删除成功标志位
     */
    int deleteByPrimaryKey(String id);

    /**
     * 根据查询条件查询出列表.
     *
     * @param map 参数集合
     * @return 身份关系列表
     */
    List<WorkflowIdentitylink> selectBySelective(Map map);

    /**
     * 根据查询条件查询出数据集合的条数.
     *
     * @param map 参数集合
     * @return 条数
     */
    Integer selectBySelectiveCount(Map map);


    /**
     * 根据任务id删除数据.
     *
     * @param taskId String
     * @return 删除成功标志位
     */
    int deleteByTaskId(String taskId);
}
