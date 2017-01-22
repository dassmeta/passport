package com.dassmeta.passport.security.auth.filter.support;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.dassmeta.passport.security.context.SecurityContext;

public abstract class AbstractSecurityFilter implements Filter {
	protected final Logger logger = Logger.getLogger(getClass());
	private boolean onlySession = false;

	public void init(FilterConfig filterConfig) throws ServletException {
		this.onlySession = toBoolean(getInitParams(filterConfig, "onlySession", "false"));
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		initSecurityContext(httpRequest, httpResponse);

		doFilter(httpRequest, httpResponse, chain);
	}

	public abstract void doFilter(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse, FilterChain paramFilterChain) throws IOException, ServletException;

	public void destroy() {
	}

	protected void initSecurityContext(HttpServletRequest request, HttpServletResponse response) {
		SecurityContext context = new SecurityContext();
		SecurityContext.setSecurityContext(context);
		SecurityContext.setRequest(request);
		SecurityContext.setResponse(response);
	}

	protected void cleanSecurityContext() {
	}

	protected final String getInitParams(FilterConfig config, String propertyName, String defaultValue) {
		String value = config.getInitParameter(propertyName);
		if (StringUtils.isNotBlank(value)) {
			this.logger.info(propertyName + " = " + value + " load from filter success!");
			return value;
		}
		String value2 = config.getServletContext().getInitParameter(propertyName);
		if (StringUtils.isNotBlank(value2)) {
			this.logger.info(propertyName + " = " + value2 + " load servletContext success!");
			return value2;
		}
		this.logger.info(propertyName + " = " + value2 + " load by default value!");

		return defaultValue;
	}

	protected boolean toBoolean(String value) {
		return (value != null) && (value.equalsIgnoreCase("true"));
	}

	public boolean isOnlySession() {
		return this.onlySession;
	}

	public void setOnlySession(boolean onlySession) {
		this.onlySession = onlySession;
	}
}
