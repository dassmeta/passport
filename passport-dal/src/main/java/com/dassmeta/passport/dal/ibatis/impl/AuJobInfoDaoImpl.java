package com.dassmeta.passport.dal.ibatis.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dassmeta.passport.dal.dataobject.AuJobInfo;
import com.dassmeta.passport.dal.ibatis.AuJobInfoDao;
import com.dassmeta.passport.util.IbatisMapperNameSpaceUtil;
import com.dassmeta.passport.util.PageList;
import com.dassmeta.passport.util.PageQueryUtils;

public class AuJobInfoDaoImpl extends SqlSessionDaoSupport implements AuJobInfoDao {

	private JdbcTemplate jdbcTemplate;

	public AuJobInfo findByPrimaryKey(Serializable id) throws DataAccessException {
		return getSqlSession().selectOne("selectByPrimaryKey", id);
	}

	public long create(AuJobInfo t) throws DataAccessException {
		return getSqlSession().insert("insert", t);
	}

	public int update(AuJobInfo t) throws DataAccessException {
		return getSqlSession().update("update", t);
	}

	public int remove(AuJobInfo t) throws DataAccessException {
		return getSqlSession().delete("remove", t);
	}

	public int remove(Serializable id) throws DataAccessException {
		return getSqlSession().delete("deleteByPrimaryKey", id);
	}

	public int saveOrUpdate(AuJobInfo t) throws DataAccessException {
		return getSqlSession().update("saveOrUpdate", t);
	}

	public int batchSave(List<AuJobInfo> paramList) throws DataAccessException {
		return getSqlSession().insert("batchSave", paramList);
	}

	public List<AuJobInfo> batchSaveReturnIds(List<AuJobInfo> paramList) throws DataAccessException {
		return null;
	}

	public int batchUpdate(List<AuJobInfo> paramList) throws DataAccessException {
		return getSqlSession().update("batchUpdate", paramList);
	}

	public PageList<AuJobInfo> findPageList(AuJobInfo t, int pageSize, int pageNo) {
		IbatisMapperNameSpaceUtil.getMethodPath(this.getClass(), "pageList");
		return PageQueryUtils.pageQuery(getSqlSession(), "pageList", t, pageNo, pageSize);
	}

	public PageList<AuJobInfo> findPageList(Map<String, Object> params, int pageSize, int pageNo) {
		return PageQueryUtils.pageQuery(getSqlSession(), "pageList", params, pageNo, pageSize);
	}

	public JdbcTemplate getJdbcTemplate() {
		return this.jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate paramJdbcTemplate) {
		this.jdbcTemplate = paramJdbcTemplate;
	}

}
