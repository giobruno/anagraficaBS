package com.ddway.anagraficaBS.model.db;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class DDipartimenti implements java.io.Serializable {

	private int codiDipartimento;
	private String textSiglaDipartimento;
	private String descDipartimento;	

	public DDipartimenti() {
	}

	public DDipartimenti(int codiDipartimento) {
		this.codiDipartimento = codiDipartimento;
	}

	public DDipartimenti(int codiDipartimento, String textSiglaDipartimento,
			String descDipartimento) {
		this.codiDipartimento = codiDipartimento;
		this.textSiglaDipartimento = textSiglaDipartimento;
		this.descDipartimento = descDipartimento;		
	}

	public int getCodiDipartimento() {
		return this.codiDipartimento;
	}

	public void setCodiDipartimento(int codiDipartimento) {
		this.codiDipartimento = codiDipartimento;
	}

	public String getTextSiglaDipartimento() {
		return this.textSiglaDipartimento;
	}

	public void setTextSiglaDipartimento(String textSiglaDipartimento) {
		this.textSiglaDipartimento = textSiglaDipartimento;
	}

	public String getDescDipartimento() {
		return this.descDipartimento;
	}

	public void setDescDipartimento(String descDipartimento) {
		this.descDipartimento = descDipartimento;
	}

}
