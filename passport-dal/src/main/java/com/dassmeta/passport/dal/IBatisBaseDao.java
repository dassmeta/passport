package com.dassmeta.passport.dal;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dassmeta.passport.util.PageList;

/**
 * @param <T>
 * @author chenxin@dassmeta.com
 * @creation 2017年1月19日
 */
public abstract class IBatisBaseDao<T> extends SqlSessionDaoSupport implements IBaseDao<T> {

	public T findByPrimaryKey(Serializable id) throws DataAccessException {
		return getSqlSession().selectOne("selectByPrimaryKey", id);
	}

	public int create(T t) throws DataAccessException {
		return getSqlSession().insert("insert", t);
	}

	public int update(T t) throws DataAccessException {
		return getSqlSession().update("update", t);
	}

	public int remove(T t) throws DataAccessException {
		return getSqlSession().delete("remove", t);
	}

	public int saveOrUpdate(T t) throws DataAccessException {
		return 0;
	}

	public int remove(Serializable id) throws DataAccessException {
		return getSqlSession().delete("deleteByPrimaryKey", id);
	}

	public void batchSave(List<T> paramList) throws DataAccessException {
		// TODO Auto-generated method stub

	}

	public List<T> batchSaveReturnIds(List<T> paramList) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public void batchUpdate(List<T> paramList) throws DataAccessException {
		// TODO Auto-generated method stub

	}

	public int update(String paramString, Object[] paramArrayOfObject) throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getRowCount(String paramString, Object[] paramArrayOfObject) {
		// TODO Auto-generated method stub
		return 0;
	}

	public PageList<T> findPageList(T t) {
		// TODO Auto-generated method stub
		return null;
	}

	public PageList<T> findPageList(Map<String, Object> params) {
		return null;
	}

	public PageList<T> findPageList(T t, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	public JdbcTemplate getJdbcTemplate() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setJdbcTemplate(JdbcTemplate paramJdbcTemplate) {
		// TODO Auto-generated method stub
	}
}
