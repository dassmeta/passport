package com.dassmeta.passport.dal.redis;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dassmeta.passport.dal.dataobject.DictionaryAreacode;
import com.dassmeta.passport.util.PageList;

/**
 * 
 * 
 * @author chenxin@dassmeta.com
 * @creation 2017年2月10日
 */
public interface DictionaryAreacodeRedisDao {

	public DictionaryAreacode findByPrimaryKey(Serializable id) throws DataAccessException;

	public long create(DictionaryAreacode t) throws DataAccessException;

	public int update(DictionaryAreacode t) throws DataAccessException;

	public int remove(DictionaryAreacode t) throws DataAccessException;

	public int saveOrUpdate(DictionaryAreacode t) throws DataAccessException;

	public int remove(Serializable id) throws DataAccessException;

	public int batchSave(List<DictionaryAreacode> paramList) throws DataAccessException;

	public List<DictionaryAreacode> batchSaveReturnIds(List<DictionaryAreacode> paramList) throws DataAccessException;

	public int batchUpdate(List<DictionaryAreacode> paramList) throws DataAccessException;

	public PageList<DictionaryAreacode> findPageList(DictionaryAreacode t, int pageSize, int pageNo);

	public PageList<DictionaryAreacode> findPageList(Map<String, Object> params, int pageSize, int pageNo);

	List<DictionaryAreacode> getAreaByAreaCode(String areaCode);

	List<DictionaryAreacode> getAjaxArea(String areaCode, String area, String nextArea);

	public JdbcTemplate getJdbcTemplate();

	public void setJdbcTemplate(JdbcTemplate paramJdbcTemplate);

}