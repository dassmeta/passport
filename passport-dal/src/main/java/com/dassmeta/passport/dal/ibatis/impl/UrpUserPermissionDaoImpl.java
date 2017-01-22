package com.dassmeta.passport.dal.ibatis.impl;

import com.dassmeta.passport.dal.IBatisBaseDao;
import com.dassmeta.passport.dal.dataobject.UrpUserPermission;
import com.dassmeta.passport.dal.ibatis.UrpUserPermissionDao;

public class UrpUserPermissionDaoImpl extends IBatisBaseDao<UrpUserPermission> implements UrpUserPermissionDao {

	public void removeByPid(Long id) {
		getSqlSession().delete("com.dassmeta.passport.dal.ibatis.impl.UrpUserPermissionDaoImpl.removeByPid", id);

	}

}
