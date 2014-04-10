package com.ddway.anagraficaBS.model.db;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class DServiziFunzioniId implements java.io.Serializable {

	private int codiBusinessService;
	private int codiArea;
	private int codiApplicazione;
	private int codiFunzione;
	private Date dataInizioAssociazione;

	public DServiziFunzioniId() {
	}

	public DServiziFunzioniId(int codiBusinessService, int codiArea,
			int codiApplicazione, int codiFunzione, Date dataInizioAssociazione) {
		this.codiBusinessService = codiBusinessService;
		this.codiArea = codiArea;
		this.codiApplicazione = codiApplicazione;
		this.codiFunzione = codiFunzione;
		this.dataInizioAssociazione = dataInizioAssociazione;
	}

	public int getCodiBusinessService() {
		return this.codiBusinessService;
	}

	public void setCodiBusinessService(int codiBusinessService) {
		this.codiBusinessService = codiBusinessService;
	}

	public int getCodiArea() {
		return this.codiArea;
	}

	public void setCodiArea(int codiArea) {
		this.codiArea = codiArea;
	}

	public int getCodiApplicazione() {
		return this.codiApplicazione;
	}

	public void setCodiApplicazione(int codiApplicazione) {
		this.codiApplicazione = codiApplicazione;
	}

	public int getCodiFunzione() {
		return this.codiFunzione;
	}

	public void setCodiFunzione(int codiFunzione) {
		this.codiFunzione = codiFunzione;
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
		if (!(other instanceof DServiziFunzioniId))
			return false;
		DServiziFunzioniId castOther = (DServiziFunzioniId) other;

		return (this.getCodiBusinessService() == castOther
				.getCodiBusinessService())
				&& (this.getCodiArea() == castOther.getCodiArea())
				&& (this.getCodiApplicazione() == castOther
						.getCodiApplicazione())
				&& (this.getCodiFunzione() == castOther.getCodiFunzione())
				&& ((this.getDataInizioAssociazione() == castOther
						.getDataInizioAssociazione()) || (this
						.getDataInizioAssociazione() != null
						&& castOther.getDataInizioAssociazione() != null && this
						.getDataInizioAssociazione().equals(
								castOther.getDataInizioAssociazione())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodiBusinessService();
		result = 37 * result + this.getCodiArea();
		result = 37 * result + this.getCodiApplicazione();
		result = 37 * result + this.getCodiFunzione();
		result = 37
				* result
				+ (getDataInizioAssociazione() == null ? 0 : this
						.getDataInizioAssociazione().hashCode());
		return result;
	}

}
