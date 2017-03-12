package com.dassmeta.passport.web.home.manage;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dassmeta.passport.core.service.ApplicationService;
import com.dassmeta.passport.dal.dataobject.AppAppInfo;
import com.dassmeta.passport.util.PageConstant;
import com.dassmeta.passport.util.PageList;
import com.dassmeta.passport.web.home.manage.form.AppInfoForm;
import com.dassmeta.passport.web.home.util.FormCheckResult;
import com.dassmeta.passport.web.home.util.ResponseCodeEnum;

@Controller
@RequestMapping("/app")
public class ApplicationManageController {
	@Autowired
	private ApplicationService applicationService;

	private final static Logger LOGGER = LoggerFactory.getLogger(ApplicationManageController.class);

	@RequestMapping(value = "/apps", method = RequestMethod.POST)
	public @ResponseBody ModelMap list(@RequestBody ModelMap model) {
		Integer offset = model.get("offset") == null ? 0 : Integer.valueOf(model.get("offset").toString());
		Integer limit = model.get("limit") == null ? PageConstant.DEFAULT : Integer.valueOf(model.get("limit").toString());
		String search = model.get("search") == null ? null : model.get("search").toString();
		String sort = model.get("sort") == null ? null : model.get("sort").toString();
		String order = model.get("order") == null ? "asc" : model.get("order").toString();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("search", search);
		paramMap.put("sort", sort);
		paramMap.put("order", order);
		PageList<AppAppInfo> appList = applicationService.findForPage(paramMap, limit, offset);
		model = new ModelMap();
		if (appList != null && appList.size() > 0) {
			model.put("total", appList.getPaginator().getItems());
			model.put("rows", appList);
		}
		return model;
	}

	@RequestMapping(value = "/manage", method = RequestMethod.GET)
	public String index(ModelMap model) {
		return "app/app-manage";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String before(ModelMap model) {
		return "app/app-registration";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseBody FormCheckResult create(@RequestBody AppInfoForm appInfoForm, ModelMap model) {
		FormCheckResult result = new FormCheckResult();
		checkAppInfoForm(appInfoForm, result);
		if (!result.isValid()) {
			return result;
		}

		try {
			AppAppInfo appInfo = buildAppInfo(appInfoForm);
			applicationService.save(appInfo);
		} catch (Exception e) {
			LOGGER.error("create app error!", e);
			result.setValid(false);
			result.setMessage(ResponseCodeEnum.SYSTEM_ERROR.getDesc());
		}
		return result;
	}

	private AppAppInfo buildAppInfo(AppInfoForm appInfoForm) {
		AppAppInfo appInfo = new AppAppInfo();
		BeanUtils.copyProperties(appInfoForm, appInfo);
		appInfo.setDeleted("N");
		return appInfo;
	}

	private void checkAppInfoForm(AppInfoForm appInfoForm, FormCheckResult result) {
		if (appInfoForm == null) {
			result.setMessage(ResponseCodeEnum.PARAM_INVALID.getDesc());
			result.setValid(false);
		}
		if (StringUtils.isBlank(appInfoForm.getAppName())) {
			result.setMessage(ResponseCodeEnum.PARAM_INVALID.getDesc());
			result.setValid(false);
		}
	}
}
