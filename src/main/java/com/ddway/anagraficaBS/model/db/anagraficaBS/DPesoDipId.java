package com.ddway.anagraficaBS.model.db.anagraficaBS;

import java.util.Date;

/**
 * DPesoDipId generated by hbm2java
 */
public class DPesoDipId implements java.io.Serializable {

	private int codiDipartimento;
	private Date dataInizioAssociazione;

	public DPesoDipId() {
	}

	public DPesoDipId(int codiDipartimento, Date dataInizioAssociazione) {
		this.codiDipartimento = codiDipartimento;
		this.dataInizioAssociazione = dataInizioAssociazione;
	}

	public int getCodiDipartimento() {
		return this.codiDipartimento;
	}

	public void setCodiDipartimento(int codiDipartimento) {
		this.codiDipartimento = codiDipartimento;
	}

	public Date getDataInizioAssociazione() {
		return this.dataInizioAssociazione;
	}

	public void setDataInizioAssociazione(Date dataInizioAssociazione) {
		this.dataInizioAssociazione = dataInizioAssociazione;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DPesoDipId))
			return false;
		DPesoDipId castOther = (DPesoDipId) other;

		return (this.getCodiDipartimento() == castOther.getCodiDipartimento())
				&& ((this.getDataInizioAssociazione() == castOther
						.getDataInizioAssociazione()) || (this
						.getDataInizioAssociazione() != null
						&& castOther.getDataInizioAssociazione() != null && this
						.getDataInizioAssociazione().equals(
								castOther.getDataInizioAssociazione())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodiDipartimento();
		result = 37
				* result
				+ (getDataInizioAssociazione() == null ? 0 : this
						.getDataInizioAssociazione().hashCode());
		return result;
	}

}