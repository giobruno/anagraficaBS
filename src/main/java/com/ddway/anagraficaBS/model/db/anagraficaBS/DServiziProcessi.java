package com.ddway.anagraficaBS.model.db.anagraficaBS;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class DServiziProcessi implements java.io.Serializable {

	private DServiziProcessiId id;
	private DProcessi DProcessi;
	private DCategorieInfr DCategorieInfr;
	private DBusinessServices DBusinessServices;
	private DCategorieMac DCategorieMac;
	private Date orarioLavIni;
	private Date orarioLavFine;
	private String misuTmpLavorativo;
	private String misuTmpSolare;
	private String dataFineValidita;

	public DServiziProcessi() {
	}

	public DServiziProcessi(DServiziProcessiId id, DProcessi DProcessi,
			DCategorieInfr DCategorieInfr, DBusinessServices DBusinessServices,
			DCategorieMac DCategorieMac) {
		this.id = id;
		this.DProcessi = DProcessi;
		this.DCategorieInfr = DCategorieInfr;
		this.DBusinessServices = DBusinessServices;
		this.DCategorieMac = DCategorieMac;
	}

	public DServiziProcessi(DServiziProcessiId id, DProcessi DProcessi,
			DCategorieInfr DCategorieInfr, DBusinessServices DBusinessServices,
			DCategorieMac DCategorieMac, Date orarioLavIni, Date orarioLavFine,
			String misuTmpLavorativo, String misuTmpSolare,
			String dataFineValidita) {
		this.id = id;
		this.DProcessi = DProcessi;
		this.DCategorieInfr = DCategorieInfr;
		this.DBusinessServices = DBusinessServices;
		this.DCategorieMac = DCategorieMac;
		this.orarioLavIni = orarioLavIni;
		this.orarioLavFine = orarioLavFine;
		this.misuTmpLavorativo = misuTmpLavorativo;
		this.misuTmpSolare = misuTmpSolare;
		this.dataFineValidita = dataFineValidita;
	}

	public DServiziProcessiId getId() {
		return this.id;
	}

	public void setId(DServiziProcessiId id) {
		this.id = id;
	}

	public DProcessi getDProcessi() {
		return this.DProcessi;
	}

	public void setDProcessi(DProcessi DProcessi) {
		this.DProcessi = DProcessi;
	}

	public DCategorieInfr getDCategorieInfr() {
		return this.DCategorieInfr;
	}

	public void setDCategorieInfr(DCategorieInfr DCategorieInfr) {
		this.DCategorieInfr = DCategorieInfr;
	}

	public DBusinessServices getDBusinessServices() {
		return this.DBusinessServices;
	}

	public void setDBusinessServices(DBusinessServices DBusinessServices) {
		this.DBusinessServices = DBusinessServices;
	}

	public DCategorieMac getDCategorieMac() {
		return this.DCategorieMac;
	}

	public void setDCategorieMac(DCategorieMac DCategorieMac) {
		this.DCategorieMac = DCategorieMac;
	}

	public Date getOrarioLavIni() {
		return this.orarioLavIni;
	}

	public void setOrarioLavIni(Date orarioLavIni) {
		this.orarioLavIni = orarioLavIni;
	}

	public Date getOrarioLavFine() {
		return this.orarioLavFine;
	}

	public void setOrarioLavFine(Date orarioLavFine) {
		this.orarioLavFine = orarioLavFine;
	}

	public String getMisuTmpLavorativo() {
		return this.misuTmpLavorativo;
	}

	public void setMisuTmpLavorativo(String misuTmpLavorativo) {
		this.misuTmpLavorativo = misuTmpLavorativo;
	}

	public String getMisuTmpSolare() {
		return this.misuTmpSolare;
	}

	public void setMisuTmpSolare(String misuTmpSolare) {
		this.misuTmpSolare = misuTmpSolare;
	}

	public String getDataFineValidita() {
		return this.dataFineValidita;
	}

	public void setDataFineValidita(String dataFineValidita) {
		this.dataFineValidita = dataFineValidita;
	}

}
