package com.dassmeta.passport.core.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import cn.widewisdom.entity.app.AppAppInfo;
import cn.widewisdom.entity.urp.UrpPermission;
import cn.widewisdom.service.PermissionService;

import com.specter.dao.BaseDao;
import com.specter.dao.Page;
import com.specter.security.auth.entity.Permission;
import com.specter.security.auth.entity.UserDetail;
import com.specter.security.context.SecurityContext;
import com.specter.service.impl.CriterionBuilder;

public class PermissionServiceImpl implements PermissionService {
	@Autowired
	private BaseDao baseDao;

	public List<?> getPermission() {
		String hql = "from UrpPermission t where t.deleted='N'";
		List l = this.baseDao.executeHQL(hql).list();
		return l;
	}

	public void save(UrpPermission permission) {
		permission.setDeleted("N");
		this.baseDao.save(permission);
	}

	public void delete(UrpPermission permission) {
		this.baseDao.delete(permission);

		String hql1 = "from UrpRolePermission t where t.permissionId='" + permission.getPid() + "'";
		String hql2 = "from UrpUserPermission t  where t.permissionId='" + permission.getPid() + "'";
		List list1 = this.baseDao.executeHQL(hql1).list();
		List list2 = this.baseDao.executeHQL(hql2).list();
		this.baseDao.deleteAll(list1);
		this.baseDao.deleteAll(list2);
	}

	public Page<UrpPermission> findForPage(Map<String, Object> params, int page) {
		Order o = null;
		Criterion cri = null;
		if (params != null) {
			cri = CriterionBuilder.and(cri, CriterionBuilder.like("name", params.get("name")));
			if (params.get("appId") != null) {
				cri = CriterionBuilder.and(cri, CriterionBuilder.sqlRestriction("({alias}.app_id=" + params.get("appId") + ")"));
			}
		}
		o = CriterionBuilder.getOrder("createTime", false);
		return this.baseDao.findForPage(UrpPermission.class, cri, Integer.valueOf(page), Integer.valueOf(10), o);
	}

	public boolean check(Long id, String permissionKey) {
		DetachedCriteria criteria = DetachedCriteria.forClass(UrpPermission.class);
		criteria.add(Restrictions.eq("permissionKey", permissionKey));
		if ((id != null) && (!"".equals(id))) {
			criteria.add(Restrictions.ne("id", id));
		}
		List<UrpPermission> l = this.baseDao.findByCriteria(UrpPermission.class, criteria);
		return (l != null) && (l.size() >= 1);
	}

	public Set<UrpPermission> findPermissionByAppCode(String code) {
		AppAppInfo app = (AppAppInfo) this.baseDao.getByUnique(AppAppInfo.class, "appCode", code);
		if (app == null) {
			return null;
		}
		return app.getPermission();
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
		Set<String> ret = new HashSet();
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
		UrpPermission up = (UrpPermission) this.baseDao.get(UrpPermission.class, entity.getPid());
		if (up != null) {
			this.baseDao.executeHQL("update UrpPermission p set p.deleted=?,p.modifyTime=? where p.id=?").setString(0, "N").setDate(1, new Date()).setSerializable(2, up.getPid()).executeUpdate();
		}
	}

	public void disabledPermission(UrpPermission entity) {
		UrpPermission up = (UrpPermission) this.baseDao.get(UrpPermission.class, entity.getPid());
		if (up != null) {
			this.baseDao.executeHQL("update UrpPermission p set p.deleted=?,p.modifyTime=? where p.id=?").setString(0, "Y").setDate(1, new Date()).setSerializable(2, up.getPid()).executeUpdate();
		}
	}
}
