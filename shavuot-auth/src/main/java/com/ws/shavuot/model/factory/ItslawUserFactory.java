package com.ws.shavuot.model.factory;

import com.ws.shavuot.model.security.AuthUser;
import com.ws.shavuot.model.security.ItslawUser;
import org.springframework.security.core.authority.AuthorityUtils;

public class ItslawUserFactory {

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
