package com.dassmeta.passport.core.service;

import java.util.List;

import com.dassmeta.passport.dal.dataobject.AppMenu;
import com.dassmeta.passport.dal.dataobject.AuOrgInfo;

public abstract interface TreeService {
	public abstract List<AuOrgInfo> getDepartList();

	public abstract List<AuOrgInfo> getDepartList(String paramString1, String paramString2);

	public abstract AuOrgInfo getAuOrgInfo(String paramString);

	public abstract List<AppMenu> getMenuList(String paramString);

	public abstract boolean generateDepartTreeXML();

	public abstract boolean generateMenuTreeXML(String paramString);
}
