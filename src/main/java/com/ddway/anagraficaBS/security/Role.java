package com.ddway.anagraficaBS.security;

import java.io.Serializable;

public class Role implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 515582662343313848L;
	private String id;
	private String role;
	private String roleDescription;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getRoleDescription() {
		return roleDescription;
	}
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	
	
	
}
