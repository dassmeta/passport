package com.dassmeta.passport.util;

import java.io.Serializable;

public class ReturnJson<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8582430288374229869L;

	private Integer total;
	private T rows;

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public T getRows() {
		return rows;
	}

	public void setRows(T rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "ReturnJson [total=" + total + ", rows=" + rows + "]";
	}
}
