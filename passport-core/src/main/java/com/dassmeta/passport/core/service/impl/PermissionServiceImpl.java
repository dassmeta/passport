package com.dassmeta.passport.core.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dassmeta.passport.core.service.PermissionService;
import com.dassmeta.passport.dal.dataobject.AppAppInfo;
import com.dassmeta.passport.dal.dataobject.UrpPermission;
import com.dassmeta.passport.dal.ibatis.AppAppInfoDao;
import com.dassmeta.passport.dal.ibatis.UrpPermissionDao;
import com.dassmeta.passport.dal.ibatis.UrpRolePermissionDao;
import com.dassmeta.passport.dal.ibatis.UrpUserPermissionDao;
import com.dassmeta.passport.security.auth.entity.Permission;
import com.dassmeta.passport.security.auth.entity.UserDetail;
import com.dassmeta.passport.security.context.SecurityContext;
import com.dassmeta.passport.util.PageList;

public class PermissionServiceImpl implements PermissionService {

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private UrpPermissionDao permissionDao;

	@Autowired
	private UrpRolePermissionDao rolePermissionDao;

	@Autowired
	private UrpUserPermissionDao userPermissionDao;

	@Autowired
	private AppAppInfoDao appDao;

	public List<UrpPermission> getAllPermission() {
		return permissionDao.getAllPermission();
	}

	public void save(UrpPermission permission) {
		permission.setDeleted("N");
		this.permissionDao.update(permission);
	}

	public void delete(UrpPermission permission) {
		this.permissionDao.remove(permission);
		this.rolePermissionDao.removeByPid(permission.getId());
		this.userPermissionDao.removeByPid(permission.getId());
	}

	public PageList<UrpPermission> findForPage(Map<String, Object> params, int pageSize, int pageNo) {

		return this.permissionDao.findPageList(params, pageSize, pageNo);
	}

	public boolean check(Long id, String permissionKey) {
		return false;
	}

	public List<UrpPermission> findPermissionByAppCode(String code) {
		AppAppInfo app = this.appDao.findAppByAppCode(code);
		if (app == null) {
			if (logger.isInfoEnabled()) {
				logger.info("find Permission By AppCode is null, appCode=" + code);
			}
			return null;
		}
		return this.permissionDao.findByAppId(app.getId());
	}

	public boolean ifAllGranted(String... permissionKey) {
		Set<String> granted = getGranted();
		if (containsAll(granted, permissionKey)) {
			return true;
		}
		return false;
	}

	public boolean ifAnyGranted(String... permissionKey) {
		Set<String> granted = getGranted();
		if (containsAny(granted, permissionKey)) {
			return true;
		}
		return false;
	}

	public boolean ifNotGranted(String... permissionKey) {
		Set<String> granted = getGranted();
		if (!containsAll(granted, permissionKey)) {
			return true;
		}
		return false;
	}

	private Set<String> getGranted() {
		Set<String> ret = new HashSet<String>();
		UserDetail detail = SecurityContext.getUserDetail();
		Permission[] ps = detail.getPermissions();
		if ((ps != null) && (ps.length > 0)) {
			Permission[] arrayOfPermission1;
			int j = (arrayOfPermission1 = ps).length;
			for (int i = 0; i < j; i++) {
				Permission each = arrayOfPermission1[i];
				String key = each.getPermissionKey();
				ret.add(key);
			}
		}
		return ret;
	}

	private boolean containsAll(Set<String> set, String[] values) {
		if ((values == null) || (values.length == 0) || (set == null) || (set.isEmpty())) {
			return false;
		}
		String[] arrayOfString;
		int j = (arrayOfString = values).length;
		for (int i = 0; i < j; i++) {
			String each = arrayOfString[i];
			if (!set.contains(each)) {
				return false;
			}
		}
		return true;
	}

	private boolean containsAny(Set<String> set, String[] values) {
		if ((values == null) || (values.length == 0) || (set == null) || (set.isEmpty())) {
			return false;
		}
		String[] arrayOfString;
		int j = (arrayOfString = values).length;
		for (int i = 0; i < j; i++) {
			String each = arrayOfString[i];
			if (set.contains(each)) {
				return true;
			}
		}
		return false;
	}

	public void enabledPermission(UrpPermission entity) {
		UrpPermission up = this.permissionDao.findByPrimaryKey(entity.getId());
		if (up != null) {

			// this.baseDao.executeHQL("update UrpPermission p set p.deleted=?,p.modifyTime=? where p.id=?").setString(0,
			// "N").setDate(1, new Date()).setSerializable(2, up.getPid()).executeUpdate();
		}
	}

	public void disabledPermission(UrpPermission entity) {
		UrpPermission up = this.permissionDao.findByPrimaryKey(entity.getId());
		if (up != null) {
			// this.baseDao.executeHQL("update UrpPermission p set p.deleted=?,p.modifyTime=? where p.id=?").setString(0,
			// "Y").setDate(1, new Date()).setSerializable(2, up.getPid()).executeUpdate();
		}
	}

	public List<?> getPermission() {
		// TODO Auto-generated method stub
		return null;
	}
}
