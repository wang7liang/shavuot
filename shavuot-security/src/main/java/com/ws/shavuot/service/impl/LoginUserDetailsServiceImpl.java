package com.ws.shavuot.service.impl;

import com.ws.shavuot.common.constants.Constants;
import com.ws.shavuot.common.exception.ExceptionStatus;
import com.ws.shavuot.common.exception.ProcessorException;
import com.ws.shavuot.common.utils.DateUtils;
import com.ws.shavuot.domain.mysql.User;
import com.ws.shavuot.domain.mysql.UserRoleRelation;
import com.ws.shavuot.model.AuthUser;
import com.ws.shavuot.model.ItslawUserFactory;
import com.ws.shavuot.service.LoginService;
import com.ws.shavuot.service.LoginUserDetailsService;
import com.ws.shavuot.service.SecurityService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by wangqiliang on 17/4/14.
 */
@Service
public class LoginUserDetailsServiceImpl implements LoginUserDetailsService {

    /**
     *
     */
    @Resource
    private LoginService loginService;

    /**
     *
     */
    @Resource
    private SecurityService securityService;

    @Override
    public UserDetails loadUserByUsername(String username, String password) throws UsernameNotFoundException {
        //用作第三方验证
        //通过无讼账号体系进行验证,确认用户密码是否正确
        Map loginInfo = loginService.isLogin(username, password);
        if (loginInfo == null || !(Boolean) loginInfo.get("isLogin")) {
            throw new ProcessorException(ExceptionStatus.EX_2002, "用户名或密码错误");
        }
        //inner account for fawu
        AuthUser authUser = this.findByUsername(username, password, (Boolean) loginInfo.get("isWusongLawyer"));

        if (authUser == null) {
            throw new UsernameNotFoundException(String.format("No authUser found with username '%s'.", username));
        } else {
            //for sso
            authUser.setUserId((String) loginInfo.get("userId"));
            authUser.setIdentifier((String) loginInfo.get("identifier"));
            authUser.setPersistenceId((String) loginInfo.get("persistenceId"));
            return ItslawUserFactory.create(authUser);
        }

    }

    /**
     * @param username 用户名
     * @return UserDetails
     * @throws UsernameNotFoundException UsernameNotFoundException
     */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser authUser = this.findByUsername(username);

        if (authUser == null) {
            throw new UsernameNotFoundException(String.format("No authUser found with username '%s'.", username));
        } else {
            return ItslawUserFactory.create(authUser);
        }
    }

    /**
     * @param username       String
     * @param password       String
     * @param isWusongLawyer Boolean
     * @return AuthUser
     */
    private AuthUser findByUsername(String username, String password, Boolean isWusongLawyer) {
        //判断法务系统是否存在该账户
        //username为手机号
        User user = securityService.getUserByMobile(username);
        Integer roleId = null;
        if (user == null) {
            throw new ProcessorException(ExceptionStatus.EX_1010, "该用户不存在");
        }
        if (Constants.UserStatus.UNNORMAL.getCode().equals(user.getStatus())) {
            throw new ProcessorException(ExceptionStatus.EX_1010, "您的账户尚未激活，请联系系统管理员");
        }
        if (user == null) {
            //N 需要初始化账号信息 对于认证律师新增账户
            if (isWusongLawyer) {
                user = new User();
                user.setMobilephone(username);
                user.setCreateTime(DateUtils.getCurrentTime());
                securityService.insertSelectiveUser(user);
                UserRoleRelation userRoleRelation = new UserRoleRelation();
                userRoleRelation.setRoleId(Constants.RoleType.LAWYER.getCode());
                securityService.insertSelectiveUserRoleRelation(userRoleRelation);
                roleId = Constants.RoleType.LAWYER.getCode();
            } else {
                roleId = securityService.getUserDefautRoleById(user.getId());
                if (roleId == null) {
                    throw new ProcessorException(ExceptionStatus.EX_1010, "该用户的角色不存在");
                }
            }
        }


        return new AuthUser(user.getId(), username, new BCryptPasswordEncoder().encode(password),
                null, null,
                roleId.toString(), user.getUserName(), user.getCompanyId());
    }

    /**
     * @param username String
     * @return AuthUser
     */
    private AuthUser findByUsername(String username) {
        //判断法务系统是否存在该账户
        //username为手机号
        User user = securityService.getUserByMobile(username);
        if (user == null) {
            throw new ProcessorException(ExceptionStatus.EX_1010, "该用户不存在");
        }
        Integer roleId = securityService.getUserDefautRoleById(user.getId());
        if (roleId == null) {
            throw new ProcessorException(ExceptionStatus.EX_1010, "该用户的角色不存在");
        }
        //Y 返回AuthUser
        return new AuthUser(user.getId(), username,
                null, null, null,
                roleId.toString(), user.getUserName(), user.getCompanyId());
    }
}
