package com.ddway.anagraficaBS.model.db.anagraficaBS;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class Roles implements java.io.Serializable {

	private int roleId;
	private String rolename;
	private Set<Users> userses = new HashSet<Users>(0);

	public Roles() {
	}

	public Roles(int roleId, String rolename) {
		this.roleId = roleId;
		this.rolename = rolename;
	}

	public Roles(int roleId, String rolename, Set<Users> userses) {
		this.roleId = roleId;
		this.rolename = rolename;
		this.userses = userses;
	}

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Set<Users> getUserses() {
		return this.userses;
	}

	public void setUserses(Set<Users> userses) {
		this.userses = userses;
	}

}
