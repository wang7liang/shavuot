package com.ws.shavuot.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by wangqiliang on 17/4/14.
 */
public interface LoginUserDetailsService {
    /**
     * 功能描述：根据用户与密码验证用户信息
     * @param username 用户名
     * @param password 密码
     * @return UserDetails
     * @throws UsernameNotFoundException UsernameNotFoundException
     */
    UserDetails loadUserByUsername(String username, String password) throws UsernameNotFoundException;
    /**
     * 功能描述：根据用户名获取用户信息
     * @param username 用户名
     * @return UserDetails
     * @throws UsernameNotFoundException UsernameNotFoundException
     */
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;


}
