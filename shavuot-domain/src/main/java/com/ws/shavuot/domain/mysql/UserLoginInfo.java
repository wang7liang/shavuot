package com.ws.shavuot.domain.mysql;

import lombok.Data;

import java.util.Date;

/**
 * 用户登陆信息.
 */
@Data
public class UserLoginInfo {

    /**
     *
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 登录时间
     */
    private Date loginTime;

    /**
     * 所属企业ID
     */
    private Integer companyId;

    /**
     * 插入时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private Long createBy;

    /**
     * 更新人
     */
    private Long updateBy;

    /**
     * 备注
     */
    private String remark;

    public UserLoginInfo(Long userId, Date loginTime, Date createTime) {
        this.userId = userId;
        this.loginTime = loginTime;
        this.createTime = createTime;
    }
}
