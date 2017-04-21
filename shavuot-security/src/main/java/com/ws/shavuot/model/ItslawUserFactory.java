package com.ws.shavuot.model;

import org.springframework.security.core.authority.AuthorityUtils;

/**
 * ItslawUser工厂类
 */
public class ItslawUserFactory {

    /**
     *
     * @param authUser AuthUser
     * @return ItslawUser
     */
  public static ItslawUser create(AuthUser authUser) {
      return new ItslawUser(
        authUser.getId(),
        authUser.getUsername(),
        authUser.getPassword(),
        authUser.getEmail(),
        authUser.getLastPasswordReset(),
        AuthorityUtils.commaSeparatedStringToAuthorityList(authUser.getAuthorities()),
        authUser.getUserId(),
        authUser.getIdentifier(),
        authUser.getPersistenceId(),
        authUser.getName(),
        authUser.getCompanyId()
    );
  }

}
