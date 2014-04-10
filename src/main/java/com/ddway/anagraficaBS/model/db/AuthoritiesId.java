package com.ddway.anagraficaBS.model.db;

import org.springframework.stereotype.Service;

@Service
public class AuthoritiesId implements java.io.Serializable {

	private int roleId;
	private int userId;

	public AuthoritiesId() {
	}

	public AuthoritiesId(int roleId, int userId) {
		this.roleId = roleId;
		this.userId = userId;
	}

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AuthoritiesId))
			return false;
		AuthoritiesId castOther = (AuthoritiesId) other;

		return (this.getRoleId() == castOther.getRoleId())
				&& (this.getUserId() == castOther.getUserId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getRoleId();
		result = 37 * result + this.getUserId();
		return result;
	}

}
