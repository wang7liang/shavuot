package com.ws.shavuot.model;

import lombok.Data;
/**
* 角色菜单关系.
*/
@Data
public class RoleMenuRelation {

    /**
     * 
     */
    private Integer id;

    /**
     * 角色类型
     */
    private Integer roleId;

    /**
     * 菜单的主键
     */
    private Integer menuKey;

    /**
     * 显示顺序
     */
    private Integer displayOrder;

}
