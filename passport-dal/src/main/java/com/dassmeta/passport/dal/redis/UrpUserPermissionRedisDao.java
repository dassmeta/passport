package com.dassmeta.passport.dal.redis;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dassmeta.passport.dal.dataobject.UrpUserPermission;
import com.dassmeta.passport.util.PageList;

/**
 * 
 * 
 * @author chenxin@dassmeta.com
 * @creation 2017年2月10日
 */
public interface UrpUserPermissionRedisDao {

	public UrpUserPermission findByPrimaryKey(Serializable id) throws DataAccessException;

	public long create(UrpUserPermission t) throws DataAccessException;

	public int update(UrpUserPermission t) throws DataAccessException;

	public int remove(UrpUserPermission t) throws DataAccessException;

	public int saveOrUpdate(UrpUserPermission t) throws DataAccessException;

	public int remove(Serializable id) throws DataAccessException;

	public int batchSave(List<UrpUserPermission> paramList) throws DataAccessException;

	public List<UrpUserPermission> batchSaveReturnIds(List<UrpUserPermission> paramList) throws DataAccessException;

	public int batchUpdate(List<UrpUserPermission> paramList) throws DataAccessException;

	public PageList<UrpUserPermission> findPageList(UrpUserPermission t, int pageSize, int pageNo);

	public PageList<UrpUserPermission> findPageList(Map<String, Object> params, int pageSize, int pageNo);

	void removeByPid(Long id);

	public JdbcTemplate getJdbcTemplate();

	public void setJdbcTemplate(JdbcTemplate paramJdbcTemplate);

}