package com.ws.shavuot.service.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.ws.shavuot.service.MenuService;
import com.ws.shavuot.model.Menu;
import com.ws.shavuot.dao.MenuMapper;
import lombok.extern.slf4j.Slf4j;
import com.ws.shavuot.common.exception.ExceptionStatus;
import com.ws.shavuot.common.exception.ProcessorException;
import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

/**
 * Created by
 */
@Service
@Slf4j
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MenuServiceImpl implements MenuService {

    /**
     * MenuMapper
     */
    @Resource
    private MenuMapper menuMapper;

    /**
     * 新增菜单.
     *
     * @param record 实体
     * @return 主键
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public int insertSelective(Menu record) {
        try {
            return menuMapper.insertSelective(record);
        } catch (Exception e) {
            log.error("新增菜单:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据新增异常");
        }
    }

    /**
     * 根据主键返回菜单实体.
     *
     * @param id  主键
     * @return Menu
     */
    @Override
    public Menu selectByPrimaryKey(Integer id) {
        try {
            return menuMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            log.error("查询菜单异常:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据查询异常");
        }
    }

    /**
     * 选择更新菜单.
     *
     * @param record  实体
     * @return 更新状态
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(Menu record)  {
        try {
            return menuMapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            log.error("更新菜单异常:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据更新异常");
        }
    }

    /**
     * 全量更新菜单.
     *
     * @param record  实体
     * @return 更新状态
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public int updateByPrimaryKey(Menu record)  {
        try {
            return menuMapper.updateByPrimaryKey(record);
        } catch (Exception e) {
            log.error("更新菜单异常:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据更新异常");
        }
    }

    /**
     * 批量插入菜单.
     *
     * @param list 实体菜单列表
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public void insertBatch(List<Menu> list) {
        try {
            menuMapper.insertBatch(list);
        } catch (Exception e) {
            log.error("插入菜单异常:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据插入异常");
        }
    }

    /**
     * 根据主键删除数据.
     *
     * @param id  主键
     * @return 删除成功标志位
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public int deleteByPrimaryKey(Integer id) {
        try {
            return menuMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            log.error("删除菜单异常:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据删除异常");
        }
    }


    /**
     * 根据查询条件查询出列表.
     *
     * @param map  参数集合
     * @return 菜单列表
     */
    @Override
    public List<Menu> selectBySelective(Map map) {
        try {
            return menuMapper.selectBySelective(map);
        } catch (Exception e) {
            log.error("查询菜单异常:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据查询异常");
        }
    }

    /**
     * 根据查询条件查询出数据集合的条数.
     *
     * @param map  参数集合
     * @return 条数
     */
    @Override
    public Integer selectBySelectiveCount(Map map) {
        try {
            return menuMapper.selectBySelectiveCount(map);
        } catch (Exception e) {
            log.error("查询菜单异常:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据查询异常");
        }
    }
    /**
     * 根据角色获取菜单列表.
     * @param roleId  角色Id
     * @return 菜单列表
     */
    @Override
    @Cacheable(value = "menuCache", keyGenerator = "myKeyGenerate", condition = "#roleId != null", unless = "#result == null")
    public List<Menu> getMenuByRole(Integer roleId) {
        try {
            return menuMapper.getMenusByRole(roleId);
        } catch (Exception e) {
            log.error("查询菜单异常:" + e);
            throw new ProcessorException(ExceptionStatus.EX_1009, "数据查询异常");
        }
    }
}
