package com.dassmeta.passport.dal.ibatis;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dassmeta.passport.dal.dataobject.DictionaryAreacodeRecord;
import com.dassmeta.passport.util.PageList;

/**
 * 
 * 
 * @author chenxin@dassmeta.com
 * @creation 2017年2月10日
 */
public interface DictionaryAreacodeRecordDao {

	public DictionaryAreacodeRecord findByPrimaryKey(Serializable id) throws DataAccessException;

	public long create(DictionaryAreacodeRecord t) throws DataAccessException;

	public int update(DictionaryAreacodeRecord t) throws DataAccessException;

	public int remove(DictionaryAreacodeRecord t) throws DataAccessException;

	public int saveOrUpdate(DictionaryAreacodeRecord t) throws DataAccessException;

	public int remove(Serializable id) throws DataAccessException;

	public int batchSave(List<DictionaryAreacodeRecord> paramList) throws DataAccessException;

	public List<DictionaryAreacodeRecord> batchSaveReturnIds(List<DictionaryAreacodeRecord> paramList) throws DataAccessException;

	public int batchUpdate(List<DictionaryAreacodeRecord> paramList) throws DataAccessException;

	public PageList<DictionaryAreacodeRecord> findPageList(DictionaryAreacodeRecord t, int pageSize, int pageNo);

	public PageList<DictionaryAreacodeRecord> findPageList(Map<String, Object> params, int pageSize, int pageNo);

	public JdbcTemplate getJdbcTemplate();

	public void setJdbcTemplate(JdbcTemplate paramJdbcTemplate);

}