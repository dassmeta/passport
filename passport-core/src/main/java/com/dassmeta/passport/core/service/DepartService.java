package com.dassmeta.passport.core.service;

import java.util.List;
import java.util.Map;

import com.dassmeta.passport.dal.dataobject.AuOrgInfo;
import com.dassmeta.passport.dal.dataobject.AuUserDetail;
import com.dassmeta.passport.util.PageList;

public abstract interface DepartService {
	public abstract PageList<AuUserDetail> findForPage(Map<String, Object> paramMap, int paramInt);

	public abstract PageList<AuUserView> findForViewPage(Map<String, Object> paramMap, int paramInt);

	public abstract List getAllOrg();

	public abstract AuOrgInfo getOrgByCode(Long paramLong);

	public abstract void delete(Long paramLong);

	public abstract boolean isHaveChild(Long paramLong);

	public abstract boolean CheckDeleteChildElement(Long paramLong);
}
