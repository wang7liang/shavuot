package com.ws.shavuot.service.impl;

import com.ws.shavuot.common.exception.ExceptionStatus;
import com.ws.shavuot.common.exception.ProcessorException;
import com.ws.shavuot.dao.EventDupForbiddenMapper;
import com.ws.shavuot.domain.EventDupForbidden;
import com.ws.shavuot.service.EventDupForbiddenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by
 */
@Service
@Slf4j
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EventDupForbiddenServiceImpl implements EventDupForbiddenService {

    /**
     * EventDupForbiddenMapper
     */
    @Resource
    private EventDupForbiddenMapper eventDupForbiddenMapper;

    /**
     * 新增本地事件.
     *
     * @param record 实体
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public int insertSelective(EventDupForbidden record) {
        try {
            return eventDupForbiddenMapper.insertSelective(record);
        } catch (Exception e) {
            log.error("新增本地事件:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据新增异常");
        }
    }

    /**
     * 根据主键返回本地事件实体.
     *
     * @param id 主键
     * @return EventDupForbidden
     */
    @Override
    public EventDupForbidden selectByPrimaryKey(Long id) {
        try {
            return eventDupForbiddenMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            log.error("查询本地事件异常:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据查询异常");
        }
    }

    /**
     * 选择更新本地事件.
     *
     * @param record 实体
     * @return 更新状态
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(EventDupForbidden record) {
        try {
            return eventDupForbiddenMapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            log.error("更新本地事件异常:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据更新异常");
        }
    }

    /**
     * 全量更新本地事件.
     *
     * @param record 实体
     * @return 更新状态
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public int updateByPrimaryKey(EventDupForbidden record) {
        try {
            return eventDupForbiddenMapper.updateByPrimaryKey(record);
        } catch (Exception e) {
            log.error("更新本地事件异常:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据更新异常");
        }
    }

    /**
     * 批量插入本地事件.
     *
     * @param list 实体本地事件列表
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public void insertBatch(List<EventDupForbidden> list) {
        try {
            eventDupForbiddenMapper.insertBatch(list);
        } catch (Exception e) {
            log.error("插入本地事件异常:" + e);
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
            return eventDupForbiddenMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            log.error("删除本地事件异常:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据删除异常");
        }
    }


    /**
     * 根据查询条件查询出列表.
     *
     * @param map 参数集合
     * @return 本地事件列表
     */
    @Override
    public List<EventDupForbidden> selectBySelective(Map map) {
        try {
            return eventDupForbiddenMapper.selectBySelective(map);
        } catch (Exception e) {
            log.error("查询本地事件异常:" + e);
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
            return eventDupForbiddenMapper.selectBySelectiveCount(map);
        } catch (Exception e) {
            log.error("查询本地事件异常:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据查询异常");
        }
    }
}
