package com.dassmeta.passport.web.home.report;

import java.util.List;

import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import cn.widewisdom.service.ApplicationService;

@Results({ @org.apache.struts2.convention.annotation.Result(name = "reload", type = "redirect", location = "user-report!list.action") })
public class IndexAction {
	@Autowired
	private ApplicationService applicationService;
	private List<?> set;

	public String execute() throws Exception {
		this.set = this.applicationService.getApp();
		return "success";
	}

	public List<?> getSet() {
		return this.set;
	}

	public void setSet(List<?> set) {
		this.set = set;
	}
}
