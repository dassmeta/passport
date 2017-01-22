package com.dassmeta.passport.security.auth.exception;

public class PasswordErrorException extends AuthenticationException {
	private static final long serialVersionUID = 1L;

	public PasswordErrorException(String code) {
		super(code);
	}

	public PasswordErrorException(String message, Throwable cause) {
		super(message, cause);
	}
}
