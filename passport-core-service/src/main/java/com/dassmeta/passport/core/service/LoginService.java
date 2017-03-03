package com.dassmeta.passport.core.service;

import com.dassmeta.passport.dal.dataobject.AuUser;

public abstract interface LoginService {
	public abstract Boolean isLoginID(String paramString);

	public abstract Boolean isLoginUser(AuUser paramAuUser);
}
