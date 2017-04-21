package com.ws.shavuot.dao.mysql;


import com.ws.shavuot.domain.mysql.WorkflowTask;
import org.apache.ibatis.annotations.Param;


import java.util.List;
import java.util.Map;

/**
 * 任务Dao.
 */
public interface WorkflowTaskMapper {
    /**
     * 新增任务.
     *
     * @param record 实体
     * @return 主键
     */
    int insertSelective(WorkflowTask record);

    /**
     * 根据主键返回任务实体.
     *
     * @param id 主键
     * @return Task
     */
    WorkflowTask selectByPrimaryKey(@Param("id") String id);

    /**
     * 选择更新任务.
     *
     * @param record 实体
     * @return 更新状态
     */
    int updateByPrimaryKeySelective(WorkflowTask record);

    /**
     * 全量更新任务.
     *
     * @param record 实体
     * @return 更新状态
     */
    int updateByPrimaryKey(WorkflowTask record);

    /**
     * 批量插入任务.
     *
     * @param list 实体任务列表
     */
    void insertBatch(List<WorkflowTask> list);

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
     * @return 任务列表
     */
    List<WorkflowTask> selectBySelective(Map map);

    /**
     * 根据查询条件查询出数据集合的条数.
     *
     * @param map 参数集合
     * @return 条数
     */
    Integer selectBySelectiveCount(Map map);



    /**
     * 根据业务id查询已完成任务列表
     *
     * @param map {businessKey:业务id}
     * @return 任务列表
     */
    List<WorkflowTask> selectCompleteTaskByBusinessKey(Map map);

    /**
     * 根据业务id查询未完成任务列表
     *
     * @param map {businessKey:业务id}
     * @return 任务列表
     */
    List<WorkflowTask> selectNotCompleteTaskByBusinessKey(Map map);
}
