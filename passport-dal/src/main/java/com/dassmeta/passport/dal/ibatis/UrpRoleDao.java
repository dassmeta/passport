package com.dassmeta.passport.dal.ibatis;

import java.util.List;

import com.dassmeta.passport.dal.IBaseDao;
import com.dassmeta.passport.dal.dataobject.UrpRole;

public interface UrpRoleDao extends IBaseDao<UrpRole> {

	List<UrpRole> getRoleByAppId(String appId);

	List<UrpRole> getAllRole();
}