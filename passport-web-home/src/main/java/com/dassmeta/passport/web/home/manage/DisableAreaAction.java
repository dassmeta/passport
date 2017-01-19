package com.dassmeta.passport.web.home.manage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.widewisdom.entity.areacode.DictionaryAreacode;
import cn.widewisdom.service.DictionaryAreacodeService;

import com.specter.utils.JsonPaserUtil;
import com.specter.web.struts2.CRUDActionSupport;
import com.specter.web.struts2.Struts2Utils;

public class DisableAreaAction extends CRUDActionSupport<DictionaryAreacode> {
	private static final long serialVersionUID = 1L;
	@Autowired
	private DictionaryAreacodeService dictionaryAreaCodeService;
	private String areaCode;
	private String area;

	public String index() throws Exception {
		return "success";
	}

	public String load() throws Exception {
		List<DictionaryAreacode> list = this.dictionaryAreaCodeService.getAreaByAreaCode(this.areaCode);
		String json = JsonPaserUtil.list2Json(list);

		Struts2Utils.renderJson(json, new String[] { "no-cache:false" });
		return null;
	}

	public String ajax() throws Exception {
		if ((this.area == null) || ("".equals(this.area))) {
			this.area = "city";
		} else {
			this.area = this.area.trim();
		}
		List<DictionaryAreacode> list = this.dictionaryAreaCodeService.getAjaxArea(this.areaCode, this.area);
		String json = JsonPaserUtil.list2Json(list);
		System.out.println(json);
		Struts2Utils.renderJson(json, new String[] { "no-cache:false" });
		return null;
	}

	public String getAreaCode() {
		return this.areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getArea() {
		return this.area;
	}

	public DictionaryAreacode getModel() {
		return null;
	}

	public String delete() throws Exception {
		return null;
	}

	public String list() throws Exception {
		return null;
	}

	protected void prepareModel() throws Exception {
	}

	public String save() throws Exception {
		return null;
	}
}
