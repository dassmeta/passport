package com.dassmeta.passport.dal.redis;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dassmeta.passport.dal.dataobject.AuJobInfo;
import com.dassmeta.passport.util.PageList;

/**
 * 
 * 
 * @author chenxin@dassmeta.com
 * @creation 2017年2月10日
 */
public interface AuJobInfoRedisDao {

	public AuJobInfo findByPrimaryKey(Serializable id) throws DataAccessException;

	public long create(AuJobInfo t) throws DataAccessException;

	public int update(AuJobInfo t) throws DataAccessException;

	public int remove(AuJobInfo t) throws DataAccessException;

	public int saveOrUpdate(AuJobInfo t) throws DataAccessException;

	public int remove(Serializable id) throws DataAccessException;

	public int batchSave(List<AuJobInfo> paramList) throws DataAccessException;

	public List<AuJobInfo> batchSaveReturnIds(List<AuJobInfo> paramList) throws DataAccessException;

	public int batchUpdate(List<AuJobInfo> paramList) throws DataAccessException;

	public PageList<AuJobInfo> findPageList(AuJobInfo t, int pageSize, int pageNo);

	public PageList<AuJobInfo> findPageList(Map<String, Object> params, int pageSize, int pageNo);

	public JdbcTemplate getJdbcTemplate();

	public void setJdbcTemplate(JdbcTemplate paramJdbcTemplate);

}