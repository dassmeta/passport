package com.dassmeta.passport.web.home.manage;

import org.springframework.stereotype.Controller;

@Controller
public class UpdatePasswordController {
	// @Autowired
	// private ApplicationService applicationService;
	// private String psw;
	//
	// public String updatePass() throws Exception {
	// ReturnJson json = new ReturnJson();
	// HttpServletResponse response = ServletActionContext.getResponse();
	// HttpSession session = Struts2Utils.getSession();
	// String loginId = (String) session.getAttribute("specter_session_login_key");
	// String result = this.applicationService.updataPasswordPass(loginId, this.psw);
	// if (result == null) {
	// json.setStatusCode("200");
	// }
	// JSONObject jsonObject = JSONObject.fromObject(json);
	// response.getWriter().println(jsonObject.toString());
	// return null;
	// }
	//
	// public String yanzheng() throws Exception {
	// ReturnJson json = new ReturnJson();
	//
	// HttpServletResponse response = ServletActionContext.getResponse();
	// HttpSession session = Struts2Utils.getSession();
	// String loginId = (String) session.getAttribute("specter_session_login_key");
	// AuUser auUser = this.applicationService.updatePassword(loginId, null);
	// if (auUser.getPassword().equals("hzcl123456")) {
	// json.setMessage(loginId);
	// json.setStatusCode("200");
	// }
	// JSONObject jsonObject = JSONObject.fromObject(json);
	// response.getWriter().println(jsonObject.toString());
	// return null;
	// }
	//
	// public String updatePassword() throws Exception {
	// HttpSession session = Struts2Utils.getSession();
	// String loginId = (String) session.getAttribute("specter_session_login_key");
	// System.out.println(loginId);
	//
	// return "success";
	// }
	//
	// public String delete() throws Exception {
	// return null;
	// }
	//
	// public String list() throws Exception {
	// return null;
	// }
	//
	// protected void prepareModel() throws Exception {
	// }
	//
	// public String save() throws Exception {
	// return null;
	// }
	//
	// public AuUser getModel() {
	// return null;
	// }
	//
	// public String getPsw() {
	// return this.psw;
	// }
	//
	// public void setPsw(String psw) {
	// this.psw = psw;
	// }
}
