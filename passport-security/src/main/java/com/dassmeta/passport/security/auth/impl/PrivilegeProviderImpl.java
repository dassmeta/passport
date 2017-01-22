package com.dassmeta.passport.security.auth.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;

import com.dassmeta.passport.security.auth.AuthConstants;
import com.dassmeta.passport.security.auth.PrivilegeProvider;
import com.dassmeta.passport.security.auth.entity.Permission;
import com.dassmeta.passport.security.auth.entity.UserDetail;
import com.dassmeta.passport.security.context.SecurityContext;

public class PrivilegeProviderImpl implements PrivilegeProvider, InitializingBean, AuthConstants {
	protected final Log logger = LogFactory.getLog(getClass());
	private String[] noControlResource;
	private List<Pattern> patterns;
	private String privilegeFailureURL;

	public boolean privilege(String permissionKey) {
		UserDetail detail = SecurityContext.getUserDetail();
		Permission[] permissions = detail.getPermissions();
		if ((permissions == null) || (permissions.length == 0)) {
			return false;
		}
		Permission[] arrayOfPermission1;
		int j = (arrayOfPermission1 = permissions).length;
		for (int i = 0; i < j; i++) {
			Permission each = arrayOfPermission1[i];
			String per = each.getPermissionKey();
			if (StringUtils.equals(per, permissionKey)) {
				return true;
			}
		}
		return false;
	}

	public boolean isNoControlResource(String permissionKey) {
		if ((this.patterns != null) && (this.patterns.size() > 0)) {
			for (Pattern each : this.patterns) {
				Matcher matcher = each.matcher(permissionKey);
				if (matcher.matches()) {
					return true;
				}
			}
		}
		this.logger.debug("not matche permission:" + permissionKey);
		return false;
	}

	public void setPrivilegeFailureURL(String privilegeFailureURL) {
		this.privilegeFailureURL = privilegeFailureURL;
	}

	public String getPrivilegeFailureURL() {
		return this.privilegeFailureURL;
	}

	public void setNoControlResource(String[] noControlResource) {
		this.noControlResource = noControlResource;
	}

	public void setPatterns(List<Pattern> patterns) {
		this.patterns = patterns;
	}

	public void afterPropertiesSet() throws Exception {
		this.patterns = new ArrayList();

		this.noControlResource = ((String[]) ArrayUtils.add(this.noControlResource, "/specter_security_login_on"));
		if (this.noControlResource != null) {
			for (int i = 0; i < this.noControlResource.length; i++) {
				Pattern p = Pattern.compile(this.noControlResource[i]);
				this.patterns.add(p);
			}
		}
	}
}
