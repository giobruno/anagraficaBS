package com.ddway.anagraficaBS.model.bean;

import java.math.BigDecimal;

public class DipartimentoBean {
	
	private String textSiglaDipartimento;
	private int codiDipartimento;
	private BigDecimal misuPesoDip;
	
	public DipartimentoBean(){}

	public int getCodiDipartimento() {
		return codiDipartimento;
	}
	
	

	public String getTextSiglaDipartimento() {
		return textSiglaDipartimento;
	}

	public void setTextSiglaDipartimento(String textSiglaDipartimento) {
		this.textSiglaDipartimento = textSiglaDipartimento;
	}

	public void setCodiDipartimento(int codiDipartimento) {
		this.codiDipartimento = codiDipartimento;
	}

	public BigDecimal getMisuPesoDip() {
		return misuPesoDip;
	}

	public void setMisuPesoDip(BigDecimal misuPesoDip) {
		this.misuPesoDip = misuPesoDip;
	}
	
	

}
