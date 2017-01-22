package com.dassmeta.passport.security.auth.exception;

public class AuthenticationException extends RuntimeException {
	private static final long serialVersionUID = 3906648604830611762L;
	private String code;

	public AuthenticationException(String code) {
		this.code = code;
	}

	public AuthenticationException(String code, Throwable throwable) {
		super(throwable);
		this.code = code;
	}

	public final String getCode() {
		return this.code;
	}

	public final String toString() {
		return getCode();
	}
}
