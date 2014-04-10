package com.ddway.anagraficaBS.model.db;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class DModelApplicativi implements java.io.Serializable {

	private int codiModelApplicativo;
	private String descModelApplicativo;
	private Date dataValiditaInizio;
	private Date dataValiditaFine;	

	public DModelApplicativi() {
	}

	public DModelApplicativi(int codiModelApplicativo) {
		this.codiModelApplicativo = codiModelApplicativo;
	}

	public DModelApplicativi(int codiModelApplicativo,
			String descModelApplicativo, Date dataValiditaInizio,
			Date dataValiditaFine) {
		this.codiModelApplicativo = codiModelApplicativo;
		this.descModelApplicativo = descModelApplicativo;
		this.dataValiditaInizio = dataValiditaInizio;
		this.dataValiditaFine = dataValiditaFine;		
	}

	public int getCodiModelApplicativo() {
		return this.codiModelApplicativo;
	}

	public void setCodiModelApplicativo(int codiModelApplicativo) {
		this.codiModelApplicativo = codiModelApplicativo;
	}

	public String getDescModelApplicativo() {
		return this.descModelApplicativo;
	}

	public void setDescModelApplicativo(String descModelApplicativo) {
		this.descModelApplicativo = descModelApplicativo;
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

}
