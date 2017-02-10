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

	public static <T> PageList<T> pageQuery(SqlSession sqlSession, String statementName, PageQuery parameterObject) {
		return pageQuery(sqlSession, statementName, statementName + ".count", parameterObject, parameterObject.getPage(), parameterObject.getPageSize());
	}

	public static <T> PageList<T> pageQuery(SqlSession sqlSession, String statementName, String countStatementName, PageQuery parameterObject) {
		return pageQuery(sqlSession, statementName, countStatementName, parameterObject, parameterObject.getPage(), parameterObject.getPageSize());
	}

	public static <T> PageList<T> pageQuery(SqlSession sqlSession, String statementName, Object parameterObject, int page, int pageSize) {
		return pageQuery(sqlSession, statementName, statementName + ".count", parameterObject, page, pageSize);
	}

	public static <T> PageList<T> pageQuery(SqlSession sqlsession, String statementName, String countStatementName, Object parameterObject, int page, int pageSize) {

		int totalCount = sqlsession.selectOne(countStatementName, parameterObject);

		Paginator paginator = new Paginator(pageSize, totalCount);
		paginator.setPage(page);

		if (totalCount > 0) {
			Map<String, Integer> otherParams = new HashMap<String, Integer>();
			otherParams.put("limit", paginator.getLength());
			otherParams.put("offset", paginator.getOffset());
			otherParams.put("startRow", paginator.getBeginIndex());
			otherParams.put("endRow", paginator.getEndIndex());

			List<T> list = sqlsession.selectList(statementName, otherParams);
			return new PageList<T>(list, paginator);
		}
		return new PageList<T>(new ArrayList<T>(0), new Paginator(pageSize, 0));
	}
}