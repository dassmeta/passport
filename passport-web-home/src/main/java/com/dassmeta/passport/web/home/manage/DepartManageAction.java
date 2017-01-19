package com.dassmeta.passport.web.home.manage;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import cn.widewisdom.entity.auth.AuOrgInfo;
import cn.widewisdom.entity.util.ReturnJson;
import cn.widewisdom.service.DepartService;

import com.specter.service.BaseService;
import com.specter.utils.DateFormatUtil;
import com.specter.web.struts2.CRUDActionSupport;

@Results({ @org.apache.struts2.convention.annotation.Result(name = "reload", type = "redirect", location = "depart-manage.action"),
		@org.apache.struts2.convention.annotation.Result(name = "back", type = "redirect", location = "depart-manage!input.action?id=${id}") })
public class DepartManageAction extends CRUDActionSupport<AuOrgInfo> {
	private static final long serialVersionUID = 1L;
	@Autowired
	private DepartService departService;
	@Autowired
	private BaseService baseService;
	private AuOrgInfo org;
	private Long id;
	private Long parentId;
	private String userName;
	private List<?> orgList;
	private String areaCode;

	public String execute() {
		return "success";
	}

	public String list() {
		return null;
	}

	public String save() {
		if ((this.id == null) || ("".equals(this.id))) {
			this.org.setCreateTime(DateFormatUtil.getCurrentSQLDate());
			this.org.setParentId(this.parentId);
			this.org.setId(null);
			this.org.setIdFullPath(null);
			this.org.setModifyTime(DateFormatUtil.getCurrentSQLDate());
			this.org.setDeleted("N");
			this.org = ((AuOrgInfo) this.baseService.save(this.org));
			this.id = this.org.getId();
		} else {
			this.org.setModifyTime(DateFormatUtil.getCurrentSQLDate());
			this.baseService.update(this.org);
		}
		return "reload";
	}

	public String choise() {
		return "choise";
	}

	public String choiserole() {
		return "choiserole";
	}

	public String deleteElementAndUser() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		ReturnJson json = new ReturnJson();

		this.departService.delete(this.id);
		json.setStatusCode("200");
		json.setMessage("���������������");
		JSONObject jsonObject = JSONObject.fromObject(json);
		response.getWriter().println(jsonObject.toString());
		response.getWriter().close();
		return "ajax";
	}

	public String delete() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		ReturnJson json = new ReturnJson();

		boolean resu = this.departService.isHaveChild(this.id);
		boolean reuser = this.departService.CheckDeleteChildElement(this.id);
		if (resu) {
			json.setStatusCode("300");
			json.setMessage("���������������������������������������");
		} else if (!reuser) {
			json.setStatusCode("201");
			json.setMessage("���������������������������������,������������������?");
		} else {
			this.departService.delete(this.id);
			json.setStatusCode("200");
			json.setMessage("���������������");
		}
		JSONObject jsonObject = JSONObject.fromObject(json);
		response.getWriter().println(jsonObject.toString());
		response.getWriter().close();
		return "ajax";
	}

	public String ajax() {
		this.org = ((AuOrgInfo) this.baseService.get(AuOrgInfo.class, this.id));
		this.areaCode = this.org.getOrgCode();
		return "ajax";
	}

	protected void prepareModel() throws Exception {
		if (this.id != null) {
			this.org = ((AuOrgInfo) this.baseService.get(AuOrgInfo.class, this.id));
		} else {
			this.org = new AuOrgInfo();
		}
	}

	public AuOrgInfo getModel() {
		return this.org;
	}

	public AuOrgInfo getOrg() {
		return this.org;
	}

	public void setOrg(AuOrgInfo org) {
		this.org = org;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public List getOrgList() {
		return this.orgList;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return this.userName;
	}

	public String getAreaCode() {
		return this.areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
}
