package com.dassmeta.passport.dal.ibatis.impl;

import java.util.List;

import com.dassmeta.passport.dal.IBatisBaseDao;
import com.dassmeta.passport.dal.dataobject.AppAppInfo;
import com.dassmeta.passport.dal.ibatis.AppAppInfoDao;

public class AppAppInfoDaoImpl extends IBatisBaseDao<AppAppInfo> implements AppAppInfoDao {

	// private static final Logger log = LoggerFactory.getLogger(AppAppInfoDaoImpl.class);

	public List<AppAppInfo> getAllApp() {
		return getSqlSession().selectList("com.dassmeta.passport.dal.ibatis.impl.AppAppInfoDaoImpl.getAllApp");
	}

	public List<AppAppInfo> getAppByShow() {
		return getSqlSession().selectList("com.dassmeta.passport.dal.ibatis.impl.AppAppInfoDaoImpl.getAppByShow");
	}

	public AppAppInfo findAppByAppCode(String appCpde) {
		return getSqlSession().selectOne("com.dassmeta.passport.dal.ibatis.impl.AppAppInfoDaoImpl.findAppByAppCode", appCpde);
	}
}
