package com.dassmeta.passport.taglib;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.dassmeta.passport.security.auth.entity.Permission;
import com.dassmeta.passport.security.auth.entity.UserDetail;
import com.dassmeta.passport.security.context.SecurityContext;

public class PrivilegeTag extends SimpleTagSupport {
	public static final String COMMA = ",";
	private String ifAllGranted;
	private String ifAnyGranted;
	private String ifNotGranted;

	public void doTag() throws JspException, IOException {
		if ((StringUtils.isBlank(this.ifAllGranted)) && (StringUtils.isBlank(this.ifAnyGranted)) && (StringUtils.isBlank(this.ifNotGranted))) {
			return;
		}
		Set<String> granted = getGranted();
		if (StringUtils.isNotBlank(this.ifNotGranted)) {
			String[] permissionKeys = StringUtils.split(this.ifNotGranted, ",");
			if (containsAny(granted, permissionKeys)) {
				return;
			}
		}
		if (StringUtils.isNotBlank(this.ifAllGranted)) {
			String[] permissionKeys = StringUtils.split(this.ifAllGranted, ",");
			if (!containsAll(granted, permissionKeys)) {
				return;
			}
		}
		if (StringUtils.isNotBlank(this.ifAnyGranted)) {
			String[] permissionKeys = StringUtils.split(this.ifAnyGranted, ",");
			if (!containsAny(granted, permissionKeys)) {
				return;
			}
		}
		getJspBody().invoke(null);
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

	public static boolean containsAll(Set<String> set, String[] values) {
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

	public static boolean containsAny(Set<String> set, String[] values) {
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

	public void setIfAllGranted(String ifAllGranted) {
		this.ifAllGranted = ifAllGranted;
	}

	public void setIfAnyGranted(String ifAnyGranted) {
		this.ifAnyGranted = ifAnyGranted;
	}

	public void setIfNotGranted(String ifNotGranted) {
		this.ifNotGranted = ifNotGranted;
	}
}
