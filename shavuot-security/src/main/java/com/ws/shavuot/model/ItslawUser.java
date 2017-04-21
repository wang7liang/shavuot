package com.ws.shavuot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

/**
 *
 */
public class ItslawUser implements UserDetails {

    /**
     * 用户ID
     */
    private Long id;

    /**
     * 登录用户名(手机号)
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 上次密码重置时间
     */
    private Date lastPasswordReset;

    /**
     * 用户角色
     */
    private Collection<? extends GrantedAuthority> authorities;

    /**
     *
     */
    private Boolean accountNonExpired = true;

    /**
     *
     */
    private Boolean accountNonLocked = true;

    /**
     *
     */
    private Boolean credentialsNonExpired = true;

    /**
     *
     */
    private Boolean enabled = true;


    //for sso wusong

    /**
     * 平台端用户名
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
     * 用户名
     */
    private String name;

    /**
     * 公司ID
     */
    private Integer companyId;


    public ItslawUser() {
        super();
    }

    public ItslawUser(Long id, String username, String password, String email,
                      Date lastPasswordReset, Collection<? extends GrantedAuthority> authorities,
                      String userId, String identifier, String persistenceId, String name, Integer companyId) {
        this.setId(id);
        this.setUsername(username);
        this.setPassword(password);
        this.setEmail(email);
        this.setLastPasswordReset(lastPasswordReset);
        this.setAuthorities(authorities);
        this.setUserId(userId);
        this.setIdentifier(identifier);
        this.setPersistenceId(persistenceId);
        this.setName(name);
        this.setCompanyId(companyId);
    }

    /**
     * @return Integer
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * @param companyId Integer
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * @return Integer
     */
    public Long getId() {
        return this.id;
    }

    /**
     * @param id Integer
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return String
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * @param username String
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return String
     */
    @JsonIgnore
    public String getPassword() {
        return this.password;
    }

    /**
     * @param password String
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return String
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * @param email String
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return Date
     */
    @JsonIgnore
    public Date getLastPasswordReset() {
        return this.lastPasswordReset;
    }

    /**
     * @param lastPasswordReset Date
     */
    public void setLastPasswordReset(Date lastPasswordReset) {
        this.lastPasswordReset = lastPasswordReset;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    /**
     * @param authorities Collection
     */
    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    /**
     * @return Boolean
     */
    @JsonIgnore
    public Boolean getAccountNonExpired() {
        return this.accountNonExpired;
    }

    /**
     * @param accountNonExpired Boolean
     */
    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    /**
     * @return boolean
     */
    @Override
    public boolean isAccountNonExpired() {
        return this.getAccountNonExpired();
    }

    /**
     * @return Boolean
     */
    @JsonIgnore
    public Boolean getAccountNonLocked() {
        return this.accountNonLocked;
    }

    /**
     * @param accountNonLocked Boolean
     */
    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.getAccountNonLocked();
    }

    /**
     * @return Boolean
     */
    @JsonIgnore
    public Boolean getCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    /**
     * @param credentialsNonExpired Boolean
     */
    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.getCredentialsNonExpired();
    }

    /**
     * @return Boolean
     */
    @JsonIgnore
    public Boolean getEnabled() {
        return this.enabled;
    }

    /**
     * @param enabled Boolean
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean isEnabled() {
        return this.getEnabled();
    }

    /**
     * @return String
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId String
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return String
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * @param identifier String
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    /**
     * @return String
     */
    public String getPersistenceId() {
        return persistenceId;
    }

    /**
     * @param persistenceId String
     */
    public void setPersistenceId(String persistenceId) {
        this.persistenceId = persistenceId;
    }

    /**
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ItslawUser{"
                + "id=" + id
                + ", username='" + username + '\''
                + ", password='" + password + '\''
                + ", email='" + email + '\''
                + ", lastPasswordReset=" + lastPasswordReset
                + ", authorities=" + authorities
                + ", accountNonExpired=" + accountNonExpired
                + ", accountNonLocked=" + accountNonLocked
                + ", credentialsNonExpired=" + credentialsNonExpired
                + ", enabled=" + enabled
                + ", userId='" + userId + '\''
                + ", identifier='" + identifier + '\''
                + ", persistenceId='" + persistenceId + '\''
                + ", name='" + name + '\''
                + '}';
    }
}
