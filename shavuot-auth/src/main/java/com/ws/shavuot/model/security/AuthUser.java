package com.ws.shavuot.model.security;


import java.util.Date;

//
//@Entity
//@Table(name = "users")
public class AuthUser {

  private static final long serialVersionUID = 2353528370345499815L;
  private long _id;
  private String username;
  private String password;
  private String email;
  private Date lastPasswordReset;
  private String authorities;
  //for sso wusong
  private String userId;
  private String identifier;
  private String persistenceId;

  private String name;

  private Integer companyId;

  public AuthUser(long _id, String username, String password,
                  String email, Date lastPasswordReset,
                  String authorities, String name, Integer companyId) {
    this._id = _id;
    this.username = username;
    this.password = password;
    this.email = email;
    this.lastPasswordReset = lastPasswordReset;
    this.authorities = authorities;
    this.name = name;
    this.companyId = companyId;
  }

  public AuthUser() {
    super();
  }

  public AuthUser(String username, String password, String email, Date lastPasswordReset, String authorities) {
    this.setUsername(username);
    this.setPassword(password);
    this.setEmail(email);
    this.setLastPasswordReset(lastPasswordReset);
    this.setAuthorities(authorities);
  }

//  @Id
//	@Column(name = "id")
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
//	@SequenceGenerator(name = "users_seq", sequenceName = "users_seq", allocationSize = 1)
  public long getId() {
    return this._id;
  }

  public void setId(long _id) {
    this._id = _id;
  }

//  @Column(name = "username")
  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

//  @Column(name = "password")
  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

//  @Column(name = "email")
  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

//  @Column(name = "last_password_reset")
  public Date getLastPasswordReset() {
    return this.lastPasswordReset;
  }

  public void setLastPasswordReset(Date lastPasswordReset) {
    this.lastPasswordReset = lastPasswordReset;
  }

//  @Column(name = "authorities")
  public String getAuthorities() {
    return this.authorities;
  }

  public void setAuthorities(String authorities) {
    this.authorities = authorities;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getIdentifier() {
    return identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  public String getPersistenceId() {
    return persistenceId;
  }

  public void setPersistenceId(String persistenceId) {
    this.persistenceId = persistenceId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getCompanyId() {
    return companyId;
  }

  public void setCompanyId(Integer companyId) {
    this.companyId = companyId;
  }
}
