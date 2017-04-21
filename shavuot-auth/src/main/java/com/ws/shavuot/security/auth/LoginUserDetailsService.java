package com.ws.shavuot.security.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by wghxynn on 16/5/30.
 */
public interface LoginUserDetailsService {
    /**
     * 功能描述：根据用户与密码验证用户信息.
     * @param username 用户名
     * @param password 密码
     * @return userDetail
     * @throws UsernameNotFoundException 用户找不到
     */
    UserDetails loadUserByUsername(String username, String password) throws UsernameNotFoundException;
    /**
     * 功能描述：根据用户名获取用户信息.
     * @param username 用户名
     * @return userDetail
     * @throws UsernameNotFoundException
     */
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;


}
