package com.ws.shavuot.dao.mysql;


import com.ws.shavuot.domain.mysql.CaseEntrust;
import com.ws.shavuot.dto.cases.CaseEntrustTaskDto;
import com.ws.shavuot.dto.cases.ImageTaskDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 案件信息Dao.
 */
public interface CaseEntrustMapper {
    /**
     * 新增案件信息.
     *
     * @param record 实体
     * @return 主键
     */
    int insertSelective(CaseEntrust record);

    /**
     * 根据主键返回案件信息实体.
     *
     * @param id 主键
     * @return CaseEntrust
     */
    CaseEntrust selectByPrimaryKey(@Param("id") Long id);

    /**
     * 选择更新案件信息.
     *
     * @param record 实体
     * @return 更新状态
     */
    int updateByPrimaryKeySelective(CaseEntrust record);

    /**
     * 全量更新案件信息.
     *
     * @param record 实体
     * @return 更新状态
     */
    int updateByPrimaryKey(CaseEntrust record);

    /**
     * 批量插入案件信息.
     *
     * @param list 实体案件信息列表
     */
    void insertBatch(List<CaseEntrust> list);

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
     * @return 案件信息列表
     */
    List<CaseEntrust> selectBySelective(Map map);

    /**
     * 根据查询条件查询出数据集合的条数.
     *
     * @param map 参数集合
     * @return 条数
     */
    Integer selectBySelectiveCount(Map map);







    /**
     * 取得用户候选任务列表
     *
     * @param map {userId:用户id, sort:排序字段, order:生序降序}
     * @return list
     */
    List<CaseEntrustTaskDto> listCandidateTaskByUserId(Map<String, String> map);

    /**
     * 取得用户候待办务列表(包括超期任务)
     *
     * @param map {userId:用户id, sort:排序字段, order:生序降序}
     * @return
     */
    List<CaseEntrustTaskDto> listTodoTaskByUserId(Map<String, String> map);

    /**
     * 取得用户候待办务列表(不包括超期任务)
     *
     * @param map {userId:用户id, sort:排序字段, order:生序降序}
     * @return
     */
    List<CaseEntrustTaskDto> listTodoTaskExcludeOvertimeTaskByUserId(Map<String, String> map);

    /**
     * 取得用户超期任务列表
     *
     * @param map {userId:用户id, sort:排序字段, order:生序降序}
     * @return
     */
    List<CaseEntrustTaskDto> listOvertimeTaskByUserId(Map<String, String> map);

    /**
     * 取得当前正在运行任务
     * @param businessKey 业务数据id
     * @return 前正在运行任务
     */
    List<ImageTaskDto> getCurrentImageTask(Long businessKey);
}




