package com.dassmeta.passport.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.dassmeta.passport.core.service.LoginService;
import com.dassmeta.passport.dal.dataobject.AuUser;
import com.dassmeta.passport.dal.ibatis.AuUserDao;

public class LoginServiceImpl implements LoginService {

	@Autowired
	private AuUserDao userDao;

	public Boolean isLoginID(String loginId) {
		return userDao.findByLoginName(loginId) != null;
	}

	public Boolean isLoginUser(AuUser user) {
		return userDao.isLoginUser(user) != null;
	}
}
