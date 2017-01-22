package com.dassmeta.passport.dal.ibatis;

import com.dassmeta.passport.dal.IBaseDao;
import com.dassmeta.passport.dal.dataobject.UrpUserPermission;

public interface UrpUserPermissionDao extends IBaseDao<UrpUserPermission> {

	void removeByPid(Long id);

}