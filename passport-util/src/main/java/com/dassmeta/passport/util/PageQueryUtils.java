package com.dassmeta.passport.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

/**
 * 
 * @param <T>
 * @author chenxin@dassmeta.com
 * @creation 2017年1月19日
 */
public class PageQueryUtils<T> {

	public static <T> PageList<T> pageQuery(SqlSession sqlSession, String statementName, Map<String, Object> params, int currentPage, int pageSize) {
		return pageQuery(sqlSession, statementName, statementName + ".count", params, currentPage, pageSize);
	}

	public static <T> PageList<T> pageQuery(SqlSession sqlSession, String statementName, T t, int currentPage, int pageSize) {
		return pageQuery(sqlSession, statementName, statementName + ".count", t, currentPage, pageSize);
	}

	public static <T> PageList<T> pageQuery(SqlSession sqlsession, String statementName, String countStatementName, T t, int currentPage, int pageSize) {

		int totalCount = sqlsession.selectOne(countStatementName, t);
		Paginator paginator = new Paginator(pageSize, totalCount);
		paginator.setPage(currentPage);
		Map<String, Object> params = new HashMap<String, Object>();
		if (totalCount > 0) {
			params.put("limit", paginator.getLength());
			params.put("offset", paginator.getOffset());
			params.put("startRow", paginator.getBeginIndex());
			params.put("endRow", paginator.getEndIndex());
			List<T> list = sqlsession.selectList(statementName, params);
			return new PageList<T>(list, paginator);
		}
		return new PageList<T>(new ArrayList<T>(0), new Paginator(pageSize, 0));
	}

	public static <T> PageList<T> pageQuery(SqlSession sqlsession, String statementName, String countStatementName, Map<String, Object> params, int currentPage, int pageSize) {

		int totalCount = sqlsession.selectOne(countStatementName, params);

		Paginator paginator = new Paginator(pageSize, totalCount);
		paginator.setPage(currentPage);

		if (totalCount > 0) {
			params.put("limit", paginator.getLength());
			params.put("offset", paginator.getOffset());
			params.put("startRow", paginator.getBeginIndex());
			params.put("endRow", paginator.getEndIndex());

			List<T> list = sqlsession.selectList(statementName, params);
			return new PageList<T>(list, paginator);
		}
		return new PageList<T>(new ArrayList<T>(0), new Paginator(pageSize, 0));
	}
}