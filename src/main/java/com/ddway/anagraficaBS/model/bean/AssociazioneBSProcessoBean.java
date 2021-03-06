package com.ddway.anagraficaBS.model.bean;

import java.util.Date;

public class AssociazioneBSProcessoBean {
	
	private int codiBusinessService;
	private int codiProcesso;
	private int codiCategoriaMac;
	private String descCategoriaMac;
	private int codiCategoriaInfr;
	private String descCategoriaInfr;
	private Date dataInizioValidita;	
	private String textSiglaProcesso;
	private String dataFineValidita;
	private String descProcesso;
	
	public AssociazioneBSProcessoBean(){}
	
	public AssociazioneBSProcessoBean(int codiBusinessService,
										int codiProcesso,
										int codiCategoriaMac,
										String descCategoriaMac,
										int codiCategoriaInfr,
										String descCategoriaInfr,
										Date dataInizioValidita,	
										String textSiglaProcesso,
										String dataFineValidita,String descProcesso){
		
		this.codiBusinessService = codiBusinessService;
		this.codiCategoriaInfr = codiCategoriaInfr;
		this.codiCategoriaMac = codiCategoriaMac;
		this.descCategoriaMac = descCategoriaMac;
		this.descCategoriaInfr = descCategoriaInfr;
		this.codiProcesso = codiProcesso;
		this.dataFineValidita = dataFineValidita;
		this.dataInizioValidita = dataInizioValidita;
		this.textSiglaProcesso = textSiglaProcesso;
		this.descProcesso = descProcesso;
	}
	
	
	public String getDescCategoriaMac() {
		return descCategoriaMac;
	}

	public void setDescCategoriaMac(String descCategoriaMac) {
		this.descCategoriaMac = descCategoriaMac;
	}

	public String getDescCategoriaInfr() {
		return descCategoriaInfr;
	}

	public void setDescCategoriaInfr(String descCategoriaInfr) {
		this.descCategoriaInfr = descCategoriaInfr;
	}

	public String getDescProcesso() {
		return descProcesso;
	}

	public void setDescProcesso(String descProcesso) {
		this.descProcesso = descProcesso;
	}

	public int getCodiBusinessService() {
		return codiBusinessService;
	}

	public void setCodiBusinessService(int codiBusinessService) {
		this.codiBusinessService = codiBusinessService;
	}

	public int getCodiProcesso() {
		return codiProcesso;
	}

	public void setCodiProcesso(int codiProcesso) {
		this.codiProcesso = codiProcesso;
	}

	public int getCodiCategoriaMac() {
		return codiCategoriaMac;
	}

	public void setCodiCategoriaMac(int codiCategoriaMac) {
		this.codiCategoriaMac = codiCategoriaMac;
	}

	public int getCodiCategoriaInfr() {
		return codiCategoriaInfr;
	}

	public void setCodiCategoriaInfr(int codiCategoriaInfr) {
		this.codiCategoriaInfr = codiCategoriaInfr;
	}

	public Date getDataInizioValidita() {
		return dataInizioValidita;
	}

	public void setDataInizioValidita(Date dataInizioValidita) {
		this.dataInizioValidita = dataInizioValidita;
	}

	public String getTextSiglaProcesso() {
		return textSiglaProcesso;
	}

	public void setTextSiglaProcesso(String textSiglaProcesso) {
		this.textSiglaProcesso = textSiglaProcesso;
	}

	public String getDataFineValidita() {
		return dataFineValidita;
	}

	public void setDataFineValidita(String dataFineValidita) {
		this.dataFineValidita = dataFineValidita;
	}
}
