package com.dassmeta.passport.dal.redis.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dassmeta.passport.dal.dataobject.AuUserDetail;
import com.dassmeta.passport.dal.dataobject.UserDetailVO;
import com.dassmeta.passport.dal.ibatis.AuUserDetailDao;
import com.dassmeta.passport.util.IbatisMapperNameSpaceUtil;
import com.dassmeta.passport.util.PageList;
import com.dassmeta.passport.util.PageQueryUtils;

public class AuUserDetailDaoImpl extends SqlSessionDaoSupport implements AuUserDetailDao {

	private JdbcTemplate jdbcTemplate;

	public AuUserDetail findByPrimaryKey(Serializable id) throws DataAccessException {
		return getSqlSession().selectOne("selectByPrimaryKey", id);
	}

	public long create(AuUserDetail t) throws DataAccessException {
		return getSqlSession().insert("insert", t);
	}

	public int update(AuUserDetail t) throws DataAccessException {
		return getSqlSession().update("update", t);
	}

	public int remove(AuUserDetail t) throws DataAccessException {
		return getSqlSession().delete("remove", t);
	}

	public int remove(Serializable id) throws DataAccessException {
		return getSqlSession().delete("deleteByPrimaryKey", id);
	}

	public int saveOrUpdate(AuUserDetail t) throws DataAccessException {
		return getSqlSession().update("saveOrUpdate", t);
	}

	public int batchSave(List<AuUserDetail> paramList) throws DataAccessException {
		return getSqlSession().insert("batchSave", paramList);
	}

	public List<AuUserDetail> batchSaveReturnIds(List<AuUserDetail> paramList) throws DataAccessException {
		return null;
	}

	public int batchUpdate(List<AuUserDetail> paramList) throws DataAccessException {
		return getSqlSession().update("batchUpdate", paramList);
	}

	public PageList<AuUserDetail> findPageList(AuUserDetail t, int pageSize, int pageNo) {
		IbatisMapperNameSpaceUtil.getMethodPath(this.getClass(), "pageList");
		return PageQueryUtils.pageQuery(getSqlSession(), "pageList", t, pageNo, pageSize);
	}

	public PageList<AuUserDetail> findPageList(Map<String, Object> params, int pageSize, int pageNo) {
		return PageQueryUtils.pageQuery(getSqlSession(), "pageList", params, pageNo, pageSize);
	}

	public JdbcTemplate getJdbcTemplate() {
		return this.jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate paramJdbcTemplate) {
		this.jdbcTemplate = paramJdbcTemplate;
	}

	public UserDetailVO selectUserOrgDetailByUserId(Long id) {
		return getSqlSession().selectOne("selectUserOrgDetailByUserId", id);
	}
}
