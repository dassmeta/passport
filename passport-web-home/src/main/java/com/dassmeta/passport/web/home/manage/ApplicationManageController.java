package com.dassmeta.passport.web.home.manage;

import org.springframework.stereotype.Controller;

@Controller
public class ApplicationManageController {
	// @Autowired
	// private ApplicationService applicationService;
	//
	// public String list() {
	// Integer page = Struts2Utils.getIntParameter("specter_params_pageNo", Integer.valueOf(1));
	// Map<String, Object> params = new HashMap();
	// this.page = this.applicationService.findForPage(params, page.intValue());
	// return "success";
	// }
	//
	// public String input() throws Exception {
	// return "input";
	// }
	//
	// public String delete() {
	// this.app = ((AppAppInfo) this.baseService.get(AppAppInfo.class, this.app.getId()));
	// this.applicationService.delete(this.app);
	// this.app = null;
	// return "reload";
	// }
	//
	// public String save() throws Exception {
	// Date now = DateFormatUtil.getCurrentSQLDate();
	// this.app.setModifyTime(now);
	// if ((this.id == null) || ("".equals(this.id))) {
	// this.app.setCreateTime(now);
	// this.applicationService.save(this.app);
	// } else {
	// this.baseService.update(this.app);
	// }
	// addActionMessage("������������������");
	// return "reload";
	// }
	//
	// public Page getPage() {
	// return this.page;
	// }
	//
	// public AppAppInfo getApp() {
	// return this.app;
	// }
	//
	// public void setApp(AppAppInfo app) {
	// this.app = app;
	// }
	//
	// protected void prepareModel() throws Exception {
	// if (this.id != null) {
	// this.app = ((AppAppInfo) this.baseService.get(AppAppInfo.class, this.id));
	// } else {
	// this.app = new AppAppInfo();
	// }
	// }
	//
	// public AppAppInfo getModel() {
	// return this.app;
	// }
	//
	// public Long getId() {
	// return this.id;
	// }
	//
	// public void setId(Long id) {
	// this.id = id;
	// }
}
