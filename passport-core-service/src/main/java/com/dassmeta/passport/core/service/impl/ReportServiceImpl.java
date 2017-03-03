package com.dassmeta.passport.core.service.impl;

import org.springframework.stereotype.Service;

import com.dassmeta.passport.core.service.ReportService;

@Service("reportService")
public class ReportServiceImpl implements ReportService {
	// @Autowired
	// private BaseDao baseDao;
	//
	// public Page<ReportUserDetail> findForPage(Map<String, Object> params, int page) {
	// Criterion cri = null;
	// if (params.get("userSystem") == null) {
	// return null;
	// }
	// if ((params.get("identityCard") != null) && (!"".equals(params.get("identityCard")))) {
	// cri = CriterionBuilder.and(cri, CriterionBuilder.eq("identityCard", params.get("identityCard")));
	// }
	// if ((params.get("userName") != null) && (!"".equals(params.get("userName")))) {
	// cri = CriterionBuilder.and(cri, CriterionBuilder.like("userName", params.get("userName")));
	// }
	// if ((params.get("orgCode") != null) && (!"".equals(params.get("orgCode")))) {
	// cri = CriterionBuilder.and(cri, CriterionBuilder.llike("orgCode", params.get("orgCode")));
	// }
	// String[] sj = (String[]) params.get("length");
	// if ((sj != null) && (sj.length > 0)) {
	// String sql = "(length({alias}.org_code)=" + sj[0];
	// for (int i = 1; i < sj.length; i++) {
	// sql = sql + " or length({alias}.org_code)=" + sj[i];
	// }
	// sql = sql + ")";
	// cri = CriterionBuilder.and(cri, CriterionBuilder.sqlRestriction(sql));
	// }
	// if ((params.get("userSystem") != null) && (!"".equals(params.get("userSystem")))) {
	// String[] a = (String[]) params.get("userSystem");
	// if (a.length == 1) {
	// cri = CriterionBuilder.and(cri, CriterionBuilder.like("userSystem", a[0]));
	// } else {
	// Criterion cr = null;
	// for (int i = 0; i < a.length; i++) {
	// cr = CriterionBuilder.or(cr, CriterionBuilder.like("userSystem", a[i]));
	// }
	// cri = CriterionBuilder.and(cri, cr);
	// }
	// }
	// if ((params.get("isAdmin") != null) && (!"".equals(params.get("isAdmin")))) {
	// cri = CriterionBuilder.and(cri, CriterionBuilder.eq("isAdmin", params.get("isAdmin")));
	// }
	// Object ascendName = params.get("ascendName");
	// Object ascending = params.get("ascending");
	// Order o = null;
	// if ((ascendName != null) && (ascending != null)) {
	// o = CriterionBuilder.getOrder(String.valueOf(ascendName),
	// Boolean.valueOf(String.valueOf(ascending)).booleanValue());
	// }
	// Page<ReportUserDetail> p = this.baseDao.findForPage(ReportUserDetail.class, cri, Integer.valueOf(page),
	// Integer.valueOf(15), o);
	// List<ReportUserDetail> list = p.getPageList();
	// List<ReportUserDetail> li = new ArrayList();
	// String areaSql = "";
	// for (ReportUserDetail l : list) {
	// int i = l.getOrgCode().length();
	// if (i == 2) {
	// areaSql = "select t.org_name from AU_ORG_INFO t where t.org_code='" + l.getOrgCode() + "'";
	// } else if (i == 4) {
	// areaSql = "select t.org_name from AU_ORG_INFO t where t.org_code='" + l.getOrgCode() + "'";
	// } else if (i == 6) {
	// areaSql = "select (select o.org_name from AU_ORG_INFO o where o.org_code=substr('" + l.getOrgCode() +
	// "',1,4))||t.org_name from AU_ORG_INFO t where t.org_code='" + l.getOrgCode()
	// + "'";
	// } else if (i == 9) {
	// areaSql = "select (select o.org_name from AU_ORG_INFO o where o.org_code=substr('" + l.getOrgCode() +
	// "',1,6))||t.org_name from AU_ORG_INFO t where t.org_code='" + l.getOrgCode()
	// + "'";
	// } else if (i == 12) {
	// areaSql = "select (select o.org_name from AU_ORG_INFO o where o.org_code=substr('" + l.getOrgCode() +
	// "',1,9))||t.org_name from AU_ORG_INFO t where t.org_code='" + l.getOrgCode()
	// + "'";
	// }
	// l.setOrgName(String.valueOf(this.baseDao.executeSQL(areaSql).uniqueResult()));
	// li.add(l);
	// }
	// p.setPageList(li);
	// return p;
	// }
	//
	// public Page<UserDetail> findForEditedPage(Map<String, Object> params, int page) {
	// Criterion cri = null;
	// String sql = "";
	// String[] userSystem = (String[]) params.get("userSystem");
	// if (userSystem == null) {
	// return null;
	// }
	// if (params.get("identityCard") != null) {
	// cri = CriterionBuilder.and(cri, CriterionBuilder.eq("identityCard", params.get("identityCard")));
	// }
	// if (params.get("userName") != null) {
	// cri = CriterionBuilder.and(cri, CriterionBuilder.like("userName", params.get("userName")));
	// }
	// if (params.get("orgCode") != null) {
	// cri = CriterionBuilder.and(cri, CriterionBuilder.llike("orgCode", params.get("orgCode")));
	// }
	// if (params.get("loginName") != null) {
	// cri = CriterionBuilder.and(cri, CriterionBuilder.like("loginName", params.get("loginName")));
	// }
	// String[] sj = (String[]) params.get("length");
	// System.out.println("---------------------" + sj + "-------------------------");
	// if ((sj != null) && (sj.length > 0)) {
	// String sqls = "(length((select t.ORG_CODE from AU_ORG_INFO t where t.id = {alias}.ORG_ID))=" + sj[0];
	// for (int i = 1; i < sj.length; i++) {
	// sqls = sqls + " or length((select t.ORG_CODE from AU_ORG_INFO t where t.id = {alias}.ORG_ID))=" + sj[i];
	// }
	// sqls = sqls + ")";
	// System.out.println("---------------------" + sqls + "-------------------------");
	// cri = CriterionBuilder.and(cri, CriterionBuilder.sqlRestriction(sqls));
	// }
	// if (userSystem != null) {
	// for (int i = 0; i < userSystem.length; i++) {
	// if (i != userSystem.length - 1) {
	// sql = sql + "'" + userSystem[i] + "',";
	// } else {
	// sql = sql + "'" + userSystem[i] + "'";
	// }
	// }
	// cri = CriterionBuilder
	// .and(cri,
	// CriterionBuilder
	// .sqlRestriction(" {alias}.user_id in( select t.id from au_user t,urp_user_permission b where t.id= b.user_id and b.permission_id in (select c.id from urp_permission c where c.permission_key in("
	// +
	//
	// sql + ")))"));
	// }
	// Object ascendName = params.get("ascendName");
	// Object ascending = params.get("ascending");
	// Order o = null;
	// if ((ascendName != null) && (ascending != null)) {
	// o = CriterionBuilder.getOrder(String.valueOf(ascendName),
	// Boolean.valueOf(String.valueOf(ascending)).booleanValue());
	// } else {
	// o = CriterionBuilder.getOrder("createTime", false);
	// }
	// Page<UserDetail> p = this.baseDao.findForPage(UserDetail.class, cri, Integer.valueOf(page), Integer.valueOf(15),
	// o);
	// List<UserDetail> list = p.getPageList();
	// List<UserDetail> li = new ArrayList();
	// String areaSql = "";
	// for (UserDetail l : list) {
	// int i = l.getOrgCode().length();
	// if (i == 2) {
	// areaSql = "select t.org_name from AU_ORG_INFO t where t.org_code='" + l.getOrgCode() + "'";
	// } else if (i == 4) {
	// areaSql = "select t.org_name from AU_ORG_INFO t where t.org_code='" + l.getOrgCode() + "'";
	// } else if (i == 6) {
	// areaSql = "select (select o.org_name from AU_ORG_INFO o where o.org_code=substr('" + l.getOrgCode() +
	// "',1,4))||t.org_name from AU_ORG_INFO t where t.org_code='" + l.getOrgCode()
	// + "'";
	// } else if (i == 9) {
	// areaSql = "select (select o.org_name from AU_ORG_INFO o where o.org_code=substr('" + l.getOrgCode() +
	// "',1,6))||t.org_name from AU_ORG_INFO t where t.org_code='" + l.getOrgCode()
	// + "'";
	// } else if (i == 12) {
	// areaSql = "select (select o.org_name from AU_ORG_INFO o where o.org_code=substr('" + l.getOrgCode() +
	// "',1,9))||t.org_name from AU_ORG_INFO t where t.org_code='" + l.getOrgCode()
	// + "'";
	// }
	// l.setOrgName(String.valueOf(this.baseDao.executeSQL(areaSql).uniqueResult()));
	// li.add(l);
	// }
	// p.setPageList(li);
	// return p;
	// }
	//
	// public void reportUser(String loginId, String password, ReportUserDetail reportUser) {
	// AuUser login = new AuUser();
	// login.setDeleted("N");
	// login.setCreateTime(DateFormatUtil.getCurrentSQLDate());
	// login.setModifyTime(DateFormatUtil.getCurrentSQLDate());
	// login.setLoginId(loginId);
	// login.setPassword(password);
	// login = (AuUser) this.baseDao.save(login);
	//
	// AuUserDetail d = new AuUserDetail();
	// d.setCreateTime(reportUser.getCreateTime());
	// d.setEmail(reportUser.getEmail());
	// d.setGender(reportUser.getGender());
	// d.setIdentityCard(reportUser.getIdentityCard());
	// d.setJobName(reportUser.getJobName());
	// d.setMobile(reportUser.getMobile());
	// d.setModifyTime(reportUser.getModifyTime());
	// d.setPhone(reportUser.getPhone());
	// d.setUserName(reportUser.getUserName());
	// d.setUserQQ(reportUser.getUserQQ());
	// d.setDeleted("N");
	// d.setUserId(login.getId());
	// AuOrgInfo org = (AuOrgInfo) this.baseDao.get(AuOrgInfo.class, reportUser.getOrgId());
	// d.setOrg(org);
	// this.baseDao.save(d);
	// if ((reportUser.getRoleId() != null) && (!"".equals(reportUser.getRoleId()))) {
	// String[] roleId = reportUser.getRoleId().split(",");
	// for (int i = 0; i < roleId.length; i++) {
	// UrpUserRole role = new UrpUserRole();
	// role.setUserId(login.getId());
	// role.setRoleId(new Long(roleId[i]));
	// role.setCreateTime(DateFormatUtil.getCurrentSQLDate());
	// role.setModifyTime(DateFormatUtil.getCurrentSQLDate());
	// this.baseDao.save(role);
	// }
	// }
	// }
	//
	// public void saveUser(ReportUserDetail reportUser) {
	// RUserInfo ru = (RUserInfo) Struts2Utils.getSession().getAttribute("SSH_ONLINE_USER");
	// String loginID = reportUser.getLoginName();
	//
	// AuUser u = (AuUser) this.baseDao.getByUnique(AuUser.class, "loginId", loginID);
	// String userid = "";
	// if (u != null) {
	// userid = u.getId().toString();
	// } else {
	// AuUser login = new AuUser();
	// login.setDeleted("N");
	// login.setCreateTime(DateFormatUtil.getCurrentSQLDate());
	// login.setModifyTime(DateFormatUtil.getCurrentSQLDate());
	// login.setLoginId(reportUser.getLoginName());
	// login.setPassword(reportUser.getPassword());
	// login = (AuUser) this.baseDao.save(login);
	// userid = login.getId().toString();
	//
	// AuUserDetail d = new AuUserDetail();
	// d.setCreateTime(reportUser.getCreateTime());
	// d.setEmail(reportUser.getEmail());
	// d.setGender(reportUser.getGender());
	// d.setIdentityCard(reportUser.getIdentityCard());
	// d.setJobName(reportUser.getJobName());
	// d.setMobile(reportUser.getMobile());
	// d.setModifyTime(reportUser.getModifyTime());
	// d.setPhone(reportUser.getPhone());
	// d.setUserName(reportUser.getUserName());
	// d.setUserQQ(reportUser.getUserQQ());
	// d.setUserEmployer(reportUser.getUserEmployer());
	// d.setDeleted("N");
	// d.setUserId(new Long(userid));
	// d.setCreator(ru.getLoginId());
	// String hql = "from AuOrgInfo a where a.orgCode='" + reportUser.getOrgCode() + "' and a.deleted='N'";
	// AuOrgInfo org = (AuOrgInfo) this.baseDao.executeHQL(hql).list().get(0);
	// d.setOrg(org);
	// this.baseDao.save(d);
	// }
	// if ((reportUser.getUserSystem() != null) && (!"".equals(reportUser.getUserSystem()))) {
	// String[] sid = reportUser.getUserSystem().split(",");
	// for (int i = 0; i < sid.length; i++) {
	// String appcode = sid[i].replace(" ", "");
	// UrpPermission up = (UrpPermission) this.baseDao.getByUnique(UrpPermission.class, "permissionKey", appcode);
	// UrpUserPermission p = new UrpUserPermission();
	// p.setUserId(new Long(userid));
	// p.setPermissionId(up.getPid());
	// p.setCreateTime(DateFormatUtil.getCurrentSQLDate());
	// p.setModifyTime(DateFormatUtil.getCurrentSQLDate());
	// this.baseDao.save(p);
	// }
	// }
	// if ((reportUser.getRoleId() != null) && (!"".equals(reportUser.getRoleId()))) {
	// String[] rid = reportUser.getRoleId().split(",");
	// for (int i = 0; i < rid.length; i++) {
	// UrpUserRole ur = new UrpUserRole();
	// ur.setUserId(new Long(userid));
	// ur.setRoleId(new Long(rid[i].replace(" ", "")));
	// ur.setModifyTime(DateFormatUtil.getCurrentSQLDate());
	// ur.setCreateTime(DateFormatUtil.getCurrentSQLDate());
	// this.baseDao.save(ur);
	// }
	// }
	// if ("1".equals(reportUser.getIsAdmin())) {
	// UrpUserPermission p = new UrpUserPermission();
	// UrpPermission up = (UrpPermission) this.baseDao.getByUnique(UrpPermission.class, "permissionKey",
	// "user-report-manage");
	// p.setUserId(new Long(userid));
	// p.setPermissionId(up.getPid());
	// p.setCreateTime(DateFormatUtil.getCurrentSQLDate());
	// p.setModifyTime(DateFormatUtil.getCurrentSQLDate());
	// this.baseDao.save(p);
	// }
	// }
	//
	// public Map<String, String> getReportRole(String id) {
	// Map<String, String> map = new HashMap();
	// ReportUserDetail u = (ReportUserDetail) this.baseDao.get(ReportUserDetail.class, id);
	// String roleName = "";
	// String hql = "from UrpRole t where t.id in (" + u.getRoleId() + ")";
	// List<UrpRole> roleList = this.baseDao.executeHQL(hql).list();
	// for (int i = 0; i < roleList.size(); i++) {
	// UrpRole role = (UrpRole) roleList.get(i);
	// roleName = roleName + role.getRoleName() + "���";
	// }
	// if (!"".equals(roleName)) {
	// roleName = roleName.substring(0, roleName.length() - 1);
	// }
	// map.put("roleId", u.getRoleId());
	// map.put("roleName", roleName);
	// return map;
	// }
	//
	// public AuUserDetail findUserReportManage(String orgCode, String permissionKey) {
	// orgCode = subCode(orgCode);
	//
	// return null;
	// }
	//
	// private String subCode(String orgCode) {
	// String code = "";
	// int i = orgCode.length();
	// switch (i) {
	// case 12:
	// code = orgCode.substring(0, 9);
	// break;
	// case 9:
	// code = orgCode.substring(0, 6);
	// break;
	// case 6:
	// code = orgCode.substring(0, 4);
	// break;
	// case 4:
	// code = orgCode.substring(0, 2);
	// }
	// return code;
	// }
	//
	// public boolean validateuser(String loginName) {
	// ReportUserDetail user = null;
	// try {
	// user = (ReportUserDetail) this.baseDao.getByUnique(ReportUserDetail.class, "loginName", loginName);
	// } catch (NonUniqueResultException e) {
	// return false;
	// }
	// if (user != null) {
	// return false;
	// }
	// return true;
	// }
	//
	// public String checkUser(String name, String identityCard) {
	// String cc = DisabledClient.getDisabled(identityCard, name);
	// if ("b".equals(cc)) {
	// return "1";
	// }
	// ReportUserDetail user = null;
	// try {
	// user = (ReportUserDetail) this.baseDao.getByUnique(ReportUserDetail.class, "identityCard", identityCard);
	// } catch (NonUniqueResultException e) {
	// return "2";
	// }
	// if (user != null) {
	// return "2";
	// }
	// Map<String, String> m = new HashMap();
	// m.put("identityCard", identityCard);
	// List<AuUserDetail> ul = this.baseDao.find(AuUserDetail.class, m);
	// if (ul.size() > 0) {
	// AuUserDetail u = (AuUserDetail) ul.get(0);
	// AuUser au = (AuUser) this.baseDao.getByUnique(AuUser.class, "id", u.getUserId());
	// String json = au.getLoginId();
	// return json;
	// }
	// if ("c".equals(cc)) {
	// return "5";
	// }
	// return "4";
	// }
	//
	// public String getAuditedUserRoles(String userId) {
	// String sql =
	// "select o.role_name,(select e.app_name from app_app_info e where e.id=o.app_id)as syst from urp_user_role t,urp_role o where t.user_id='"
	// + userId + "'";
	// SQLQuery q = this.baseDao.executeSQL(sql);
	// q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
	// List<Map<String, Object>> list = q.list();
	// String str = "";
	// for (Map<String, Object> a : list) {
	// String b = String.valueOf(a.get("ROLE_NAME"));
	// String c = String.valueOf(a.get("SYST"));
	// if ("null".equals(b)) {
	// b = "";
	// }
	// if ("null".equals(c)) {
	// c = "";
	// }
	// str = str + c + b + "  ";
	// }
	// return str;
	// }
	//
	// public RAuUserDetail getAuUserDetail(String loginId) {
	// String sql = "select t.id from au_user t where t.login_id='" + loginId + "'";
	// SQLQuery q = this.baseDao.executeSQL(sql);
	// String userId = q.list().get(0).toString();
	// RAuUserDetail au = (RAuUserDetail) this.baseDao.getByUnique(RAuUserDetail.class, "userId", userId);
	// return au;
	// }
	//
	// public void saveEdit(String userId, List list1, List list2, List list3, List list4) {
	// ArrayList addsys = getAdd(list1, list3);
	// ArrayList deletesys = getAdd(list3, list1);
	// Object s = null;
	// Iterator<String> it = null;
	//
	// it = addsys.iterator();
	// while (it.hasNext()) {
	// s = it.next();
	// UrpPermission up = (UrpPermission) this.baseDao.getByUnique(UrpPermission.class, "permissionKey",
	// s.toString().trim());
	// UrpUserPermission p = new UrpUserPermission();
	// p.setUserId(new Long(userId));
	// p.setPermissionId(up.getPid());
	// p.setCreateTime(DateFormatUtil.getCurrentSQLDate());
	// p.setModifyTime(DateFormatUtil.getCurrentSQLDate());
	// this.baseDao.save(p);
	// }
	// it = deletesys.iterator();
	// while (it.hasNext()) {
	// s = it.next();
	// System.out.println(s.toString().trim());
	// UrpPermission up = (UrpPermission) this.baseDao.getByUnique(UrpPermission.class, "permissionKey",
	// s.toString().trim());
	// UrpUserPermission p = new UrpUserPermission();
	// p.setUserId(new Long(userId));
	// p.setPermissionId(up.getPid());
	// this.baseDao.executeSQL("delete URP_USER_PERMISSION t where t.USER_ID='" + userId + "' and t.PERMISSION_ID='" +
	// up.getPid() + "'").executeUpdate();
	// }
	// ArrayList addrole = getAdd(list2, list4);
	// ArrayList deleterole = getAdd(list4, list2);
	//
	// it = addrole.iterator();
	// while (it.hasNext()) {
	// s = it.next();
	// UrpUserRole ur = new UrpUserRole();
	// ur.setUserId(new Long(userId));
	// ur.setRoleId(new Long(s.toString().trim()));
	// ur.setModifyTime(DateFormatUtil.getCurrentSQLDate());
	// ur.setCreateTime(DateFormatUtil.getCurrentSQLDate());
	// this.baseDao.save(ur);
	// }
	// it = deleterole.iterator();
	// while (it.hasNext()) {
	// s = it.next();
	// UrpUserRole ur = new UrpUserRole();
	// ur.setUserId(new Long(userId));
	// ur.setRoleId(new Long(s.toString().trim()));
	// this.baseDao.executeSQL("delete URP_USER_ROLE t where t.USER_ID='" + userId + "' and t.ROLE_ID='" +
	// s.toString().trim() + "'").executeUpdate();
	// }
	// }
	//
	// public ArrayList getAdd(List a, List b) {
	// Iterator bb = b.iterator();
	// ArrayList al = new ArrayList();
	// while (bb.hasNext()) {
	// Object temp = bb.next();
	// if (!a.contains(temp)) {
	// al.add(temp);
	// }
	// }
	// return al;
	// }
	//
	// public List<AuUserBean> findGly(String areacode) {
	// List<AuUserBean> list = new ArrayList();
	// List<AuUserBean> list1 = new ArrayList();
	// List<AuUserBean> list2 = new ArrayList();
	// List<AuUserBean> list3 = new ArrayList();
	// List<AuUserBean> list4 = new ArrayList();
	// String fatherareacode1 = "";
	// String fatherareacode2 = "";
	// String fatherareacode3 = "";
	// String fatherareacode4 = "";
	// if ((areacode != null) && (!"".equals(areacode))) {
	// if (areacode.length() == 2) {
	// fatherareacode1 = areacode;
	// fatherareacode2 = areacode;
	// fatherareacode3 = areacode;
	// fatherareacode4 = areacode;
	// } else if (areacode.length() == 4) {
	// fatherareacode1 = areacode.substring(0, 2);
	// fatherareacode2 = areacode.substring(0, 2);
	// fatherareacode3 = areacode.substring(0, 2);
	// fatherareacode4 = areacode.substring(0, 2);
	// } else if (areacode.length() == 6) {
	// fatherareacode1 = areacode.substring(0, 4);
	// fatherareacode2 = areacode.substring(0, 2);
	// fatherareacode3 = areacode.substring(0, 2);
	// fatherareacode4 = areacode.substring(0, 2);
	// } else if (areacode.length() == 9) {
	// fatherareacode1 = areacode.substring(0, 6);
	// fatherareacode2 = areacode.substring(0, 4);
	// fatherareacode3 = areacode.substring(0, 2);
	// fatherareacode4 = areacode.substring(0, 2);
	// } else if (areacode.length() == 12) {
	// fatherareacode1 = areacode.substring(0, 9);
	// fatherareacode2 = areacode.substring(0, 6);
	// fatherareacode3 = areacode.substring(0, 4);
	// fatherareacode4 = areacode.substring(0, 2);
	// }
	// }
	// String sql1 =
	// " select a.*,d.province||d.city||d.county||d.town||d.village from (select * from au_user t where t.id in  (select user_id from urp_user_permission where permission_id =  (select id from urp_permission  where permission_key = 'user-report-manage'))) a ,au_org_info b,au_user_detail c  ,zjscl_info.dictionary_areacode d where a.id = c.user_id and c.org_id=b.id and b.org_code=d.area_code and b.org_code like'%"
	// +
	//
	// fatherareacode1 + "%'";
	// list1 = this.baseDao.executeSQL(sql1).list();
	//
	// String sql2 =
	// " select a.*,d.province||d.city||d.county||d.town||d.village from (select * from au_user t where t.id in  (select user_id from urp_user_permission where permission_id =  (select id from urp_permission  where permission_key = 'user-report-manage'))) a ,au_org_info b,au_user_detail c  ,zjscl_info.dictionary_areacode d where a.id = c.user_id and c.org_id=b.id and b.org_code=d.area_code and b.org_code like'%"
	// +
	//
	// fatherareacode2 + "%'";
	// list2 = this.baseDao.executeSQL(sql2).list();
	//
	// String sql3 =
	// " select a.*,d.province||d.city||d.county||d.town||d.village from (select * from au_user t where t.id in  (select user_id from urp_user_permission where permission_id =  (select id from urp_permission  where permission_key = 'user-report-manage'))) a ,au_org_info b,au_user_detail c  ,zjscl_info.dictionary_areacode d where a.id = c.user_id and c.org_id=b.id and b.org_code=d.area_code and b.org_code like'%"
	// +
	//
	// fatherareacode3 + "%'";
	// list3 = this.baseDao.executeSQL(sql3).list();
	//
	// String sql4 =
	// " select a.*,d.province||d.city||d.county||d.town||d.village from (select * from au_user t where t.id in  (select user_id from urp_user_permission where permission_id =  (select id from urp_permission  where permission_key = 'user-report-manage'))) a ,au_org_info b,au_user_detail c  ,zjscl_info.dictionary_areacode d where a.id = c.user_id and c.org_id=b.id and b.org_code=d.area_code and b.org_code like'%"
	// +
	//
	// fatherareacode4 + "%'";
	// list4 = this.baseDao.executeSQL(sql4).list();
	// if ((list1 != null) && (list1.size() > 0)) {
	// list = list1;
	// } else if ((list2 != null) && (list2.size() > 0)) {
	// list = list2;
	// } else if ((list3 != null) && (list3.size() > 0)) {
	// list = list3;
	// } else if ((list4 != null) && (list4.size() > 0)) {
	// list = list4;
	// }
	// return list;
	// }
}
