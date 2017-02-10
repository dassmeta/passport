package com.dassmeta.passport.dal.ibatis;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dassmeta.passport.dal.dataobject.UrpRolePermission;
import com.dassmeta.passport.util.PageList;

/**
 * 
 * 
 * @author chenxin@dassmeta.com
 * @creation 2017年2月10日
 */
public interface UrpRolePermissionDao {

	public UrpRolePermission findByPrimaryKey(Serializable id) throws DataAccessException;

	public long create(UrpRolePermission t) throws DataAccessException;

	public int update(UrpRolePermission t) throws DataAccessException;

	public int remove(UrpRolePermission t) throws DataAccessException;

	public int saveOrUpdate(UrpRolePermission t) throws DataAccessException;

	public int remove(Serializable id) throws DataAccessException;

	public int batchSave(List<UrpRolePermission> paramList) throws DataAccessException;

	public List<UrpRolePermission> batchSaveReturnIds(List<UrpRolePermission> paramList) throws DataAccessException;

	public int batchUpdate(List<UrpRolePermission> paramList) throws DataAccessException;

	public PageList<UrpRolePermission> findPageList(UrpRolePermission t, int pageSize, int pageNo);

	public PageList<UrpRolePermission> findPageList(Map<String, Object> params, int pageSize, int pageNo);

	void removeByPid(Long id);

	void removeByRoleId(Long id);

	public JdbcTemplate getJdbcTemplate();

	public void setJdbcTemplate(JdbcTemplate paramJdbcTemplate);

}