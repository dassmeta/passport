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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dassmeta.passport.core.service.ApplicationService;
import com.dassmeta.passport.dal.dataobject.AppAppInfo;
import com.dassmeta.passport.dal.dataobject.AppMenu;
import com.dassmeta.passport.dal.dataobject.AuUser;
import com.dassmeta.passport.dal.dataobject.UrpRole;
import com.dassmeta.passport.dal.ibatis.AppAppInfoDao;
import com.dassmeta.passport.dal.ibatis.AppMenuDao;
import com.dassmeta.passport.dal.ibatis.AuUserDao;
import com.dassmeta.passport.dal.ibatis.UrpRoleDao;
import com.dassmeta.passport.util.PageList;

@Service("appService")
public class ApplicationServiceImpl implements ApplicationService {

	private static final Logger logger = LoggerFactory.getLogger(ApplicationServiceImpl.class);

	@Autowired
	private AppAppInfoDao appInfoDao;

	@Autowired
	private AuUserDao userDao;

	@Autowired
	private AppMenuDao menuDao;

	@Autowired
	private UrpRoleDao roleDao;

	public PageList<AppAppInfo> findForPage(Map<String, Object> params, int pageSize, int pageNo) {
		if (logger.isInfoEnabled()) {
			logger.info("findForPage invoke,params:{},pageSize:{},pageNo:{}", params, pageSize, pageNo);
		}
		return appInfoDao.findPageList(params, pageSize, pageNo);
	}

	public void delete(AppAppInfo app) {
		app.setDeleted("Y");
		if (logger.isInfoEnabled()) {
			logger.info("delete invoke,AppAppInfo:{}", app);
		}
		appInfoDao.update(app);
	}

	public List<AppAppInfo> getAllApp() {
		if (logger.isInfoEnabled()) {
			logger.info("getAllApp invoke");
		}
		return appInfoDao.getAllApp();
	}

	public void save(AppAppInfo app) {
		if (logger.isInfoEnabled()) {
			logger.info("save invoke,create app:{}", app);
		}
		long appId = appInfoDao.create(app);

		String appname = app.getAppName();
		AppMenu menu = new AppMenu();
		menu.setId(null);
		menu.setMenuName(appname);
		menu.setAppId(appId);
		menu.setMenuOrder(1);
		menu.setParentId(Long.valueOf(0L));
		menu.setShowStyle("1");
		if (logger.isInfoEnabled()) {
			logger.info("save invoke,create menu:{}", menu);
		}
		menuDao.create(menu);
	}

	public List<UrpRole> getRoleByAppId(String appId) {
		if (logger.isInfoEnabled()) {
			logger.info("getRoleByAppId invoke,appId:{}", appId);
		}
		return roleDao.getRoleByAppId(appId);
	}

	public List<AppAppInfo> getApp() {
		if (logger.isInfoEnabled()) {
			logger.info("getApp invoke");
		}
		return appInfoDao.getAppByShow();
	}

	public List<Map<String, String>> getUserSystemList(String filePath) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		SAXReader reader = new SAXReader();
		Document doc = null;
		try {
			doc = reader.read(new File(filePath + "/WEB-INF/classes/user-system.xml"));
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		if (doc != null) {
			List<?> l = doc.getRootElement().elements();
			for (int i = 0; i < l.size(); i++) {
				Map<String, String> m = new HashMap<String, String>();
				List<?> l1 = ((Element) l.get(i)).elements();
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
		if (logger.isInfoEnabled()) {
			logger.info("updatePassword invoke,loginName:{},password:{}", loginName, password);
		}
		return userDao.findByLoginName(loginName);
	}

	public String updataPasswordPass(String loginName, String newPassword) {
		// String s = "from AuUser where deleted='N' and loginId='" + loginId + "'";
		// List<AuUser> list = this.baseDao.executeHQL(s).list();
		// AuUser entity = new AuUser();
		// if ((list != null) && (list.size() > 0)) {
		// entity = (AuUser) list.get(0);
		// entity.setPassword(psw);
		// this.baseDao.update(entity);
		// }

		if (logger.isInfoEnabled()) {
			logger.info("updataPasswordPass invoke,loginName:{},newPassword:{}", loginName, newPassword);
		}
		userDao.updataPasswordByLoginName(loginName, newPassword);

		return null;
	}
}
