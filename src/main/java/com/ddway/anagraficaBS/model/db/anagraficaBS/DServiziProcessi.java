package com.ddway.anagraficaBS.model.db.anagraficaBS;

// Generated Apr 17, 2014 2:09:27 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import org.springframework.stereotype.Service;

/**
 * DServiziProcessi generated by hbm2java
 */
@Service
public class DServiziProcessi implements java.io.Serializable {

	private DServiziProcessiId id;
	private DProcessi DProcessi;
	private DCategorieInfr DCategorieInfr;
	private DBusinessServices DBusinessServices;
	private DCategorieMac DCategorieMac;
	private Date orarioLavIni;
	private Date orarioLavFine;
	private Integer misuTmpLavorativo;
	private Integer misuTmpSolare;
	private Date dataFineValidita;

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
			Integer misuTmpLavorativo, Integer misuTmpSolare,
			Date dataFineValidita) {
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

	public Integer getMisuTmpLavorativo() {
		return this.misuTmpLavorativo;
	}

	public void setMisuTmpLavorativo(Integer misuTmpLavorativo) {
		this.misuTmpLavorativo = misuTmpLavorativo;
	}

	public Integer getMisuTmpSolare() {
		return this.misuTmpSolare;
	}

	public void setMisuTmpSolare(Integer misuTmpSolare) {
		this.misuTmpSolare = misuTmpSolare;
	}

	public Date getDataFineValidita() {
		return this.dataFineValidita;
	}

	public void setDataFineValidita(Date dataFineValidita) {
		this.dataFineValidita = dataFineValidita;
	}

}
