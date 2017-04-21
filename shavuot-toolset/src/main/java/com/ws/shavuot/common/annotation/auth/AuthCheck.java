package com.ws.shavuot.common.annotation.auth;

import com.ws.shavuot.common.constants.Constants;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>FileName：</p>
 * <p>Author：田继东</p>
 * <p>Date：2016年06月01日 17:44</p>
 * <p>Version 1.0</p>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AuthCheck {
    /**
     * 允许访问的角色
     * @return
     */
    Constants.RoleType[] roles()default {};
    /**
     * 所有角色，都可以访问
     * @return
     */
    boolean allRole()default false;
}
