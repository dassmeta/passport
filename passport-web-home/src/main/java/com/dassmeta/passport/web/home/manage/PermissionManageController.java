package com.dassmeta.passport.web.home.manage;

import org.springframework.stereotype.Controller;

@Controller
public class PermissionManageController {
	//
	// @Autowired
	// private ApplicationService applicationService;
	// @Autowired
	// private BaseService baseService;
	// @Autowired
	// private PermissionService permissionService;
	// private Long id;
	// private List<?> appL;
	// private UrpPermission entity;
	// private AppAppInfo app;
	// private Page<UrpPermission> page;
	//
	// public String delete() throws Exception {
	// this.entity = ((UrpPermission) this.baseService.get(UrpPermission.class, this.id));
	// this.permissionService.delete(this.entity);
	// return "reload";
	// }
	//
	// public String enabled() {
	// if ((this.entity != null) && (this.entity.getPid() != null)) {
	// this.permissionService.enabledPermission(this.entity);
	// }
	// return "reload";
	// }
	//
	// public String disabled() {
	// if ((this.entity != null) && (this.entity.getPid() != null)) {
	// this.permissionService.disabledPermission(this.entity);
	// }
	// return "reload";
	// }
	//
	// public String list() throws Exception {
	// Integer page = Struts2Utils.getIntParameter("specter_params_pageNo", Integer.valueOf(1));
	// Map<String, Object> params = new HashMap();
	// if (this.entity != null) {
	// if (this.entity.getName() != null) {
	// System.out.println(this.entity.getName().trim());
	// params.put("name", this.entity.getName().trim());
	// }
	// if (this.entity.getApp().getId() != null) {
	// params.put("appId", this.entity.getApp().getId());
	// }
	// }
	// this.page = this.permissionService.findForPage(params, page.intValue());
	// this.appL = this.applicationService.getAllApp();
	// return "success";
	// }
	//
	// public String check() throws Exception {
	// boolean flag = false;
	//
	// String permissionKey = this.entity.getPermissionKey();
	//
	// permissionKey = new String(this.entity.getPermissionKey().getBytes("ISO-8859-1"), "GBK");
	// flag = this.permissionService.check(this.id, permissionKey);
	//
	// HttpServletResponse response = (HttpServletResponse)
	// ActionContext.getContext().get("com.opensymphony.xwork2.dispatcher.HttpServletResponse");
	//
	// response.getWriter().write(String.valueOf(flag));
	// response.getWriter().flush();
	// response.getWriter().close();
	//
	// return null;
	// }
	//
	// public String save() throws Exception {
	// if ((this.id == null) || ("".equals(this.id))) {
	// this.entity.setPid(null);
	// this.entity.setDeleted("N");
	// this.entity.setCreateTime(DateFormatUtil.getCurrentSQLDate());
	// }
	// this.entity.setModifyTime(DateFormatUtil.getCurrentSQLDate());
	// this.baseService.saveOrUpdate(this.entity);
	// addActionMessage("������������������");
	// return "reload";
	// }
	//
	// public String input() throws Exception {
	// this.appL = this.applicationService.getAllApp();
	// return "input";
	// }
	//
	// protected void prepareModel() throws Exception {
	// if (this.id != null) {
	// this.entity = ((UrpPermission) this.baseService.get(UrpPermission.class, this.id));
	// } else {
	// this.entity = new UrpPermission();
	// }
	// }
	//
	// public UrpPermission getModel() {
	// return this.entity;
	// }
	//
	// public Long getId() {
	// return this.id;
	// }
	//
	// public void setId(Long id) {
	// this.id = id;
	// }
	//
	// public UrpPermission getEntity() {
	// return this.entity;
	// }
	//
	// public void setEntity(UrpPermission entity) {
	// this.entity = entity;
	// }
	//
	// public Page<UrpPermission> getPage() {
	// return this.page;
	// }
	//
	// public List<?> getAppL() {
	// return this.appL;
	// }
	//
	// public AppAppInfo getApp() {
	// return this.app;
	// }
}
