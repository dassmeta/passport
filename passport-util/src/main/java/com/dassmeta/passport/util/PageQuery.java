package com.dassmeta.passport.util;

/**
 * 
 * 
 * @author chenxin@dassmeta.com
 * @creation 2017年1月19日
 */
public class PageQuery {
	private int page;
	private int pageSize;

	public PageQuery() {
	}

	public PageQuery(int page, int pageSize) {
		setPage(page);
		setPageSize(pageSize);
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
