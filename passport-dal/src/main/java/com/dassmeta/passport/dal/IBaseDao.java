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
	T findByPrimaryKey(Serializable id) throws DataAccessException;

	long create(T t) throws DataAccessException;

	int update(T t) throws DataAccessException;

	int remove(T t) throws DataAccessException;

	int saveOrUpdate(T t) throws DataAccessException;

	int remove(Serializable id) throws DataAccessException;

	int batchSave(List<T> paramList) throws DataAccessException;

	List<T> batchSaveReturnIds(List<T> paramList) throws DataAccessException;

	int batchUpdate(List<T> paramList) throws DataAccessException;

	PageList<T> findPageList(T t, int pageSize, int pageNo);

	PageList<T> findPageList(Map<String, Object> params, int pageSize, int pageNo);

	JdbcTemplate getJdbcTemplate();

	void setJdbcTemplate(JdbcTemplate paramJdbcTemplate);

}
