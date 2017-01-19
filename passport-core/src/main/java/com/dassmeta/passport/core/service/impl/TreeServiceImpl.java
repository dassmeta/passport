package com.dassmeta.passport.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.widewisdom.entity.app.AppMenu;
import cn.widewisdom.entity.auth.AuOrgInfo;
import cn.widewisdom.entity.util.OnlineUser;
import cn.widewisdom.service.TreeService;
import cn.widewisdom.service.handler.TreeGenerateHandler;
import cn.widewisdom.service.handler.TreeItem;

import com.specter.dao.BaseDao;
import com.specter.web.struts2.Struts2Utils;

public class TreeServiceImpl implements TreeService {
	@Autowired
	private BaseDao baseDao;

	public List<AuOrgInfo> getDepartList() {
		String hql = "from AuOrgInfo t where t.deleted='N' order by t.ordering";
		return this.baseDao.executeHQL(hql).list();
	}

	public List<AppMenu> getMenuList(String appID) {
		String hql = "from AppMenu t where t.appId='" + appID + "' order by t.menuOrder";
		return this.baseDao.executeHQL(hql).list();
	}

	public boolean generateDepartTreeXML() {
		List<AuOrgInfo> list = getDepartList();
		boolean flag = false;
		if ((list == null) || (list.size() == 0)) {
			return flag;
		}
		List<TreeItem> li = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			TreeItem item = new TreeItem();
			item.setId(Long.valueOf(((AuOrgInfo) list.get(i)).getId().longValue()));
			item.setName(((AuOrgInfo) list.get(i)).getOrgName());
			item.setParentId(((AuOrgInfo) list.get(i)).getParentId());
			if ("0".equals(item.getParentId())) {
				item.setState("open");
			}
			li.add(item);
		}
		flag = TreeGenerateHandler.generateXMLFile(li, "depart-tree.xml");

		return flag;
	}

	public boolean generateMenuTreeXML(String appID) {
		List<AppMenu> list = getMenuList(appID);
		boolean flag = false;
		if ((list == null) || (list.size() == 0)) {
			return flag;
		}
		List<TreeItem> li = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			TreeItem item = new TreeItem();
			item.setId(((AppMenu) list.get(i)).getId());
			item.setName(((AppMenu) list.get(i)).getMenuName());
			item.setParentId(((AppMenu) list.get(i)).getParentId());
			if ("0".equals(item.getParentId())) {
				item.setState("open");
			}
			li.add(item);
		}
		flag = TreeGenerateHandler.generateXMLFile(li, "menu-tree.xml");

		return flag;
	}

	public List<AuOrgInfo> getDepartList(String id, String flag) {
		HttpSession session = Struts2Utils.getSession();
		OnlineUser user = (OnlineUser) session.getAttribute("SSH_ONLINE_USER");
		System.out.println(StringUtils.isNotBlank(flag));
		AuOrgInfo orginfo = (AuOrgInfo) this.baseDao.get(AuOrgInfo.class, new Long(user.getDepartmentId()));
		String hql = "";
		if (flag == null) {
			hql = "from AuOrgInfo t where t.deleted='N' and t.parentId=" + new Long(id) + " order by t.ordering";
		} else {
			hql = "from AuOrgInfo t where t.deleted='N' and t.orgCode=" + user.getAreaCode() + " and t.parentId = " + orginfo.getParentId() + " order by t.ordering";
			if ((user != null) && (user.getAreaCode().equals("3301"))) {
				hql = "from AuOrgInfo t where t.deleted='N' and t.id=" + new Long(id) + " order by t.ordering";
			}
		}
		return this.baseDao.executeHQL(hql).list();
	}

	public AuOrgInfo getAuOrgInfo(String loginId) {
		String sql = "select c.* from au_user a,au_user_detail b,au_org_info c where a.id = b.user_id and b.org_id = c.id and a.login_id='" + loginId + "'";
		List<AuOrgInfo> paList = this.baseDao.executeSQL(sql).addEntity(AuOrgInfo.class).list();
		if ((paList != null) && (paList.size() > 0)) {
			return (AuOrgInfo) paList.get(0);
		}
		return null;
	}
}
