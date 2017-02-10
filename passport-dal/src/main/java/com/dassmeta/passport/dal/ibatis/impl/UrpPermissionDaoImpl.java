package com.dassmeta.passport.dal.ibatis.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dassmeta.passport.dal.dataobject.UrpPermission;
import com.dassmeta.passport.dal.ibatis.UrpPermissionDao;
import com.dassmeta.passport.util.IbatisMapperNameSpaceUtil;
import com.dassmeta.passport.util.PageList;
import com.dassmeta.passport.util.PageQueryUtils;

public class UrpPermissionDaoImpl extends SqlSessionDaoSupport implements UrpPermissionDao {

	private JdbcTemplate jdbcTemplate;

	public UrpPermission findByPrimaryKey(Serializable id) throws DataAccessException {
		return getSqlSession().selectOne("selectByPrimaryKey", id);
	}

	public long create(UrpPermission t) throws DataAccessException {
		return getSqlSession().insert("insert", t);
	}

	public int update(UrpPermission t) throws DataAccessException {
		return getSqlSession().update("update", t);
	}

	public int remove(UrpPermission t) throws DataAccessException {
		return getSqlSession().delete("remove", t);
	}

	public int remove(Serializable id) throws DataAccessException {
		return getSqlSession().delete("deleteByPrimaryKey", id);
	}

	public int saveOrUpdate(UrpPermission t) throws DataAccessException {
		return getSqlSession().update("saveOrUpdate", t);
	}

	public int batchSave(List<UrpPermission> paramList) throws DataAccessException {
		return getSqlSession().insert("batchSave", paramList);
	}

	public List<UrpPermission> batchSaveReturnIds(List<UrpPermission> paramList) throws DataAccessException {
		return null;
	}

	public int batchUpdate(List<UrpPermission> paramList) throws DataAccessException {
		return getSqlSession().update("batchUpdate", paramList);
	}

	public PageList<UrpPermission> findPageList(UrpPermission t, int pageSize, int pageNo) {
		IbatisMapperNameSpaceUtil.getMethodPath(this.getClass(), "pageList");
		return PageQueryUtils.pageQuery(getSqlSession(), "pageList", t, pageNo, pageSize);
	}

	public PageList<UrpPermission> findPageList(Map<String, Object> params, int pageSize, int pageNo) {
		return PageQueryUtils.pageQuery(getSqlSession(), "pageList", params, pageNo, pageSize);
	}

	public List<UrpPermission> getAllPermission() {
		return getSqlSession().selectList("getAllPermission");
	}

	public List<UrpPermission> findByAppId(Long appId) {
		return getSqlSession().selectList("findByAppId", appId);
	}

	public List<UrpPermission> findByRoleId(Long roleId) {
		return getSqlSession().selectList("findByRoleId", roleId);
	}

	public JdbcTemplate getJdbcTemplate() {
		return this.jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate paramJdbcTemplate) {
		this.jdbcTemplate = paramJdbcTemplate;
	}

}
