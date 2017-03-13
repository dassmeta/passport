package com.dassmeta.passport.dal.redis;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dassmeta.passport.dal.dataobject.AppAppInfo;

/**
 * 
 * 
 * @author chenxin@dassmeta.com
 * @creation 2017年2月10日
 */
public interface AppAppInfoRedisDao {

	public Boolean add(AppAppInfo t) throws DataAccessException;

	public Boolean update(AppAppInfo t) throws DataAccessException;

	public void remove(AppAppInfo t) throws DataAccessException;

	public void remove(Serializable id) throws DataAccessException;

	public Boolean batchSave(List<AppAppInfo> paramList) throws DataAccessException;

	public Boolean batchUpdate(List<AppAppInfo> paramList) throws DataAccessException;

	List<AppAppInfo> getAllApp();

}