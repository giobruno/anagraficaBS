package com.ddway.anagraficaBS.model.forms;

public class ModificaPasswordForm {
	
	private String userId;
	private String nome;
	private String cognome;
	private String username;
	private String email;
	private String oldPassword;
	private String password;
	private String confermaPassword;
	
	public ModificaPasswordForm(){}
	
	public ModificaPasswordForm(String userId,String nome, String cognome,
			String username,String email,String oldPassword,String password,String confermaPassword){
		
		this.userId = userId;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.email = email;
		this.oldPassword = oldPassword;
		this.password = password;
		this.confermaPassword = confermaPassword;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfermaPassword() {
		return confermaPassword;
	}

	public void setConfermaPassword(String confermaPassword) {
		this.confermaPassword = confermaPassword;
	}		
}
