package com.dassmeta.passport.dal.ibatis.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dassmeta.passport.dal.dataobject.AppAppInfo;
import com.dassmeta.passport.dal.ibatis.AppAppInfoDao;
import com.dassmeta.passport.util.PageList;
import com.dassmeta.passport.util.PageQueryUtils;

public class AppAppInfoDaoImpl extends SqlSessionDaoSupport implements AppAppInfoDao {

	// private static final Logger log = LoggerFactory.getLogger(AppAppInfoDaoImpl.class);

	private JdbcTemplate jdbcTemplate;

	public AppAppInfo findByPrimaryKey(Serializable id) throws DataAccessException {
		return getSqlSession().selectOne("com.dassmeta.passport.dal.ibatis.AppAppInfoDao.selectByPrimaryKey", id);
	}

	public long create(AppAppInfo t) throws DataAccessException {
		return getSqlSession().insert("com.dassmeta.passport.dal.ibatis.AppAppInfoDao.insert", t);
	}

	public int update(AppAppInfo t) throws DataAccessException {
		return getSqlSession().update("com.dassmeta.passport.dal.ibatis.AppAppInfoDao.update", t);
	}

	public int remove(AppAppInfo t) throws DataAccessException {
		return getSqlSession().delete("com.dassmeta.passport.dal.ibatis.AppAppInfoDao.remove", t);
	}

	public int remove(Serializable id) throws DataAccessException {
		return getSqlSession().delete("com.dassmeta.passport.dal.ibatis.AppAppInfoDao.deleteByPrimaryKey", id);
	}

	public int saveOrUpdate(AppAppInfo t) throws DataAccessException {
		return getSqlSession().update("com.dassmeta.passport.dal.ibatis.AppAppInfoDao.saveOrUpdate", t);
	}

	public int batchSave(List<AppAppInfo> paramList) throws DataAccessException {
		return getSqlSession().insert("com.dassmeta.passport.dal.ibatis.AppAppInfoDao.batchSave", paramList);
	}

	public List<AppAppInfo> batchSaveReturnIds(List<AppAppInfo> paramList) throws DataAccessException {
		return null;
	}

	public int batchUpdate(List<AppAppInfo> paramList) throws DataAccessException {
		return getSqlSession().update("com.dassmeta.passport.dal.ibatis.AppAppInfoDao.batchUpdate", paramList);
	}

	public PageList<AppAppInfo> findPageList(AppAppInfo t, int pageSize, int pageNo) {
		return PageQueryUtils.pageQuery(getSqlSession(), "com.dassmeta.passport.dal.ibatis.AppAppInfoDao.findPage", t, pageNo, pageSize);
	}

	public PageList<AppAppInfo> findPageList(Map<String, Object> params, int pageSize, int pageNo) {
		return PageQueryUtils.pageQuery(getSqlSession(), "com.dassmeta.passport.dal.ibatis.AppAppInfoDao.findPage", params, pageNo, pageSize);
	}

	public List<AppAppInfo> getAllApp() {
		return getSqlSession().selectList("com.dassmeta.passport.dal.ibatis.AppAppInfoDao.findAllApp");
	}

	public List<AppAppInfo> getAppByShow() {
		return getSqlSession().selectList("com.dassmeta.passport.dal.ibatis.AppAppInfoDao.getAppByShow");
	}

	public AppAppInfo findAppByAppCode(String appCpde) {
		return getSqlSession().selectOne("com.dassmeta.passport.dal.ibatis.AppAppInfoDao.findAppByAppCode", appCpde);
	}

	public JdbcTemplate getJdbcTemplate() {
		return this.jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
