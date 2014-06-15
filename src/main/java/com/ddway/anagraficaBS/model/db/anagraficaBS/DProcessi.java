package com.ddway.anagraficaBS.model.db.anagraficaBS;

// Generated Apr 17, 2014 2:09:27 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

/**
 * DProcessi generated by hbm2java
 */
@Service
public class DProcessi implements java.io.Serializable {

	private Integer codiProcesso;
	private String textSiglaProcesso;
	private String descProcesso;
	private Date dataInizioValidita;
	private Date dataFineValidita;
	private Boolean flagCatMac;
	private Boolean flagCatInfr;
	private Set<DServiziProcessi> DServiziProcessis = new HashSet<DServiziProcessi>(
			0);

	public DProcessi() {
	}

	public DProcessi(String textSiglaProcesso, String descProcesso,
			Date dataInizioValidita, Date dataFineValidita,Boolean flagCatMac,Boolean flagCatInfr,
			Set<DServiziProcessi> DServiziProcessis) {
		this.textSiglaProcesso = textSiglaProcesso;
		this.descProcesso = descProcesso;
		this.dataInizioValidita = dataInizioValidita;
		this.dataFineValidita = dataFineValidita;
		this.flagCatMac = flagCatMac;
		this.flagCatInfr = flagCatInfr;
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

	public Date getDataInizioValidita() {
		return this.dataInizioValidita;
	}

	public void setDataInizioValidita(Date dataInizioValidita) {
		this.dataInizioValidita = dataInizioValidita;
	}

	public Date getDataFineValidita() {
		return this.dataFineValidita;
	}

	public void setDataFineValidita(Date dataFineValidita) {
		this.dataFineValidita = dataFineValidita;
	}
	
	public Boolean getFlagCatMac() {
		return flagCatMac;
	}

	public void setFlagCatMac(Boolean flagCatMac) {
		this.flagCatMac = flagCatMac;
	}

	public Boolean getFlagCatInfr() {
		return flagCatInfr;
	}

	public void setFlagCatInfr(Boolean flagCatInfr) {
		this.flagCatInfr = flagCatInfr;
	}

	public Set<DServiziProcessi> getDServiziProcessis() {
		return this.DServiziProcessis;
	}

	public void setDServiziProcessis(Set<DServiziProcessi> DServiziProcessis) {
		this.DServiziProcessis = DServiziProcessis;
	}

}
