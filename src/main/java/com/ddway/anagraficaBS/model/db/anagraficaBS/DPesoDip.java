package com.ddway.anagraficaBS.model.db.anagraficaBS;

import java.math.BigDecimal;
import java.util.Date;

/**
 * DPesoDip generated by hbm2java
 */
public class DPesoDip implements java.io.Serializable {

	private DPesoDipId id;
	private BigDecimal misuPesoDip;
	private Date dataFineAssociazione;

	public DPesoDip() {
	}

	public DPesoDip(DPesoDipId id) {
		this.id = id;
	}

	public DPesoDip(DPesoDipId id, BigDecimal misuPesoDip,
			Date dataFineAssociazione) {
		this.id = id;
		this.misuPesoDip = misuPesoDip;
		this.dataFineAssociazione = dataFineAssociazione;
	}

	public DPesoDipId getId() {
		return this.id;
	}

	public void setId(DPesoDipId id) {
		this.id = id;
	}

	public BigDecimal getMisuPesoDip() {
		return this.misuPesoDip;
	}

	public void setMisuPesoDip(BigDecimal misuPesoDip) {
		this.misuPesoDip = misuPesoDip;
	}

	public Date getDataFineAssociazione() {
		return this.dataFineAssociazione;
	}

	public void setDataFineAssociazione(Date dataFineAssociazione) {
		this.dataFineAssociazione = dataFineAssociazione;
	}

}
