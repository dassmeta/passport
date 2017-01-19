package com.dassmeta.passport.web.home.report;

import org.springframework.beans.factory.annotation.Autowired;

import cn.widewisdom.entity.app.AppAppInfo;
import cn.widewisdom.entity.report.RUserInfo;
import cn.widewisdom.service.PermissionService;

import com.opensymphony.xwork2.ActionContext;
import com.specter.service.BaseService;
import com.specter.utils.JsonPaserUtil;
import com.specter.web.struts2.Struts2Utils;

public class AuthenticationAction {
	@Autowired
	private BaseService baseService;
	@Autowired
	private PermissionService permissionService;

	public String execute() throws Exception {
		return "success";
	}

	public String sso() throws Exception {
		String service = Struts2Utils.getParameter("service");

		RUserInfo u = (RUserInfo) ActionContext.getContext().getSession().get("SSH_ONLINE_USER");

		String sso = null;

		boolean flag = this.permissionService.ifAnyGranted(new String[] { service });
		if (flag) {
			sso = (String) ActionContext.getContext().getApplication().get(service);
			if ((sso == null) || ("".equals(sso))) {
				AppAppInfo app = (AppAppInfo) this.baseService.getByUnique(AppAppInfo.class, "appCode", service);
				app.setPermission(null);
				sso = JsonPaserUtil.bean2Json(app);
				ActionContext.getContext().getApplication().put(service, sso);
			}
		}
		String token = JsonPaserUtil.bean2Json(u);

		String json = "{\"result\":" + flag + ",\"sso\":" + sso + ",\"token\":" + token + "}";

		Struts2Utils.renderJson(json, new String[] { "no-cache:false" });
		return null;
	}
}
