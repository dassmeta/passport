package com.dassmeta.passport.dal.redis.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dassmeta.passport.dal.dataobject.DictionaryAreacode;
import com.dassmeta.passport.dal.ibatis.DictionaryAreacodeDao;
import com.dassmeta.passport.util.IbatisMapperNameSpaceUtil;
import com.dassmeta.passport.util.PageList;
import com.dassmeta.passport.util.PageQueryUtils;

public class DictionaryAreacodeDaoImpl extends SqlSessionDaoSupport implements DictionaryAreacodeDao {

	private JdbcTemplate jdbcTemplate;

	public DictionaryAreacode findByPrimaryKey(Serializable id) throws DataAccessException {
		return getSqlSession().selectOne("selectByPrimaryKey", id);
	}

	public long create(DictionaryAreacode t) throws DataAccessException {
		return getSqlSession().insert("insert", t);
	}

	public int update(DictionaryAreacode t) throws DataAccessException {
		return getSqlSession().update("update", t);
	}

	public int remove(DictionaryAreacode t) throws DataAccessException {
		return getSqlSession().delete("remove", t);
	}

	public int remove(Serializable id) throws DataAccessException {
		return getSqlSession().delete("deleteByPrimaryKey", id);
	}

	public int saveOrUpdate(DictionaryAreacode t) throws DataAccessException {
		return getSqlSession().update("saveOrUpdate", t);
	}

	public int batchSave(List<DictionaryAreacode> paramList) throws DataAccessException {
		return getSqlSession().insert("batchSave", paramList);
	}

	public List<DictionaryAreacode> batchSaveReturnIds(List<DictionaryAreacode> paramList) throws DataAccessException {
		return null;
	}

	public int batchUpdate(List<DictionaryAreacode> paramList) throws DataAccessException {
		return getSqlSession().update("batchUpdate", paramList);
	}

	public PageList<DictionaryAreacode> findPageList(DictionaryAreacode t, int pageSize, int pageNo) {
		IbatisMapperNameSpaceUtil.getMethodPath(this.getClass(), "pageList");
		return PageQueryUtils.pageQuery(getSqlSession(), "pageList", t, pageNo, pageSize);
	}

	public PageList<DictionaryAreacode> findPageList(Map<String, Object> params, int pageSize, int pageNo) {
		return PageQueryUtils.pageQuery(getSqlSession(), "pageList", params, pageNo, pageSize);
	}

	public List<DictionaryAreacode> getAreaByAreaCode(String areaCode) {
		return getSqlSession().selectList("getAreaByAreaCode", areaCode);
	}

	public List<DictionaryAreacode> getAjaxArea(String areaCode, String area, String nextArea) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("areaCode", areaCode);
		params.put("area", area);
		params.put("nextArea", nextArea);
		return getSqlSession().selectList("getAjaxArea", params);
	}

	public JdbcTemplate getJdbcTemplate() {
		return this.jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate paramJdbcTemplate) {
		this.jdbcTemplate = paramJdbcTemplate;
	}
}
