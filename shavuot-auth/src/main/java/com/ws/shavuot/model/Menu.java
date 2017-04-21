package com.ws.shavuot.model;

import lombok.Data;
/**
* 菜单.
*/
@Data
public class Menu {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 菜单key
     */
    private Integer menuKey;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单请求路径
     */
    private String menuUrl;

    /**
     * 菜单层级
     */
    private Integer menuLevel;

    /**
     * 菜单顺序
     */
    private Integer menuOrder;

    /**
     * 父菜单id
     */
    private Integer pid;

    /**
     * 菜单图标
     */
    private String menuIcon;

}
