package com.dassmeta.passport.dal.ibatis;

import java.util.List;

import com.dassmeta.passport.dal.IBaseDao;
import com.dassmeta.passport.dal.dataobject.UrpPermission;

public interface UrpPermissionDao extends IBaseDao<UrpPermission> {

	List<UrpPermission> getAllPermission();

	List<UrpPermission> findByAppId(Long id);

	List<UrpPermission> findByRoleId(Long roleId);

}