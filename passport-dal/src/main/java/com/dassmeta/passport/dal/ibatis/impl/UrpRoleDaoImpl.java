package com.dassmeta.passport.dal.ibatis.impl;

import java.util.List;

import com.dassmeta.passport.dal.IBatisBaseDao;
import com.dassmeta.passport.dal.dataobject.UrpRole;
import com.dassmeta.passport.dal.ibatis.UrpRoleDao;

public class UrpRoleDaoImpl extends IBatisBaseDao<UrpRole> implements UrpRoleDao {

	public List<UrpRole> getRoleByAppId(String appId) {
		return getSqlSession().selectList("getRoleByAppId", appId);
	}

	public List<UrpRole> getAllRole() {
		return getSqlSession().selectList("getAllRole");
	}

}
