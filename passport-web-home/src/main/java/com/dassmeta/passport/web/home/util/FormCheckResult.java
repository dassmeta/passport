package com.dassmeta.passport.web.home.util;

import org.apache.commons.lang.StringUtils;

/**
 * 表单验证结果
 * 
 * @author chenxin@dassmeta.com
 * @creation 2017年3月9日
 */
public class FormCheckResult {

	/** 表单数据是否合法 */
	private boolean isValid;

	/** 错误信息 */
	private String message;

	/** 默认构造函数 */
	public FormCheckResult() {
		this.isValid = true;
		this.message = "";
	}

	public FormCheckResult(boolean isvalid, String message) {
		this.isValid = isvalid;
		this.message = message;
	}

	/**
	 * 增加错误消息
	 * 
	 * @param msg
	 */
	public void appendMessage(String msg) {

		if (StringUtils.isBlank(msg)) {
			return;
		}
		// 多条错误消息以英文逗号隔开，方便前端页面使用
		message = message.concat(", ").concat(msg);
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FormCheckResult [isValid=");
		builder.append(isValid);
		builder.append(", message=");
		builder.append(message);
		builder.append("]");
		return builder.toString();
	}

}
