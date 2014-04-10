package com.ddway.anagraficaBS.model.forms;

import java.util.List;

public class RicercaFunzioniUtenteForm {
	
	private String codiApplicazione;	
	private String codiArea;
	private String descApplicazione;	
	private String descArea;
	
	public RicercaFunzioniUtenteForm(){}
	
	public RicercaFunzioniUtenteForm(String codiApplicazione,String codiArea,String descApplicazione,String descArea){
		
		this.codiArea = codiArea;
		this.codiApplicazione = codiApplicazione;	
		this.descApplicazione = descApplicazione;
		this.descArea = descArea;
		
	}

	public String getCodiApplicazione() {
		return codiApplicazione;
	}

	public void setCodiApplicazione(String codiApplicazione) {
		this.codiApplicazione = codiApplicazione;
	}

	public String getCodiArea() {
		return codiArea;
	}

	public void setCodiArea(String codiArea) {
		this.codiArea = codiArea;
	}

	public String getDescApplicazione() {
		return descApplicazione;
	}

	public void setDescApplicazione(String descApplicazione) {
		this.descApplicazione = descApplicazione;
	}

	public String getDescArea() {
		return descArea;
	}

	public void setDescArea(String descArea) {
		this.descArea = descArea;
	}
	
	
	
}
