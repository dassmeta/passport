package com.dassmeta.passport.security.auth.exception;

public class CaptchaErrorException extends AuthenticationException {
	private static final long serialVersionUID = 1L;

	public CaptchaErrorException(String code) {
		super(code);
	}

	public CaptchaErrorException(String message, Throwable cause) {
		super(message, cause);
	}
}
