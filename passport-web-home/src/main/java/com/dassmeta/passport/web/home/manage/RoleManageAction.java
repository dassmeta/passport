package com.dassmeta.passport.web.home.manage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import cn.widewisdom.entity.auth.AuOrgInfo;
import cn.widewisdom.entity.urp.UrpRole;
import cn.widewisdom.entity.urp.UrpRolePermission;
import cn.widewisdom.service.ApplicationService;
import cn.widewisdom.service.DepartService;
import cn.widewisdom.service.RoleService;
import cn.widewisdom.service.UserService;

import com.specter.dao.Page;
import com.specter.service.BaseService;
import com.specter.utils.DateFormatUtil;
import com.specter.web.struts2.CRUDActionSupport;
import com.specter.web.struts2.Struts2Utils;

@Results({ @org.apache.struts2.convention.annotation.Result(name = "reload", type = "redirectAction", location = "role-manage!list.action") })
public class RoleManageAction extends CRUDActionSupport<UrpRole> {
	private static final long serialVersionUID = 1L;
	private Page<UrpRole> page;
	@Autowired
	private RoleService roleService;
	@Autowired
	private BaseService baseService;
	@Autowired
	private UserService userService;
	@Autowired
	private DepartService departService;
	@Autowired
	private ApplicationService applicationService;
	private UrpRole role;
	private List<?> list;
	private Map map;
	private Long id;
	private String perName;
	private String orgName;
	private String orgId;
	private String orgCode;
	private String userId;
	private String temp;
	private List<?> orgList;
	private List<?> appL;
	private String visibleCode;
	private String visibleName;

	public String getVisibleCode() {
		return this.visibleCode;
	}

	public void setVisibleCode(String visibleCode) {
		this.visibleCode = visibleCode;
	}

	public String getVisibleName() {
		return this.visibleName;
	}

	public String getTemp() {
		return this.temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getAllRole() {
		this.map = new HashMap();

		List appList = this.applicationService.getAllApp();
		this.map.put("app", appList);

		this.list = this.roleService.getAllRole();

		this.map.put("allRole", this.list);

		this.list = this.userService.getUserRole(this.userId);
		this.map.put("userRole", this.list);
		return "all";
	}

	public String list() throws Exception {
		Integer pageNo = Struts2Utils.getIntParameter("specter_params_pageNo", Integer.valueOf(1));
		Map<String, Object> params = new HashMap();
		this.page = this.roleService.findForPage(params, pageNo.intValue());
		return "success";
	}

	public String input() {
		this.appL = this.applicationService.getAllApp();
		if (this.id != null) {
			if (("".equals(this.role.getOrgCode())) || (this.role.getOrgCode() == null)) {
				this.orgName = "";
				this.orgId = "";
			} else {
				String[] code = this.role.getOrgCode().split(",");
				this.orgName = "";
				this.orgId = "";
				for (int i = 0; i < code.length; i++) {
					AuOrgInfo orgInfo = this.departService.getOrgByCode(new Long(code[i]));
					this.orgName = (this.orgName + orgInfo.getOrgName() + ",");
					this.orgId = (this.orgId + orgInfo.getId() + ",");
				}
				this.orgName = this.orgName.substring(0, this.orgName.length() - 1);
				this.orgId = this.orgId.substring(0, this.orgId.length() - 1);
			}
		}
		return "input";
	}

	public String save() throws Exception {
		if ((this.orgId != null) && (!"".equals(this.orgId))) {
			this.role.setOrgCode(this.orgId);
		} else {
			this.role.setOrgCode(null);
		}
		this.role.setVisible("Y");
		if ((this.id == null) || ("".equals(this.id))) {
			this.role.setId(null);
			this.role.setCreateTime(DateFormatUtil.getCurrentSQLDate());
		}
		this.role.setModifyTime(DateFormatUtil.getCurrentSQLDate());
		this.baseService.saveOrUpdate(this.role);
		return "reload";
	}

	public String view() {
		this.role = ((UrpRole) this.baseService.get(UrpRole.class, this.id));

		return "view";
	}

	public String getAllPermission() {
		this.map = new HashMap();

		List appList = this.applicationService.getAllApp();
		this.map.put("app", appList);

		List userPerL = this.roleService.getRolePermission(this.id);
		this.map.put("userpermission", userPerL);
		return "permission";
	}

	public String update() throws Exception {
		String[] permissionId = this.userId.split(";");
		String[] orgin = this.temp.split(";");
		ArrayList ll = null;
		ArrayList b = new ArrayList(Arrays.asList(permissionId));
		ArrayList a = new ArrayList(Arrays.asList(orgin));
		Iterator<String> it = null;
		UrpRolePermission rolePermission = new UrpRolePermission();
		Object s = null;
		ll = getAdd(a, b);
		it = ll.iterator();
		while (it.hasNext()) {
			s = it.next();
			rolePermission = new UrpRolePermission();
			rolePermission.setRoleId(this.id);
			rolePermission.setId(null);
			rolePermission.setPermissionId(new Long(s.toString()));
			rolePermission.setCreateTime(DateFormatUtil.getCurrentSQLDate());
			rolePermission.setModifyTime(DateFormatUtil.getCurrentSQLDate());
			if ((rolePermission.getPermissionId() != null) && (!"".equals(rolePermission.getPermissionId()))) {
				this.roleService.saveOrUpdateRolePermission(rolePermission);
			}
		}
		ll = getAdd(b, a);
		it = ll.iterator();
		while (it.hasNext()) {
			s = it.next();
			rolePermission = new UrpRolePermission();
			rolePermission.setRoleId(this.id);
			rolePermission.setPermissionId(new Long(s.toString()));
			if ((rolePermission.getPermissionId() != null) && (!"".equals(rolePermission.getPermissionId()))) {
				this.roleService.deleteRolePermission(rolePermission);
			}
		}
		return "reload";
	}

	public ArrayList getAdd(ArrayList a, ArrayList b) {
		Iterator bb = b.iterator();
		ArrayList al = new ArrayList();
		while (bb.hasNext()) {
			Object temp = bb.next();
			if ((!a.contains(temp)) && (!"".equals(temp))) {
				al.add(temp);
			}
		}
		return al;
	}

	public String delete() throws Exception {
		this.role = ((UrpRole) this.baseService.get(UrpRole.class, this.id));
		this.roleService.delete(this.role);
		return "reload";
	}

	public String enabled() {
		if ((this.role != null) && (this.role.getId() != null)) {
			this.roleService.enabledRole(this.role);
		}
		return "reload";
	}

	public String disabled() {
		if ((this.role != null) && (this.role.getId() != null)) {
			this.roleService.disabledRole(this.role);
		}
		return "reload";
	}

	protected void prepareModel() throws Exception {
		if ((this.id != null) && (!"".equals(this.id))) {
			this.role = ((UrpRole) this.baseService.get(UrpRole.class, this.id));
		} else {
			this.role = new UrpRole();
		}
	}

	public UrpRole getModel() {
		return this.role;
	}

	public Page<UrpRole> getPage() {
		return this.page;
	}

	public List<?> getList() {
		return this.list;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Map getMap() {
		return this.map;
	}

	public UrpRole getRole() {
		return this.role;
	}

	public void setRole(UrpRole role) {
		this.role = role;
	}

	public String getPerName() {
		return this.perName;
	}

	public List getOrgList() {
		return this.orgList;
	}

	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgCode() {
		return this.orgCode;
	}

	public String getOrgId() {
		return this.orgId;
	}

	public List<?> getAppL() {
		return this.appL;
	}

	public void setAppL(List<?> appL) {
		this.appL = appL;
	}
}
