package com.hm.internal.idm.web.model;

import java.util.List;

public class RoleDto {

	private String name;
	private String  description;
	private List<Integer> permissionIds;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Integer> getPermissionIds() {
		return permissionIds;
	}
	public void setPermissionIds(List<Integer> permissionIds) {
		this.permissionIds = permissionIds;
	}
}
