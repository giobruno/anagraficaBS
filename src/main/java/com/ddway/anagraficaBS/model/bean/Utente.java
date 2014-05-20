package com.ddway.anagraficaBS.model.bean;

public class Utente {
	
	private Integer userId;
	private String username;
	private String password;
	private String nome;
	private String cognome;
	private String nomeCognome;
	private String email;
	private boolean enabled = false;
	
	public Utente(){}
	
	public Utente(Integer userId,
					String username,
					String password,
					String nome,
					String cognome,
					String nomeCognome,
					String email,boolean enabled){
		
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.nomeCognome = nomeCognome;
		this.email = email;
		this.enabled = enabled;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getNomeCognome() {
		return nomeCognome;
	}

	public void setNomeCognome(String nomeCognome) {
		this.nomeCognome = nomeCognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	

}
