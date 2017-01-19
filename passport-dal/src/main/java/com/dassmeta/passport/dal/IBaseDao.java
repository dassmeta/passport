package com.dassmeta.passport.dal;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public interface IBaseDao<T> {
	public T findByPrimaryKey(Serializable id) throws DataAccessException;

	public int create(T t) throws DataAccessException;

	public int update(T t) throws DataAccessException;

	public int remove(T t) throws DataAccessException;

	public int saveOrUpdate(T t) throws DataAccessException;

	public int remove(Serializable id) throws DataAccessException;

	public void batchSave(List<T> paramList) throws DataAccessException;

	public List<T> batchSaveReturnIds(List<T> paramList) throws DataAccessException;

	public void batchUpdate(List<T> paramList) throws DataAccessException;

	public int update(String paramString, Object[] paramArrayOfObject) throws DataAccessException;

	public int getRowCount(String paramString, Object[] paramArrayOfObject);

	public List<T> findPageList(T t);

	public List<T> findPageList(T t, Map<String, Object> params);

	public JdbcTemplate getJdbcTemplate();

	public void setJdbcTemplate(JdbcTemplate paramJdbcTemplate);

}
