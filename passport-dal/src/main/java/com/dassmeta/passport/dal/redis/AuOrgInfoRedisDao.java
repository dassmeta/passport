package com.dassmeta.passport.dal.redis;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dassmeta.passport.dal.dataobject.AuOrgInfo;
import com.dassmeta.passport.util.PageList;

/**
 * 
 * 
 * @author chenxin@dassmeta.com
 * @creation 2017年2月10日
 */
public interface AuOrgInfoRedisDao {

	public AuOrgInfo findByPrimaryKey(Serializable id) throws DataAccessException;

	public long create(AuOrgInfo t) throws DataAccessException;

	public int update(AuOrgInfo t) throws DataAccessException;

	public int remove(AuOrgInfo t) throws DataAccessException;

	public int saveOrUpdate(AuOrgInfo t) throws DataAccessException;

	public int remove(Serializable id) throws DataAccessException;

	public int batchSave(List<AuOrgInfo> paramList) throws DataAccessException;

	public List<AuOrgInfo> batchSaveReturnIds(List<AuOrgInfo> paramList) throws DataAccessException;

	public int batchUpdate(List<AuOrgInfo> paramList) throws DataAccessException;

	public PageList<AuOrgInfo> findPageList(AuOrgInfo t, int pageSize, int pageNo);

	public PageList<AuOrgInfo> findPageList(Map<String, Object> params, int pageSize, int pageNo);

	public JdbcTemplate getJdbcTemplate();

	public void setJdbcTemplate(JdbcTemplate paramJdbcTemplate);

}