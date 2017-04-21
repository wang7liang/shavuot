package com.ws.shavuot.model.security;


public class AuthenticationResponse{

	private static final long serialVersionUID = -6624726180748515507L;
	private String token;
	private String userId;
	private String identifier;
	private String persistenceId;

	public AuthenticationResponse() {
		super();
	}

	public AuthenticationResponse(String token) {
		this.setToken(token);
	}

	public AuthenticationResponse(String token, String userId, String identifier, String persistenceId) {
		this.token = token;
		this.userId = userId;
		this.identifier = identifier;
		this.persistenceId = persistenceId;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getPersistenceId() {
		return persistenceId;
	}

	public void setPersistenceId(String persistenceId) {
		this.persistenceId = persistenceId;
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

}
