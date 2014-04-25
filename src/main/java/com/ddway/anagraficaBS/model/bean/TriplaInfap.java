package com.ddway.anagraficaBS.model.bean;

public class TriplaInfap {
	
	private String codiArea;
	private String descArea;
	private String codiApplicazione;
	private String descApplicazione;
	private String codiFunzione;
	private String descFunzione;	
	
	public TriplaInfap(){}
	
	public TriplaInfap(String codiArea,String descArea,String codiApplicazione,
			String descApplicazione,String codiFunzione,String descFunzione){
		
		this.codiArea = codiArea;
		this.descArea = descArea;
		this.codiApplicazione = codiApplicazione;
		this.descApplicazione = descApplicazione;
		this.codiFunzione = codiFunzione;
		this.descFunzione = descFunzione;
	}

	public String getCodiArea() {
		return codiArea;
	}

	public void setCodiArea(String codiArea) {
		this.codiArea = codiArea;
	}

	public String getDescArea() {
		return descArea;
	}

	public void setDescArea(String descArea) {
		this.descArea = descArea;
	}

	public String getCodiApplicazione() {
		return codiApplicazione;
	}

	public void setCodiApplicazione(String codiApplicazione) {
		this.codiApplicazione = codiApplicazione;
	}

	public String getDescApplicazione() {
		return descApplicazione;
	}

	public void setDescApplicazione(String descApplicazione) {
		this.descApplicazione = descApplicazione;
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
