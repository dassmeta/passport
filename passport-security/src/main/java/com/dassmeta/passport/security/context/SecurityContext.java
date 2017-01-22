package com.dassmeta.passport.security.context;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dassmeta.passport.security.auth.entity.UserDetail;

public class SecurityContext implements Serializable {
	private static final long serialVersionUID = -6157336207280713429L;
	public static final String KEY_REQUEST = "com.specter.context.SecurityContext.HttpServletRequest";
	public static final String KEY_RESPONSE = "com.specter.context.SecurityContext.HttpServletResponse";
	public static final String KEY_USER_DETAIL = "com.specter.context.SecurityContext.UserDetail";
	private static ThreadLocal<SecurityContext> contextHolder = new ThreadLocal<SecurityContext>()

	{
		protected synchronized SecurityContext initialValue()

		{
			return new SecurityContext();
		}
	};

	private Map<String, Object> context;

	public SecurityContext() {
		this.context = new HashMap<String, Object>();
	}

	public SecurityContext(Map<String, Object> param) {
		this.context = param;
	}

	public Map<String, Object> getContext() {
		return this.context;
	}

	public void setContext(Map<String, Object> context) {
		this.context = context;
	}

	public static void clearContext() {
		contextHolder.remove();
	}

	public static <T> T get(Class<T> clazz, String key) {
		SecurityContext securityContext = (SecurityContext) contextHolder.get();
		Map<String, Object> cnt = securityContext.getContext();
		T obj = clazz.cast(cnt.get(key));
		return obj;
	}

	public static void put(String key, Object value) {
		SecurityContext securityContext = (SecurityContext) contextHolder.get();
		Map<String, Object> cnt = securityContext.getContext();
		cnt.put(key, value);
	}

	public static SecurityContext getSecurityContext() {
		return (SecurityContext) contextHolder.get();
	}

	public static void setSecurityContext(SecurityContext securityContext) {
		contextHolder.set(securityContext);
	}

	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) get(HttpServletRequest.class, "com.specter.context.SecurityContext.HttpServletRequest");
	}

	public static void setRequest(HttpServletRequest req) {
		put("com.specter.context.SecurityContext.HttpServletRequest", req);
	}

	public static HttpServletResponse getResponse() {
		return (HttpServletResponse) get(HttpServletResponse.class, "com.specter.context.SecurityContext.HttpServletResponse");
	}

	public static void setResponse(HttpServletResponse resp) {
		put("com.specter.context.SecurityContext.HttpServletResponse", resp);
	}

	public static HttpSession getSession() {
		HttpServletRequest req = getRequest();
		return req.getSession();
	}

	public static void setUserDetail(UserDetail userDetail) {
		put("com.specter.context.SecurityContext.UserDetail", userDetail);
	}

	public static UserDetail getUserDetail() {
		return (UserDetail) get(UserDetail.class, "com.specter.context.SecurityContext.UserDetail");
	}

	public static Map getParameters() {
		HttpServletRequest request = getRequest();
		Map retMap = new HashMap();
		Enumeration e = request.getParameterNames();
		while (e.hasMoreElements()) {
			String name = (String) e.nextElement();
			String[] values = request.getParameterValues(name);
			if ((values != null) && (values.length != 0)) {
				if (values.length > 1) {
					retMap.put(name, values);
				} else {
					retMap.put(name, values[0]);
				}
			}
		}
		return retMap;
	}
}
