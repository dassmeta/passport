package com.dassmeta.passport.core.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.dassmeta.passport.core.service.RoleService;
import com.dassmeta.passport.dal.dataobject.UrpPermission;
import com.dassmeta.passport.dal.dataobject.UrpRole;
import com.dassmeta.passport.dal.ibatis.UrpPermissionDao;
import com.dassmeta.passport.dal.ibatis.UrpRoleDao;
import com.dassmeta.passport.dal.ibatis.UrpRolePermissionDao;
import com.dassmeta.passport.dal.ibatis.UrpUserRoleDao;

public class RoleServiceImpl implements RoleService {
	@Autowired
	private UrpRoleDao roleDao;

	@Autowired
	private UrpRolePermissionDao rolePermissionDao;

	@Autowired
	private UrpUserRoleDao userRoleDao;

	@Autowired
	private UrpPermissionDao permissionDao;

	@Autowired
	private TransactionTemplate aclTransactionTemplate;

	public void delete(final UrpRole role) {

		aclTransactionTemplate.execute(new TransactionCallbackWithoutResult() {

			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				roleDao.remove(role);
				rolePermissionDao.removeByRoleId(role.getId());
				userRoleDao.removeByRoleId(role.getId());
			}
		});

	}

	public void deleteRolePermission(Long roleId) {
		this.rolePermissionDao.removeByRoleId(roleId);
	}

	public List<UrpPermission> findPermissionInfo() {
		return this.permissionDao.getAllPermission();
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

	public void setAclTransactionTemplate(TransactionTemplate aclTransactionTemplate) {
		this.aclTransactionTemplate = aclTransactionTemplate;
	}

}
