package com.dassmeta.passport.dal.redis.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dassmeta.passport.dal.dataobject.DictionaryAreacodeRecord;
import com.dassmeta.passport.dal.ibatis.DictionaryAreacodeRecordDao;
import com.dassmeta.passport.util.IbatisMapperNameSpaceUtil;
import com.dassmeta.passport.util.PageList;
import com.dassmeta.passport.util.PageQueryUtils;

public class DictionaryAreacodeRecordDaoImpl extends SqlSessionDaoSupport implements DictionaryAreacodeRecordDao {

	private JdbcTemplate jdbcTemplate;

	public DictionaryAreacodeRecord findByPrimaryKey(Serializable id) throws DataAccessException {
		return getSqlSession().selectOne("selectByPrimaryKey", id);
	}

	public long create(DictionaryAreacodeRecord t) throws DataAccessException {
		return getSqlSession().insert("insert", t);
	}

	public int update(DictionaryAreacodeRecord t) throws DataAccessException {
		return getSqlSession().update("update", t);
	}

	public int remove(DictionaryAreacodeRecord t) throws DataAccessException {
		return getSqlSession().delete("remove", t);
	}

	public int remove(Serializable id) throws DataAccessException {
		return getSqlSession().delete("deleteByPrimaryKey", id);
	}

	public int saveOrUpdate(DictionaryAreacodeRecord t) throws DataAccessException {
		return getSqlSession().update("saveOrUpdate", t);
	}

	public int batchSave(List<DictionaryAreacodeRecord> paramList) throws DataAccessException {
		return getSqlSession().insert("batchSave", paramList);
	}

	public List<DictionaryAreacodeRecord> batchSaveReturnIds(List<DictionaryAreacodeRecord> paramList) throws DataAccessException {
		return null;
	}

	public int batchUpdate(List<DictionaryAreacodeRecord> paramList) throws DataAccessException {
		return getSqlSession().update("batchUpdate", paramList);
	}

	public PageList<DictionaryAreacodeRecord> findPageList(DictionaryAreacodeRecord t, int pageSize, int pageNo) {
		IbatisMapperNameSpaceUtil.getMethodPath(this.getClass(), "pageList");
		return PageQueryUtils.pageQuery(getSqlSession(), "pageList", t, pageNo, pageSize);
	}

	public PageList<DictionaryAreacodeRecord> findPageList(Map<String, Object> params, int pageSize, int pageNo) {
		return PageQueryUtils.pageQuery(getSqlSession(), "pageList", params, pageNo, pageSize);
	}

	public JdbcTemplate getJdbcTemplate() {
		return this.jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate paramJdbcTemplate) {
		this.jdbcTemplate = paramJdbcTemplate;
	}

}
