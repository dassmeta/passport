package com.dassmeta.passport.dal;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dassmeta.passport.util.PageList;

/**
 * 
 * @param <T>
 * @author chenxin@dassmeta.com
 * @creation 2017年1月19日
 */
public interface IBaseDao<T> {
	public T findByPrimaryKey(Serializable id) throws DataAccessException;

	public long create(T t) throws DataAccessException;

	public int update(T t) throws DataAccessException;

	public int remove(T t) throws DataAccessException;

	public int saveOrUpdate(T t) throws DataAccessException;

	public int remove(Serializable id) throws DataAccessException;

	public int batchSave(List<T> paramList) throws DataAccessException;

	public List<T> batchSaveReturnIds(List<T> paramList) throws DataAccessException;

	public int batchUpdate(List<T> paramList) throws DataAccessException;

	public PageList<T> findPageList(T t, int pageSize, int pageNo);

	public PageList<T> findPageList(Map<String, Object> params, int pageSize, int pageNo);

	public JdbcTemplate getJdbcTemplate();

	public void setJdbcTemplate(JdbcTemplate paramJdbcTemplate);

}
