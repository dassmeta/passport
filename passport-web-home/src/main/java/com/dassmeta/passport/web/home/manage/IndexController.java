package com.dassmeta.passport.web.home.manage;

import org.springframework.stereotype.Controller;

@Controller
public class IndexController {
	// @Autowired
	// private TreeService treeService;
	// @Autowired
	// private PrivilegeProvider privilegeProvider;
	// @Autowired
	// private AuthenticationProvider authenticationProvider;
	//
	// public String execute() {
	// HttpSession session = Struts2Utils.getSession();
	//
	// OnlineUser user = (OnlineUser) session.getAttribute("SSH_ONLINE_USER");
	// if (user != null) {
	// String appcode = "aegean-login";
	// if (!this.privilegeProvider.privilege(appcode)) {
	// session.removeAttribute("SSH_ONLINE_USER");
	// this.authenticationProvider.logout();
	// String fail = this.privilegeProvider.getPrivilegeFailureURL();
	// fail = URLUtils.constructRedirectURL(ServletActionContext.getRequest(), fail);
	// try {
	// ServletActionContext.getResponse().sendRedirect(fail);
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// return null;
	// }
	// return "success";
	// }
	// try {
	// ServletActionContext.getResponse().sendRedirect("/manage/login.do");
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// return null;
	// }
}
