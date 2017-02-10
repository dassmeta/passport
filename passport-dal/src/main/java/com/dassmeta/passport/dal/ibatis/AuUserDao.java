package com.dassmeta.passport.dal.ibatis;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dassmeta.passport.dal.dataobject.AuUser;
import com.dassmeta.passport.dal.dataobject.AuUserDetail;
import com.dassmeta.passport.util.PageList;

/**
 * 
 * 
 * @author chenxin@dassmeta.com
 * @creation 2017年2月10日
 */
public interface AuUserDao {

	public AuUser findByPrimaryKey(Serializable id) throws DataAccessException;

	public long create(AuUser t) throws DataAccessException;

	public int update(AuUser t) throws DataAccessException;

	public int remove(AuUser t) throws DataAccessException;

	public int saveOrUpdate(AuUser t) throws DataAccessException;

	public int remove(Serializable id) throws DataAccessException;

	public int batchSave(List<AuUser> paramList) throws DataAccessException;

	public List<AuUser> batchSaveReturnIds(List<AuUser> paramList) throws DataAccessException;

	public int batchUpdate(List<AuUser> paramList) throws DataAccessException;

	public PageList<AuUser> findPageList(AuUser t, int pageSize, int pageNo);

	public PageList<AuUser> findPageList(Map<String, Object> params, int pageSize, int pageNo);

	AuUser findByLoginName(String loginName);

	int updataPasswordByLoginName(String loginName, String newPassword);

	AuUserDetail getUserDetail(Long id);

	AuUser isLoginUser(AuUser user);

	public JdbcTemplate getJdbcTemplate();

	public void setJdbcTemplate(JdbcTemplate paramJdbcTemplate);

}