package com.dassmeta.passport.dal.redis;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dassmeta.passport.dal.dataobject.AppMenu;
import com.dassmeta.passport.util.PageList;

/**
 * 
 * 
 * @author chenxin@dassmeta.com
 * @creation 2017年2月10日
 */
public interface AppMenuRedisDao {

	public AppMenu findByPrimaryKey(Serializable id) throws DataAccessException;

	public long create(AppMenu t) throws DataAccessException;

	public int update(AppMenu t) throws DataAccessException;

	public int remove(AppMenu t) throws DataAccessException;

	public int saveOrUpdate(AppMenu t) throws DataAccessException;

	public int remove(Serializable id) throws DataAccessException;

	public int batchSave(List<AppMenu> paramList) throws DataAccessException;

	public List<AppMenu> batchSaveReturnIds(List<AppMenu> paramList) throws DataAccessException;

	public int batchUpdate(List<AppMenu> paramList) throws DataAccessException;

	public PageList<AppMenu> findPageList(AppMenu t, int pageSize, int pageNo);

	public PageList<AppMenu> findPageList(Map<String, Object> params, int pageSize, int pageNo);

	public JdbcTemplate getJdbcTemplate();

	public void setJdbcTemplate(JdbcTemplate paramJdbcTemplate);

}