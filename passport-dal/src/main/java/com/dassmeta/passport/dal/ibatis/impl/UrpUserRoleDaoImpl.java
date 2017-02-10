package com.dassmeta.passport.dal.ibatis.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dassmeta.passport.dal.dataobject.UrpUserRole;
import com.dassmeta.passport.dal.ibatis.UrpUserRoleDao;
import com.dassmeta.passport.util.IbatisMapperNameSpaceUtil;
import com.dassmeta.passport.util.PageList;
import com.dassmeta.passport.util.PageQueryUtils;

public class UrpUserRoleDaoImpl extends SqlSessionDaoSupport implements UrpUserRoleDao {

	private JdbcTemplate jdbcTemplate;

	public UrpUserRole findByPrimaryKey(Serializable id) throws DataAccessException {
		return getSqlSession().selectOne("selectByPrimaryKey", id);
	}

	public long create(UrpUserRole t) throws DataAccessException {
		return getSqlSession().insert("insert", t);
	}

	public int update(UrpUserRole t) throws DataAccessException {
		return getSqlSession().update("update", t);
	}

	public int remove(UrpUserRole t) throws DataAccessException {
		return getSqlSession().delete("remove", t);
	}

	public int remove(Serializable id) throws DataAccessException {
		return getSqlSession().delete("deleteByPrimaryKey", id);
	}

	public int saveOrUpdate(UrpUserRole t) throws DataAccessException {
		return getSqlSession().update("saveOrUpdate", t);
	}

	public int batchSave(List<UrpUserRole> paramList) throws DataAccessException {
		return getSqlSession().insert("batchSave", paramList);
	}

	public List<UrpUserRole> batchSaveReturnIds(List<UrpUserRole> paramList) throws DataAccessException {
		return null;
	}

	public int batchUpdate(List<UrpUserRole> paramList) throws DataAccessException {
		return getSqlSession().update("batchUpdate", paramList);
	}

	public PageList<UrpUserRole> findPageList(UrpUserRole t, int pageSize, int pageNo) {
		IbatisMapperNameSpaceUtil.getMethodPath(this.getClass(), "pageList");
		return PageQueryUtils.pageQuery(getSqlSession(), "pageList", t, pageNo, pageSize);
	}

	public PageList<UrpUserRole> findPageList(Map<String, Object> params, int pageSize, int pageNo) {
		return PageQueryUtils.pageQuery(getSqlSession(), "pageList", params, pageNo, pageSize);
	}

	public void removeByRoleId(Long roleId) {
		getSqlSession().delete("removeByRoleId", roleId);
	}

	public JdbcTemplate getJdbcTemplate() {
		return this.jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate paramJdbcTemplate) {
		this.jdbcTemplate = paramJdbcTemplate;
	}

}
