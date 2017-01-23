package com.dassmeta.passport.web.home.report;

import org.springframework.stereotype.Controller;

@Controller
public class UserReportController {
	// @Autowired
	// private ApplicationService applicationService;
	// @Autowired
	// private ReportService reportService;
	// @Autowired
	// private UserService userService;
	// @Autowired
	// private BaseService baseService;
	// private List<AppAppInfo> set;
	// private AppAppInfo app;
	// private ReportUserDetail user;
	// private UserDetail auditedUser;
	// private Page<ReportUserDetail> page;
	// private String areacode;
	// private Page<UserDetail> userPage;
	// private List<AuUserBean> glylist;
	// private String appCode;
	// private Map map;
	//
	// public String execute() throws Exception {
	// RUserInfo ruser = (RUserInfo) Struts2Utils.getSession().getAttribute("SSH_ONLINE_USER");
	// this.glylist = this.reportService.findGly(ruser.getOrgCode());
	// Struts2Utils.getRequest().setAttribute("glylist", this.glylist);
	// this.areacode = ruser.getOrgCode();
	// return "success";
	// }
	//
	// public String add() throws Exception {
	// RUserInfo user = (RUserInfo) Struts2Utils.getSession().getAttribute("SSH_ONLINE_USER");
	//
	// this.areacode = user.getOrgCode();
	// List<Map<String, String>> m = (List) Struts2Utils.getSession().getAttribute("userSystemList");
	// RUserInfo u = (RUserInfo) Struts2Utils.getSession().getAttribute("SSH_ONLINE_USER");
	// String[] us = this.applicationService.getUserSystem(m, u.getLoginId());
	// String sys = "";
	// for (int i = 0; i < us.length; i++) {
	// sys = sys + us[i] + ",";
	// }
	// Struts2Utils.getRequest().setAttribute("sys", sys);
	// return "add";
	// }
	//
	// public String addsave() throws Exception {
	// String areaCodea = Struts2Utils.getParameter("areaCode");
	// this.user.setIdentityCard(this.user.getIdentityCard().toUpperCase());
	// this.user.setOrgCode(areaCodea);
	// this.user.setCreateTime(DateFormatUtil.getCurrentSQLDate());
	// this.user.setModifyTime(DateFormatUtil.getCurrentSQLDate());
	// AuOrgInfo org = (AuOrgInfo) this.baseService.getByUnique(AuOrgInfo.class, "orgCode", areaCodea);
	// this.user.setOrgId(org.getId());
	// this.user.setOrgName(org.getOrgName());
	// this.user = ((ReportUserDetail) this.baseService.save(this.user));
	//
	// this.reportService.saveUser(this.user);
	//
	// this.baseService.delete(this.user);
	//
	// return "userlist";
	// }
	//
	// public String sys() throws Exception {
	// RUserInfo user = (RUserInfo) Struts2Utils.getSession().getAttribute("SSH_ONLINE_USER");
	//
	// this.areacode = user.getOrgCode();
	// return "sys";
	// }
	//
	// public String appRole() throws Exception {
	// String appid = Struts2Utils.getParameter("appid");
	// List<UrpRole> roles = this.applicationService.getRoleByAppId(appid);
	// String json = JsonPaserUtil.list2Json(roles);
	// Struts2Utils.renderJson(json, new String[] { "no-cache:false" });
	// return null;
	// }
	//
	// public String role() throws Exception {
	// String appid = Struts2Utils.getParameter("appid");
	// List<UrpRole> roles = this.applicationService.getRoleByAppId(appid);
	// Struts2Utils.getRequest().setAttribute("roles", roles);
	// return "role";
	// }
	//
	// public String validate() throws Exception {
	// String loginId = Struts2Utils.getParameter("loginId");
	// if ((this.userService.getUserByLoginID(loginId) != null) || (!this.reportService.validateuser(loginId))) {
	// Struts2Utils.renderText("true", new String[] { "no-cache:false" });
	// } else {
	// Struts2Utils.renderText("false", new String[] { "no-cache:false" });
	// }
	// return null;
	// }
	//
	// public String userRoles() {
	// String userRoles = this.reportService.getAuditedUserRoles(Struts2Utils.getParameter("userId"));
	// Struts2Utils.renderText(userRoles, new String[] { "no-cache:false" });
	// return null;
	// }
	//
	// public String validateUser() {
	// String name = Struts2Utils.getParameter("name");
	// String identityCard = Struts2Utils.getParameter("identityCard").toUpperCase();
	// String msg = this.reportService.checkUser(name, identityCard);
	// Struts2Utils.renderText(msg, new String[] { "no-cache:false" });
	// return null;
	// }
	//
	// public String save() throws Exception {
	// RUserInfo ruser = (RUserInfo) Struts2Utils.getSession().getAttribute("SSH_ONLINE_USER");
	// String areaCode = ruser.getOrgCode();
	// String areaCodea = Struts2Utils.getParameter("areaCode");
	//
	// this.user.setIdentityCard(this.user.getIdentityCard().toUpperCase());
	// this.user.setOrgCode(areaCodea);
	// this.user.setCreateTime(DateFormatUtil.getCurrentSQLDate());
	// this.user.setModifyTime(DateFormatUtil.getCurrentSQLDate());
	// AuOrgInfo org = (AuOrgInfo) this.baseService.getByUnique(AuOrgInfo.class, "orgCode", areaCodea);
	// this.user.setOrgId(org.getId());
	// this.user.setOrgName(org.getOrgName());
	// this.baseService.save(this.user);
	// String msg = "���������������������������������������������������������������������������������";
	// Struts2Utils.getRequest().setAttribute("msg", msg);
	// return "detail";
	// }
	//
	// public String savesys() throws Exception {
	// RUserInfo ruser = (RUserInfo) Struts2Utils.getSession().getAttribute("SSH_ONLINE_USER");
	// String areaCode = ruser.getOrgCode();
	// String areaCodea = Struts2Utils.getParameter("areaCode");
	//
	// this.user.setIdentityCard(this.user.getIdentityCard().toUpperCase());
	// this.user.setOrgCode(areaCodea);
	// this.user.setCreateTime(DateFormatUtil.getCurrentSQLDate());
	// this.user.setModifyTime(DateFormatUtil.getCurrentSQLDate());
	// AuOrgInfo org = (AuOrgInfo) this.baseService.getByUnique(AuOrgInfo.class, "orgCode", areaCodea);
	// this.user.setOrgId(org.getId());
	// this.user.setOrgName(org.getOrgName());
	// this.baseService.save(this.user);
	// String msg = "���������������������������������������������������������������������������������";
	// Struts2Utils.getRequest().setAttribute("msg", msg);
	// return "dal";
	// }
	//
	// public String rolesave() throws Exception {
	// RUserInfo ruser = (RUserInfo) Struts2Utils.getSession().getAttribute("SSH_ONLINE_USER");
	// if (!this.reportService.validateuser(ruser.getLoginId())) {
	// Struts2Utils.renderText("false", new String[] { "no-cache:false" });
	// return null;
	// }
	// ReportUserDetail ruDetail = new ReportUserDetail();
	// ruDetail.setCreateTime(DateFormatUtil.getCurrentSQLDate());
	// ruDetail.setEmail(ruser.getEmail());
	// ruDetail.setGender(ruser.getGender());
	// ruDetail.setIdentityCard(ruser.getIdentityCard());
	// ruDetail.setJobName(ruser.getJobName());
	// ruDetail.setLoginName(ruser.getLoginId());
	// ruDetail.setMobile(ruser.getMobile());
	// ruDetail.setModifyTime(DateFormatUtil.getCurrentSQLDate());
	// ruDetail.setOrgCode(ruser.getOrgCode());
	// ruDetail.setOrgId(ruser.getOrgId());
	// ruDetail.setOrgName(ruser.getOrgName());
	// ruDetail.setPassword(ruser.getPassword());
	// ruDetail.setPhone(ruser.getPhone());
	// ruDetail.setRoleId(Struts2Utils.getParameter("roleIds"));
	// ruDetail.setUserEmployer(ruser.getUserEmployer());
	// ruDetail.setUserName(ruser.getUserName());
	// ruDetail.setUserQQ(ruser.getUserQQ());
	// ruDetail.setUserSystem(Struts2Utils.getParameter("syscode"));
	// this.baseService.save(ruDetail);
	//
	// Struts2Utils.renderText("true", new String[] { "no-cache:false" });
	// return null;
	// }
	//
	// public String list() throws Exception {
	// String[] zhjb = Struts2Utils.getRequest().getParameterValues("zhjb");
	//
	// RUserInfo u = (RUserInfo) Struts2Utils.getSession().getAttribute("SSH_ONLINE_USER");
	// List<Map<String, String>> m = (List) Struts2Utils.getSession().getAttribute("userSystemList");
	// Integer page = Struts2Utils.getIntParameter("specter_params_pageNo", Integer.valueOf(1));
	// Map<String, Object> params = new HashMap();
	// if ((zhjb != null) && (zhjb.length > 0)) {
	// params.put("length", zhjb);
	// }
	// params.put("orgCode", u.getOrgCode());
	// if (this.user != null) {
	// params.put("identityCard", this.user.getIdentityCard());
	// params.put("userName", this.user.getUserName());
	// params.put("isAdmin", this.user.getIsAdmin());
	// params.put("userSystem", this.applicationService.getUserSystem(m, u.getLoginId()));
	// params.put("ascendName", Struts2Utils.getParameter("ascendName"));
	// params.put("ascending", Struts2Utils.getParameter("ascending"));
	// } else {
	// params.put("userSystem", this.applicationService.getUserSystem(m, u.getLoginId()));
	// }
	// this.page = this.reportService.findForPage(params, page.intValue());
	//
	// return "list";
	// }
	//
	// public String userList() throws Exception {
	// RUserInfo u = (RUserInfo) Struts2Utils.getSession().getAttribute("SSH_ONLINE_USER");
	// String[] zhjb = Struts2Utils.getRequest().getParameterValues("zhjb");
	// List<Map<String, String>> m = (List) Struts2Utils.getSession().getAttribute("userSystemList");
	// Integer page = Struts2Utils.getIntParameter("specter_params_pageNo", Integer.valueOf(1));
	// Map<String, Object> params = new HashMap();
	//
	// params.put("orgCode", u.getOrgCode());
	// System.out.println("-----------------" + zhjb + "-----------------");
	// if ((zhjb != null) && (zhjb.length > 0)) {
	// params.put("length", zhjb);
	// }
	// if (this.auditedUser != null) {
	// params.put("identityCard", this.auditedUser.getIdentityCard());
	// params.put("userName", this.auditedUser.getUserName());
	// params.put("orgCode", u.getOrgCode());
	// params.put("loginName", this.auditedUser.getLoginName());
	// params.put("ascendName", Struts2Utils.getParameter("ascendName"));
	// params.put("ascending", Struts2Utils.getParameter("ascending"));
	// params.put("userSystem", this.applicationService.getUserSystem(m, u.getLoginId()));
	// } else {
	// params.put("userSystem", this.applicationService.getUserSystem(m, u.getLoginId()));
	// }
	// this.userPage = this.reportService.findForEditedPage(params, page.intValue());
	//
	// return "userList";
	// }
	//
	// public String auditedUser() throws Exception {
	// this.auditedUser = ((UserDetail) this.baseService.getByUnique(UserDetail.class, "id", this.auditedUser.getId()));
	// return "userDetail";
	// }
	//
	// public String delete() throws Exception {
	// this.user = ((ReportUserDetail) this.baseService.get(ReportUserDetail.class, this.user.getId()));
	// this.baseService.delete(this.user);
	// return "reload";
	// }
	//
	// public String edit() throws Exception {
	// this.user = ((ReportUserDetail) this.baseService.get(ReportUserDetail.class, this.user.getId()));
	//
	// this.areacode = this.user.getOrgCode();
	// List<Map<String, String>> m = (List) Struts2Utils.getSession().getAttribute("userSystemList");
	// RUserInfo u = (RUserInfo) Struts2Utils.getSession().getAttribute("SSH_ONLINE_USER");
	// String[] us = this.applicationService.getUserSystem(m, u.getLoginId());
	// String sys = "";
	// for (int i = 0; i < us.length; i++) {
	// sys = sys + us[i] + ",";
	// }
	// Struts2Utils.getRequest().setAttribute("sys", sys);
	// Struts2Utils.getRequest().setAttribute("areacode", this.areacode);
	// return "edit";
	// }
	//
	// public String audit() throws Exception {
	// this.user = ((ReportUserDetail) this.baseService.get(ReportUserDetail.class, this.user.getId()));
	// this.user.setUserSystem(Struts2Utils.getParameter("user.userSystem"));
	// this.user.setRoleId(Struts2Utils.getParameter("user.roleId"));
	// String areaCode = Struts2Utils.getParameter("areaCode");
	// this.user.setOrgCode(areaCode);
	//
	// this.reportService.saveUser(this.user);
	//
	// this.baseService.delete(this.user);
	// return "reload";
	// }
	//
	// public String resetPassword() throws Exception {
	// String loginId = Struts2Utils.getParameter("loginId");
	// String password = Struts2Utils.getParameter("password");
	// AuUser auUser = (AuUser) this.baseService.getByUnique(AuUser.class, "loginId", loginId);
	// auUser.setPassword(password);
	// this.baseService.saveOrUpdate(auUser);
	// Struts2Utils.renderText("true", new String[] { "no-cache:false" });
	// return null;
	// }
	//
	// public String roleEdit() throws Exception {
	// this.auditedUser = ((UserDetail) this.baseService.getByUnique(UserDetail.class, "userId",
	// this.auditedUser.getUserId()));
	// List<Map<String, String>> m = (List) Struts2Utils.getSession().getAttribute("userSystemList");
	// RUserInfo u = (RUserInfo) Struts2Utils.getSession().getAttribute("SSH_ONLINE_USER");
	// String[] us = this.applicationService.getUserSystem(m, u.getLoginId());
	// String sys = "";
	// for (int i = 0; i < us.length; i++) {
	// sys = sys + us[i] + ",";
	// }
	// Struts2Utils.getRequest().setAttribute("sys", sys);
	// this.map = this.userService.getAllUserRole(this.auditedUser.getUserId());
	//
	// return "redit";
	// }
	//
	// public String saveEdit() throws Exception {
	// String yper = Struts2Utils.getParameter("ypercodes");
	// String yrole = Struts2Utils.getParameter("yroles");
	// List yperl = new ArrayList();
	// List yrolel = new ArrayList();
	// if ((yper != null) && (!"".equals(yper))) {
	// yperl = Arrays.asList(yper.split(";"));
	// }
	// if ((yrole != null) && (!"".equals(yrole))) {
	// yrolel = Arrays.asList(yrole.split(";"));
	// }
	// String sys = this.user.getUserSystem();
	// String ur = this.user.getRoleId();
	//
	// List sysl = new ArrayList();
	// List url = new ArrayList();
	// if ((sys != null) && (!"".equals(sys))) {
	// sysl = Arrays.asList(sys.trim().split(","));
	// }
	// if ((ur != null) && (!"".equals(ur))) {
	// url = Arrays.asList(ur.trim().split(","));
	// }
	// System.out.println(this.user.getUserSystem());
	// System.out.println(this.user.getRoleId());
	// System.out.println("-------------");
	// System.out.println("������������������" + yper);
	// System.out.println("������������������" + sys);
	// System.out.println("-------------");
	// System.out.println("���������������" + yrole);
	// System.out.println("���������������" + ur);
	// this.reportService.saveEdit(this.user.getId(), yperl, yrolel, sysl, url);
	// return null;
	// }
	//
	// public List<AppAppInfo> getSet() {
	// return this.set;
	// }
	//
	// public void setSet(List<AppAppInfo> set) {
	// this.set = set;
	// }
	//
	// public void setUser(ReportUserDetail user) {
	// this.user = user;
	// }
	//
	// public ReportUserDetail getUser() {
	// return this.user;
	// }
	//
	// public Page<ReportUserDetail> getPage() {
	// return this.page;
	// }
	//
	// public void setPage(Page<ReportUserDetail> page) {
	// this.page = page;
	// }
	//
	// public String getAreacode() {
	// return this.areacode;
	// }
	//
	// public ApplicationService getApplicationService() {
	// return this.applicationService;
	// }
	//
	// public void setApplicationService(ApplicationService applicationService) {
	// this.applicationService = applicationService;
	// }
	//
	// public ReportService getReportService() {
	// return this.reportService;
	// }
	//
	// public void setReportService(ReportService reportService) {
	// this.reportService = reportService;
	// }
	//
	// public UserService getUserService() {
	// return this.userService;
	// }
	//
	// public void setUserService(UserService userService) {
	// this.userService = userService;
	// }
	//
	// public BaseService getBaseService() {
	// return this.baseService;
	// }
	//
	// public void setBaseService(BaseService baseService) {
	// this.baseService = baseService;
	// }
	//
	// public UserDetail getAuditedUser() {
	// return this.auditedUser;
	// }
	//
	// public void setAuditedUser(UserDetail auditedUser) {
	// this.auditedUser = auditedUser;
	// }
	//
	// public Page<UserDetail> getUserPage() {
	// return this.userPage;
	// }
	//
	// public void setUserPage(Page<UserDetail> userPage) {
	// this.userPage = userPage;
	// }
	//
	// public void setAreacode(String areacode) {
	// this.areacode = areacode;
	// }
	//
	// public Map getMap() {
	// return this.map;
	// }
	//
	// public List<AuUserBean> getGlylist() {
	// return this.glylist;
	// }
	//
	// public void setGlylist(List<AuUserBean> glylist) {
	// this.glylist = glylist;
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
	// public String getAppCode() {
	// return this.appCode;
	// }
	//
	// public void setAppCode(String appCode) {
	// this.appCode = appCode;
	// }
}
