package com.dassmeta.passport.dal.redis.impl;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;

import com.dassmeta.passport.dal.dataobject.AppAppInfo;
import com.dassmeta.passport.dal.redis.AbstractBaseRedisDao;
import com.dassmeta.passport.dal.redis.AppAppInfoRedisDao;

public class AppAppInfoDaoRedisImpl extends AbstractBaseRedisDao<String, String> implements AppAppInfoRedisDao {

	private static final Logger log = LoggerFactory.getLogger(AppAppInfoDaoRedisImpl.class);

	@Override
	public Boolean add(AppAppInfo t) throws DataAccessException {
		return super.add(t.getAppName(), t.toString());
	}
 
	@Override
	public Boolean update(AppAppInfo t) throws DataAccessException {
		return null;
	}

	@Override
	public void remove(AppAppInfo t) throws DataAccessException {

	}

	@Override
	public void remove(Serializable id) throws DataAccessException {

	}

	@Override
	public Boolean batchSave(List<AppAppInfo> paramList) throws DataAccessException {
		return null;
	}

	@Override
	public Boolean batchUpdate(List<AppAppInfo> paramList) throws DataAccessException {
		return null;
	}

	@Override
	public List<AppAppInfo> getAllApp() {
		return null;
	}

}
