package com.ddway.anagraficaBS.model.forms;

public class RegistrazioneForm {
	
	private String nome;
	private String cognome;
	private String user;
	private String email;
	private String password;
	private String confermaPassword;
	
	public RegistrazioneForm(){}
	
	public RegistrazioneForm(String nome, String cognome,
			String user,String email,String password,String confermaPassword){
		
		this.nome = nome;
		this.cognome = password;
		this.user = user;
		this.email = email;
		this.password = password;
		this.confermaPassword = confermaPassword;
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
