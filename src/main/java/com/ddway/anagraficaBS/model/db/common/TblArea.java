package com.ddway.anagraficaBS.model.db.common;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class TblArea implements java.io.Serializable {

	private Integer idTblArea;
	private String scodeArea;
	private String sdescrizione;
	private Date dateStart;
	private Date dateEnd;
	private String snote;
	private Integer idTblDipartim;
	private Character indAreaProg;
	private Date dateAgg;
	private String sfunzAgg;
	private int ienabled;
	private Integer iconfigured;
	private Character notificaEmail;
	private Integer istrutturacartelle;
	private Integer iassegnatari;

	public TblArea() {
	}

	public TblArea(String scodeArea, int ienabled) {
		this.scodeArea = scodeArea;
		this.ienabled = ienabled;
	}

	public TblArea(String scodeArea, String sdescrizione, Date dateStart,
			Date dateEnd, String snote, Integer idTblDipartim,
			Character indAreaProg, Date dateAgg, String sfunzAgg, int ienabled,
			Integer iconfigured, Character notificaEmail,
			Integer istrutturacartelle, Integer iassegnatari) {
		this.scodeArea = scodeArea;
		this.sdescrizione = sdescrizione;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.snote = snote;
		this.idTblDipartim = idTblDipartim;
		this.indAreaProg = indAreaProg;
		this.dateAgg = dateAgg;
		this.sfunzAgg = sfunzAgg;
		this.ienabled = ienabled;
		this.iconfigured = iconfigured;
		this.notificaEmail = notificaEmail;
		this.istrutturacartelle = istrutturacartelle;
		this.iassegnatari = iassegnatari;
	}

	public Integer getIdTblArea() {
		return this.idTblArea;
	}

	public void setIdTblArea(Integer idTblArea) {
		this.idTblArea = idTblArea;
	}

	public String getScodeArea() {
		return this.scodeArea;
	}

	public void setScodeArea(String scodeArea) {
		this.scodeArea = scodeArea;
	}

	public String getSdescrizione() {
		return this.sdescrizione;
	}

	public void setSdescrizione(String sdescrizione) {
		this.sdescrizione = sdescrizione;
	}

	public Date getDateStart() {
		return this.dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return this.dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getSnote() {
		return this.snote;
	}

	public void setSnote(String snote) {
		this.snote = snote;
	}

	public Integer getIdTblDipartim() {
		return this.idTblDipartim;
	}

	public void setIdTblDipartim(Integer idTblDipartim) {
		this.idTblDipartim = idTblDipartim;
	}

	public Character getIndAreaProg() {
		return this.indAreaProg;
	}

	public void setIndAreaProg(Character indAreaProg) {
		this.indAreaProg = indAreaProg;
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

	public int getIenabled() {
		return this.ienabled;
	}

	public void setIenabled(int ienabled) {
		this.ienabled = ienabled;
	}

	public Integer getIconfigured() {
		return this.iconfigured;
	}

	public void setIconfigured(Integer iconfigured) {
		this.iconfigured = iconfigured;
	}

	public Character getNotificaEmail() {
		return this.notificaEmail;
	}

	public void setNotificaEmail(Character notificaEmail) {
		this.notificaEmail = notificaEmail;
	}

	public Integer getIstrutturacartelle() {
		return this.istrutturacartelle;
	}

	public void setIstrutturacartelle(Integer istrutturacartelle) {
		this.istrutturacartelle = istrutturacartelle;
	}

	public Integer getIassegnatari() {
		return this.iassegnatari;
	}

	public void setIassegnatari(Integer iassegnatari) {
		this.iassegnatari = iassegnatari;
	}

}
