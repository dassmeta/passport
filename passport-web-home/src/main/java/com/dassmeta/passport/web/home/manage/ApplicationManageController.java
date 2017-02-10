package com.dassmeta.passport.web.home.manage;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dassmeta.passport.core.service.ApplicationService;
import com.dassmeta.passport.dal.dataobject.AppAppInfo;
import com.dassmeta.passport.util.PageConstant;
import com.dassmeta.passport.util.PageList;

@Controller
public class ApplicationManageController {
	@Autowired
	private ApplicationService applicationService;

	@RequestMapping(value = "/app", method = RequestMethod.GET)
	public String list(ModelMap model, Integer currentPage) {

		if (currentPage == null || currentPage <= 0) {
			currentPage = 1;
		}
		Map<String, Object> paramMap = new HashMap<String, Object>();

		PageList<AppAppInfo> appList = applicationService.findForPage(paramMap, PageConstant.pageSize, currentPage);
		model.put("appList", appList);
		return "app-manage";

	}
}
