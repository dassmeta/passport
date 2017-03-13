package com.dassmeta.passport.dal.redis.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dassmeta.passport.dal.dataobject.UrpUserPermission;
import com.dassmeta.passport.dal.ibatis.UrpUserPermissionDao;
import com.dassmeta.passport.util.IbatisMapperNameSpaceUtil;
import com.dassmeta.passport.util.PageList;
import com.dassmeta.passport.util.PageQueryUtils;

public class UrpUserPermissionDaoImpl extends SqlSessionDaoSupport implements UrpUserPermissionDao {

	private JdbcTemplate jdbcTemplate;

	public UrpUserPermission findByPrimaryKey(Serializable id) throws DataAccessException {
		return getSqlSession().selectOne("selectByPrimaryKey", id);
	}

	public long create(UrpUserPermission t) throws DataAccessException {
		return getSqlSession().insert("insert", t);
	}

	public int update(UrpUserPermission t) throws DataAccessException {
		return getSqlSession().update("update", t);
	}

	public int remove(UrpUserPermission t) throws DataAccessException {
		return getSqlSession().delete("remove", t);
	}

	public int remove(Serializable id) throws DataAccessException {
		return getSqlSession().delete("deleteByPrimaryKey", id);
	}

	public int saveOrUpdate(UrpUserPermission t) throws DataAccessException {
		return getSqlSession().update("saveOrUpdate", t);
	}

	public int batchSave(List<UrpUserPermission> paramList) throws DataAccessException {
		return getSqlSession().insert("batchSave", paramList);
	}

	public List<UrpUserPermission> batchSaveReturnIds(List<UrpUserPermission> paramList) throws DataAccessException {
		return null;
	}

	public int batchUpdate(List<UrpUserPermission> paramList) throws DataAccessException {
		return getSqlSession().update("batchUpdate", paramList);
	}

	public PageList<UrpUserPermission> findPageList(UrpUserPermission t, int pageSize, int pageNo) {
		IbatisMapperNameSpaceUtil.getMethodPath(this.getClass(), "pageList");
		return PageQueryUtils.pageQuery(getSqlSession(), "pageList", t, pageNo, pageSize);
	}

	public PageList<UrpUserPermission> findPageList(Map<String, Object> params, int pageSize, int pageNo) {
		return PageQueryUtils.pageQuery(getSqlSession(), "pageList", params, pageNo, pageSize);
	}

	public JdbcTemplate getJdbcTemplate() {
		return this.jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate paramJdbcTemplate) {
		this.jdbcTemplate = paramJdbcTemplate;
	}

	public void removeByPid(Long id) {
		getSqlSession().delete("removeByPid", id);

	}

}
