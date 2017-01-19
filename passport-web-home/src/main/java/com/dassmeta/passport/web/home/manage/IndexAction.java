package com.dassmeta.passport.web.home.manage;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import cn.widewisdom.entity.util.OnlineUser;
import cn.widewisdom.service.TreeService;

import com.specter.security.auth.AuthenticationProvider;
import com.specter.security.auth.PrivilegeProvider;
import com.specter.security.utils.URLUtils;
import com.specter.web.struts2.Struts2Utils;

@Results({ @org.apache.struts2.convention.annotation.Result(name = "login", type = "redirect", location = "/admin/login!cheak.action?loginId=${loginId}&isLoginId=${isLoginId}&isLoginUser=${isLoginUser}") })
public class IndexAction {
	@Autowired
	private TreeService treeService;
	@Autowired
	private PrivilegeProvider privilegeProvider;
	@Autowired
	private AuthenticationProvider authenticationProvider;

	public String execute() {
		HttpSession session = Struts2Utils.getSession();

		OnlineUser user = (OnlineUser) session.getAttribute("SSH_ONLINE_USER");
		if (user != null) {
			String appcode = "aegean-login";
			if (!this.privilegeProvider.privilege(appcode)) {
				session.removeAttribute("SSH_ONLINE_USER");
				this.authenticationProvider.logout();
				String fail = this.privilegeProvider.getPrivilegeFailureURL();
				fail = URLUtils.constructRedirectURL(ServletActionContext.getRequest(), fail);
				try {
					ServletActionContext.getResponse().sendRedirect(fail);
				} catch (IOException e) {
					e.printStackTrace();
				}
				return null;
			}
			return "success";
		}
		try {
			ServletActionContext.getResponse().sendRedirect("/manage/login.do");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
