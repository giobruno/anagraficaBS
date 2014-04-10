package com.ddway.anagraficaBS.model.db;

import java.util.Date;
import org.springframework.stereotype.Service;

@Service
public class DServiziProcessi implements java.io.Serializable {

	private DServiziProcessiId id;	
	private Date orarioLavIni;
	private Date orarioLavFine;
	private String misuTmpLavorativo;
	private String misuTmpSolare;
	private String dataFineValidita;

	public DServiziProcessi() {
	}

	public DServiziProcessi(DServiziProcessiId id, DProcessi DProcessi,
			DCategorieInfr DCategorieInfr, DBusinessServices DBusinessServices,
			DCategorieMac DCategorieMac, Date orarioLavIni, Date orarioLavFine,
			String misuTmpLavorativo, String misuTmpSolare,
			String dataFineValidita) {
		this.id = id;		
		this.orarioLavIni = orarioLavIni;
		this.orarioLavFine = orarioLavFine;
		this.misuTmpLavorativo = misuTmpLavorativo;
		this.misuTmpSolare = misuTmpSolare;
		this.dataFineValidita = dataFineValidita;
	}

	public DServiziProcessiId getId() {
		return id;
	}

	public void setId(DServiziProcessiId id) {
		this.id = id;
	}

	public Date getOrarioLavIni() {
		return orarioLavIni;
	}

	public void setOrarioLavIni(Date orarioLavIni) {
		this.orarioLavIni = orarioLavIni;
	}

	public Date getOrarioLavFine() {
		return orarioLavFine;
	}

	public void setOrarioLavFine(Date orarioLavFine) {
		this.orarioLavFine = orarioLavFine;
	}

	public String getMisuTmpLavorativo() {
		return misuTmpLavorativo;
	}

	public void setMisuTmpLavorativo(String misuTmpLavorativo) {
		this.misuTmpLavorativo = misuTmpLavorativo;
	}

	public String getMisuTmpSolare() {
		return misuTmpSolare;
	}

	public void setMisuTmpSolare(String misuTmpSolare) {
		this.misuTmpSolare = misuTmpSolare;
	}

	public String getDataFineValidita() {
		return dataFineValidita;
	}

	public void setDataFineValidita(String dataFineValidita) {
		this.dataFineValidita = dataFineValidita;
	}

	

}
