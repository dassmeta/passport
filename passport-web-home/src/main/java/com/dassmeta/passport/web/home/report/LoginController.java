package com.dassmeta.passport.web.home.report;

import org.springframework.stereotype.Controller;

@Controller
public class LoginController {
	// @Autowired
	// private BaseService baseService;
	// @Autowired
	// private DepartAreaService departAreaService;
	// @Autowired
	// private ApplicationService applicationService;
	// private String loginName;
	// private String password;
	// private String appCode;
	//
	// public String updatePassword() throws Exception {
	// return "update-password";
	// }
	//
	// public String execute() throws Exception {
	// return "success";
	// }
	//
	// public String sys() throws Exception {
	// return "sys";
	// }
	//
	// public String login() throws Exception {
	// String flog = "";
	//
	// String state = "";
	//
	// boolean flag = false;
	//
	// AuUserDetail d = null;
	// AuUser u = (AuUser) this.baseService.getByUnique(AuUser.class, "loginId", this.loginName);
	// String loginType = Struts2Utils.getRequest().getParameter("loginType");
	// if (!"1".equals(loginType)) {
	// if (u == null) {
	// flag = false;
	// flog = "error_1";
	// state = "���������������";
	// } else if (!this.password.equals(u.getPassword())) {
	// flag = false;
	// flog = "error_2";
	// state = "������������������";
	// } else if (!"1".equals(u.getType())) {
	// flag = false;
	// flog = "error_4";
	// state = "������������������";
	// } else {
	// flag = true;
	// d = (AuUserDetail) this.baseService.getByUnique(AuUserDetail.class, "userId", u.getId());
	// }
	// } else if (u == null) {
	// flag = false;
	// flog = "error_1";
	// state = "���������������";
	// } else if (!this.password.equals(u.getPassword())) {
	// flag = false;
	// flog = "error_2";
	// state = "������������������";
	// } else {
	// flog = "";
	// state = "";
	// d = (AuUserDetail) this.baseService.getByUnique(AuUserDetail.class, "userId", u.getId());
	//
	// String identityCard = d.getIdentityCard();
	// if (("".equals(identityCard)) || (identityCard == null)) {
	// flag = false;
	// flog = "error_3";
	// state = "���������������������������";
	// } else {
	// String last4IdentityCard = Struts2Utils.getRequest().getParameter("last4IdentityCard").toUpperCase();
	// if (last4IdentityCard.trim().equals(identityCard.substring(identityCard.length() - 4, identityCard.length()))) {
	// flag = true;
	// } else {
	// flag = false;
	// flog = "error_3";
	// state = "���������������������������������";
	// }
	// }
	// }
	// if (flag) {
	// flog = "success";
	// state = "������������";
	// RUserInfo ru = new RUserInfo();
	// BeanUtils.copyProperties(d, ru);
	// ru.setLoginId(u.getLoginId());
	// ru.setPassword(u.getPassword());
	// ru.setOrgId(d.getOrg().getId());
	// ru.setOrgName(d.getOrg().getOrgName());
	// ru.setOrgCode(d.getOrg().getOrgCode());
	// Struts2Utils.getSession().setAttribute("SSH_ONLINE_USER", ru);
	// Struts2Utils.getSession().setAttribute("areaCode", ru.getOrgCode());
	// Struts2Utils.getSession().setAttribute("specter_session_login_key", ru.getLoginId());
	// String f = Struts2Utils.getSession().getServletContext().getRealPath("");
	// Struts2Utils.getSession().setAttribute("userSystemList", this.applicationService.getUserSystemList(f));
	// List<AppAppInfoa> set = this.applicationService.getApp();
	// Struts2Utils.getSession().setAttribute("set", set);
	// }
	// String json = "{'flog':'" + flog + "','state':'" + state + "'}";
	// Struts2Utils.renderText(json, new String[] { "no-cache:false" });
	// return null;
	// }
	//
	// public String syslogin() throws Exception {
	// String flog = "";
	//
	// String state = "";
	//
	// boolean flag = false;
	//
	// AuUserDetail d = null;
	// AuUser u = (AuUser) this.baseService.getByUnique(AuUser.class, "loginId", this.loginName);
	// String loginType = Struts2Utils.getRequest().getParameter("loginType");
	// if (!"1".equals(loginType)) {
	// if (u == null) {
	// flag = false;
	// flog = "error_1";
	// state = "���������������";
	// } else if (!this.password.equals(u.getPassword())) {
	// flag = false;
	// flog = "error_2";
	// state = "������������������";
	// } else if (!"1".equals(u.getType())) {
	// flag = false;
	// flog = "error_4";
	// state = "������������������";
	// } else {
	// flag = true;
	// d = (AuUserDetail) this.baseService.getByUnique(AuUserDetail.class, "userId", u.getId());
	// }
	// } else if (u == null) {
	// flag = false;
	// flog = "error_1";
	// state = "���������������";
	// } else if (!this.password.equals(u.getPassword())) {
	// flag = false;
	// flog = "error_2";
	// state = "������������������";
	// } else {
	// flog = "";
	// state = "";
	// d = (AuUserDetail) this.baseService.getByUnique(AuUserDetail.class, "userId", u.getId());
	//
	// String identityCard = d.getIdentityCard();
	// if (("".equals(identityCard)) || (identityCard == null)) {
	// flag = false;
	// flog = "error_3";
	// state = "���������������������������";
	// } else {
	// String last4IdentityCard = Struts2Utils.getRequest().getParameter("last4IdentityCard").toUpperCase();
	// if (last4IdentityCard.trim().equals(identityCard.substring(identityCard.length() - 4, identityCard.length()))) {
	// flag = true;
	// } else {
	// flag = false;
	// flog = "error_3";
	// state = "���������������������������������";
	// }
	// }
	// }
	// if (flag) {
	// flog = "success";
	// state = "������������";
	// RUserInfo ru = new RUserInfo();
	// BeanUtils.copyProperties(d, ru);
	// ru.setLoginId(u.getLoginId());
	// ru.setPassword(u.getPassword());
	// ru.setOrgId(d.getOrg().getId());
	// ru.setOrgName(d.getOrg().getOrgName());
	// ru.setOrgCode(d.getOrg().getOrgCode());
	// Struts2Utils.getSession().setAttribute("SSH_ONLINE_USER", ru);
	// Struts2Utils.getSession().setAttribute("areaCode", ru.getOrgCode());
	// Struts2Utils.getSession().setAttribute("specter_session_login_key", ru.getLoginId());
	// String f = Struts2Utils.getSession().getServletContext().getRealPath("");
	// Struts2Utils.getSession().setAttribute("userSystemList", this.applicationService.getUserSystemList(f));
	// List<AppAppInfoa> set = this.applicationService.getApp();
	// Struts2Utils.getSession().setAttribute("set", set);
	// }
	// String json = "{'flog':'" + flog + "','state':'" + state + "'}";
	// System.out.println(json);
	// Struts2Utils.renderText(json, new String[] { "no-cache:false" });
	// return null;
	// }
	//
	// public String area() {
	// RUserInfo ruser = (RUserInfo) Struts2Utils.getSession().getAttribute("SSH_ONLINE_USER");
	// String areaCode = ruser.getOrgCode();
	// String area = this.departAreaService.getArea(areaCode);
	// Struts2Utils.renderText(area, new String[] { "no-cache:false" });
	// return null;
	// }
	//
	// public String loginOut() throws Exception {
	// Struts2Utils.getSession().removeAttribute("SSH_ONLINE_USER");
	// Struts2Utils.getSession().removeAttribute("specter_session_login_key");
	// Struts2Utils.getSession().removeAttribute("userSystemList");
	// return "success";
	// }
	//
	// public void setLoginName(String loginName) {
	// this.loginName = loginName;
	// }
	//
	// public void setPassword(String password) {
	// this.password = password;
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
