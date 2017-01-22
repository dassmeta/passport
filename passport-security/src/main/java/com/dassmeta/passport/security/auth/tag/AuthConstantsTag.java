package com.dassmeta.passport.security.auth.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

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
		if (StringUtils.equals("parameter", type)) {
			return getParamKey(value);
		}
		if (StringUtils.equals("url", type)) {
			return getURLKey(value);
		}
		return "";
	}

	private String getParamKey(String value) {
		if (StringUtils.equals("loginId", value)) {
			return "specter_security_params_loginid";
		}
		if (StringUtils.equals("password", value)) {
			return "specter_security_params_password";
		}
		if (StringUtils.equals("captcha", value)) {
			return "specter_security_params_captcha";
		}
		return "";
	}

	private String getURLKey(String value) {
		if (StringUtils.equals("login", value)) {
			return "/specter_security_login_on";
		}
		if (StringUtils.equals("logout", value)) {
			return "/specter_security_login_out";
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
