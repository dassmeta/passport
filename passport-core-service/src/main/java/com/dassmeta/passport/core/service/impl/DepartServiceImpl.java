package com.dassmeta.passport.core.service.impl;

import org.springframework.stereotype.Service;

import com.dassmeta.passport.core.service.DepartService;

@Service("departService")
public class DepartServiceImpl implements DepartService {

	// public Page<AuUserDetail> findForPage(Map<String, Object> params, int page) {
	// Criterion cri = null;
	// if (params.get("org") != null) {
	// cri = CriterionBuilder.and(cri, CriterionBuilder.eq("org", params.get("org")));
	// }
	// if (params.get("userName") != null) {
	// cri = CriterionBuilder.and(cri, CriterionBuilder.like("userName", params.get("userName")));
	// }
	// return this.baseDao.findForPage(AuUserDetail.class, cri, Integer.valueOf(page), Integer.valueOf(10), null);
	// }
	//
	// public Page<AuUserView> findForViewPage(Map<String, Object> params, int page) {
	// Criterion cri = null;
	//
	// String sql = "select getChildLst(?)";
	// if (params.get("loginId") != null) {
	// cri = CriterionBuilder.and(cri, CriterionBuilder.like("loginId", params.get("loginId")));
	// }
	// if (params.get("orgId") != null) {
	// List listStr = this.baseDao.executeSQL(sql).setLong(0, Long.parseLong(params.get("orgId").toString())).list();
	// if ((listStr != null) && (listStr.size() > 0)) {
	// String[] orgIds = ((String) listStr.get(0)).substring(0, ((String) listStr.get(0)).length()).split(",");
	// Long[] longs = new Long[orgIds.length];
	// for (int i = 0; i < orgIds.length; i++) {
	// longs[i] = Long.valueOf(Long.parseLong(orgIds[i]));
	// }
	// cri = CriterionBuilder.and(cri, CriterionBuilder.in("orgId", longs));
	// }
	// }
	// if (params.get("userName") != null) {
	// cri = CriterionBuilder.and(cri, CriterionBuilder.like("userName", params.get("userName")));
	// }
	// if (params.get("orgCode") != null) {
	// cri = CriterionBuilder.and(cri, CriterionBuilder.like("orgCode", params.get("orgCode")));
	// }
	// return this.baseDao.findForPage(AuUserView.class, cri, Integer.valueOf(page), Integer.valueOf(10), null);
	// }
	//
	// public boolean CheckDeleteChildElement(Long orgId) {
	// Criterion cri = null;
	//
	// String sql = "select getChildLst(?)";
	// List listStr = this.baseDao.executeSQL(sql).setLong(0, orgId.longValue()).list();
	// if ((listStr != null) && (listStr.size() > 0)) {
	// String[] orgIds = ((String) listStr.get(0)).substring(0, ((String) listStr.get(0)).length()).split(",");
	// Long[] longs = new Long[orgIds.length];
	// for (int i = 0; i < orgIds.length; i++) {
	// longs[i] = Long.valueOf(Long.parseLong(orgIds[i]));
	// }
	// cri = CriterionBuilder.and(cri, CriterionBuilder.in("orgId", longs));
	// }
	// Page auUserViewPage = this.baseDao.findForPage(AuUserView.class, cri, Integer.valueOf(0), Integer.valueOf(10),
	// null);
	// if ((auUserViewPage != null) && (auUserViewPage.getTotalCount() > 0)) {
	// return false;
	// }
	// return true;
	// }
	//
	// public List getAllOrg() {
	// String hql = "from AuOrgInfo t where 1=1 and t.deleted='N'";
	// return this.baseDao.executeHQL(hql).list();
	// }
	//
	// public void delete(Long id) {
	// AuOrgInfo org = (AuOrgInfo) this.baseDao.get(AuOrgInfo.class, id);
	//
	// String sql = "select id from au_org_info where FIND_IN_SET(id, getChildLst(" + id + "))";
	//
	// List list = this.baseDao.executeSQL(sql).list();
	// if ((list != null) && (list.size() > 0)) {
	// for (int i = 0; i < list.size(); i++) {
	// long orgId = new Long(list.get(i).toString()).longValue();
	//
	// String hql = "from AuUserDetail t where t.org.id=?";
	// List<AuUserDetail> lista = this.baseDao.getHibernateTemplate().find(hql, Long.valueOf(orgId));
	// for (int j = 0; j < lista.size(); j++) {
	// AuUserDetail user = (AuUserDetail) lista.get(j);
	// this.baseDao.delete(AuUser.class, ((AuUserDetail) lista.get(j)).getUserId());
	// this.baseDao.delete(user);
	// }
	// this.baseDao.delete(AuOrgInfo.class, Long.valueOf(orgId));
	// }
	// }
	// }
	//
	// public AuOrgInfo getOrgByCode(Long code) {
	// return (AuOrgInfo) this.baseDao.get(AuOrgInfo.class, code);
	// }
	//
	// public boolean isHaveChild(Long id) {
	// String sql = "select id from au_org_info where FIND_IN_SET(id, getChildLst(" + id + "))";
	// List list = this.baseDao.executeSQL(sql).list();
	// if ((list != null) && (list.size() > 1)) {
	// return true;
	// }
	// return false;
	// }
}
