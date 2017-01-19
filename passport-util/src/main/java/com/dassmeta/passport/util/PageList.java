package com.dassmeta.passport.util;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 
 * @param <T>
 * @author chenxin@dassmeta.com
 * @creation 2017年1月19日
 */
public class PageList<T> extends ArrayList<T> {

	private static final long serialVersionUID = 5130949595981949362L;
	private Paginator paginator;

	public PageList() {
		paginator = new Paginator();
	}

	public PageList(Collection<T> c) {
		this(c, null);
	}

	public PageList(Collection<T> c, Paginator paginator) {
		super(c);
		this.paginator = (paginator == null) ? new Paginator() : paginator;
	}

	public Paginator getPaginator() {
		return paginator;
	}

	public void setPaginator(Paginator paginator) {
		if (paginator != null) {
			this.paginator = paginator;
		}
	}
}
