package com.dassmeta.passport.dal.ibatis.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dassmeta.passport.dal.dataobject.DictionaryIntegration;
import com.dassmeta.passport.dal.ibatis.DictionaryIntegrationDao;
import com.dassmeta.passport.util.IbatisMapperNameSpaceUtil;
import com.dassmeta.passport.util.PageList;
import com.dassmeta.passport.util.PageQueryUtils;

public class DictionaryIntegrationDaoImpl extends SqlSessionDaoSupport implements DictionaryIntegrationDao {

	private JdbcTemplate jdbcTemplate;

	public DictionaryIntegration findByPrimaryKey(Serializable id) throws DataAccessException {
		return getSqlSession().selectOne("selectByPrimaryKey", id);
	}

	public long create(DictionaryIntegration t) throws DataAccessException {
		return getSqlSession().insert("insert", t);
	}

	public int update(DictionaryIntegration t) throws DataAccessException {
		return getSqlSession().update("update", t);
	}

	public int remove(DictionaryIntegration t) throws DataAccessException {
		return getSqlSession().delete("remove", t);
	}

	public int remove(Serializable id) throws DataAccessException {
		return getSqlSession().delete("deleteByPrimaryKey", id);
	}

	public int saveOrUpdate(DictionaryIntegration t) throws DataAccessException {
		return getSqlSession().update("saveOrUpdate", t);
	}

	public int batchSave(List<DictionaryIntegration> paramList) throws DataAccessException {
		return getSqlSession().insert("batchSave", paramList);
	}

	public List<DictionaryIntegration> batchSaveReturnIds(List<DictionaryIntegration> paramList) throws DataAccessException {
		return null;
	}

	public int batchUpdate(List<DictionaryIntegration> paramList) throws DataAccessException {
		return getSqlSession().update("batchUpdate", paramList);
	}

	public PageList<DictionaryIntegration> findPageList(DictionaryIntegration t, int pageSize, int pageNo) {
		IbatisMapperNameSpaceUtil.getMethodPath(this.getClass(), "pageList");
		return PageQueryUtils.pageQuery(getSqlSession(), "pageList", t, pageNo, pageSize);
	}

	public PageList<DictionaryIntegration> findPageList(Map<String, Object> params, int pageSize, int pageNo) {
		return PageQueryUtils.pageQuery(getSqlSession(), "pageList", params, pageNo, pageSize);
	}

	public JdbcTemplate getJdbcTemplate() {
		return this.jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate paramJdbcTemplate) {
		this.jdbcTemplate = paramJdbcTemplate;
	}

}
