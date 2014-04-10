package com.ddway.anagraficaBS.model.bean;

public class Funzione {
	
	private String codiFunzione;	
	private String descFunzione;	
	
	public Funzione(){}
	
	public Funzione(String codiFunzione, String descFunzione){
		
		this.codiFunzione = codiFunzione;
		this.descFunzione = descFunzione;		
	}

	public String getCodiFunzione() {
		return codiFunzione;
	}

	public void setCodiFunzione(String codiFunzione) {
		this.codiFunzione = codiFunzione;
	}

	public String getDescFunzione() {
		return descFunzione;
	}

	public void setDescFunzione(String descFunzione) {
		this.descFunzione = descFunzione;
	}
}
