package com.dassmeta.passport.security.auth.entity;

import java.io.Serializable;

public class Permission implements Serializable {
	private static final long serialVersionUID = -6953935642670956253L;
	private String id;
	private String name;
	private String permissionKey;
	private String permissionType;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPermissionKey() {
		return this.permissionKey;
	}

	public void setPermissionKey(String permissionKey) {
		this.permissionKey = permissionKey;
	}

	public String getPermissionType() {
		return this.permissionType;
	}

	public void setPermissionType(String permissionType) {
		this.permissionType = permissionType;
	}
}
