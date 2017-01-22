package com.dassmeta.passport.security.auth.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.dassmeta.passport.security.auth.entity.UserDetail;
import com.dassmeta.passport.security.context.SecurityContext;

public class AuthenticationTag extends SimpleTagSupport {
	private String property;

	public void setProperty(String property) {
		this.property = property;
	}

	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		if (StringUtils.equals(this.property, "loginId")) {
			UserDetail detail = SecurityContext.getUserDetail();
			if ((detail != null) && (StringUtils.isNotBlank(detail.getLoginId()))) {
				out.println(detail.getLoginId());
			}
		}
	}
}
