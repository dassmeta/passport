package com.dassmeta.passport.dal.ibatis;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dassmeta.passport.dal.dataobject.UrpPermission;
import com.dassmeta.passport.util.PageList;

/**
 * 
 * 
 * @author chenxin@dassmeta.com
 * @creation 2017年2月10日
 */
public interface UrpPermissionDao {

	public UrpPermission findByPrimaryKey(Serializable id) throws DataAccessException;

	public long create(UrpPermission t) throws DataAccessException;

	public int update(UrpPermission t) throws DataAccessException;

	public int remove(UrpPermission t) throws DataAccessException;

	public int saveOrUpdate(UrpPermission t) throws DataAccessException;

	public int remove(Serializable id) throws DataAccessException;

	public int batchSave(List<UrpPermission> paramList) throws DataAccessException;

	public List<UrpPermission> batchSaveReturnIds(List<UrpPermission> paramList) throws DataAccessException;

	public int batchUpdate(List<UrpPermission> paramList) throws DataAccessException;

	public PageList<UrpPermission> findPageList(UrpPermission t, int pageSize, int pageNo);

	public PageList<UrpPermission> findPageList(Map<String, Object> params, int pageSize, int pageNo);

	List<UrpPermission> getAllPermission();

	List<UrpPermission> findByAppId(Long id);

	List<UrpPermission> findByRoleId(Long roleId);

	public JdbcTemplate getJdbcTemplate();

	public void setJdbcTemplate(JdbcTemplate paramJdbcTemplate);

}