package com.dassmeta.passport.dal.ibatis.impl;

import java.util.List;

import com.dassmeta.passport.dal.IBatisBaseDao;
import com.dassmeta.passport.dal.dataobject.UrpPermission;
import com.dassmeta.passport.dal.ibatis.UrpPermissionDao;

public class UrpPermissionDaoImpl extends IBatisBaseDao<UrpPermission> implements UrpPermissionDao {

	public List<UrpPermission> getAllPermission() {
		return getSqlSession().selectList("getAllPermission");
	}

	public List<UrpPermission> findByAppId(Long appId) {
		return getSqlSession().selectList("findByAppId", appId);
	}

	public List<UrpPermission> findByRoleId(Long roleId) {
		return getSqlSession().selectList("findByRoleId", roleId);
	}

}
