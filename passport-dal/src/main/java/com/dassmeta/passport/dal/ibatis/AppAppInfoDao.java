package com.dassmeta.passport.dal.ibatis;

import java.util.List;

import com.dassmeta.passport.dal.IBaseDao;
import com.dassmeta.passport.dal.dataobject.AppAppInfo;

public interface AppAppInfoDao extends IBaseDao<AppAppInfo> {

	List<AppAppInfo> getAllApp();

	List<AppAppInfo> getAppByShow();

	AppAppInfo findAppByAppCode(String code);

}