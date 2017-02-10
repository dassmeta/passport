package com.dassmeta.passport.dal.ibatis;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dassmeta.passport.dal.dataobject.DictionaryIntegration;
import com.dassmeta.passport.util.PageList;

/**
 * 
 * 
 * @author chenxin@dassmeta.com
 * @creation 2017年2月10日
 */
public interface DictionaryIntegrationDao {

	public DictionaryIntegration findByPrimaryKey(Serializable id) throws DataAccessException;

	public long create(DictionaryIntegration t) throws DataAccessException;

	public int update(DictionaryIntegration t) throws DataAccessException;

	public int remove(DictionaryIntegration t) throws DataAccessException;

	public int saveOrUpdate(DictionaryIntegration t) throws DataAccessException;

	public int remove(Serializable id) throws DataAccessException;

	public int batchSave(List<DictionaryIntegration> paramList) throws DataAccessException;

	public List<DictionaryIntegration> batchSaveReturnIds(List<DictionaryIntegration> paramList) throws DataAccessException;

	public int batchUpdate(List<DictionaryIntegration> paramList) throws DataAccessException;

	public PageList<DictionaryIntegration> findPageList(DictionaryIntegration t, int pageSize, int pageNo);

	public PageList<DictionaryIntegration> findPageList(Map<String, Object> params, int pageSize, int pageNo);

	public JdbcTemplate getJdbcTemplate();

	public void setJdbcTemplate(JdbcTemplate paramJdbcTemplate);

}