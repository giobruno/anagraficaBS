package com.ddway.anagraficaBS.model.forms;

import java.util.Date;

public class AssociazioneBSProcessoForm {
	
	private String codiBusinessService;
	private String codiProcesso;
	private String codiCategoriaMac;
	private String codiCategoriaInfr;	
	private String orarioLavIniOre;
	private String orarioLavIniMinuti;
	private String orarioLavFineOre;
	private String orarioLavFineMinuti;
	private String misuTmpLavorativo;
	private String misuTmpSolare;
	
	public AssociazioneBSProcessoForm(){}
	
	public AssociazioneBSProcessoForm(String codiBusinessService,String codiProcesso,String codiCategoriaMac,
			String codiCategoriaInfr, String orarioLavIniOre, String orarioLavIniMinuti,String orarioLavFineOre, 
			String orarioLavFineMinuti,String misuTmpLavorativo,String misuTmpSolare){
		
		this.codiBusinessService = codiBusinessService;
		this.codiProcesso = codiProcesso;
		this.codiCategoriaMac = codiCategoriaMac;
		this.codiCategoriaInfr = codiCategoriaInfr;
		this.orarioLavIniOre = orarioLavIniOre;
		this.orarioLavIniMinuti  = orarioLavIniMinuti;
		this.orarioLavFineOre = orarioLavFineOre;
		this.orarioLavFineMinuti = orarioLavFineMinuti;
		this.misuTmpLavorativo = misuTmpLavorativo;
		this.misuTmpSolare = misuTmpSolare;		
	}

	public String getCodiBusinessService() {
		return codiBusinessService;
	}

	public void setCodiBusinessService(String codiBusinessService) {
		this.codiBusinessService = codiBusinessService;
	}

	public String getCodiProcesso() {
		return codiProcesso;
	}

	public void setCodiProcesso(String codiProcesso) {
		this.codiProcesso = codiProcesso;
	}

	public String getCodiCategoriaMac() {
		return codiCategoriaMac;
	}

	public void setCodiCategoriaMac(String codiCategoriaMac) {
		this.codiCategoriaMac = codiCategoriaMac;
	}

	public String getCodiCategoriaInfr() {
		return codiCategoriaInfr;
	}

	public void setCodiCategoriaInfr(String codiCategoriaInfr) {
		this.codiCategoriaInfr = codiCategoriaInfr;
	}

	public String getOrarioLavIniOre() {
		return orarioLavIniOre;
	}

	public void setOrarioLavIniOre(String orarioLavIniOre) {
		this.orarioLavIniOre = orarioLavIniOre;
	}

	public String getOrarioLavIniMinuti() {
		return orarioLavIniMinuti;
	}

	public void setOrarioLavIniMinuti(String orarioLavIniMinuti) {
		this.orarioLavIniMinuti = orarioLavIniMinuti;
	}

	public String getOrarioLavFineOre() {
		return orarioLavFineOre;
	}

	public void setOrarioLavFineOre(String orarioLavFineOre) {
		this.orarioLavFineOre = orarioLavFineOre;
	}

	public String getOrarioLavFineMinuti() {
		return orarioLavFineMinuti;
	}

	public void setOrarioLavFineMinuti(String orarioLavFineMinuti) {
		this.orarioLavFineMinuti = orarioLavFineMinuti;
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

}
