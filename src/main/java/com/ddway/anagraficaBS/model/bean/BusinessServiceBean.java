package com.ddway.anagraficaBS.model.bean;

public class BusinessServiceBean {
	
	private String codiBusinessService;
	private String textSiglaDipartimento;
	private String textNomeBusinessService;	
	private String persRespBusinessService;	
	private String descModelApplicativo;
	private Boolean flagConvenzione;
	
	public BusinessServiceBean(){}
	
	public BusinessServiceBean(String codiBusinessService,
										String textSiglaDipartimento,
										String textNomeBusinessService,
										String persRespBusinessService,
										String descModelApplicativo,
										Boolean flagConvenzione){
		
		this.codiBusinessService = codiBusinessService;
		this.textNomeBusinessService = textNomeBusinessService;
		this.textSiglaDipartimento = textSiglaDipartimento;
		this.persRespBusinessService = persRespBusinessService;
		this.descModelApplicativo = descModelApplicativo;
		this.flagConvenzione = flagConvenzione;
	}

	public String getCodiBusinessService() {
		return codiBusinessService;
	}

	public void setCodiBusinessService(String codiBusinessService) {
		this.codiBusinessService = codiBusinessService;
	}

	public String getTextSiglaDipartimento() {
		return textSiglaDipartimento;
	}

	public void setTextSiglaDipartimento(String textSiglaDipartimento) {
		this.textSiglaDipartimento = textSiglaDipartimento;
	}

	public String getTextNomeBusinessService() {
		return textNomeBusinessService;
	}

	public void setTextNomeBusinessService(String textNomeBusinessService) {
		this.textNomeBusinessService = textNomeBusinessService;
	}

	public String getPersRespBusinessService() {
		return persRespBusinessService;
	}

	public void setPersRespBusinessService(String persRespBusinessService) {
		this.persRespBusinessService = persRespBusinessService;
	}

	public String getDescModelApplicativo() {
		return descModelApplicativo;
	}

	public void setDescModelApplicativo(String descModelApplicativo) {
		this.descModelApplicativo = descModelApplicativo;
	}

	public Boolean getFlagConvenzione() {
		return flagConvenzione;
	}

	public void setFlagConvenzione(Boolean flagConvenzione) {
		this.flagConvenzione = flagConvenzione;
	}
	
}
