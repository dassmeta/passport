package com.dassmeta.passport.dal;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dassmeta.passport.util.IbatisMapperNameSpaceUtil;
import com.dassmeta.passport.util.PageList;
import com.dassmeta.passport.util.PageQueryUtils;

/**
 * @param <T>
 * @author chenxin@dassmeta.com
 * @creation 2017年1月19日
 */
public abstract class IBatisBaseDao<T> extends SqlSessionDaoSupport implements IBaseDao<T> {

	private JdbcTemplate jdbcTemplate;

	public T findByPrimaryKey(Serializable id) throws DataAccessException {
		return getSqlSession().selectOne("selectByPrimaryKey", id);
	}

	public long create(T t) throws DataAccessException {
		return getSqlSession().insert("insert", t);
	}

	public int update(T t) throws DataAccessException {
		return getSqlSession().update("update", t);
	}

	public int remove(T t) throws DataAccessException {
		return getSqlSession().delete("remove", t);
	}

	public int remove(Serializable id) throws DataAccessException {
		return getSqlSession().delete("deleteByPrimaryKey", id);
	}

	public int saveOrUpdate(T t) throws DataAccessException {
		return getSqlSession().update("saveOrUpdate", t);
	}

	public int batchSave(List<T> paramList) throws DataAccessException {
		return getSqlSession().insert("batchSave", paramList);
	}

	public List<T> batchSaveReturnIds(List<T> paramList) throws DataAccessException {
		return null;
	}

	public int batchUpdate(List<T> paramList) throws DataAccessException {
		return getSqlSession().update("batchUpdate", paramList);
	}

	public PageList<T> findPageList(T t, int pageSize, int pageNo) {
		IbatisMapperNameSpaceUtil.getMethodPath(this.getClass(), "pageList");
		return PageQueryUtils.pageQuery(getSqlSession(), "pageList", t, pageNo, pageSize);
	}

	public PageList<T> findPageList(Map<String, Object> params, int pageSize, int pageNo) {
		return PageQueryUtils.pageQuery(getSqlSession(), "pageList", params, pageNo, pageSize);
	}

	public JdbcTemplate getJdbcTemplate() {
		return this.jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate paramJdbcTemplate) {
		this.jdbcTemplate = paramJdbcTemplate;
	}
}
