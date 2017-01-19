package com.dassmeta.passport.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * 
 * @param <T>
 * @author chenxin@dassmeta.com
 * @creation 2017年1月19日
 */
public class PageQueryUtils<T> {

	public static PageList<Object> pageQuery(SqlSessionDaoSupport sqlSessionDaoSupport, String statementName, PageQuery parameterObject) {
		return pageQuery(sqlSessionDaoSupport, statementName, statementName + ".count", parameterObject, parameterObject.getPage(), parameterObject.getPageSize());
	}

	public static PageList<Object> pageQuery(SqlSessionDaoSupport sqlSessionDaoSupport, String statementName, String countStatementName, PageQuery parameterObject) {
		return pageQuery(sqlSessionDaoSupport, statementName, countStatementName, parameterObject, parameterObject.getPage(), parameterObject.getPageSize());
	}

	public static PageList<Object> pageQuery(SqlSessionDaoSupport sqlSessionDaoSupport, String statementName, Object parameterObject, int page, int pageSize) {
		return pageQuery(sqlSessionDaoSupport, statementName, statementName + ".count", parameterObject, page, pageSize);
	}

	public static PageList<Object> pageQuery(SqlSessionDaoSupport sqlSessionDaoSupport, String statementName, String countStatementName, Object parameterObject, int page, int pageSize) {

		int totalCount = sqlSessionDaoSupport.getSqlSession().selectOne(countStatementName, parameterObject);

		Paginator paginator = new Paginator(pageSize, totalCount);
		paginator.setPage(page);

		if (totalCount > 0) {
			Map<String, Integer> otherParams = new HashMap<String, Integer>();
			otherParams.put("limit", paginator.getLength());
			otherParams.put("offset", paginator.getOffset());
			otherParams.put("startRow", paginator.getBeginIndex());
			otherParams.put("endRow", paginator.getEndIndex());

			List<Object> list = sqlSessionDaoSupport.getSqlSession().selectList(statementName, otherParams);
			return new PageList<Object>(list, paginator);
		}
		return new PageList<Object>(new ArrayList<Object>(0), new Paginator(pageSize, 0));
	}
}
