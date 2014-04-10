package com.ddway.anagraficaBS.model.db;

import java.util.Date;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class DBusinessServices implements java.io.Serializable {

	private int codiBusinessService;
	private int codiDipartimento;
	private String textNomeBusinessService;
	private String descBusinessService;
	private Date dataValiditaInizio;
	private Date dataValiditaFine;
	private String persRespBusinessService;
	private String textUrlBusinessService;
	private Boolean flagConvenzione;	

	public DBusinessServices() {}

	public DBusinessServices(int codiDipartimento,
			String textNomeBusinessService, String descBusinessService,
			Date dataValiditaInizio, Date dataValiditaFine,
			String persRespBusinessService, String textUrlBusinessService,
			Boolean flagConvenzione, Set DServiziProcessis,
			Set DServiziFunzionis, Set DServiziModels) {
		this.codiDipartimento = codiDipartimento;
		this.textNomeBusinessService = textNomeBusinessService;
		this.descBusinessService = descBusinessService;
		this.dataValiditaInizio = dataValiditaInizio;
		this.dataValiditaFine = dataValiditaFine;
		this.persRespBusinessService = persRespBusinessService;
		this.textUrlBusinessService = textUrlBusinessService;
		this.flagConvenzione = flagConvenzione;		
	}

	public Integer getCodiBusinessService() {
		return this.codiBusinessService;
	}

	public void setCodiBusinessService(Integer codiBusinessService) {
		this.codiBusinessService = codiBusinessService;
	}	
	
	public int getCodiDipartimento() {
		return codiDipartimento;
	}

	public void setCodiDipartimento(int codiDipartimento) {
		this.codiDipartimento = codiDipartimento;
	}

	public String getTextNomeBusinessService() {
		return this.textNomeBusinessService;
	}

	public void setTextNomeBusinessService(String textNomeBusinessService) {
		this.textNomeBusinessService = textNomeBusinessService;
	}

	public String getDescBusinessService() {
		return this.descBusinessService;
	}

	public void setDescBusinessService(String descBusinessService) {
		this.descBusinessService = descBusinessService;
	}

	public Date getDataValiditaInizio() {
		return this.dataValiditaInizio;
	}

	public void setDataValiditaInizio(Date dataValiditaInizio) {
		this.dataValiditaInizio = dataValiditaInizio;
	}

	public Date getDataValiditaFine() {
		return this.dataValiditaFine;
	}

	public void setDataValiditaFine(Date dataValiditaFine) {
		this.dataValiditaFine = dataValiditaFine;
	}

	public String getPersRespBusinessService() {
		return this.persRespBusinessService;
	}

	public void setPersRespBusinessService(String persRespBusinessService) {
		this.persRespBusinessService = persRespBusinessService;
	}

	public String getTextUrlBusinessService() {
		return this.textUrlBusinessService;
	}

	public void setTextUrlBusinessService(String textUrlBusinessService) {
		this.textUrlBusinessService = textUrlBusinessService;
	}

	public Boolean getFlagConvenzione() {
		return this.flagConvenzione;
	}

	public void setFlagConvenzione(Boolean flagConvenzione) {
		this.flagConvenzione = flagConvenzione;
	}

}
