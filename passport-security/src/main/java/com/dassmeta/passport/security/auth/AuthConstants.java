package com.dassmeta.passport.security.auth;

public abstract interface AuthConstants {
	
	public static final String LOGIN_ON_URL = "/specter_security_login_on";
	public static final String LOGIN_OUT_URL = "/specter_security_login_out";
	public static final String SESSION_LOGIN_KEY = "specter_session_login_key";
	public static final String SESSION_ERROR_KEY = "specter_session_error_key";
	public static final String SESSION_FROM_KEY = "specter_session_from_key";
	public static final String ERROR_CAPTCHA_ERROR = "specter_captcha_error";
	public static final String ERROR_PASSWORD_ERROR = "specter_password_error";
	public static final String ERROR_NO_USER_ERROR = "specter_no_user_error";
	public static final String ERROR_AUTH_EXCEPTION_ERROR = "specter_auth_exception";
	public static final String PARAMS_LOGIN_ID = "specter_security_params_loginid";
	public static final String PARAMS_PASSWORD = "specter_security_params_password";
	public static final String PARAMS_CAPTCHA = "specter_security_params_captcha";
}
