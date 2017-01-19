package com.dassmeta.passport.web.home.manage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import cn.widewisdom.entity.auth.AuUser;
import cn.widewisdom.entity.report.ReportUserDetail;
import cn.widewisdom.service.ReportService;
import cn.widewisdom.service.RoleService;

import com.specter.dao.Page;
import com.specter.service.BaseService;
import com.specter.web.struts2.CRUDActionSupport;
import com.specter.web.struts2.Struts2Utils;

@Results({ @org.apache.struts2.convention.annotation.Result(name = "reload", type = "redirect", location = "report-manage!list.action"),
		@org.apache.struts2.convention.annotation.Result(name = "back", type = "redirect", location = "report-manage!list.action") })
public class ReportManageAction extends CRUDActionSupport<ReportUserDetail> {
	private static final long serialVersionUID = 1L;
	@Autowired
	private ReportService reportService;
	@Autowired
	private BaseService baseService;
	@Autowired
	private RoleService roleService;
	private ReportUserDetail entity;
	private AuUser user;
	private Map map;
	private Page<ReportUserDetail> page;

	public String list() throws Exception {
		Integer page = Struts2Utils.getIntParameter("specter_params_pageNo", Integer.valueOf(1));
		Map<String, Object> params = new HashMap();
		if (this.entity != null) {
			params.put("identityCard", this.entity.getIdentityCard());
			params.put("userName", this.entity.getUserName());
		}
		this.page = this.reportService.findForPage(params, page.intValue());

		return "success";
	}

	public String delete() throws Exception {
		this.entity = ((ReportUserDetail) this.baseService.get(ReportUserDetail.class, this.entity.getId()));
		this.baseService.delete(this.entity);
		return "reload";
	}

	public String input() throws Exception {
		prepareModel();
		this.map = this.reportService.getReportRole(this.entity.getId());
		return "input";
	}

	public String getAllRole() throws Exception {
		prepareModel();
		this.map = new HashMap();

		List r = this.roleService.getAllRole();
		this.map.put("allRole", r);
		return "all";
	}

	protected void prepareModel() throws Exception {
		if ((this.entity != null) && (this.entity.getId() != null)) {
			this.entity = ((ReportUserDetail) this.baseService.get(ReportUserDetail.class, this.entity.getId()));
		} else {
			this.entity = new ReportUserDetail();
		}
	}

	public String save() throws Exception {
		this.reportService.reportUser(this.user.getLoginId(), this.user.getPassword(), this.entity);

		this.entity = ((ReportUserDetail) this.baseService.get(ReportUserDetail.class, this.entity.getId()));
		this.baseService.delete(this.entity);
		return "reload";
	}

	public ReportUserDetail getModel() {
		return this.entity;
	}

	public ReportUserDetail getEntity() {
		return this.entity;
	}

	public void setEntity(ReportUserDetail entity) {
		this.entity = entity;
	}

	public Page<ReportUserDetail> getPage() {
		return this.page;
	}

	public void setUser(AuUser user) {
		this.user = user;
	}

	public Map getMap() {
		return this.map;
	}
}
