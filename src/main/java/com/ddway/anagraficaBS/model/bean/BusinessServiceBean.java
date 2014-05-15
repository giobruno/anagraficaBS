package com.ddway.anagraficaBS.model.bean;

public class BusinessServiceBean {
	
	private String codiBusinessService;
	private String descBusinessService;
	private String textSiglaDipartimento;
	private String textUrlBusinessService;
	private String textNomeBusinessService;	
	private String persRespBusinessService;	
	private String descModelApplicativo;
	private Boolean flagConvenzione;
	private Boolean presenzaProcessiAssociati;
	private Boolean presenzaFUAssociate = true;
	
	public BusinessServiceBean(){}
	
	public BusinessServiceBean(String codiBusinessService,String descBusinessService,
										String textSiglaDipartimento,
										String textUrlBusinessService,
										String textNomeBusinessService,
										String persRespBusinessService,
										String descModelApplicativo,
										Boolean flagConvenzione,
										Boolean presenzaProcessiAssociati,Boolean presenzaFUAssociate){
		
		this.codiBusinessService = codiBusinessService;
		this.descBusinessService = descBusinessService;
		this.textNomeBusinessService = textNomeBusinessService;
		this.textUrlBusinessService = textUrlBusinessService;
		this.textSiglaDipartimento = textSiglaDipartimento;
		this.persRespBusinessService = persRespBusinessService;
		this.descModelApplicativo = descModelApplicativo;
		this.flagConvenzione = flagConvenzione;
		this.presenzaProcessiAssociati = presenzaProcessiAssociati;
		this.presenzaFUAssociate = presenzaFUAssociate;
	}
	
	
	public Boolean getPresenzaFUAssociate() {
		return presenzaFUAssociate;
	}

	public void setPresenzaFUAssociate(Boolean presenzaFUAssociate) {
		this.presenzaFUAssociate = presenzaFUAssociate;
	}

	public Boolean getPresenzaProcessiAssociati() {
		return presenzaProcessiAssociati;
	}

	public void setPresenzaProcessiAssociati(Boolean presenzaProcessiAssociati) {
		this.presenzaProcessiAssociati = presenzaProcessiAssociati;
	}

	public String getTextUrlBusinessService() {
		return textUrlBusinessService;
	}

	public void setTextUrlBusinessService(String textUrlBusinessService) {
		this.textUrlBusinessService = textUrlBusinessService;
	}

	public String getDescBusinessService() {
		return descBusinessService;
	}

	public void setDescBusinessService(String descBusinessService) {
		this.descBusinessService = descBusinessService;
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
