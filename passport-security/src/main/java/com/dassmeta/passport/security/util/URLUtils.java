package com.dassmeta.passport.security.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

public class URLUtils {
	public static String constructURL(HttpServletRequest request, String postfix) {
		String url = request.getRequestURL().toString();
		String path = request.getServletPath();

		String prefix = StringUtils.substringBefore(url, path);
		String suffix = request.getQueryString();
		String go = prefix + postfix;
		if ((suffix != null) && (!"".equals(suffix))) {
			String andStr;
			if (postfix.contains("?")) {
				andStr = "&";
			} else {
				andStr = "?";
			}
			go = go + andStr + suffix;
		}
		return go;
	}

	public static String constructRedirectURL(HttpServletRequest request, String postfix) {
		String url = request.getRequestURL().toString();
		String path = request.getServletPath();

		String prefix = StringUtils.substringBefore(url, path);
		String go = prefix + postfix;
		return go;
	}

	public static String getRequestURL(HttpServletRequest request) {
		// String path = request.getServletPath();
		//
		// Enumeration e = request.getParameterNames();
		// StringBuilder sb = new StringBuilder();
		// int j;
		// int i;
		// for (; e.hasMoreElements(); i < j)
		// {
		// String name = (String)e.nextElement();
		// String[] values = request.getParameterValues(name);
		// String[] arrayOfString1;
		// j = (arrayOfString1 = values).length;i = 0; continue;String value = arrayOfString1[i];
		// try
		// {
		// value = URLEncoder.encode(value, "UTF-8");
		// }
		// catch (UnsupportedEncodingException e1)
		// {
		// e1.printStackTrace();
		// }
		// if (sb.length() != 0) {
		// sb.append("&");
		// }
		// sb.append(name);
		// sb.append("=");
		// sb.append(value);i++;
		// }
		// path = path + sb.toString();
		// return path;
		return null;
	}
}
