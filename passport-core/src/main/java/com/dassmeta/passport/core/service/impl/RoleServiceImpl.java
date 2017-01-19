package com.dassmeta.passport.core.service.impl;

import cn.widewisdom.entity.urp.UrpPermission;
import cn.widewisdom.entity.urp.UrpRole;
import cn.widewisdom.entity.urp.UrpRolePermission;
import cn.widewisdom.service.RoleService;
import com.specter.dao.BaseDao;
import com.specter.dao.Page;
import com.specter.service.impl.CriterionBuilder;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleServiceImpl implements RoleService {
	@Autowired
	private BaseDao baseDao;

	public void delete(UrpRole role) {
		this.baseDao.delete(role);
		String hql = "from UrpRolePermission t where t.roleId='" + role.getId() + "'";
		Query q = this.baseDao.executeHQL(hql);
		this.baseDao.deleteAll(q.list());

		hql = "from UrpUserRole t where t.roleId='" + role.getId() + "'";
		q = this.baseDao.executeHQL(hql);
		this.baseDao.deleteAll(q.list());
	}

	public void deleteRolePermission(String roleId) {
		String hql = "from UrpRolePermission t where t.roleId = " + roleId;
		List list = this.baseDao.executeHQL(hql).list();
		this.baseDao.deleteAll(list);
	}

	public List<UrpPermission> findPermissionInfo() {
		String HQL = "from UrpPermission t where t.deleted='N'";
		List<UrpPermission> l = this.baseDao.executeHQL(HQL).list();
		return l;
	}

	public List<?> getRolePermission(Long roleId) {
		String s = "select b.NAME ,a.PERMISSION_ID from URP_ROLE_PERMISSION a,URP_PERMISSION b where a.PERMISSION_ID=b.ID and ROLE_ID=" + roleId;
		Query query = this.baseDao.executeSQL(s);
		return query.list();
	}

	public List<UrpRole> getAllRole() {
		Query query = this.baseDao.executeHQL("from UrpRole t where t.visible='Y' order by t.roleName");
		return query.list();
	}

	public List<UrpRole> getAllRoleByOrgCode(String orgId) {
		orgId = " and orgCode = " + orgId + " ";
		Query query = this.baseDao.executeHQL("from UrpRole t where t.visible='Y'" + orgId + " order by t.roleName");
		return query.list();
	}

	public Page<UrpRole> findForPage(Map<String, Object> params, int page) {
		Criterion cri = null;
		Order o = null;
		o = CriterionBuilder.getOrder("createTime", false);
		return this.baseDao.findForPage(UrpRole.class, cri, Integer.valueOf(page), Integer.valueOf(10), o);
	}

	public List<?> findAuUserDetail(String id) {
		String s = "select c.USER_NAME,b.ORG_NAME,c.JOB_NAME from AU_ORG_INFO  b,AU_USER_DETAIL  c,";
		s = s + "URP_USER_ROLE d\twhere d.ROLE_ID='" + id + "' and b.ID=c.ORG_ID and d.USER_ID=c.USER_ID ";
		Query query = this.baseDao.executeSQL(s);
		return query.list();
	}

	public void saveOrUpdateRolePermission(UrpRolePermission urpRolePermission) {
		this.baseDao.save(urpRolePermission);
	}

	public String getRolePer(String roleId) {
		String perID = "";
		String perS = "";
		String hql = "from UrpRolePermission t where t.roleId='" + roleId + "'";
		List roleL = this.baseDao.executeHQL(hql).list();
		for (int i = 0; i < roleL.size(); i++) {
			UrpRolePermission role = (UrpRolePermission) roleL.get(i);
			perID = perID + "'" + role.getPermissionId() + "',";
		}
		if (!"".equals(perID)) {
			perID = perID.substring(0, perID.length() - 1);
			String hql2 = "from UrpPermission t where t.id in (" + perID + ")";
			List perL = this.baseDao.executeHQL(hql2).list();
			for (int i = 0; i < perL.size(); i++) {
				UrpPermission per = (UrpPermission) perL.get(i);
				perS = perS + per.getName() + "���";
			}
		}
		return perS;
	}

	public void deleteRolePermission(UrpRolePermission urpRolePermission) {
		String hql = "from UrpRolePermission a where a.roleId = " + urpRolePermission.getRoleId() + " and a.permissionId = " + urpRolePermission.getPermissionId();
		Query query = this.baseDao.executeHQL(hql);
		this.baseDao.deleteAll(query.list());
	}

	public List getAllDepart() {
		String hql = "from AuOrgInfo";
		List list = this.baseDao.executeHQL(hql).list();
		return list;
	}

	public void enabledRole(UrpRole role) {
		UrpRole ur = (UrpRole) this.baseDao.get(UrpRole.class, role.getId());
		if (ur != null) {
			this.baseDao.executeHQL("update UrpRole r set r.visible=?,r.modifyTime=? where r.id=?").setString(0, "Y").setDate(1, new Date()).setSerializable(2, ur.getId()).executeUpdate();
		}
	}

	public void disabledRole(UrpRole role) {
		UrpRole ur = (UrpRole) this.baseDao.get(UrpRole.class, role.getId());
		if (ur != null) {
			this.baseDao.executeHQL("update UrpRole r set r.visible=?,r.modifyTime=? where r.id=?").setString(0, "N").setDate(1, new Date()).setSerializable(2, ur.getId()).executeUpdate();
		}
	}
}
