package com.ddway.anagraficaBS.model.db;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class DCategorieMac implements java.io.Serializable {

	private int codiCategoriaMac;
	private String descCategoriaMac;
	private Boolean flagMacLavSol;
	private Set DServiziProcessis = new HashSet(0);

	public DCategorieMac() {
	}

	public DCategorieMac(int codiCategoriaMac) {
		this.codiCategoriaMac = codiCategoriaMac;
	}

	public DCategorieMac(int codiCategoriaMac, String descCategoriaMac,
			Boolean flagMacLavSol, Set DServiziProcessis) {
		this.codiCategoriaMac = codiCategoriaMac;
		this.descCategoriaMac = descCategoriaMac;
		this.flagMacLavSol = flagMacLavSol;
		this.DServiziProcessis = DServiziProcessis;
	}

	public int getCodiCategoriaMac() {
		return this.codiCategoriaMac;
	}

	public void setCodiCategoriaMac(int codiCategoriaMac) {
		this.codiCategoriaMac = codiCategoriaMac;
	}

	public String getDescCategoriaMac() {
		return this.descCategoriaMac;
	}

	public void setDescCategoriaMac(String descCategoriaMac) {
		this.descCategoriaMac = descCategoriaMac;
	}

	public Boolean getFlagMacLavSol() {
		return this.flagMacLavSol;
	}

	public void setFlagMacLavSol(Boolean flagMacLavSol) {
		this.flagMacLavSol = flagMacLavSol;
	}

	public Set getDServiziProcessis() {
		return this.DServiziProcessis;
	}

	public void setDServiziProcessis(Set DServiziProcessis) {
		this.DServiziProcessis = DServiziProcessis;
	}

}
