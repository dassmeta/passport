package com.dassmeta.passport.web.home.manage;

import org.springframework.stereotype.Controller;

@Controller
public class MenuManageController {
	// @Autowired
	// private BaseService baseService;
	// private AppMenu menu;
	// private Long id;
	// private Long parentId;
	// private Long appId;
	//
	// public String delete() throws Exception {
	// this.baseService.delete(AppMenu.class, this.id);
	// return "ajax";
	// }
	//
	// public String ajax() {
	// this.menu = ((AppMenu) this.baseService.get(AppMenu.class, this.id));
	// return "ajax";
	// }
	//
	// public String cheakMenu() {
	// String bool = "false";
	// String permissionKey = "";
	// if (this.menu.getPermissionKey() != null) {
	// try {
	// permissionKey = new String(this.menu.getPermissionKey().getBytes("ISO-8859-1"), "GBK");
	// } catch (UnsupportedEncodingException e) {
	// e.printStackTrace();
	// }
	// }
	// if ("".equals(this.id)) {
	// AppMenu menua = (AppMenu) this.baseService.getByUnique(AppMenu.class, "permissionKey", permissionKey);
	// if (menua != null) {
	// bool = "true";
	// }
	// } else {
	// AppMenu menub = (AppMenu) this.baseService.get(AppMenu.class, this.id);
	// String permissionValue = menub.getPermissionKey();
	// if (permissionKey.equals(permissionValue)) {
	// bool = "false";
	// } else {
	// UrpPermission permissionc = (UrpPermission) this.baseService.getByUnique(UrpPermission.class, "permissionKey",
	// permissionKey);
	// if (permissionc != null) {
	// bool = "true";
	// }
	// }
	// }
	// HttpServletResponse response = (HttpServletResponse)
	// ActionContext.getContext().get("com.opensymphony.xwork2.dispatcher.HttpServletResponse");
	// try {
	// response.getWriter().write(bool);
	// response.getWriter().flush();
	// response.getWriter().close();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// return null;
	// }
	//
	// public String save() throws Exception {
	// Date now = DateFormatUtil.getCurrentSQLDate();
	// if ((this.id == null) || ("".equals(this.id))) {
	// this.menu.setId(null);
	// this.menu.setParentId(this.parentId);
	// this.menu.setCreateTime(now);
	// this.menu.setModifyTime(now);
	// this.menu.setAppId(this.appId);
	// this.menu = ((AppMenu) this.baseService.save(this.menu));
	// UrpPermission perm = new UrpPermission();
	// perm.setPid(null);
	// perm.setCreateTime(now);
	// AppAppInfo app = (AppAppInfo) this.baseService.get(AppAppInfo.class, this.appId);
	// perm.setApp(app);
	// perm.setDeleted("N");
	// perm.setDescription(this.menu.getDescription() + "(������)");
	// perm.setModifyTime(now);
	// perm.setName(this.menu.getMenuName() + "(������)");
	// perm.setPermissionKey(this.menu.getPermissionKey());
	// perm.setPermissionType("lable");
	// this.baseService.save(perm);
	// } else {
	// AppMenu menua = (AppMenu) this.baseService.get(AppMenu.class, this.id);
	//
	// UrpPermission perm = (UrpPermission) this.baseService.getByUnique(UrpPermission.class, "permissionKey",
	// menua.getPermissionKey());
	// if (perm != null) {
	// perm.setDescription(this.menu.getDescription() + "(������)");
	// perm.setModifyTime(now);
	// perm.setName(this.menu.getMenuName() + "(������)");
	// perm.setPermissionKey(this.menu.getPermissionKey());
	// this.baseService.update(perm);
	// }
	// this.menu.setModifyTime(now);
	// this.baseService.update(this.menu);
	// }
	// addActionMessage("������������������");
	// return "success";
	// }
	//
	// public String list() throws Exception {
	// return "success";
	// }
	//
	// protected void prepareModel() throws Exception {
	// if (this.id != null) {
	// this.menu = ((AppMenu) this.baseService.get(AppMenu.class, this.id));
	// } else {
	// this.menu = new AppMenu();
	// }
	// }
	//
	// public AppMenu getModel() {
	// return this.menu;
	// }
	//
	// public AppMenu getMenu() {
	// return this.menu;
	// }
	//
	// public void setMenu(AppMenu menu) {
	// this.menu = menu;
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
	// public Long getParentId() {
	// return this.parentId;
	// }
	//
	// public void setParentId(Long parentId) {
	// this.parentId = parentId;
	// }
	//
	// public Long getAppId() {
	// return this.appId;
	// }
	//
	// public void setAppId(Long appId) {
	// this.appId = appId;
	// }
}
