package com.dassmeta.passport.core.service;

import java.util.List;
import java.util.Map;

import com.dassmeta.passport.dal.dataobject.UrpPermission;
import com.dassmeta.passport.util.PageList;

public abstract interface PermissionService {
	public abstract void delete(UrpPermission paramUrpPermission);

	public abstract boolean check(Long paramLong, String paramString);

	public abstract void save(UrpPermission paramUrpPermission);

	public abstract List<?> getPermission();

	public abstract PageList<UrpPermission> findForPage(Map<String, Object> params, int pageSize, int pageNo);

	public abstract List<UrpPermission> findPermissionByAppCode(String paramString);

	public abstract boolean ifAllGranted(String[] paramArrayOfString);

	public abstract boolean ifAnyGranted(String[] paramArrayOfString);

	public abstract boolean ifNotGranted(String[] paramArrayOfString);

	public abstract void enabledPermission(UrpPermission paramUrpPermission);

	public abstract void disabledPermission(UrpPermission paramUrpPermission);
}
