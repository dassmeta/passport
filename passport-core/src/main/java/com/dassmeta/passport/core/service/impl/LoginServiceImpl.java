package com.dassmeta.passport.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.widewisdom.entity.auth.AuUser;
import cn.widewisdom.service.LoginService;

import com.specter.dao.BaseDao;

public class LoginServiceImpl implements LoginService {
	@Autowired
	private BaseDao baseDao;

	public Boolean isLoginID(String loginId) {
		String hql = "from AuUser t where t.loginId='" + loginId + "'";
		List list = this.baseDao.executeHQL(hql).list();
		if ((list == null) || (list.size() == 0)) {
			return Boolean.valueOf(false);
		}
		return Boolean.valueOf(true);
	}

	public Boolean isLoginUser(AuUser user) {
		String hql = "from AuUser t where t.loginId='" + user.getLoginId() + "' and t.password='" + user.getPassword() + "'";
		List list = this.baseDao.executeHQL(hql).list();
		if ((list == null) || (list.size() == 0)) {
			return Boolean.valueOf(false);
		}
		return Boolean.valueOf(true);
	}
}
