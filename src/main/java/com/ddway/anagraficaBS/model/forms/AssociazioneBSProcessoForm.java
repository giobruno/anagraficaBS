package com.ddway.anagraficaBS.model.forms;

public class AssociazioneBSProcessoForm {
	
	private String textNomeBusinessService;
	private String codiBusinessServiceOld;
	private String codiBusinessService;
	private String codiProcesso;
	private String codiCategoriaMac;
	private String codiCategoriaInfr;	
	private String orarioLavIniOre;
	private String orarioLavIniMinuti;
	private String orarioLavFineOre;
	private String orarioLavFineMinuti;
	private String misuTmpLavorativoGiorni;
	private String misuTmpLavorativoOre;
	private String misuTmpLavorativoMinuti;
	private String misuTmpSolareGiorni;
	private String misuTmpSolareOre;
	private String misuTmpSolareMinuti;
	
	public AssociazioneBSProcessoForm(){}
	
	public AssociazioneBSProcessoForm(String textNomeBusinessService,String codiBusinessServiceOld,String codiBusinessService,String codiProcesso,String codiCategoriaMac,
			String codiCategoriaInfr, String orarioLavIniOre, String orarioLavIniMinuti,String orarioLavFineOre, 
			String orarioLavFineMinuti,String misuTmpLavorativoGiorni, String misuTmpLavorativoOre,String misuTmpLavorativoMinuti,String misuTmpSolareGiorni,String misuTmpSolareOre,String misuTmpSolareMinuti ){
		
		this.textNomeBusinessService = textNomeBusinessService;
		this.codiBusinessServiceOld = codiBusinessServiceOld;
		this.codiBusinessService = codiBusinessService;
		this.codiProcesso = codiProcesso;
		this.codiCategoriaMac = codiCategoriaMac;
		this.codiCategoriaInfr = codiCategoriaInfr;
		this.orarioLavIniOre = orarioLavIniOre;
		this.orarioLavIniMinuti  = orarioLavIniMinuti;
		this.orarioLavFineOre = orarioLavFineOre;
		this.orarioLavFineMinuti = orarioLavFineMinuti;
		this.misuTmpLavorativoGiorni = misuTmpLavorativoGiorni;
		this.misuTmpLavorativoOre = misuTmpLavorativoOre;
		this.misuTmpLavorativoMinuti = misuTmpLavorativoMinuti;
		this.misuTmpSolareGiorni = misuTmpSolareGiorni;	
		this.misuTmpSolareOre = misuTmpSolareOre;	
		this.misuTmpSolareMinuti = misuTmpSolareMinuti;	
	}
	
	

	public String getTextNomeBusinessService() {
		return textNomeBusinessService;
	}

	public void setTextNomeBusinessService(String textNomeBusinessService) {
		this.textNomeBusinessService = textNomeBusinessService;
	}

	public String getCodiBusinessServiceOld() {
		return codiBusinessServiceOld;
	}

	public void setCodiBusinessServiceOld(String codiBusinessServiceOld) {
		this.codiBusinessServiceOld = codiBusinessServiceOld;
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

	public String getMisuTmpLavorativoGiorni() {
		return misuTmpLavorativoGiorni;
	}

	public void setMisuTmpLavorativoGiorni(String misuTmpLavorativoGiorni) {
		this.misuTmpLavorativoGiorni = misuTmpLavorativoGiorni;
	}

	public String getMisuTmpLavorativoOre() {
		return misuTmpLavorativoOre;
	}

	public void setMisuTmpLavorativoOre(String misuTmpLavorativoOre) {
		this.misuTmpLavorativoOre = misuTmpLavorativoOre;
	}

	public String getMisuTmpLavorativoMinuti() {
		return misuTmpLavorativoMinuti;
	}

	public void setMisuTmpLavorativoMinuti(String misuTmpLavorativoMinuti) {
		this.misuTmpLavorativoMinuti = misuTmpLavorativoMinuti;
	}

	public String getMisuTmpSolareGiorni() {
		return misuTmpSolareGiorni;
	}

	public void setMisuTmpSolareGiorni(String misuTmpSolareGiorni) {
		this.misuTmpSolareGiorni = misuTmpSolareGiorni;
	}

	public String getMisuTmpSolareOre() {
		return misuTmpSolareOre;
	}

	public void setMisuTmpSolareOre(String misuTmpSolareOre) {
		this.misuTmpSolareOre = misuTmpSolareOre;
	}

	public String getMisuTmpSolareMinuti() {
		return misuTmpSolareMinuti;
	}

	public void setMisuTmpSolareMinuti(String misuTmpSolareMinuti) {
		this.misuTmpSolareMinuti = misuTmpSolareMinuti;
	}	
}
