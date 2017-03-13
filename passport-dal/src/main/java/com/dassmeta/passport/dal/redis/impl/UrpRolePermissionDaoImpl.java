package com.dassmeta.passport.dal.redis.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dassmeta.passport.dal.dataobject.UrpRolePermission;
import com.dassmeta.passport.dal.ibatis.UrpRolePermissionDao;
import com.dassmeta.passport.util.IbatisMapperNameSpaceUtil;
import com.dassmeta.passport.util.PageList;
import com.dassmeta.passport.util.PageQueryUtils;

public class UrpRolePermissionDaoImpl extends SqlSessionDaoSupport implements UrpRolePermissionDao {

	private JdbcTemplate jdbcTemplate;

	public UrpRolePermission findByPrimaryKey(Serializable id) throws DataAccessException {
		return getSqlSession().selectOne("selectByPrimaryKey", id);
	}

	public long create(UrpRolePermission t) throws DataAccessException {
		return getSqlSession().insert("insert", t);
	}

	public int update(UrpRolePermission t) throws DataAccessException {
		return getSqlSession().update("update", t);
	}

	public int remove(UrpRolePermission t) throws DataAccessException {
		return getSqlSession().delete("remove", t);
	}

	public int remove(Serializable id) throws DataAccessException {
		return getSqlSession().delete("deleteByPrimaryKey", id);
	}

	public int saveOrUpdate(UrpRolePermission t) throws DataAccessException {
		return getSqlSession().update("saveOrUpdate", t);
	}

	public int batchSave(List<UrpRolePermission> paramList) throws DataAccessException {
		return getSqlSession().insert("batchSave", paramList);
	}

	public List<UrpRolePermission> batchSaveReturnIds(List<UrpRolePermission> paramList) throws DataAccessException {
		return null;
	}

	public int batchUpdate(List<UrpRolePermission> paramList) throws DataAccessException {
		return getSqlSession().update("batchUpdate", paramList);
	}

	public PageList<UrpRolePermission> findPageList(UrpRolePermission t, int pageSize, int pageNo) {
		IbatisMapperNameSpaceUtil.getMethodPath(this.getClass(), "pageList");
		return PageQueryUtils.pageQuery(getSqlSession(), "pageList", t, pageNo, pageSize);
	}

	public PageList<UrpRolePermission> findPageList(Map<String, Object> params, int pageSize, int pageNo) {
		return PageQueryUtils.pageQuery(getSqlSession(), "pageList", params, pageNo, pageSize);
	}

	public void removeByPid(Long id) {
		getSqlSession().delete("removeByPid", id);
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
