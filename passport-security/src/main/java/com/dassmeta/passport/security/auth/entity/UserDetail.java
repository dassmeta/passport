package com.dassmeta.passport.security.auth.entity;

import java.io.Serializable;
import org.apache.commons.lang.StringUtils;

public class UserDetail implements Serializable {
	private static final long serialVersionUID = 8154225047427803380L;
	private String userId;
	private String loginId;
	private String password;
	private Permission[] permissions;

	public UserDetail(String userId, String loginId, String password, Permission[] permissions) {
		if (StringUtils.isBlank(loginId)) {
			throw new IllegalArgumentException("loginId must not blank.");
		}
		if (StringUtils.isBlank(password)) {
			throw new IllegalArgumentException("password must not blank.");
		}
		this.userId = userId;
		this.loginId = loginId;
		this.password = password;
		this.permissions = permissions;
	}

	public String getUserId() {
		return this.userId;
	}

	public String getLoginId() {
		return this.loginId;
	}

	public String getPassword() {
		return this.password;
	}

	public Permission[] getPermissions() {
		return this.permissions;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPermissions(Permission[] permissions) {
		this.permissions = permissions;
	}
}
