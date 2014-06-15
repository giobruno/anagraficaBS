package com.ddway.anagraficaBS.model.forms;

import org.springframework.stereotype.Service;

@Service
public class ProcessoForm {
	
	private String textSiglaProcesso;
	private String descProcesso;
	private Boolean flagCatMac;
	private Boolean flagCatInfr;
	
	public ProcessoForm(){}
	
	public ProcessoForm(String textSiglaProcesso,String descProcesso,Boolean flagCatMac,Boolean flagCatInfr){
		
		this.textSiglaProcesso = textSiglaProcesso;
		this.descProcesso = descProcesso;
		this.flagCatMac = flagCatMac;
		this.flagCatInfr = flagCatInfr;
	}

	public String getTextSiglaProcesso() {
		return textSiglaProcesso;
	}

	public void setTextSiglaProcesso(String textSiglaProcesso) {
		this.textSiglaProcesso = textSiglaProcesso;
	}

	public String getDescProcesso() {
		return descProcesso;
	}

	public void setDescProcesso(String descProcesso) {
		this.descProcesso = descProcesso;
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
	
}
