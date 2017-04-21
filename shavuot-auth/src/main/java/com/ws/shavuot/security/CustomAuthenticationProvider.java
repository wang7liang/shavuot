package com.ws.shavuot.security;

import com.ws.shavuot.common.exception.ExceptionStatus;
import com.ws.shavuot.common.exception.ProcessorException;
import com.ws.shavuot.security.auth.LoginUserDetailsService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by wghxynn on 16/5/30.
 */
@Service
public class CustomAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
    /**
     * loginDetailServiceImpl
     */
    @Resource
    private LoginUserDetailsService loginUserDetailsService;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails,
                                                  UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        UserDetails loadedUser;

        try {
            String password = authentication.getCredentials().toString();
            loadedUser = loginUserDetailsService.loadUserByUsername(username, password);
        } catch (Exception repositoryProblem) {
            throw new ProcessorException(ExceptionStatus.EX_2002, "用户认证失败");
//            throw new InternalAuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
        }

        if (loadedUser == null) {
            throw new ProcessorException(ExceptionStatus.EX_2002, "用户认证失败");
//            throw new InternalAuthenticationServiceException(
//                    "UserDetailsService returned null, which is an interface contract violation");
        }
        return loadedUser;
    }

}
