package com.dassmeta.passport.security.cache;

import java.io.Serializable;

/**
 * @author chenxin@dassmeta.com
 * @creation 2017年2月21日
 */
public class CacheModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1404698221790988858L;

	private String name;

	private String code;

	private String value;

	private String state;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
