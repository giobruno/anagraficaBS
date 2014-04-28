package com.ddway.anagraficaBS.model.forms;

public class AccountForm {
	
	private String userId;
	private String nome;
	private String cognome;
	private String username;
	private String email;
	private String password;
	
	public AccountForm(){}
	
	public AccountForm(String userId,String nome, String cognome, String username,String email,String password){		
		
		this.userId = userId;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.email = email;		
		this.password = password;
	}
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
}
