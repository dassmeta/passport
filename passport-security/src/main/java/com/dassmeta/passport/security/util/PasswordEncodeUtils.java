package com.dassmeta.passport.security.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

public class PasswordEncodeUtils {
	public static String encode(String encoder, String loginId, String password) {
		if (StringUtils.equals(encoder, "salt_md5")) {
			return DigestUtils.md5Hex(loginId + password);
		}
		if (StringUtils.equals(encoder, "md5")) {
			return DigestUtils.md5Hex(password);
		}
		if (StringUtils.equals(encoder, "plaintext")) {
			return password;
		}
		return null;
	}
}
