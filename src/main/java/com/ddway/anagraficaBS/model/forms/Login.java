package com.ddway.anagraficaBS.model.forms;

public class Login {
	
	private String nome;
	private String password;
	
	public Login(){};
	
	public Login(String nome, String password){
		
		this.nome = nome;
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
}
