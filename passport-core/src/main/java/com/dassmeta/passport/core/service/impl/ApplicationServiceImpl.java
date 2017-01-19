package com.dassmeta.passport.core.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;

import com.dassmeta.passport.core.service.ApplicationService;
import com.dassmeta.passport.dal.dataobject.AppAppInfo;
import com.dassmeta.passport.dal.dataobject.AuUser;
import com.dassmeta.passport.dal.dataobject.UrpRole;
import com.dassmeta.passport.dal.ibatis.AppAppInfoDao;
import com.dassmeta.passport.util.PageList;

public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	private AppAppInfoDao appInfoDao;

	public PageList<AppAppInfo> findForPage(Map<String, Object> params, int page) {
		// Criterion cri = null;
		// cri = CriterionBuilder.eq("deleted", "N");
		// Order o = null;
		// o = CriterionBuilder.getOrder("createTime", false);
		// return this.baseDao.findForPage(AppAppInfo.class, cri, Integer.valueOf(page), Integer.valueOf(10), o);
		return null;
	}

	public void delete(AppAppInfo app) {
		// app.setDeleted("Y");
		// this.baseDao.update(app);
	}

	public List<AppAppInfo> getAllApp() {
		// String hql =
		// "select distinct t from AppAppInfo t left join t.permission ps where t.deleted='N' and ps.deleted='N'";
		// List appL = this.baseDao.executeHQL(hql).list();
		// return appL;
		return null;
	}

	public void save(AppAppInfo app) {
		// Date now = DateFormatUtil.getCurrentSQLDate();
		// app = (AppAppInfo) this.baseDao.save(app);
		// String appname = app.getAppName();
		// AppMenu menu = new AppMenu();
		// menu.setId(null);
		// menu.setMenuName(appname);
		// menu.setAppId(app.getId());
		// menu.setCreateTime(now);
		// menu.setMenuOrder(Integer.valueOf(1));
		// menu.setModifyTime(now);
		// menu.setParentId(Long.valueOf(0L));
		// menu.setShowStyle("1");
		// this.baseDao.save(menu);

	}

	public List<UrpRole> getRoleByAppId(String appId) {
		// String hql = "from UrpRole t where t.appid='" + appId + "'";
		// List<UrpRole> appL = this.baseDao.executeHQL(hql).list();
		// return appL;
		return null;
	}

	public List<AppAppInfo> getApp() {
		// String hql = "from AppAppInfoa t where t.deleted='N' and t.isShow='0' order by t.sort asc";
		// List<AppAppInfoa> appL = this.baseDao.executeHQL(hql).list();
		// return appL;
		return null;
	}

	public List<Map<String, String>> getUserSystemList(String filePath) {
		List<Map<String, String>> list = new ArrayList();
		SAXReader reader = new SAXReader();
		Document doc = null;
		Element root = null;
		try {
			doc = reader.read(new File(filePath + "/WEB-INF/classes/user-system.xml"));
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		if (doc != null) {
			root = doc.getRootElement();
			List<Element> l = root.elements();
			for (int i = 0; i < l.size(); i++) {
				Map<String, String> m = new HashMap();
				List<Element> l1 = ((Element) l.get(i)).elements();
				for (int j = 0; j < l1.size(); j++) {
					m.put(((Element) l1.get(j)).getName(), ((Element) l1.get(j)).getText());
				}
				list.add(m);
			}
		}
		return list;
	}

	public String[] getUserSystem(List<Map<String, String>> m, String loginId) {
		String[] app = (String[]) null;
		for (Map<String, String> map : m) {
			if (loginId.equals(map.get("loginId"))) {
				String appCode = (String) map.get("appCode");
				if (appCode.contains(",")) {
					app = appCode.split(",");
				} else {
					app = new String[] { appCode };
				}
				return app;
			}
		}
		return app;
	}

	public AuUser updatePassword(String loginName, String password) {
		// String s = "from AuUser where deleted='N' and loginId='" + loginName + "'";
		// List<AuUser> list = this.baseDao.executeHQL(s).list();
		// if ((list != null) && (list.size() > 0)) {
		// return (AuUser) list.get(0);
		// }
		return null;
	}

	public String updataPasswordPass(String loginId, String psw) {
		// String s = "from AuUser where deleted='N' and loginId='" + loginId + "'";
		// List<AuUser> list = this.baseDao.executeHQL(s).list();
		// AuUser entity = new AuUser();
		// if ((list != null) && (list.size() > 0)) {
		// entity = (AuUser) list.get(0);
		// entity.setPassword(psw);
		// this.baseDao.update(entity);
		// }
		return null;
	}
}
