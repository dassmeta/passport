package com.dassmeta.passport.dal.ibatis.impl;

import java.util.HashMap;
import java.util.Map;

import com.dassmeta.passport.dal.IBatisBaseDao;
import com.dassmeta.passport.dal.dataobject.AuUser;
import com.dassmeta.passport.dal.dataobject.AuUserDetail;
import com.dassmeta.passport.dal.ibatis.AuUserDao;

public class AuUserDaoImpl extends IBatisBaseDao<AuUser> implements AuUserDao {

	public AuUser findByLoginName(String loginName) {
		return getSqlSession().selectOne("findByLoginName", loginName);
	}

	public int updataPasswordByLoginName(String loginName, String newPassword) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("loginName", loginName);
		params.put("newPassword", newPassword);
		return getSqlSession().update("updataPasswordByLoginName", params);
	}

	public AuUserDetail getUserDetail(Long id) {
		return null;
	}

	public AuUser isLoginUser(AuUser user) {
		return getSqlSession().selectOne("isLoginUser", user);
	}

}
