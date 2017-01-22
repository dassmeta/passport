package com.dassmeta.passport.security.auth.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.dassmeta.passport.security.auth.AuthConstants;

public class AuthErrorTag extends SimpleTagSupport implements AuthConstants {
	private String exception;
	private String clear;

	public void doTag() throws JspException, IOException {
		String errorKey = (String) getJspContext().getAttribute("specter_session_error_key", 3);
		if ((StringUtils.isNotBlank(this.clear)) && (StringUtils.equals("true", this.clear))) {
			getJspContext().removeAttribute("specter_session_error_key", 3);
		}
		if (StringUtils.isNotBlank(this.exception)) {
			String errorValue = getErrorValue(this.exception);
			if (StringUtils.equals(errorKey, errorValue)) {
				getJspBody().invoke(null);
				return;
			}
		}
	}

	private String getErrorValue(String exception) {
		if (StringUtils.equals("nouser-error", exception)) {
			return "specter_no_user_error";
		}
		if (StringUtils.equals("password-error", exception)) {
			return "specter_password_error";
		}
		if (StringUtils.equals("captcha-error", exception)) {
			return "specter_captcha_error";
		}
		if (StringUtils.equals("authentication-error", exception)) {
			return "specter_auth_exception";
		}
		return "";
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public void setClear(String clear) {
		this.clear = clear;
	}
}
