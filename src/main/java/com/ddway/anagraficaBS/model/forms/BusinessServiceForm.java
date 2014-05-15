package com.ddway.anagraficaBS.model.forms;

import org.springframework.stereotype.Service;

@Service
public class BusinessServiceForm {
	
	private String codiBusinessService;
	private String codiBusinessServiceOld;
	private String codiDipartimento;
	private String textSiglaDipartimento;
	private String descDipartimento;	
	private String textNomeBusinessService;
	private String descBusinessService;
	private String persRespBusinessService;
	private String textUrlBusinessService;
	private Boolean flagConvenzione = false;;
	private String codiModelApplicativo;
	private String descModelApplicativo;
	private String codiArea;
	private String codiApplicazione;
	
	public BusinessServiceForm(){}

	public BusinessServiceForm(String codiBusinessService,String codiBusinessServiceOld,String codiDipartimento,String textSiglaDipartimento,String descDipartimento,
			String textNomeBusinessService,String descBusinessService,String persRespBusinessService,
			String textUrlBusinessService,Boolean flagConvenzione,String codiModelApplicativo,String descModelApplicativo,String codiArea,String codiApplicazione  ){
		
		this.codiBusinessService = codiBusinessService;
		this.codiBusinessServiceOld = codiBusinessServiceOld;
		this.codiDipartimento = codiDipartimento;
		this.textSiglaDipartimento = textSiglaDipartimento;
		this.descDipartimento = descDipartimento;
		this.textNomeBusinessService = textNomeBusinessService;
		this.descBusinessService = descBusinessService;
		this.persRespBusinessService = persRespBusinessService;
		this.textUrlBusinessService = textUrlBusinessService;
		this.flagConvenzione = flagConvenzione;
		this.codiModelApplicativo = codiModelApplicativo;
		this.descModelApplicativo = descModelApplicativo;
		this.codiArea  = codiArea;
		this.codiApplicazione = codiApplicazione;
	}
	
	
	
	public String getCodiBusinessService() {
		return codiBusinessService;
	}

	public void setCodiBusinessService(String codiBusinessService) {
		this.codiBusinessService = codiBusinessService;
	}

	public String getCodiBusinessServiceOld() {
		return codiBusinessServiceOld;
	}

	public void setCodiBusinessServiceOld(String codiBusinessServiceOld) {
		this.codiBusinessServiceOld = codiBusinessServiceOld;
	}

	public String getCodiDipartimento() {
		return codiDipartimento;
	}

	public void setCodiDipartimento(String codiDipartimento) {
		this.codiDipartimento = codiDipartimento;
	}

	public String getTextSiglaDipartimento() {
		return textSiglaDipartimento;
	}

	public void setTextSiglaDipartimento(String textSiglaDipartimento) {
		this.textSiglaDipartimento = textSiglaDipartimento;
	}

	public String getDescDipartimento() {
		return descDipartimento;
	}

	public void setDescDipartimento(String descDipartimento) {
		this.descDipartimento = descDipartimento;
	}

	public String getTextNomeBusinessService() {
		return textNomeBusinessService;
	}

	public void setTextNomeBusinessService(String textNomeBusinessService) {
		this.textNomeBusinessService = textNomeBusinessService;
	}

	public String getDescBusinessService() {
		return descBusinessService;
	}

	public void setDescBusinessService(String descBusinessService) {
		this.descBusinessService = descBusinessService;
	}

	public String getPersRespBusinessService() {
		return persRespBusinessService;
	}

	public void setPersRespBusinessService(String persRespBusinessService) {
		this.persRespBusinessService = persRespBusinessService;
	}

	public String getTextUrlBusinessService() {
		return textUrlBusinessService;
	}

	public void setTextUrlBusinessService(String textUrlBusinessService) {
		this.textUrlBusinessService = textUrlBusinessService;
	}

	public Boolean getFlagConvenzione() {
		return flagConvenzione;
	}

	public void setFlagConvenzione(Boolean flagConvenzione) {
		this.flagConvenzione = flagConvenzione;
	}

	public String getCodiModelApplicativo() {
		return codiModelApplicativo;
	}

	public void setCodiModelApplicativo(String codiModelApplicativo) {
		this.codiModelApplicativo = codiModelApplicativo;
	}

	public String getDescModelApplicativo() {
		return descModelApplicativo;
	}

	public void setDescModelApplicativo(String descModelApplicativo) {
		this.descModelApplicativo = descModelApplicativo;
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
	
	
}
