package com.dassmeta.passport.dal.ibatis.impl;

import com.dassmeta.passport.dal.IBatisBaseDao;
import com.dassmeta.passport.dal.dataobject.UrpUserRole;
import com.dassmeta.passport.dal.ibatis.UrpUserRoleDao;

public class UrpUserRoleDaoImpl extends IBatisBaseDao<UrpUserRole> implements UrpUserRoleDao {

	public void removeByRoleId(Long roleId) {
		getSqlSession().delete("removeByRoleId", roleId);
	}

}
