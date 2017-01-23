package com.dassmeta.passport.web.home.manage;

import org.springframework.stereotype.Controller;

@Controller
public class UserManageController {
	// @Autowired
	// private TreeService treeService;
	// @Autowired
	// private UserService userService;
	// @Autowired
	// private BaseService baseService;
	// @Autowired
	// private PermissionService permissionService;
	// @Autowired
	// private ApplicationService applicationService;
	// @Autowired
	// private DepartService departService;
	// private AuUserDetail entity;
	// private AuUser user;
	// private Map map;
	// private String userRoleId;
	// private String roleId;
	// private String userPerId;
	// private String perId;
	// private List<?> orglist;
	// private List<?> joblist;
	// private Long orgID;
	// private String orgName;
	// private Long id;
	// private AuOrgInfo org;
	// private String userName;
	// private String loginId;
	// private boolean flog = true;
	// private Page<AuUserDetail> page;
	// private Page<AuUserView> pageView;
	//
	// public String list() throws Exception {
	// Integer page = Struts2Utils.getIntParameter("specter_params_pageNo", Integer.valueOf(1));
	// Map<String, Object> params = new HashMap();
	// if ((this.orgID != null) && (!"".equals(this.orgID))) {
	// params.put("orgId", this.orgID);
	// }
	// params.put("userName", this.userName);
	// params.put("loginId", this.loginId);
	//
	// HttpSession session = Struts2Utils.getSession();
	// String loginId = (String) session.getAttribute("specter_session_login_key");
	// AuOrgInfo orgInfo = this.treeService.getAuOrgInfo(loginId);
	// if (orgInfo != null) {
	// params.put("orgCode", orgInfo.getOrgCode());
	// }
	// this.pageView = this.departService.findForViewPage(params, page.intValue());
	//
	// return "success";
	// }
	//
	// public String save() throws Exception {
	// String[] userRoleIdArr = (String[]) null;
	// String[] userPerIdArr = (String[]) null;
	// if ((this.id == null) || ("".equals(this.id))) {
	// this.user.setModifyTime(DateFormatUtil.getCurrentSQLDate());
	// this.user.setCreateTime(DateFormatUtil.getCurrentSQLDate());
	// this.user.setId(null);
	// this.user.setDeleted("N");
	//
	// this.user = ((AuUser) this.baseService.save(this.user));
	// this.entity.setModifyTime(DateFormatUtil.getCurrentSQLDate());
	// this.entity.setCreateTime(DateFormatUtil.getCurrentSQLDate());
	// this.entity.setId(null);
	// this.entity.setDeleted("N");
	// AuOrgInfo org = (AuOrgInfo) this.baseService.get(AuOrgInfo.class, this.orgID);
	// this.entity.setOrg(org);
	// this.entity.setUserId(this.user.getId());
	//
	// this.entity = ((AuUserDetail) this.baseService.save(this.entity));
	// if ((!"".equals(this.userRoleId)) && (this.userRoleId != null)) {
	// userRoleIdArr = this.userRoleId.split(";");
	// Long userId = this.entity.getUserId();
	// for (int i = 0; i < userRoleIdArr.length; i++) {
	// UrpUserRole userRole = new UrpUserRole();
	// userRole.setRoleId(new Long(userRoleIdArr[i]));
	// userRole.setUserId(userId);
	// userRole.setCreateTime(DateFormatUtil.getCurrentSQLDate());
	// userRole.setModifyTime(DateFormatUtil.getCurrentSQLDate());
	// this.baseService.save(userRole);
	// }
	// }
	// if ((!"".equals(this.userPerId)) && (this.userPerId != null)) {
	// userPerIdArr = this.userPerId.split(";");
	// Long userId = this.entity.getUserId();
	// for (int i = 0; i < userPerIdArr.length; i++) {
	// UrpUserPermission userPer = new UrpUserPermission();
	// userPer.setPermissionId(new Long(userPerIdArr[i]));
	// userPer.setUserId(userId);
	// userPer.setCreateTime(DateFormatUtil.getCurrentSQLDate());
	// userPer.setModifyTime(DateFormatUtil.getCurrentSQLDate());
	// this.baseService.save(userPer);
	// }
	// }
	// } else {
	// this.user.setModifyTime(DateFormatUtil.getCurrentSQLDate());
	// this.baseService.update(this.user);
	// this.entity.setModifyTime(DateFormatUtil.getCurrentSQLDate());
	// AuOrgInfo org = (AuOrgInfo) this.baseService.get(AuOrgInfo.class, this.orgID);
	// this.entity.setOrg(org);
	// this.baseService.update(this.entity);
	// if (!this.roleId.equals(this.userRoleId)) {
	// if ("".equals(this.userRoleId)) {
	// Long userId = this.entity.getUserId();
	// this.userService.deleteUserRole(userId);
	// } else {
	// String[] srcArray = this.roleId.split(";");
	// userRoleIdArr = this.userRoleId.split(";");
	// Map map = CompareArray.compLineArray(srcArray, userRoleIdArr);
	// List delL = (List) map.get("del");
	// Long userId = this.entity.getUserId();
	// for (int i = 0; i < delL.size(); i++) {
	// this.userService.deleteUserRole(userId, new Long(delL.get(i).toString()));
	// }
	// List addL = (List) map.get("add");
	// for (int i = 0; i < addL.size(); i++) {
	// UrpUserRole userRole = new UrpUserRole();
	// userRole.setRoleId(new Long(addL.get(i).toString()));
	// userRole.setUserId(userId);
	// userRole.setCreateTime(DateFormatUtil.getCurrentSQLDate());
	// userRole.setModifyTime(DateFormatUtil.getCurrentSQLDate());
	// this.baseService.save(userRole);
	// }
	// }
	// }
	// if (!this.perId.equals(this.userPerId)) {
	// if ("".equals(this.userPerId)) {
	// Long userId = this.entity.getUserId();
	// this.userService.deleteUserPer(userId);
	// } else {
	// String[] srcArray = this.perId.split(";");
	// userPerIdArr = this.userPerId.split(";");
	// Map map = CompareArray.compLineArray(srcArray, userPerIdArr);
	// List delL = (List) map.get("del");
	// Long userId = this.entity.getUserId();
	// for (int i = 0; i < delL.size(); i++) {
	// this.userService.deleteUserPer(userId, new Long(delL.get(i).toString()));
	// }
	// List addL = (List) map.get("add");
	// for (int i = 0; i < addL.size(); i++) {
	// UrpUserPermission userPer = new UrpUserPermission();
	// userPer.setPermissionId(new Long(addL.get(i).toString()));
	// userPer.setUserId(userId);
	// userPer.setCreateTime(DateFormatUtil.getCurrentSQLDate());
	// userPer.setModifyTime(DateFormatUtil.getCurrentSQLDate());
	// this.baseService.save(userPer);
	// }
	// }
	// }
	// }
	// return "reload";
	// }
	//
	// public String input() {
	// if (("".equals(this.orgID)) || (this.orgID == null)) {
	// this.orgID = null;
	// } else {
	// AuOrgInfo org = (AuOrgInfo) this.baseService.get(AuOrgInfo.class, this.orgID);
	// this.orgName = org.getOrgName();
	// }
	// if ((this.id != null) && (!"".equals(this.id))) {
	// this.orgID = this.entity.getOrg().getId();
	// this.orgName = this.entity.getOrg().getOrgName();
	// this.map = this.userService.getAllUserRole(this.entity.getUserId());
	// this.user = ((AuUser) this.baseService.get(AuUser.class, this.entity.getUserId()));
	// }
	// return "input";
	// }
	//
	// public String choise() {
	// return "choise";
	// }
	//
	// public String isHave() {
	// HttpServletResponse response = ServletActionContext.getResponse();
	// ReturnJson json = new ReturnJson();
	// AuUser user = this.userService.getUser(this.loginId);
	// if (user != null) {
	// json.setStatusCode("300");
	// json.setMessage("������������������������������������������������");
	// } else {
	// json.setStatusCode("200");
	// json.setMessage("���������������������");
	// }
	// JSONObject jsonObject = JSONObject.fromObject(json);
	// try {
	// response.getWriter().println(jsonObject.toString());
	// response.getWriter().close();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// return null;
	// }
	//
	// public String delete() throws Exception {
	// this.entity = ((AuUserDetail) this.baseService.get(AuUserDetail.class, this.entity.getId()));
	// this.userService.delete(this.entity);
	//
	// return "reload";
	// }
	//
	// public String enabled() {
	// this.logger.info("{enabled ������������ ���������������" + this.entity.getUserName() + "}");
	// try {
	// this.userService.enabledUser(this.entity);
	// } catch (Exception e) {
	// this.logger.error(e.getMessage());
	// this.logger.error("{enabled ������������ ������������ ���������}");
	// }
	// return "reload";
	// }
	//
	// public String disabled() {
	// this.logger.info("{disabled ������������ ���������������" + this.entity.getUserName() + "}");
	// try {
	// this.userService.disabledUser(this.entity);
	// } catch (Exception e) {
	// this.logger.error(e.getMessage());
	// this.logger.error("{disabled ������������ ������������ ���������}");
	// }
	// return "reload";
	// }
	//
	// public String getAllPer() {
	// this.map = new HashMap();
	//
	// List perList = this.permissionService.getPermission();
	// this.map.put("per", perList);
	//
	// List userList = this.userService.getUserPer(this.id);
	// this.map.put("userper", userList);
	// return "per";
	// }
	//
	// public String getAllPermission() {
	// this.map = new HashMap();
	//
	// List appList = this.applicationService.getAllApp();
	// this.map.put("app", appList);
	//
	// List userPerL = this.userService.getUserPer(this.id);
	// this.map.put("userpermission", userPerL);
	// return "permission";
	// }
	//
	// public String resetPwd() throws Exception {
	// ReturnJson json = new ReturnJson();
	// HttpServletResponse response = ServletActionContext.getResponse();
	// json.setMessage("������������������,���������������������������������!");
	// json.setStatusCode("201");
	// if (this.user != null) {
	// Map<String, Long> param = new HashMap();
	// param.put("id", this.user.getId());
	// List<AuUser> userList = this.baseService.find(AuUser.class, param);
	// if ((userList != null) && (userList.size() > 0)) {
	// this.user = ((AuUser) userList.get(0));
	// this.user.setPassword("hzcl123456");
	// this.baseService.update(this.user);
	//
	// json.setMessage("������������������!");
	// json.setStatusCode("200");
	// }
	// }
	// JSONObject jsonObject = JSONObject.fromObject(json);
	// response.getWriter().println(jsonObject.toString());
	// return null;
	// }
	//
	// public String deleteUserCheck() throws Exception {
	// HttpSession session = Struts2Utils.getSession();
	// String loginId = (String) session.getAttribute("specter_session_login_key");
	// ReturnJson json = new ReturnJson();
	// HttpServletResponse response = ServletActionContext.getResponse();
	// json.setMessage("������������������!");
	// json.setStatusCode("200");
	// if (this.user != null) {
	// Map<String, Long> param = new HashMap();
	// param.put("id", this.user.getId());
	// List<AuUser> userList = this.baseService.find(AuUser.class, param);
	// if ((userList != null) && (userList.size() > 0)) {
	// this.user = ((AuUser) userList.get(0));
	// if (loginId.equals(this.user.getLoginId())) {
	// json.setMessage("���������������������������������������!");
	// json.setStatusCode("201");
	// }
	// }
	// }
	// JSONObject jsonObject = JSONObject.fromObject(json);
	// response.getWriter().println(jsonObject.toString());
	// return null;
	// }
	//
	// public AuUserDetail getEntity() {
	// return this.entity;
	// }
	//
	// public void setEntity(AuUserDetail entity) {
	// this.entity = entity;
	// }
	//
	// public Map getMap() {
	// return this.map;
	// }
	//
	// public void setUserRoleId(String userRoleId) {
	// this.userRoleId = userRoleId;
	// }
	//
	// public void setRoleId(String roleId) {
	// this.roleId = roleId;
	// }
	//
	// public List getOrglist() {
	// return this.orglist;
	// }
	//
	// public List getJoblist() {
	// return this.joblist;
	// }
	//
	// protected void prepareModel() throws Exception {
	// if (this.id != null) {
	// this.entity = ((AuUserDetail) this.baseService.get(AuUserDetail.class, this.id));
	// } else {
	// this.entity = new AuUserDetail();
	// }
	// }
	//
	// public AuUserDetail getModel() {
	// return this.entity;
	// }
	//
	// public String getUserName() {
	// return this.userName;
	// }
	//
	// public void setUserName(String userName) {
	// this.userName = userName;
	// }
	//
	// public Long getOrgID() {
	// return this.orgID;
	// }
	//
	// public void setOrgID(Long orgID) {
	// this.orgID = orgID;
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
	// public void setUserPerId(String userPerId) {
	// this.userPerId = userPerId;
	// }
	//
	// public void setPerId(String perId) {
	// this.perId = perId;
	// }
	//
	// public AuUser getUser() {
	// return this.user;
	// }
	//
	// public void setUser(AuUser user) {
	// this.user = user;
	// }
	//
	// public String getOrgName() {
	// return this.orgName;
	// }
	//
	// public Page<AuUserDetail> getPage() {
	// return this.page;
	// }
	//
	// public Page<AuUserView> getPageView() {
	// return this.pageView;
	// }
	//
	// public void setPageView(Page<AuUserView> pageView) {
	// this.pageView = pageView;
	// }
	//
	// public String getLoginId() {
	// return this.loginId;
	// }
	//
	// public void setLoginId(String loginId) {
	// this.loginId = loginId;
	// }
}
