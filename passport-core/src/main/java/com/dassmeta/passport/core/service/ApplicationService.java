package com.dassmeta.passport.core.service;

import java.util.List;
import java.util.Map;

import com.dassmeta.passport.dal.dataobject.AppAppInfo;
import com.dassmeta.passport.dal.dataobject.AuUser;
import com.dassmeta.passport.dal.dataobject.UrpRole;
import com.dassmeta.passport.util.PageList;

public abstract interface ApplicationService {

	public abstract PageList<AppAppInfo> findForPage(Map<String, Object> paramMap, int pageSize, int pageNo);

	public abstract void delete(AppAppInfo paramAppAppInfo);

	public abstract List<AppAppInfo> getAllApp();

	public abstract void save(AppAppInfo paramAppAppInfo);

	public abstract List<UrpRole> getRoleByAppId(String paramString);

	public abstract List<AppAppInfo> getApp();

	public abstract List<Map<String, String>> getUserSystemList(String paramString);

	public abstract String[] getUserSystem(List<Map<String, String>> paramList, String paramString);

	public abstract AuUser updatePassword(String paramString1, String paramString2);

	public abstract String updataPasswordPass(String paramString1, String paramString2);
}
