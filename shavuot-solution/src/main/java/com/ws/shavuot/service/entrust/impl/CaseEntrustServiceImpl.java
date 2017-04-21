package com.ws.shavuot.service.entrust.impl;

import com.ws.shavuot.common.exception.ExceptionStatus;
import com.ws.shavuot.common.exception.ProcessorException;
import com.ws.shavuot.dao.mysql.CaseEntrustMapper;
import com.ws.shavuot.domain.mysql.CaseEntrust;
import com.ws.shavuot.dto.cases.CaseEntrustTaskDto;
import com.ws.shavuot.dto.cases.ImageTaskDto;
import com.ws.shavuot.service.entrust.CaseEntrustService;
import com.ws.shavuot.service.workflow.WorkflowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by wangqiliang on 17/4/7.
 */
@Service
@Slf4j
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CaseEntrustServiceImpl implements CaseEntrustService {

    /**
     * CaseEntrustMapper
     */
    @Resource
    private CaseEntrustMapper caseEntrustMapper;

    /**
     *
     */
    @Resource
    private WorkflowService workflowService;

    /**
     * 新增案件信息.
     *
     * @param record 实体
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public int insertSelective(CaseEntrust record) {
        try {
            return caseEntrustMapper.insertSelective(record);
        } catch (Exception e) {
            log.error("新增案件信息:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据新增异常");
        }
    }

    /**
     * 根据主键返回案件信息实体.
     *
     * @param id 主键
     * @return CaseEntrust
     */
    @Override
    public CaseEntrust selectByPrimaryKey(Long id) {
        try {
            return caseEntrustMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            log.error("查询案件信息异常:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据查询异常");
        }
    }

    /**
     * 选择更新案件信息.
     *
     * @param record 实体
     * @return 更新状态
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(CaseEntrust record) {
        try {
            return caseEntrustMapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            log.error("更新案件信息异常:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据更新异常");
        }
    }

    /**
     * 全量更新案件信息.
     *
     * @param record 实体
     * @return 更新状态
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public int updateByPrimaryKey(CaseEntrust record) {
        try {
            return caseEntrustMapper.updateByPrimaryKey(record);
        } catch (Exception e) {
            log.error("更新案件信息异常:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据更新异常");
        }
    }

    /**
     * 批量插入案件信息.
     *
     * @param list 实体案件信息列表
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public void insertBatch(List<CaseEntrust> list) {
        try {
            caseEntrustMapper.insertBatch(list);
        } catch (Exception e) {
            log.error("插入案件信息异常:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据插入异常");
        }
    }

    /**
     * 根据主键删除数据.
     *
     * @param id 主键
     * @return 删除成功标志位
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public int deleteByPrimaryKey(Long id) {
        try {
            return caseEntrustMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            log.error("删除案件信息异常:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据删除异常");
        }
    }


    /**
     * 根据查询条件查询出列表.
     *
     * @param map 参数集合
     * @return 案件信息列表
     */
    @Override
    public List<CaseEntrust> selectBySelective(Map map) {
        try {
            return caseEntrustMapper.selectBySelective(map);
        } catch (Exception e) {
            log.error("查询案件信息异常:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据查询异常");
        }
    }

    /**
     * 根据查询条件查询出数据集合的条数.
     *
     * @param map 参数集合
     * @return 条数
     */
    @Override
    public Integer selectBySelectiveCount(Map map) {
        try {
            return caseEntrustMapper.selectBySelectiveCount(map);
        } catch (Exception e) {
            log.error("查询案件信息异常:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据查询异常");
        }
    }

    @Override
    public void startCaseEntrustProcess(Long businessKey, String userId, Map<String, String> variables) {
        String processInstanceId = workflowService.startProcess("caseEntrustProcess", businessKey, userId, variables);

        CaseEntrust caseEntrust = new CaseEntrust();
        caseEntrust.setId(businessKey);
        caseEntrust.setProcessInstanceId(processInstanceId);

        caseEntrustMapper.updateByPrimaryKeySelective(caseEntrust);
    }

    @Override
    public List<ImageTaskDto> listProcessImage(Long businessKey) {
        List<String> imageTaskNameList = new ArrayList<>();
        imageTaskNameList.add("接收案件");
        imageTaskNameList.add("确认律师");
        imageTaskNameList.add("庭前");
        imageTaskNameList.add("庭后");
        imageTaskNameList.add("判决");
        imageTaskNameList.add("结案");

        List<ImageTaskDto> currentImageTaskList = caseEntrustMapper.getCurrentImageTask(businessKey);
        String currentTaskName = "";
        boolean flag = false;
        if (currentImageTaskList.size() > 0) {
            currentTaskName = currentImageTaskList.get(0).getName();
            flag = false;
        } else {
            flag = true;
        }

        List<ImageTaskDto> resultList = new ArrayList<>();
        for (String imageTaskName : imageTaskNameList) {
            ImageTaskDto imageTaskDto = new ImageTaskDto();
            imageTaskDto.setName(imageTaskName);

            imageTaskDto.setStatus("before");

            if (flag) {
                imageTaskDto.setStatus("after");
            }

            if (imageTaskName.equals(currentTaskName)) {
                imageTaskDto.setStatus("current");
                flag = true;
            }

            resultList.add(imageTaskDto);
        }

        return resultList;
    }


    @Override
    public List<CaseEntrustTaskDto> listCandidateTaskByUserId(Map<String, String> map) {
        List<CaseEntrustTaskDto> caseEntrustTaskDtoList = caseEntrustMapper.listCandidateTaskByUserId(map);
        return caseEntrustTaskDtoList;
    }

    @Override
    public List<CaseEntrustTaskDto> listTodoTaskByUserId(Map<String, String> map) {
        List<CaseEntrustTaskDto> caseEntrustTaskDtoList = caseEntrustMapper.listTodoTaskByUserId(map);
        return caseEntrustTaskDtoList;
    }

    @Override
    public List<CaseEntrustTaskDto> listTodoTaskExcludeOvertimeTaskByUserId(Map<String, String> map) {
        List<CaseEntrustTaskDto> caseEntrustTaskDtoList = caseEntrustMapper.listTodoTaskExcludeOvertimeTaskByUserId(map);
        return caseEntrustTaskDtoList;
    }

    @Override
    public List<CaseEntrustTaskDto> listOvertimeTaskByUserId(Map<String, String> map) {
        List<CaseEntrustTaskDto> caseEntrustTaskDtoList = caseEntrustMapper.listOvertimeTaskByUserId(map);
        return caseEntrustTaskDtoList;
    }
}
