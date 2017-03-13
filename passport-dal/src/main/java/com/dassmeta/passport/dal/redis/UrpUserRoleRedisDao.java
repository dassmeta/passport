package com.dassmeta.passport.dal.redis;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dassmeta.passport.dal.dataobject.UrpUserRole;
import com.dassmeta.passport.util.PageList;

/**
 * 
 * 
 * @author chenxin@dassmeta.com
 * @creation 2017年2月10日
 */
public interface UrpUserRoleRedisDao {

	public UrpUserRole findByPrimaryKey(Serializable id) throws DataAccessException;

	public long create(UrpUserRole t) throws DataAccessException;

	public int update(UrpUserRole t) throws DataAccessException;

	public int remove(UrpUserRole t) throws DataAccessException;

	public int saveOrUpdate(UrpUserRole t) throws DataAccessException;

	public int remove(Serializable id) throws DataAccessException;

	public int batchSave(List<UrpUserRole> paramList) throws DataAccessException;

	public List<UrpUserRole> batchSaveReturnIds(List<UrpUserRole> paramList) throws DataAccessException;

	public int batchUpdate(List<UrpUserRole> paramList) throws DataAccessException;

	public PageList<UrpUserRole> findPageList(UrpUserRole t, int pageSize, int pageNo);

	public PageList<UrpUserRole> findPageList(Map<String, Object> params, int pageSize, int pageNo);

	void removeByRoleId(Long id);

	public JdbcTemplate getJdbcTemplate();

	public void setJdbcTemplate(JdbcTemplate paramJdbcTemplate);

}