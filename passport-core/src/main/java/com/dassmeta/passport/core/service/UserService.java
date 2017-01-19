package com.dassmeta.passport.core.service;

import java.util.List;
import java.util.Map;

import com.dassmeta.passport.dal.dataobject.AuUser;
import com.dassmeta.passport.dal.dataobject.AuUserDetail;
import com.dassmeta.passport.dal.dataobject.UrpPermission;

public abstract interface UserService {
	public abstract void delete(AuUserDetail paramAuUserDetail);

	public abstract Map<String, String> getAllUserRole(Long paramLong);

	public abstract List getUserRole(String paramString);

	public abstract AuUserDetail getUserByUserId(String paramString);

	public abstract void deleteUserRole(Long paramLong);

	public abstract List getUserPer(Long paramLong);

	public abstract void deleteUserPer(Long paramLong);

	public abstract void deleteUserRole(Long paramLong1, Long paramLong2);

	public abstract void deleteUserPer(Long paramLong1, Long paramLong2);

	public abstract AuUser getUserByLoginID(String paramString);

	public abstract List<UrpPermission> findUserPermission(String paramString);

	public abstract void enabledUser(AuUserDetail paramAuUserDetail);

	public abstract void disabledUser(AuUserDetail paramAuUserDetail);

	public abstract AuUser getUser(String paramString);

	public abstract List<UrpPermission> findUserPermission(Long paramLong, String paramString);
}
