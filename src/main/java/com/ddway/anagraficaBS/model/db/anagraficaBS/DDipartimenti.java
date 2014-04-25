package com.ddway.anagraficaBS.model.db.anagraficaBS;

// Generated Apr 17, 2014 2:09:27 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

/**
 * DDipartimenti generated by hbm2java
 */
@Service
public class DDipartimenti implements java.io.Serializable {

	private int codiDipartimento;
	private String textSiglaDipartimento;
	private String descDipartimento;
	private Set<DBusinessServices> DBusinessServiceses = new HashSet<DBusinessServices>(
			0);

	public DDipartimenti() {
	}

	public DDipartimenti(int codiDipartimento) {
		this.codiDipartimento = codiDipartimento;
	}

	public DDipartimenti(int codiDipartimento, String textSiglaDipartimento,
			String descDipartimento, Set<DBusinessServices> DBusinessServiceses) {
		this.codiDipartimento = codiDipartimento;
		this.textSiglaDipartimento = textSiglaDipartimento;
		this.descDipartimento = descDipartimento;
		this.DBusinessServiceses = DBusinessServiceses;
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

	public Set<DBusinessServices> getDBusinessServiceses() {
		return this.DBusinessServiceses;
	}

	public void setDBusinessServiceses(
			Set<DBusinessServices> DBusinessServiceses) {
		this.DBusinessServiceses = DBusinessServiceses;
	}

}
