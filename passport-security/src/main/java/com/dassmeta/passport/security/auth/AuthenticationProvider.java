package com.dassmeta.passport.security.auth;

import com.dassmeta.passport.security.auth.exception.AuthenticationException;

public abstract interface AuthenticationProvider {
	public abstract String getRequestURL();

	public abstract boolean isRememberURL();

	public abstract String getLoginURL();

	public abstract String getDefaultTargetURL();

	public abstract String getAuthenticationFailureURL();

	public abstract String getLogoutSuccessURL();

	public abstract boolean authenticate() throws AuthenticationException;

	public abstract boolean login() throws AuthenticationException;

	public abstract boolean logout() throws AuthenticationException;

	public abstract boolean isValidateCaptcha();

	public abstract boolean validateCaptcha() throws AuthenticationException;

	public static abstract interface PasswordEncoder {
		public static final String MD5 = "md5";
		public static final String SALT_MD5 = "salt_md5";
		public static final String PLAINTEXT = "plaintext";
	}
}
