package com.dassmeta.passport.web.home.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.widewisdom.entity.auth.AuOrgInfo;
import cn.widewisdom.report.service.DepartAreaService;

import com.specter.utils.JsonPaserUtil;
import com.specter.web.struts2.Struts2Utils;

public class DepartAreaAction {
	private static final long serialVersionUID = 1L;
	@Autowired
	private DepartAreaService departAreaService;

	public String execute() throws Exception {
		return "success";
	}

	public String load() {
		String areaCode = "33";
		List<AuOrgInfo> list = this.departAreaService.getAreaByAreaCode(areaCode);
		String json = JsonPaserUtil.list2Json(list);

		Struts2Utils.renderJson(json, new String[] { "no-cache:false" });
		return null;
	}

	public String ajax() {
		String areacode = Struts2Utils.getParameter("areacode");

		String area = Struts2Utils.getParameter("area");
		if ((areacode == null) || ("".equals(areacode))) {
			areacode = "33";
		} else {
			areacode = areacode.trim();
		}
		if ((area == null) || ("".equals(area))) {
			area = "city";
		} else {
			area = area.trim();
		}
		List<AuOrgInfo> list = this.departAreaService.getAjaxArea(areacode, area);
		String json = JsonPaserUtil.list2Json(list);

		Struts2Utils.renderJson(json, new String[] { "no-cache:false" });
		return null;
	}
}
