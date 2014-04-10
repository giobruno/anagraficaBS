package com.ddway.anagraficaBS.model.forms;

import java.util.List;

import com.ddway.anagraficaBS.model.bean.Funzione;

public class AssociazioneBSFunzUtenteForm {
	
	private String codiBusinessService;
	private String codiArea;
	private String codiApplicazione;		
	private String descArea;
	private String descApplicazione;
	private List<String> funzioneList;	
	
	public AssociazioneBSFunzUtenteForm(){}
	
	public AssociazioneBSFunzUtenteForm(String codiBusinessService,String codiArea,String codiApplicazione,
			String descArea,String descApplicazione,List<String> funzioneList){
		
		this.codiBusinessService = codiBusinessService;
		this.codiArea = codiArea;
		this.codiApplicazione = codiApplicazione;		
		this.descArea = descArea;
		this.descApplicazione = descApplicazione;
		this.funzioneList = funzioneList;
	}

	public String getCodiBusinessService() {
		return codiBusinessService;
	}

	public void setCodiBusinessService(String codiBusinessService) {
		this.codiBusinessService = codiBusinessService;
	}

	public String getCodiArea() {
		return codiArea;
	}

	public void setCodiArea(String codiArea) {
		this.codiArea = codiArea;
	}

	public String getCodiApplicazione() {
		return codiApplicazione;
	}

	public void setCodiApplicazione(String codiApplicazione) {
		this.codiApplicazione = codiApplicazione;
	}

	public String getDescArea() {
		return descArea;
	}

	public void setDescArea(String descArea) {
		this.descArea = descArea;
	}

	public String getDescApplicazione() {
		return descApplicazione;
	}

	public void setDescApplicazione(String descApplicazione) {
		this.descApplicazione = descApplicazione;
	}

	public List<String> getFunzioneList() {
		return funzioneList;
	}

	public void setFunzioneList(List<String> funzioneList) {
		this.funzioneList = funzioneList;
	}
	
	
}
