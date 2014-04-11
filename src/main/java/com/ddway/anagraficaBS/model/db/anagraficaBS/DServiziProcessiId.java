package com.ddway.anagraficaBS.model.db.anagraficaBS;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class DServiziProcessiId implements java.io.Serializable {

	private int codiBusinessService;
	private int codiProcesso;
	private int codiCategoriaMac;
	private int codiCategoriaInfr;
	private Date dataInizioValidita;

	public DServiziProcessiId() {
	}

	public DServiziProcessiId(int codiBusinessService, int codiProcesso,
			int codiCategoriaMac, int codiCategoriaInfr, Date dataInizioValidita) {
		this.codiBusinessService = codiBusinessService;
		this.codiProcesso = codiProcesso;
		this.codiCategoriaMac = codiCategoriaMac;
		this.codiCategoriaInfr = codiCategoriaInfr;
		this.dataInizioValidita = dataInizioValidita;
	}

	public int getCodiBusinessService() {
		return this.codiBusinessService;
	}

	public void setCodiBusinessService(int codiBusinessService) {
		this.codiBusinessService = codiBusinessService;
	}

	public int getCodiProcesso() {
		return this.codiProcesso;
	}

	public void setCodiProcesso(int codiProcesso) {
		this.codiProcesso = codiProcesso;
	}

	public int getCodiCategoriaMac() {
		return this.codiCategoriaMac;
	}

	public void setCodiCategoriaMac(int codiCategoriaMac) {
		this.codiCategoriaMac = codiCategoriaMac;
	}

	public int getCodiCategoriaInfr() {
		return this.codiCategoriaInfr;
	}

	public void setCodiCategoriaInfr(int codiCategoriaInfr) {
		this.codiCategoriaInfr = codiCategoriaInfr;
	}

	public Date getDataInizioValidita() {
		return this.dataInizioValidita;
	}

	public void setDataInizioValidita(Date dataInizioValidita) {
		this.dataInizioValidita = dataInizioValidita;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DServiziProcessiId))
			return false;
		DServiziProcessiId castOther = (DServiziProcessiId) other;

		return (this.getCodiBusinessService() == castOther
				.getCodiBusinessService())
				&& (this.getCodiProcesso() == castOther.getCodiProcesso())
				&& (this.getCodiCategoriaMac() == castOther
						.getCodiCategoriaMac())
				&& (this.getCodiCategoriaInfr() == castOther
						.getCodiCategoriaInfr())
				&& ((this.getDataInizioValidita() == castOther
						.getDataInizioValidita()) || (this
						.getDataInizioValidita() != null
						&& castOther.getDataInizioValidita() != null && this
						.getDataInizioValidita().equals(
								castOther.getDataInizioValidita())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodiBusinessService();
		result = 37 * result + this.getCodiProcesso();
		result = 37 * result + this.getCodiCategoriaMac();
		result = 37 * result + this.getCodiCategoriaInfr();
		result = 37
				* result
				+ (getDataInizioValidita() == null ? 0 : this
						.getDataInizioValidita().hashCode());
		return result;
	}

}
