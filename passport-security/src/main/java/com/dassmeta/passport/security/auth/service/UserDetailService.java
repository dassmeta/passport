package com.dassmeta.passport.security.auth.service;

import com.dassmeta.passport.security.auth.entity.UserDetail;

public abstract interface UserDetailService {
	public abstract UserDetail loadUserDetailByLoginId(String paramString);
}
