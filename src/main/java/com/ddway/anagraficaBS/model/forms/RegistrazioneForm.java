package com.ddway.anagraficaBS.model.forms;

public class RegistrazioneForm {
	
	private String userId;
	private String nome;
	private String cognome;
	private String user;
	private String email;
	private String oldPassword;
	private String password;
	private String confermaPassword;
	
	public RegistrazioneForm(){}
	
	public RegistrazioneForm(String userId,String nome, String cognome,
			String user,String email,String oldPassword,String password,String confermaPassword){
		
		this.userId = userId;
		this.nome = nome;
		this.cognome = password;
		this.user = user;
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

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
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
