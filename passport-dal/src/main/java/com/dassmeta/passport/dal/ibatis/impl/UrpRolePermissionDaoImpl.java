package com.dassmeta.passport.dal.ibatis.impl;

import com.dassmeta.passport.dal.IBatisBaseDao;
import com.dassmeta.passport.dal.dataobject.UrpRolePermission;
import com.dassmeta.passport.dal.ibatis.UrpRolePermissionDao;

public class UrpRolePermissionDaoImpl extends IBatisBaseDao<UrpRolePermission> implements UrpRolePermissionDao {

	public void removeByPid(Long id) {
		getSqlSession().delete("removeByPid", id);
	}

	public void removeByRoleId(Long roleId) {
		getSqlSession().delete("removeByRoleId", roleId);
	}

}
