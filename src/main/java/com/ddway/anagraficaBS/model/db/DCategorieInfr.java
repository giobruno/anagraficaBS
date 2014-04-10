package com.ddway.anagraficaBS.model.db;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class DCategorieInfr implements java.io.Serializable {

	private int codiCategoriaInfr;
	private String descCategoriaInfr;
	private Boolean flagInfrLavSol;
	private Set DServiziProcessis = new HashSet(0);

	public DCategorieInfr() {
	}

	public DCategorieInfr(int codiCategoriaInfr) {
		this.codiCategoriaInfr = codiCategoriaInfr;
	}

	public DCategorieInfr(int codiCategoriaInfr, String descCategoriaInfr,
			Boolean flagInfrLavSol, Set DServiziProcessis) {
		this.codiCategoriaInfr = codiCategoriaInfr;
		this.descCategoriaInfr = descCategoriaInfr;
		this.flagInfrLavSol = flagInfrLavSol;
		this.DServiziProcessis = DServiziProcessis;
	}

	public int getCodiCategoriaInfr() {
		return this.codiCategoriaInfr;
	}

	public void setCodiCategoriaInfr(int codiCategoriaInfr) {
		this.codiCategoriaInfr = codiCategoriaInfr;
	}

	public String getDescCategoriaInfr() {
		return this.descCategoriaInfr;
	}

	public void setDescCategoriaInfr(String descCategoriaInfr) {
		this.descCategoriaInfr = descCategoriaInfr;
	}

	public Boolean getFlagInfrLavSol() {
		return this.flagInfrLavSol;
	}

	public void setFlagInfrLavSol(Boolean flagInfrLavSol) {
		this.flagInfrLavSol = flagInfrLavSol;
	}

	public Set getDServiziProcessis() {
		return this.DServiziProcessis;
	}

	public void setDServiziProcessis(Set DServiziProcessis) {
		this.DServiziProcessis = DServiziProcessis;
	}

}
