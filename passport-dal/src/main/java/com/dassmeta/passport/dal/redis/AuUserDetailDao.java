package com.dassmeta.passport.dal.redis;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dassmeta.passport.dal.dataobject.AuUserDetail;
import com.dassmeta.passport.dal.dataobject.UserDetailVO;
import com.dassmeta.passport.util.PageList;

/**
 * 
 * 
 * @author chenxin@dassmeta.com
 * @creation 2017年2月10日
 */
public interface AuUserDetailDao {

	public AuUserDetail findByPrimaryKey(Serializable id) throws DataAccessException;

	public long create(AuUserDetail t) throws DataAccessException;

	public int update(AuUserDetail t) throws DataAccessException;

	public int remove(AuUserDetail t) throws DataAccessException;

	public int saveOrUpdate(AuUserDetail t) throws DataAccessException;

	public int remove(Serializable id) throws DataAccessException;

	public int batchSave(List<AuUserDetail> paramList) throws DataAccessException;

	public List<AuUserDetail> batchSaveReturnIds(List<AuUserDetail> paramList) throws DataAccessException;

	public int batchUpdate(List<AuUserDetail> paramList) throws DataAccessException;

	public PageList<AuUserDetail> findPageList(AuUserDetail t, int pageSize, int pageNo);

	public PageList<AuUserDetail> findPageList(Map<String, Object> params, int pageSize, int pageNo);

	UserDetailVO selectUserOrgDetailByUserId(Long id);

	public JdbcTemplate getJdbcTemplate();

	public void setJdbcTemplate(JdbcTemplate paramJdbcTemplate);

}