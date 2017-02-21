package com.dassmeta.passport.security.auth.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import org.apache.commons.lang.StringUtils;

import com.dassmeta.passport.security.auth.AuthConstants;
import com.dassmeta.passport.security.cache.CacheModel;
import com.dassmeta.passport.security.cache.DictionaryIntegrationCacheService;

public class AuthConstantsTag extends SpringSuportTag {

	private DictionaryIntegrationCacheService dictionaryIntegrationCacheService = null;

	private String value;

	private String getConstant(String value) {
		CacheModel authConstantCache = dictionaryIntegrationCacheService.getCacheByName(AuthConstants.AUTH_CONSTANTS_KEY).get(value);
		if (authConstantCache != null) {
			return authConstantCache.getValue();
		}
		return "";
	}

	@Override
	protected void initCustomBeans() {
		dictionaryIntegrationCacheService = getSpringContext().getBean(DictionaryIntegrationCacheService.class);
	}

	@Override
	void doTagWithSpring() throws JspException, IOException {
		if (StringUtils.isNotBlank(this.value)) {
			JspWriter out = getJspContext().getOut();
			out.print(getConstant(this.value));
		} else {
		}

	}

	// private String getParamKey(String value) {
	// if (StringUtils.equals("loginId", value)) {
	// return "passport_security_params_username";
	// }
	// if (StringUtils.equals("password", value)) {
	// return "passport_security_params_password";
	// }
	// if (StringUtils.equals("captcha", value)) {
	// return "passport_security_params_captcha";
	// }
	// return "";
	// }
	//
	// private String getURLKey(String value) {
	// if (StringUtils.equals("login_url", value)) {
	// return "/passport_security_login_on";
	// }
	// if (StringUtils.equals("logout_url", value)) {
	// return "/passport_security_login_out";
	// }
	// return "";
	//
	// }

	public void setValue(String value) {
		this.value = value;
	}
}
