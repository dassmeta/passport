package com.dassmeta.passport.dal.ibatis;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dassmeta.passport.dal.dataobject.UrpRole;
import com.dassmeta.passport.util.PageList;

/**
 * 
 * 
 * @author chenxin@dassmeta.com
 * @creation 2017年2月10日
 */
public interface UrpRoleDao {

	public UrpRole findByPrimaryKey(Serializable id) throws DataAccessException;

	public long create(UrpRole t) throws DataAccessException;

	public int update(UrpRole t) throws DataAccessException;

	public int remove(UrpRole t) throws DataAccessException;

	public int saveOrUpdate(UrpRole t) throws DataAccessException;

	public int remove(Serializable id) throws DataAccessException;

	public int batchSave(List<UrpRole> paramList) throws DataAccessException;

	public List<UrpRole> batchSaveReturnIds(List<UrpRole> paramList) throws DataAccessException;

	public int batchUpdate(List<UrpRole> paramList) throws DataAccessException;

	public PageList<UrpRole> findPageList(UrpRole t, int pageSize, int pageNo);

	public PageList<UrpRole> findPageList(Map<String, Object> params, int pageSize, int pageNo);

	List<UrpRole> getRoleByAppId(String appId);

	List<UrpRole> getAllRole();

	public JdbcTemplate getJdbcTemplate();

	public void setJdbcTemplate(JdbcTemplate paramJdbcTemplate);
}