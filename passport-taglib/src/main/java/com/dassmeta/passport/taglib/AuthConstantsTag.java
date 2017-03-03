package com.dassmeta.passport.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.dassmeta.passport.security.auth.AuthConstants;

public class AuthConstantsTag extends SimpleTagSupport {

	private String type;
	private String value;

	public void doTag() throws JspException, IOException {
		if ((StringUtils.isNotBlank(this.type)) && (StringUtils.isNotBlank(this.value))) {
			JspWriter out = getJspContext().getOut();
			out.print(getConstant(this.type, this.value));
		} else {
		}
	}

	private String getConstant(String type, String value) {
		if (StringUtils.equals(AuthConstants.AUTH_TYPE_PARAMETER, type)) {
			return getParamKey(value);
		}
		if (StringUtils.equals(AuthConstants.AUTH_TYPE_URL, type)) {
			return getURLKey(value);
		}
		return "";
	}

	private String getParamKey(String value) {
		if (StringUtils.equals(AuthConstants.PARAMS_LOGIN__ID_KEY, value)) {
			return AuthConstants.PARAMS_LOGIN_ID;
		}
		if (StringUtils.equals(AuthConstants.PARAMS_PASSWORD_KEY, value)) {
			return AuthConstants.PARAMS_PASSWORD;
		}
		if (StringUtils.equals(AuthConstants.PARAMS_CAPTCHA_KEY, value)) {
			return AuthConstants.PARAMS_CAPTCHA;
		}
		return "";
	}

	private String getURLKey(String value) {
		if (StringUtils.equals(AuthConstants.LOGIN_ON_URL_KEY, value)) {
			return AuthConstants.LOGIN_ON_URL;
		}
		if (StringUtils.equals(AuthConstants.AUTH_URL_LOGOUT_KEY, value)) {
			return AuthConstants.LOGIN_OUT_URL;
		}
		return "";
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
