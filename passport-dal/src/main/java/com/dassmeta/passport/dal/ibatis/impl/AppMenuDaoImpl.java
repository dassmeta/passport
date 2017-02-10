package com.dassmeta.passport.dal.ibatis.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dassmeta.passport.dal.dataobject.AppMenu;
import com.dassmeta.passport.dal.ibatis.AppMenuDao;
import com.dassmeta.passport.util.IbatisMapperNameSpaceUtil;
import com.dassmeta.passport.util.PageList;
import com.dassmeta.passport.util.PageQueryUtils;

/**
 * 
 * 
 * @author chenxin@dassmeta.com
 * @creation 2017年2月10日
 */
public class AppMenuDaoImpl extends SqlSessionDaoSupport implements AppMenuDao {

	private JdbcTemplate jdbcTemplate;

	public AppMenu findByPrimaryKey(Serializable id) throws DataAccessException {
		return getSqlSession().selectOne("selectByPrimaryKey", id);
	}

	public long create(AppMenu t) throws DataAccessException {
		return getSqlSession().insert("insert", t);
	}

	public int update(AppMenu t) throws DataAccessException {
		return getSqlSession().update("update", t);
	}

	public int remove(AppMenu t) throws DataAccessException {
		return getSqlSession().delete("remove", t);
	}

	public int remove(Serializable id) throws DataAccessException {
		return getSqlSession().delete("deleteByPrimaryKey", id);
	}

	public int saveOrUpdate(AppMenu t) throws DataAccessException {
		return getSqlSession().update("saveOrUpdate", t);
	}

	public int batchSave(List<AppMenu> paramList) throws DataAccessException {
		return getSqlSession().insert("batchSave", paramList);
	}

	public List<AppMenu> batchSaveReturnIds(List<AppMenu> paramList) throws DataAccessException {
		return null;
	}

	public int batchUpdate(List<AppMenu> paramList) throws DataAccessException {
		return getSqlSession().update("batchUpdate", paramList);
	}

	public PageList<AppMenu> findPageList(AppMenu t, int pageSize, int pageNo) {
		IbatisMapperNameSpaceUtil.getMethodPath(this.getClass(), "pageList");
		return PageQueryUtils.pageQuery(getSqlSession(), "pageList", t, pageNo, pageSize);
	}

	public PageList<AppMenu> findPageList(Map<String, Object> params, int pageSize, int pageNo) {
		return PageQueryUtils.pageQuery(getSqlSession(), "pageList", params, pageNo, pageSize);
	}

	public JdbcTemplate getJdbcTemplate() {
		return this.jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate paramJdbcTemplate) {
		this.jdbcTemplate = paramJdbcTemplate;
	}

}
