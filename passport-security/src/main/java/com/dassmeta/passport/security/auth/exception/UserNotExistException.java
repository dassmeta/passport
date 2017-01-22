package com.dassmeta.passport.security.auth.exception;

public class UserNotExistException extends AuthenticationException {
	private static final long serialVersionUID = 1L;

	public UserNotExistException(String code) {
		super(code);
	}

	public UserNotExistException(String message, Throwable cause) {
		super(message, cause);
	}
}
