package com.ws.shavuot.domain.mysql;

import lombok.Data;

/**
* 用户角色关系.
*/
@Data
public class UserRoleRelation {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 角色Id
     */
    private Integer roleId;

    /**
     * 角色级别
     */
    private Integer roleLevel;

}
