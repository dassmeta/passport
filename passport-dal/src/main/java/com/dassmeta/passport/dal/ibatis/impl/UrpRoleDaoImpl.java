package com.dassmeta.passport.dal.ibatis.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dassmeta.passport.dal.dataobject.UrpRole;
import com.dassmeta.passport.dal.ibatis.UrpRoleDao;
import com.dassmeta.passport.util.IbatisMapperNameSpaceUtil;
import com.dassmeta.passport.util.PageList;
import com.dassmeta.passport.util.PageQueryUtils;

public class UrpRoleDaoImpl extends SqlSessionDaoSupport implements UrpRoleDao {

	private JdbcTemplate jdbcTemplate;

	public UrpRole findByPrimaryKey(Serializable id) throws DataAccessException {
		return getSqlSession().selectOne("selectByPrimaryKey", id);
	}

	public long create(UrpRole t) throws DataAccessException {
		return getSqlSession().insert("insert", t);
	}

	public int update(UrpRole t) throws DataAccessException {
		return getSqlSession().update("update", t);
	}

	public int remove(UrpRole t) throws DataAccessException {
		return getSqlSession().delete("remove", t);
	}

	public int remove(Serializable id) throws DataAccessException {
		return getSqlSession().delete("deleteByPrimaryKey", id);
	}

	public int saveOrUpdate(UrpRole t) throws DataAccessException {
		return getSqlSession().update("saveOrUpdate", t);
	}

	public int batchSave(List<UrpRole> paramList) throws DataAccessException {
		return getSqlSession().insert("batchSave", paramList);
	}

	public List<UrpRole> batchSaveReturnIds(List<UrpRole> paramList) throws DataAccessException {
		return null;
	}

	public int batchUpdate(List<UrpRole> paramList) throws DataAccessException {
		return getSqlSession().update("batchUpdate", paramList);
	}

	public PageList<UrpRole> findPageList(UrpRole t, int pageSize, int pageNo) {
		IbatisMapperNameSpaceUtil.getMethodPath(this.getClass(), "pageList");
		return PageQueryUtils.pageQuery(getSqlSession(), "pageList", t, pageNo, pageSize);
	}

	public PageList<UrpRole> findPageList(Map<String, Object> params, int pageSize, int pageNo) {
		return PageQueryUtils.pageQuery(getSqlSession(), "pageList", params, pageNo, pageSize);
	}

	public List<UrpRole> getRoleByAppId(String appId) {
		return getSqlSession().selectList("getRoleByAppId", appId);
	}

	public List<UrpRole> getAllRole() {
		return getSqlSession().selectList("getAllRole");
	}

	public JdbcTemplate getJdbcTemplate() {
		return this.jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate paramJdbcTemplate) {
		this.jdbcTemplate = paramJdbcTemplate;
	}

}
