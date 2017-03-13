package com.dassmeta.passport.dal.redis.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dassmeta.passport.dal.dataobject.AuUser;
import com.dassmeta.passport.dal.dataobject.AuUserDetail;
import com.dassmeta.passport.dal.ibatis.AuUserDao;
import com.dassmeta.passport.util.IbatisMapperNameSpaceUtil;
import com.dassmeta.passport.util.PageList;
import com.dassmeta.passport.util.PageQueryUtils;

public class AuUserDaoImpl extends SqlSessionDaoSupport implements AuUserDao {

	private JdbcTemplate jdbcTemplate;

	public AuUser findByPrimaryKey(Serializable id) throws DataAccessException {
		return getSqlSession().selectOne("selectByPrimaryKey", id);
	}

	public long create(AuUser t) throws DataAccessException {
		return getSqlSession().insert("insert", t);
	}

	public int update(AuUser t) throws DataAccessException {
		return getSqlSession().update("update", t);
	}

	public int remove(AuUser t) throws DataAccessException {
		return getSqlSession().delete("remove", t);
	}

	public int remove(Serializable id) throws DataAccessException {
		return getSqlSession().delete("deleteByPrimaryKey", id);
	}

	public int saveOrUpdate(AuUser t) throws DataAccessException {
		return getSqlSession().update("saveOrUpdate", t);
	}

	public int batchSave(List<AuUser> paramList) throws DataAccessException {
		return getSqlSession().insert("batchSave", paramList);
	}

	public List<AuUser> batchSaveReturnIds(List<AuUser> paramList) throws DataAccessException {
		return null;
	}

	public int batchUpdate(List<AuUser> paramList) throws DataAccessException {
		return getSqlSession().update("batchUpdate", paramList);
	}

	public PageList<AuUser> findPageList(AuUser t, int pageSize, int pageNo) {
		IbatisMapperNameSpaceUtil.getMethodPath(this.getClass(), "pageList");
		return PageQueryUtils.pageQuery(getSqlSession(), "pageList", t, pageNo, pageSize);
	}

	public PageList<AuUser> findPageList(Map<String, Object> params, int pageSize, int pageNo) {
		return PageQueryUtils.pageQuery(getSqlSession(), "pageList", params, pageNo, pageSize);
	}

	public AuUser findByLoginName(String loginName) {
		return getSqlSession().selectOne("findByLoginName", loginName);
	}

	public int updataPasswordByLoginName(String loginName, String newPassword) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("loginName", loginName);
		params.put("newPassword", newPassword);
		return getSqlSession().update("updataPasswordByLoginName", params);
	}

	public AuUserDetail getUserDetail(Long id) {
		return null;
	}

	public AuUser isLoginUser(AuUser user) {
		return getSqlSession().selectOne("isLoginUser", user);
	}

	public JdbcTemplate getJdbcTemplate() {
		return this.jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate paramJdbcTemplate) {
		this.jdbcTemplate = paramJdbcTemplate;
	}

}
