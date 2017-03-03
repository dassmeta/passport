package com.dassmeta.passport.security.auth.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cache.Cache;

import com.dassmeta.passport.security.auth.AuthConstants;
import com.dassmeta.passport.security.auth.AuthenticationProvider;
import com.dassmeta.passport.security.auth.entity.UserDetail;
import com.dassmeta.passport.security.auth.exception.AuthenticationException;
import com.dassmeta.passport.security.auth.service.CaptchaValidateService;
import com.dassmeta.passport.security.auth.service.UserDetailService;
import com.dassmeta.passport.security.context.SecurityContext;

public class AuthenticationProviderImpl implements AuthenticationProvider {
	protected final Log logger = LogFactory.getLog(getClass());
	private String loginURL;
	private String defaultTargetURL;
	private String authenticationFailureURL;
	private String logoutSuccessURL;
	private String passwordEncoder;
	private boolean validateCaptcha;
	private String parameters;
	private boolean rememberURL = false;
	private String loginIdKey = "specter_security_params_loginid";
	private String passwordKey = "specter_security_params_password";
	private Cache userDetailCache;
	private UserDetailService userDetailService;
	private CaptchaValidateService captchaValidateService;

	public String getRequestURL() {
		HttpServletRequest request = SecurityContext.getRequest();
		String path = request.getServletPath();
		if (StringUtils.isNotBlank(this.parameters)) {
			String[] ps = StringUtils.split(this.parameters, ",");
			StringBuffer sb = new StringBuffer();
			String[] arrayOfString1;
			int j = (arrayOfString1 = ps).length;
			for (int i = 0; i < j; i++) {
				String p = arrayOfString1[i];
				String paramValue = request.getParameter(p);
				if (StringUtils.isNotBlank(paramValue)) {
					sb.append(p);
					sb.append("=");
					sb.append(paramValue);
					sb.append("&");
				}
			}
			if (StringUtils.isNotBlank(sb.toString())) {
				sb.deleteCharAt(sb.length() - 1);
				path = path + "?" + sb.toString();
			}
		}
		return path;
	}

	public boolean authenticate() throws AuthenticationException {
		// HttpSession session = SecurityContext.getSession();
		// String loginId = (String) session.getAttribute("specter_session_login_key");
		// if (StringUtils.isNotBlank(loginId)) {
		// UserDetail detail = loadUserDetail(loginId);
		// if (detail == null) {
		// throw new UserNotExistException("could not load UserDetail.");
		// }
		// SecurityContext.setUserDetail(detail);
		// return true;
		// }
		return false;
	}

	//
	public boolean login() throws AuthenticationException {
		// HttpServletRequest request = SecurityContext.getRequest();
		// String loginId = request.getParameter(this.loginIdKey);
		// String password = request.getParameter(this.passwordKey);
		//
		// String encode = PasswordEncodeUtils.encode(this.passwordEncoder, loginId, password);
		//
		// UserDetail detail = null;
		// detail = this.userDetailService.loadUserDetailByLoginId(loginId);
		// if (detail == null) {
		// throw new UserNotExistException("user is not exist!");
		// }
		// if (!StringUtils.equals(detail.getLoginId(), loginId)) {
		// throw new AuthenticationException("the request URL is wrong!");
		// }
		// if (!StringUtils.equals(encode, detail.getPassword())) {
		// throw new PasswordErrorException("password is wrong!");
		// }
		// SecurityContext.setUserDetail(detail);
		//
		// HttpSession session = SecurityContext.getSession();
		// session.setAttribute("specter_session_login_key", loginId);
		//
		// Element e = new Element(loginId, detail);
		// this.userDetailCache.put(e);
		//
		return true;
	}

	//
	public boolean logout() throws AuthenticationException {
		// HttpSession session = SecurityContext.getSession();
		//
		// String loginId = (String) session.getAttribute("specter_session_login_key");
		// if ((loginId != null) && (!"".equals(loginId))) {
		// this.userDetailCache.remove(loginId);
		// }
		// Enumeration e = session.getAttributeNames();
		// while (e.hasMoreElements()) {
		// String atrr = (String) e.nextElement();
		// session.removeAttribute(atrr);
		// }
		// session.invalidate();
		return true;
	}

	//
	public boolean validateCaptcha() throws AuthenticationException {
		// boolean flag = false;
		// if (this.captchaValidateService != null) {
		// HttpServletRequest request = SecurityContext.getRequest();
		// flag = this.captchaValidateService.vidateCaptcha(request);
		// }
		// if (!flag) {
		// throw new CaptchaErrorException("the captcha validate wrong!");
		// }
		// return flag;
		return false;
	}

	//
	private UserDetail loadUserDetail(String loginId) {
		// UserDetail detail = null;
		// Element el = this.userDetailCache.get(loginId);
		// if (el != null) {
		// Serializable value = el.getValue();
		// detail = (UserDetail) value;
		// if (this.logger.isDebugEnabled()) {
		// this.logger.debug("get the userDetail from the cache!");
		// }
		// }
		// if (detail == null) {
		// detail = this.userDetailService.loadUserDetailByLoginId(loginId);
		// if (detail != null) {
		// Element elt = new Element(loginId, detail);
		// this.userDetailCache.put(elt);
		// }
		// }
		// return detail;
		return null;
	}

	public String getLoginURL() {
		return this.loginURL;
	}

	public void setLoginURL(String loginURL) {
		this.loginURL = loginURL;
	}

	public String getDefaultTargetURL() {
		return this.defaultTargetURL;
	}

	public void setDefaultTargetURL(String defaultTargetURL) {
		this.defaultTargetURL = defaultTargetURL;
	}

	public String getAuthenticationFailureURL() {
		return this.authenticationFailureURL;
	}

	public void setAuthenticationFailureURL(String authenticationFailureURL) {
		this.authenticationFailureURL = authenticationFailureURL;
	}

	public String getLogoutSuccessURL() {
		return this.logoutSuccessURL;
	}

	public void setLogoutSuccessURL(String logoutSuccessURL) {
		this.logoutSuccessURL = logoutSuccessURL;
	}

	public boolean isValidateCaptcha() {
		return this.validateCaptcha;
	}

	public void setValidateCaptcha(boolean validateCaptcha) {
		this.validateCaptcha = validateCaptcha;
	}

	public boolean isRememberURL() {
		return this.rememberURL;
	}

	public void setRememberURL(boolean rememberURL) {
		this.rememberURL = rememberURL;
	}

	public void setPasswordEncoder(String passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	public void setLoginIdKey(String loginIdKey) {
		this.loginIdKey = loginIdKey;
	}

	public void setPasswordKey(String passwordKey) {
		this.passwordKey = passwordKey;
	}

	public void setUserDetailCache(Cache userDetailCache) {
		this.userDetailCache = userDetailCache;
	}

	public void setUserDetailService(UserDetailService userDetailService) {
		this.userDetailService = userDetailService;
	}

	public void setCaptchaValidateService(CaptchaValidateService captchaValidateService) {
		this.captchaValidateService = captchaValidateService;
	}
}
