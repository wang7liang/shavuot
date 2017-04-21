package com.ws.shavuot.model;


import lombok.Data;

import java.util.Date;

/**
 *
 */
@Data
public class AuthUser {

    private static final long serialVersionUID = 2353528370345499815L;

    /**
     *
     */
    private Long id;

    /**
     *
     */
    private String username;

    /**
     *
     */
    private String password;

    /**
     *
     */
    private String email;

    /**
     *
     */
    private Date lastPasswordReset;

    /**
     *
     */
    private String authorities;


    //for sso wusong

    /**
     *
     */
    private String userId;
    /**
     *
     */
    private String identifier;
    /**
     *
     */
    private String persistenceId;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private Integer companyId;

    public AuthUser(Long id, String username, String password,
                    String email, Date lastPasswordReset,
                    String authorities, String name, Integer companyId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.lastPasswordReset = lastPasswordReset;
        this.authorities = authorities;
        this.name = name;
        this.companyId = companyId;
    }


    public AuthUser(String username, String password, String email, Date lastPasswordReset, String authorities) {
        this.setUsername(username);
        this.setPassword(password);
        this.setEmail(email);
        this.setLastPasswordReset(lastPasswordReset);
        this.setAuthorities(authorities);
    }

}
