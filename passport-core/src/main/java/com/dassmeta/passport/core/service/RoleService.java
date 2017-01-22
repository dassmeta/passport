package com.dassmeta.passport.core.service;

import java.util.List;
import java.util.Map;

import com.dassmeta.passport.dal.dataobject.UrpPermission;
import com.dassmeta.passport.dal.dataobject.UrpRole;
import com.dassmeta.passport.dal.dataobject.UrpRolePermission;
import com.dassmeta.passport.util.PageList;

public abstract interface RoleService {
	public abstract List<UrpRole> getAllRole();

	public abstract List<UrpRole> getAllRoleByOrgCode(String paramString);

	public abstract void delete(UrpRole paramUrpRole);

	public abstract PageList<UrpRole> findForPage(Map<String, Object> paramMap, int paramInt);

	public abstract void deleteRolePermission(Long roleId);

	public abstract List<?> getRolePermission(Long paramLong);

	public abstract List<?> findAuUserDetail(String paramString);

	public abstract String getRolePer(String paramString);

	public abstract List<UrpPermission> findPermissionInfo();

	public abstract void deleteRolePermission(UrpRolePermission paramUrpRolePermission);

	public abstract void saveOrUpdateRolePermission(UrpRolePermission paramUrpRolePermission);

	public abstract List getAllDepart();

	public abstract void enabledRole(UrpRole paramUrpRole);

	public abstract void disabledRole(UrpRole paramUrpRole);
}
