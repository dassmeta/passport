package com.dassmeta.passport.web.home.report;

import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import cn.widewisdom.entity.report.RAuUserDetail;
import cn.widewisdom.service.ReportService;

import com.specter.service.BaseService;
import com.specter.web.struts2.Struts2Utils;

@Results({ @org.apache.struts2.convention.annotation.Result(name = "reload", type = "redirect", location = "user-report!list.action"),
		@org.apache.struts2.convention.annotation.Result(name = "suc", type = "redirect", location = "user-report.action") })
public class UserManageAction {
	@Autowired
	private BaseService baseService;
	@Autowired
	private ReportService reportService;
	private RAuUserDetail auUser;

	public String execute() throws Exception {
		return "success";
	}

	public String modifyPersonalInfo() {
		String loginId = Struts2Utils.getParameter("loginId");
		this.auUser = this.reportService.getAuUserDetail(loginId);
		Struts2Utils.getRequest().setAttribute("loginId", loginId);
		return "modifyPersonalInfo";
	}

	public String saveModification() {
		this.auUser.setModifyTime(new java.sql.Date(new java.util.Date().getTime()));
		this.baseService.saveOrUpdate(this.auUser);
		Struts2Utils.getRequest().setAttribute("result", "success");
		return "suc";
	}

	public RAuUserDetail getAuUser() {
		return this.auUser;
	}

	public void setAuUser(RAuUserDetail auUser) {
		this.auUser = auUser;
	}
}
