package com.dassmeta.passport.security.auth.service;

import javax.servlet.http.HttpServletRequest;

import com.dassmeta.passport.security.auth.exception.AuthenticationException;

public abstract interface CaptchaValidateService {
	public abstract boolean vidateCaptcha(HttpServletRequest paramHttpServletRequest) throws AuthenticationException;
}
