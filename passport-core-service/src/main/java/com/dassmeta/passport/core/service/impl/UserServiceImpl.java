package com.dassmeta.passport.core.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dassmeta.passport.core.service.UserService;
import com.dassmeta.passport.dal.dataobject.AuUser;
import com.dassmeta.passport.dal.dataobject.AuUserDetail;
import com.dassmeta.passport.dal.dataobject.UrpPermission;

@Service("userService")
public class UserServiceImpl implements UserService {

	public void delete(AuUserDetail user) {
		// this.baseDao.delete(user);
		//
		// String hql = "from UrpUserRole t where t.userId='" + user.getUserId() + "'";
		// List list = this.baseDao.executeHQL(hql).list();
		// if (list != null) {
		// this.baseDao.deleteAll(list);
		// }
		// Long id = user.getUserId();
		// AuUser user1 = (AuUser) this.baseDao.get(AuUser.class, id);
		// if (user1 != null) {
		// this.baseDao.delete(user1);
		// }
		// String hqla = "from UrpUserPermission t where t.userId='" + user.getUserId() + "'";
		// List lista = this.baseDao.executeHQL(hqla).list();
		// if (lista != null) {
		// this.baseDao.deleteAll(list);
		// }
	}

	public Map getAllUserRole(Long userId) {
		// Map map = new HashMap();
		// String hql1 = "from UrpUserRole t where t.userId='" + userId + "'";
		// Query query = this.baseDao.executeHQL(hql1);
		// String roleId = "";
		// String roleIda = "";
		// String roleName = "";
		// List list = query.list();
		// for (int i = 0; i < list.size(); i++) {
		// UrpUserRole role = (UrpUserRole) list.get(i);
		// roleIda = roleIda + role.getRoleId() + ";";
		// roleId = roleId + "'" + role.getRoleId() + "',";
		// }
		// if (!"".equals(roleId)) {
		// roleId = roleId.substring(0, roleId.length() - 1);
		// String hql = "from UrpRole t where t.id in (" + roleId + ")";
		// List roleList = this.baseDao.executeHQL(hql).list();
		// for (int i = 0; i < roleList.size(); i++) {
		// UrpRole role = (UrpRole) roleList.get(i);
		// roleName = roleName + role.getRoleName() + "xxxxxx";
		// }
		// if (!"".equals(roleName)) {
		// roleName = roleName.substring(0, roleName.length() - 1);
		// }
		// }
		// map.put("roleIda", roleIda);
		// map.put("roleName", roleName);
		//
		// String hql = "from UrpUserPermission t where t.userId='" + userId + "'";
		// Query query1 = this.baseDao.executeHQL(hql);
		//
		// String perId = "";
		// String perName = "";
		// String perIda = "";
		// String perCode = "";
		// List perList = query1.list();
		// for (int i = 0; i < perList.size(); i++) {
		// UrpUserPermission per = (UrpUserPermission) perList.get(i);
		// perId = perId + "'" + per.getPermissionId() + "',";
		// perIda = perIda + per.getPermissionId() + ";";
		// }
		// if (!"".equals(perId)) {
		// perId = perId.substring(0, perId.length() - 1);
		// String hql3 = "from UrpPermission t where t.id in (" + perId + ")";
		// List permission = this.baseDao.executeHQL(hql3).list();
		// for (int i = 0; i < permission.size(); i++) {
		// UrpPermission per = (UrpPermission) permission.get(i);
		// perName = perName + per.getName() + "锟斤拷锟�";
		// perCode = perCode + per.getPermissionKey() + ";";
		// }
		// if (!"".equals(perName)) {
		// perName = perName.substring(0, perName.length() - 1);
		// }
		// }
		// map.put("perName", perName);
		// map.put("perIda", perIda);
		// map.put("perCode", perCode);
		// return map;

		return null;
	}

	public AuUserDetail getUserByUserId(String userId) {
		// return (AuUserDetail) this.baseDao.getByUnique(AuUserDetail.class, "userId", userId);
		return null;
	}

	public void deleteUserRole(Long userId) {
		// String hql = "from UrpUserRole t where t.userId='" + userId + "'";
		// List list = this.baseDao.executeHQL(hql).list();
		// this.baseDao.deleteAll(list);
	}

	public void deleteUserPer(Long userId) {
		// String hql = "from UrpUserPermission t where t.userId='" + userId + "'";
		// List list = this.baseDao.executeHQL(hql).list();
		// this.baseDao.deleteAll(list);
	}

	public List getUserRole(String userId) {
		// String hql = "from UrpUserRole t where t.userId='" + userId + "'";
		// Query query = this.baseDao.executeHQL(hql);
		// return query.list();
		return null;
	}

	public List getUserPer(Long userId) {
		// String hql = "from UrpUserPermission t where t.userId='" + userId + "'";
		// Query query = this.baseDao.executeHQL(hql);
		// return query.list();
		return null;
	}

	public void deleteUserRole(Long userId, Long roleId) {
		// String hql = "from UrpUserRole t where t.userId='" + userId + "' and t.roleId='" + roleId + "'";
		// List list = this.baseDao.executeHQL(hql).list();
		// this.baseDao.deleteAll(list);
	}

	public void deleteUserPer(Long userId, Long perId) {
		// String hql = "from UrpUserPermission t where t.userId='" + userId + "' and t.permissionId='" + perId + "'";
		// List list = this.baseDao.executeHQL(hql).list();
		// this.baseDao.deleteAll(list);
	}

	public List<UrpPermission> findUserPermission(String userID) {
		// List<UrpPermission> list = this.baseDao.findByNamedQuery("select_permission_by_userid", new Object[] {
		// userID, userID });
		// return list;
		return null;
	}

	public List<UrpPermission> findUserPermission(Long userID, String appCode) {
		// AppAppInfo app = (AppAppInfo) this.baseDao.getByUnique(AppAppInfo.class, "appCode", appCode);
		// List<UrpPermission> list = null;
		// if (app != null) {
		// String appId = app.getId().toString();
		// list = this.baseDao.findByNamedQuery("select_permission_by_userid_app", new Object[] { userID, appId, userID,
		// appId });
		// }
		// return list;

		return null;
	}

	public AuUser getUserByLoginID(String loginID) {
		// Map<String, Object> map = new HashMap();
		// map.put("loginId", loginID);
		//
		// List<AuUser> list = this.baseDao.find(AuUser.class, map);
		// if ((list != null) && (list.size() > 0)) {
		// return (AuUser) list.get(0);
		// }
		return null;
	}

	public void enabledUser(AuUserDetail entity) {
		// AuUserDetail aud = (AuUserDetail) this.baseDao.get(AuUserDetail.class, entity.getId());
		// if (aud != null) {
		// this.baseDao.executeHQL("update AuUser u set u.deleted=?,u.modifyTime=? where u.id=?").setString(0,
		// "N").setDate(1, new Date()).setSerializable(2, aud.getUserId()).executeUpdate();
		// this.baseDao.executeHQL("update AuUserDetail u set u.deleted=?,u.modifyTime=? where u.id=?").setString(0,
		// "N").setDate(1, new Date()).setSerializable(2, aud.getId()).executeUpdate();
		// }
	}

	public void disabledUser(AuUserDetail entity) {
		// AuUserDetail aud = (AuUserDetail) this.baseDao.get(AuUserDetail.class, entity.getId());
		// if (aud != null) {
		// this.baseDao.executeHQL("update AuUser u set u.deleted=?,u.modifyTime=? where u.id=?").setString(0,
		// "Y").setDate(1, new Date()).setSerializable(2, aud.getUserId()).executeUpdate();
		// this.baseDao.executeHQL("update AuUserDetail u set u.deleted=?,u.modifyTime=? where u.id=?").setString(0,
		// "Y").setDate(1, new Date()).setSerializable(2, aud.getId()).executeUpdate();
		// }
	}

	public AuUser getUser(String loginId) {
		// Map<String, Object> map = new HashMap();
		// map.put("loginId", loginId);
		// map.put("deleted", "N");
		//
		// List<AuUser> list = this.baseDao.find(AuUser.class, map);
		// if ((list != null) && (list.size() > 0)) {
		// return (AuUser) list.get(0);
		// }
		return null;
	}
}
