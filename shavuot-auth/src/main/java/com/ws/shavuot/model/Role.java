package com.ws.shavuot.model;

import lombok.Data;
/**
* 角色.
*/
@Data
public class Role {

    /**
     * 
     */
    private Integer id;

    /**
     * 角色Id
     */
    private Integer roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色描述
     */
    private String roleDesc;

    /**
     * 
     */
    private Integer roleLevel;

}
