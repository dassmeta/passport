package com.dassmeta.passport.security.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract interface AuthenticationAction {
	public abstract void login(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse);

	public abstract void logout(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse);
}
