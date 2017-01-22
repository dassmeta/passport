package com.dassmeta.passport.security.auth.impl;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dassmeta.passport.security.auth.URIPreProcessor;
import com.dassmeta.passport.security.auth.exception.AuthenticationException;
import com.dassmeta.passport.security.util.AESUtils;

public class EncryptedRPCURIPreProcessor implements URIPreProcessor {
	protected final Logger logger = LoggerFactory.getLogger(EncryptedRPCURIPreProcessor.class);
	private boolean ignoreException;
	private String pattern;

	public void setIgnoreException(boolean ignore) {
		this.ignoreException = ignore;
	}

	public String process(String uri) {
		String pre = StringUtils.substringBeforeLast(uri, ".");
		String encoder = StringUtils.substringAfterLast(pre, "/");
		String decoder = AESUtils.decrypt(encoder);
		if (StringUtils.isBlank(decoder)) {
			throw new AuthenticationException("decrypt uri return blank");
		}
		this.logger.debug("EncryptedRpcURL:{}", decoder);
		return decoder;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getPattern() {
		return this.pattern;
	}

	public boolean isIgnoreException() {
		return this.ignoreException;
	}
}
