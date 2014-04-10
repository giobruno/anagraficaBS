package com.ddway.anagraficaBS.model.db;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class DServiziFunzioni implements java.io.Serializable {

	private DServiziFunzioniId id;	
	private String descArea;
	private String descApplicazione;
	private String descFunzione;
	private Date dataFineAssociazione;

	public DServiziFunzioni() {
	}

	public DServiziFunzioni(DServiziFunzioniId id, String descArea,
			String descApplicazione, String descFunzione,
			Date dataFineAssociazione) {
		this.id = id;		
		this.descArea = descArea;
		this.descApplicazione = descApplicazione;
		this.descFunzione = descFunzione;
		this.dataFineAssociazione = dataFineAssociazione;
	}

	public DServiziFunzioniId getId() {
		return this.id;
	}

	public void setId(DServiziFunzioniId id) {
		this.id = id;
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

	public Date getDataFineAssociazione() {
		return this.dataFineAssociazione;
	}

	public void setDataFineAssociazione(Date dataFineAssociazione) {
		this.dataFineAssociazione = dataFineAssociazione;
	}

}
