package com.ddway.anagraficaBS.model.bean;

public class CategorieMac {
	
	private int codiCategoriaMac;
	private String descCategoriaMac;
	private String codiDescCategoriaMac;
	private Boolean flagMacLavSol;
	
	public CategorieMac(){}

	public CategorieMac(int codiCategoriaMac, String descCategoriaMac,
			String codiDescCategoriaMac, 
			Boolean flagMacLavSol){
		
		this.codiCategoriaMac = codiCategoriaMac;
		this.descCategoriaMac = descCategoriaMac;
		this.codiDescCategoriaMac = codiDescCategoriaMac;
		this.flagMacLavSol = flagMacLavSol;		
	}

	public int getCodiCategoriaMac() {
		return codiCategoriaMac;
	}

	public void setCodiCategoriaMac(int codiCategoriaMac) {
		this.codiCategoriaMac = codiCategoriaMac;
	}

	public String getDescCategoriaMac() {
		return descCategoriaMac;
	}

	public void setDescCategoriaMac(String descCategoriaMac) {
		this.descCategoriaMac = descCategoriaMac;
	}

	public String getCodiDescCategoriaMac() {
		return codiDescCategoriaMac;
	}

	public void setCodiDescCategoriaMac(String codiDescCategoriaMac) {
		this.codiDescCategoriaMac = codiDescCategoriaMac;
	}

	public Boolean getFlagMacLavSol() {
		return flagMacLavSol;
	}

	public void setFlagMacLavSol(Boolean flagMacLavSol) {
		this.flagMacLavSol = flagMacLavSol;
	}	
}
