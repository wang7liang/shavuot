package com.ws.shavuot.model;

import lombok.Data;
import java.util.Date;
/**
* 用户.
*/
@Data
public class User {

    /**
     * 主键
     */
    private Long id;

    /**
     * UUID
     */
    private String uuid;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 手机号码
     */
    private String mobilephone;

    /**
     * 邮件地址
     */
    private String email;

    /**
     * 邮件密码
     */
    private String emailPassword;

    /**
     * 职位
     */
    private String position;

    /**
     * 头像地址
     */
    private String picUrl;

    /**
     * 服务端userId
     */
    private String relatedUserId;

    /**
     * 角色状态，1为正常，0为失效
     */
    private String status;

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
    private Integer createBy;

    /**
     * 更新人
     */
    private Integer updateBy;

    /**
     * 备注
     */
    private String remark;

}
