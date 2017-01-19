package com.dassmeta.passport.web.home.tree;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import cn.widewisdom.entity.util.OnlineUser;
import cn.widewisdom.service.TreeService;

import com.specter.web.struts2.Struts2Utils;

public class StructTreeAction {
	@Autowired
	private TreeService treeService;
	private String appId;
	private List<?> treeList;
	private String id;
	private String flag = null;

	public String execute() {
		return "success";
	}

	public String departLoad() {
		if ((this.id == null) || (this.id.equals("0"))) {
			HttpSession session = Struts2Utils.getSession();
			OnlineUser user = (OnlineUser) session.getAttribute("SSH_ONLINE_USER");
			this.id = user.getDepartmentId();
			this.flag = "";
		}
		this.treeList = this.treeService.getDepartList(this.id, this.flag);
		return "depart";
	}

	public String menuLoad() {
		this.treeList = this.treeService.getMenuList(this.appId);
		return "menu";
	}

	@Action(value = "/struct-tree!depart", results = { @org.apache.struts2.convention.annotation.Result(name = "baidu", location = "http://www.baidu.com", type = "redirect") })
	public String generateDepart() {
		boolean flag = this.treeService.generateDepartTreeXML();
		if (flag) {
			return "baidu";
		}
		return "depart";
	}

	@Action(value = "/struct-tree!menu", results = { @org.apache.struts2.convention.annotation.Result(name = "google", location = "http://www.google.com", type = "redirect") })
	public String generateMenu() {
		boolean flag = this.treeService.generateMenuTreeXML(this.appId);
		if (flag) {
			return "google";
		}
		return "menu";
	}

	public List<?> getTreeList() {
		return this.treeList;
	}

	public String getAppId() {
		return this.appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
