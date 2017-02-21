package com.dassmeta.passport.security.auth.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.RequestContextUtils;

/**
 * 支持spring Ioc特性
 * 
 * @author chenxin@dassmeta.com
 * @creation 2017年2月21日
 */
public abstract class SpringSuportTag extends SimpleTagSupport {

	protected WebApplicationContext applicationContext;

	protected WebApplicationContext getSpringContext() {
		PageContext pageContext = (PageContext) getJspContext();
		if (applicationContext == null) {
			applicationContext = RequestContextUtils.getWebApplicationContext(pageContext.getRequest(), pageContext.getServletContext());
			initCustomBeans();
		}
		return applicationContext;
	}

	protected abstract void initCustomBeans();

	@Override
	public void doTag() throws JspException, IOException {
		getSpringContext();
		doTagWithSpring();
	}

	abstract void doTagWithSpring() throws JspException, IOException;

}
