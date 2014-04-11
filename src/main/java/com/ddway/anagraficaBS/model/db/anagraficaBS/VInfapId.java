package com.ddway.anagraficaBS.model.db.anagraficaBS;

import org.springframework.stereotype.Service;

@Service
public class VInfapId implements java.io.Serializable {

	private long codiArea;
	private long codiApplicazione;
	private long codiFunzione;
	private String descArea;
	private String descApplicazione;
	private String descFunzione;
	private String dataInizioAssociazione;

	public VInfapId() {
	}

	public VInfapId(long codiArea, long codiApplicazione, long codiFunzione,
			String descArea, String descApplicazione, String descFunzione,
			String dataInizioAssociazione) {
		this.codiArea = codiArea;
		this.codiApplicazione = codiApplicazione;
		this.codiFunzione = codiFunzione;
		this.descArea = descArea;
		this.descApplicazione = descApplicazione;
		this.descFunzione = descFunzione;
		this.dataInizioAssociazione = dataInizioAssociazione;
	}

	public long getCodiArea() {
		return this.codiArea;
	}

	public void setCodiArea(long codiArea) {
		this.codiArea = codiArea;
	}

	public long getCodiApplicazione() {
		return this.codiApplicazione;
	}

	public void setCodiApplicazione(long codiApplicazione) {
		this.codiApplicazione = codiApplicazione;
	}

	public long getCodiFunzione() {
		return this.codiFunzione;
	}

	public void setCodiFunzione(long codiFunzione) {
		this.codiFunzione = codiFunzione;
	}

	public String getDescArea() {
		return this.descArea;
	}

	public void setDescArea(String descArea) {
		this.descArea = descArea;
	}

	public String getDescApplicazione() {
		return this.descApplicazione;
	}

	public void setDescApplicazione(String descApplicazione) {
		this.descApplicazione = descApplicazione;
	}

	public String getDescFunzione() {
		return this.descFunzione;
	}

	public void setDescFunzione(String descFunzione) {
		this.descFunzione = descFunzione;
	}

	public String getDataInizioAssociazione() {
		return this.dataInizioAssociazione;
	}

	public void setDataInizioAssociazione(String dataInizioAssociazione) {
		this.dataInizioAssociazione = dataInizioAssociazione;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VInfapId))
			return false;
		VInfapId castOther = (VInfapId) other;

		return (this.getCodiArea() == castOther.getCodiArea())
				&& (this.getCodiApplicazione() == castOther
						.getCodiApplicazione())
				&& (this.getCodiFunzione() == castOther.getCodiFunzione())
				&& ((this.getDescArea() == castOther.getDescArea()) || (this
						.getDescArea() != null
						&& castOther.getDescArea() != null && this
						.getDescArea().equals(castOther.getDescArea())))
				&& ((this.getDescApplicazione() == castOther
						.getDescApplicazione()) || (this.getDescApplicazione() != null
						&& castOther.getDescApplicazione() != null && this
						.getDescApplicazione().equals(
								castOther.getDescApplicazione())))
				&& ((this.getDescFunzione() == castOther.getDescFunzione()) || (this
						.getDescFunzione() != null
						&& castOther.getDescFunzione() != null && this
						.getDescFunzione().equals(castOther.getDescFunzione())))
				&& ((this.getDataInizioAssociazione() == castOther
						.getDataInizioAssociazione()) || (this
						.getDataInizioAssociazione() != null
						&& castOther.getDataInizioAssociazione() != null && this
						.getDataInizioAssociazione().equals(
								castOther.getDataInizioAssociazione())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getCodiArea();
		result = 37 * result + (int) this.getCodiApplicazione();
		result = 37 * result + (int) this.getCodiFunzione();
		result = 37 * result
				+ (getDescArea() == null ? 0 : this.getDescArea().hashCode());
		result = 37
				* result
				+ (getDescApplicazione() == null ? 0 : this
						.getDescApplicazione().hashCode());
		result = 37
				* result
				+ (getDescFunzione() == null ? 0 : this.getDescFunzione()
						.hashCode());
		result = 37
				* result
				+ (getDataInizioAssociazione() == null ? 0 : this
						.getDataInizioAssociazione().hashCode());
		return result;
	}

}
