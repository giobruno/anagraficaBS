package com.ddway.anagraficaBS.model.db;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class DProcessi implements java.io.Serializable {

	private Integer codiProcesso;
	private String textSiglaProcesso;
	private String descProcesso;
	private Date dataValiditaInizio;
	private Date dataValiditaFine;
	private Set DServiziProcessis = new HashSet(0);

	public DProcessi() {
	}

	public DProcessi(String textSiglaProcesso, String descProcesso,
			Date dataValiditaInizio, Date dataValiditaFine,
			Set DServiziProcessis) {
		this.textSiglaProcesso = textSiglaProcesso;
		this.descProcesso = descProcesso;
		this.dataValiditaInizio = dataValiditaInizio;
		this.dataValiditaFine = dataValiditaFine;
		this.DServiziProcessis = DServiziProcessis;
	}

	public Integer getCodiProcesso() {
		return this.codiProcesso;
	}

	public void setCodiProcesso(Integer codiProcesso) {
		this.codiProcesso = codiProcesso;
	}

	public String getTextSiglaProcesso() {
		return this.textSiglaProcesso;
	}

	public void setTextSiglaProcesso(String textSiglaProcesso) {
		this.textSiglaProcesso = textSiglaProcesso;
	}

	public String getDescProcesso() {
		return this.descProcesso;
	}

	public void setDescProcesso(String descProcesso) {
		this.descProcesso = descProcesso;
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

	public Set getDServiziProcessis() {
		return this.DServiziProcessis;
	}

	public void setDServiziProcessis(Set DServiziProcessis) {
		this.DServiziProcessis = DServiziProcessis;
	}

}
