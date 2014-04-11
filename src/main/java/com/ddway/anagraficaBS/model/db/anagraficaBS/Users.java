package com.ddway.anagraficaBS.model.db.anagraficaBS;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class Users implements java.io.Serializable {

	private Integer userId;
	private String username;
	private String password;
	private String nome;
	private String cognome;
	private String email;
	private boolean enabled;
	private Set<Roles> roleses = new HashSet<Roles>(0);

	public Users() {
	}

	public Users(String username, String password, String nome, String cognome,
			String email, boolean enabled) {
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.enabled = enabled;
	}

	public Users(String username, String password, String nome, String cognome,
			String email, boolean enabled, Set<Roles> roleses) {
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.enabled = enabled;
		this.roleses = roleses;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Roles> getRoleses() {
		return this.roleses;
	}

	public void setRoleses(Set<Roles> roleses) {
		this.roleses = roleses;
	}

}
