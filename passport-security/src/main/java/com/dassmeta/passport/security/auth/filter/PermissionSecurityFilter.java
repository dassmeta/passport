package com.dassmeta.passport.security.auth.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import com.dassmeta.passport.security.auth.AuthenticationAction;
import com.dassmeta.passport.security.auth.AuthenticationProvider;
import com.dassmeta.passport.security.auth.PrivilegeProvider;
import com.dassmeta.passport.security.auth.URIPreProcessProvider;
import com.dassmeta.passport.security.auth.exception.AuthenticationException;
import com.dassmeta.passport.security.auth.exception.CaptchaErrorException;
import com.dassmeta.passport.security.auth.exception.PasswordErrorException;
import com.dassmeta.passport.security.auth.exception.UserNotExistException;
import com.dassmeta.passport.security.auth.filter.support.AbstractSecurityFilter;
import com.dassmeta.passport.security.util.URLUtils;

public class PermissionSecurityFilter extends AbstractSecurityFilter {
	private AuthenticationProvider authenticationProvider;
	private PrivilegeProvider privilegeProvider;
	private URIPreProcessProvider uriPreProcessProvider;
	private AuthenticationAction authenticationAction;

	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

	}

	protected void login(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session = request.getSession();
		try {
			if (this.authenticationProvider.isValidateCaptcha()) {
				this.authenticationProvider.validateCaptcha();
			}
			this.authenticationProvider.login();
			this.authenticationAction.login(request, response);
		} catch (CaptchaErrorException e) {
			this.logger.error(e.getMessage(), e);
			session.setAttribute("specter_session_error_key", "specter_captcha_error");

			String fail = this.authenticationProvider.getAuthenticationFailureURL();
			fail = URLUtils.constructRedirectURL(request, fail);
			response.sendRedirect(fail);
			return;
		} catch (UserNotExistException e) {
			this.logger.error(e.getMessage(), e);
			session.setAttribute("specter_session_error_key", "specter_no_user_error");

			String fail = this.authenticationProvider.getAuthenticationFailureURL();
			fail = URLUtils.constructRedirectURL(request, fail);
			response.sendRedirect(fail);
			return;
		} catch (PasswordErrorException e) {
			this.logger.error(e.getMessage(), e);
			session.setAttribute("specter_session_error_key", "specter_password_error");

			String fail = this.authenticationProvider.getAuthenticationFailureURL();
			fail = URLUtils.constructRedirectURL(request, fail);
			response.sendRedirect(fail);
			return;
		} catch (AuthenticationException e) {
			this.logger.error(e.getMessage(), e);
			session.setAttribute("specter_session_error_key", "specter_auth_exception");

			String fail = this.authenticationProvider.getAuthenticationFailureURL();
			fail = URLUtils.constructRedirectURL(request, fail);
			response.sendRedirect(fail);
			return;
		}
		String target = (String) session.getAttribute("specter_session_from_key");
		if (StringUtils.isBlank(target)) {
			target = this.authenticationProvider.getDefaultTargetURL();
		}
		session.removeAttribute("specter_session_from_key");
		session.removeAttribute("specter_session_error_key");

		target = URLUtils.constructURL(request, target);
		response.sendRedirect(target);
	}

	protected void logout(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {
			this.authenticationProvider.logout();
			this.authenticationAction.logout(request, response);

			String logout = this.authenticationProvider.getLogoutSuccessURL();
			logout = URLUtils.constructRedirectURL(request, logout);
			response.sendRedirect(logout);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
	}

	protected void privilege(HttpServletRequest request, HttpServletResponse response, FilterChain chain, String path) throws IOException, ServletException {
		if (this.privilegeProvider.isNoControlResource(path)) {
			chain.doFilter(request, response);
			return;
		}
		boolean authenticate = false;
		try {
			authenticate = this.authenticationProvider.authenticate();
		} catch (AuthenticationException e) {
			this.logger.error(e.getMessage());
			request.getSession().setAttribute("specter_session_error_key", "specter_auth_exception");
			String login = this.authenticationProvider.getLoginURL();
			login = URLUtils.constructRedirectURL(request, login);
			response.sendRedirect(login);
			return;
		}
		if (!authenticate) {
			String login = this.authenticationProvider.getLoginURL();
			if (this.authenticationProvider.isRememberURL()) {
				request.getSession().setAttribute("specter_session_from_key", path);
			}
			login = URLUtils.constructRedirectURL(request, login);
			response.sendRedirect(login);
			return;
		}
		if (isOnlySession()) {
			chain.doFilter(request, response);
			return;
		}
		boolean privilege = this.privilegeProvider.privilege(path);
		if (privilege) {
			chain.doFilter(request, response);
		} else {
			String fail = this.privilegeProvider.getPrivilegeFailureURL();
			fail = URLUtils.constructRedirectURL(request, fail);
			response.sendRedirect(fail);
			return;
		}
	}

	public void setAuthenticationProvider(AuthenticationProvider authenticationProvider) {
		this.authenticationProvider = authenticationProvider;
	}

	public void setPrivilegeProvider(PrivilegeProvider privilegeProvider) {
		this.privilegeProvider = privilegeProvider;
	}

	public void setUriPreProcessProvider(URIPreProcessProvider uriPreProcessProvider) {
		this.uriPreProcessProvider = uriPreProcessProvider;
	}

	public void setAuthenticationAction(AuthenticationAction authenticationAction) {
		this.authenticationAction = authenticationAction;
	}
}
