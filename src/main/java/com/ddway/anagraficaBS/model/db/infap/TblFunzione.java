package com.ddway.anagraficaBS.model.db.infap;


import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class TblFunzione implements java.io.Serializable {

	private Integer idTblFunzione;
	private String scodeAreaUtilizz;
	private String scodeApplicazioneUtilizz;
	private String scodeAreaPropriet;
	private String scodeApplicazionePropriet;
	private String scodeFunzione;
	private String sdescrizione;
	private String stipo;
	private String snote;
	private Integer ibaseline;
	private Integer icaricamento;
	private Date dateAgg;
	private String sfunzAgg;
	private Integer ienabled;

	public TblFunzione() {
	}

	public TblFunzione(String scodeAreaUtilizz,
			String scodeApplicazioneUtilizz, String scodeAreaPropriet,
			String scodeApplicazionePropriet, String scodeFunzione) {
		this.scodeAreaUtilizz = scodeAreaUtilizz;
		this.scodeApplicazioneUtilizz = scodeApplicazioneUtilizz;
		this.scodeAreaPropriet = scodeAreaPropriet;
		this.scodeApplicazionePropriet = scodeApplicazionePropriet;
		this.scodeFunzione = scodeFunzione;
	}

	public TblFunzione(String scodeAreaUtilizz,
			String scodeApplicazioneUtilizz, String scodeAreaPropriet,
			String scodeApplicazionePropriet, String scodeFunzione,
			String sdescrizione, String stipo, String snote, Integer ibaseline,
			Integer icaricamento, Date dateAgg, String sfunzAgg,
			Integer ienabled) {
		this.scodeAreaUtilizz = scodeAreaUtilizz;
		this.scodeApplicazioneUtilizz = scodeApplicazioneUtilizz;
		this.scodeAreaPropriet = scodeAreaPropriet;
		this.scodeApplicazionePropriet = scodeApplicazionePropriet;
		this.scodeFunzione = scodeFunzione;
		this.sdescrizione = sdescrizione;
		this.stipo = stipo;
		this.snote = snote;
		this.ibaseline = ibaseline;
		this.icaricamento = icaricamento;
		this.dateAgg = dateAgg;
		this.sfunzAgg = sfunzAgg;
		this.ienabled = ienabled;
	}

	public Integer getIdTblFunzione() {
		return this.idTblFunzione;
	}

	public void setIdTblFunzione(Integer idTblFunzione) {
		this.idTblFunzione = idTblFunzione;
	}

	public String getScodeAreaUtilizz() {
		return this.scodeAreaUtilizz;
	}

	public void setScodeAreaUtilizz(String scodeAreaUtilizz) {
		this.scodeAreaUtilizz = scodeAreaUtilizz;
	}

	public String getScodeApplicazioneUtilizz() {
		return this.scodeApplicazioneUtilizz;
	}

	public void setScodeApplicazioneUtilizz(String scodeApplicazioneUtilizz) {
		this.scodeApplicazioneUtilizz = scodeApplicazioneUtilizz;
	}

	public String getScodeAreaPropriet() {
		return this.scodeAreaPropriet;
	}

	public void setScodeAreaPropriet(String scodeAreaPropriet) {
		this.scodeAreaPropriet = scodeAreaPropriet;
	}

	public String getScodeApplicazionePropriet() {
		return this.scodeApplicazionePropriet;
	}

	public void setScodeApplicazionePropriet(String scodeApplicazionePropriet) {
		this.scodeApplicazionePropriet = scodeApplicazionePropriet;
	}

	public String getScodeFunzione() {
		return this.scodeFunzione;
	}

	public void setScodeFunzione(String scodeFunzione) {
		this.scodeFunzione = scodeFunzione;
	}

	public String getSdescrizione() {
		return this.sdescrizione;
	}

	public void setSdescrizione(String sdescrizione) {
		this.sdescrizione = sdescrizione;
	}

	public String getStipo() {
		return this.stipo;
	}

	public void setStipo(String stipo) {
		this.stipo = stipo;
	}

	public String getSnote() {
		return this.snote;
	}

	public void setSnote(String snote) {
		this.snote = snote;
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
