package com.ddway.anagraficaBS.model.db.infap;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class TblApplicazione implements java.io.Serializable {

	private Integer idTblApplicazione;
	private String scodeArea;
	private String scodeApplicazione;
	private String sdescrizione;
	private String sdescrizioneBreve;
	private Character sindi;
	private Character stipo;
	private String snote;
	private String scodeDipartim;
	private Integer ibaseline;
	private Integer icaricamento;
	private Date dateAgg;
	private String sfunzAgg;
	private Integer ienabled;

	public TblApplicazione() {
	}

	public TblApplicazione(String scodeArea, String scodeApplicazione) {
		this.scodeArea = scodeArea;
		this.scodeApplicazione = scodeApplicazione;
	}

	public TblApplicazione(String scodeArea, String scodeApplicazione,
			String sdescrizione, String sdescrizioneBreve, Character sindi,
			Character stipo, String snote, String scodeDipartim,
			Integer ibaseline, Integer icaricamento, Date dateAgg,
			String sfunzAgg, Integer ienabled) {
		this.scodeArea = scodeArea;
		this.scodeApplicazione = scodeApplicazione;
		this.sdescrizione = sdescrizione;
		this.sdescrizioneBreve = sdescrizioneBreve;
		this.sindi = sindi;
		this.stipo = stipo;
		this.snote = snote;
		this.scodeDipartim = scodeDipartim;
		this.ibaseline = ibaseline;
		this.icaricamento = icaricamento;
		this.dateAgg = dateAgg;
		this.sfunzAgg = sfunzAgg;
		this.ienabled = ienabled;
	}

	public Integer getIdTblApplicazione() {
		return this.idTblApplicazione;
	}

	public void setIdTblApplicazione(Integer idTblApplicazione) {
		this.idTblApplicazione = idTblApplicazione;
	}

	public String getScodeArea() {
		return this.scodeArea;
	}

	public void setScodeArea(String scodeArea) {
		this.scodeArea = scodeArea;
	}

	public String getScodeApplicazione() {
		return this.scodeApplicazione;
	}

	public void setScodeApplicazione(String scodeApplicazione) {
		this.scodeApplicazione = scodeApplicazione;
	}

	public String getSdescrizione() {
		return this.sdescrizione;
	}

	public void setSdescrizione(String sdescrizione) {
		this.sdescrizione = sdescrizione;
	}

	public String getSdescrizioneBreve() {
		return this.sdescrizioneBreve;
	}

	public void setSdescrizioneBreve(String sdescrizioneBreve) {
		this.sdescrizioneBreve = sdescrizioneBreve;
	}

	public Character getSindi() {
		return this.sindi;
	}

	public void setSindi(Character sindi) {
		this.sindi = sindi;
	}

	public Character getStipo() {
		return this.stipo;
	}

	public void setStipo(Character stipo) {
		this.stipo = stipo;
	}

	public String getSnote() {
		return this.snote;
	}

	public void setSnote(String snote) {
		this.snote = snote;
	}

	public String getScodeDipartim() {
		return this.scodeDipartim;
	}

	public void setScodeDipartim(String scodeDipartim) {
		this.scodeDipartim = scodeDipartim;
	}

	public Integer getIbaseline() {
		return this.ibaseline;
	}

	public void setIbaseline(Integer ibaseline) {
		this.ibaseline = ibaseline;
	}

	public Integer getIcaricamento() {
		return this.icaricamento;
	}

	public void setIcaricamento(Integer icaricamento) {
		this.icaricamento = icaricamento;
	}

	public Date getDateAgg() {
		return this.dateAgg;
	}

	public void setDateAgg(Date dateAgg) {
		this.dateAgg = dateAgg;
	}

	public String getSfunzAgg() {
		return this.sfunzAgg;
	}

	public void setSfunzAgg(String sfunzAgg) {
		this.sfunzAgg = sfunzAgg;
	}

	public Integer getIenabled() {
		return this.ienabled;
	}

	public void setIenabled(Integer ienabled) {
		this.ienabled = ienabled;
	}

}
