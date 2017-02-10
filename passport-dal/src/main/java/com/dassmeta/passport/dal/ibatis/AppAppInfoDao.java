package com.dassmeta.passport.dal.ibatis;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dassmeta.passport.dal.dataobject.AppAppInfo;
import com.dassmeta.passport.util.PageList;

/**
 * 
 * 
 * @author chenxin@dassmeta.com
 * @creation 2017年2月10日
 */
public interface AppAppInfoDao {

	public AppAppInfo findByPrimaryKey(Serializable id) throws DataAccessException;

	public long create(AppAppInfo t) throws DataAccessException;

	public int update(AppAppInfo t) throws DataAccessException;

	public int remove(AppAppInfo t) throws DataAccessException;

	public int saveOrUpdate(AppAppInfo t) throws DataAccessException;

	public int remove(Serializable id) throws DataAccessException;

	public int batchSave(List<AppAppInfo> paramList) throws DataAccessException;

	public List<AppAppInfo> batchSaveReturnIds(List<AppAppInfo> paramList) throws DataAccessException;

	public int batchUpdate(List<AppAppInfo> paramList) throws DataAccessException;

	public PageList<AppAppInfo> findPageList(AppAppInfo t, int pageSize, int pageNo);

	public PageList<AppAppInfo> findPageList(Map<String, Object> params, int pageSize, int pageNo);

	List<AppAppInfo> getAllApp();

	List<AppAppInfo> getAppByShow();

	AppAppInfo findAppByAppCode(String code);

	public JdbcTemplate getJdbcTemplate();

	public void setJdbcTemplate(JdbcTemplate paramJdbcTemplate);

}