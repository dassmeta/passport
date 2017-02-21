package com.dassmeta.passport.security.auth;

public abstract interface AuthConstants {

	public static final String AUTH_CONSTANTS_KEY = "auth_constant";
	public static final String LOGIN_ON_URL = "/passport_security_login_on";
	public static final String LOGIN_OUT_URL = "/passport_security_login_out";
	public static final String SESSION_LOGIN_KEY = "passport_session_login_key";
	public static final String SESSION_ERROR_KEY = "passport_session_error_key";
	public static final String SESSION_FROM_KEY = "passport_session_from_key";
	public static final String ERROR_CAPTCHA_ERROR = "passport_captcha_error";
	public static final String ERROR_PASSWORD_ERROR = "passport_password_error";
	public static final String ERROR_NO_USER_ERROR = "passport_no_user_error";
	public static final String ERROR_AUTH_EXCEPTION_ERROR = "passport_auth_exception";
	public static final String PARAMS_LOGIN_ID = "passport_security_params_loginid";
	public static final String PARAMS_PASSWORD = "passport_security_params_password";
	public static final String PARAMS_CAPTCHA = "passport_security_params_captcha";
	public static final String AUTH_TYPE_PARAMETER = "parameter";
	public static final String AUTH_TYPE_URL = "url";
}
