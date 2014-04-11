package com.ddway.anagraficaBS.model.db.infap;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class TblElementoFzDett implements java.io.Serializable {

	private Integer idTblElementoFzDett;
	private String scodeAreaUtilizz;
	private String scodeApplicazioneUtilizz;
	private String scodeFunzioneUtilizz;
	private String scodeAreaPropriet;
	private String scodeApplicazionePropriet;
	private String scodeFunzionePropriet;
	private String scodeElementoFz;
	private String scodeObiet;
	private Date dateStart;
	private Date dateEnd;
	private Integer iriusoInterno;
	private Integer iriusoEsterno;
	private String stipo;
	private Double dnumeroDet;
	private Double dnumeroFtr;
	private String stipoVers;
	private String scomplessita;
	private Double dufp;
	private Double dufpRInt;
	private Double dufpREst;
	private Integer ibaseline;
	private Integer icaricamento;
	private Integer ierr;
	private Date dateAgg;
	private String sfunzAgg;
	private Integer ienabled;

	public TblElementoFzDett() {
	}

	public TblElementoFzDett(String scodeAreaUtilizz,
			String scodeApplicazioneUtilizz, String scodeFunzioneUtilizz,
			String scodeAreaPropriet, String scodeApplicazionePropriet,
			String scodeFunzionePropriet, String scodeElementoFz,
			String scodeObiet, Date dateStart) {
		this.scodeAreaUtilizz = scodeAreaUtilizz;
		this.scodeApplicazioneUtilizz = scodeApplicazioneUtilizz;
		this.scodeFunzioneUtilizz = scodeFunzioneUtilizz;
		this.scodeAreaPropriet = scodeAreaPropriet;
		this.scodeApplicazionePropriet = scodeApplicazionePropriet;
		this.scodeFunzionePropriet = scodeFunzionePropriet;
		this.scodeElementoFz = scodeElementoFz;
		this.scodeObiet = scodeObiet;
		this.dateStart = dateStart;
	}

	public TblElementoFzDett(String scodeAreaUtilizz,
			String scodeApplicazioneUtilizz, String scodeFunzioneUtilizz,
			String scodeAreaPropriet, String scodeApplicazionePropriet,
			String scodeFunzionePropriet, String scodeElementoFz,
			String scodeObiet, Date dateStart, Date dateEnd,
			Integer iriusoInterno, Integer iriusoEsterno, String stipo,
			Double dnumeroDet, Double dnumeroFtr, String stipoVers,
			String scomplessita, Double dufp, Double dufpRInt, Double dufpREst,
			Integer ibaseline, Integer icaricamento, Integer ierr,
			Date dateAgg, String sfunzAgg, Integer ienabled) {
		this.scodeAreaUtilizz = scodeAreaUtilizz;
		this.scodeApplicazioneUtilizz = scodeApplicazioneUtilizz;
		this.scodeFunzioneUtilizz = scodeFunzioneUtilizz;
		this.scodeAreaPropriet = scodeAreaPropriet;
		this.scodeApplicazionePropriet = scodeApplicazionePropriet;
		this.scodeFunzionePropriet = scodeFunzionePropriet;
		this.scodeElementoFz = scodeElementoFz;
		this.scodeObiet = scodeObiet;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.iriusoInterno = iriusoInterno;
		this.iriusoEsterno = iriusoEsterno;
		this.stipo = stipo;
		this.dnumeroDet = dnumeroDet;
		this.dnumeroFtr = dnumeroFtr;
		this.stipoVers = stipoVers;
		this.scomplessita = scomplessita;
		this.dufp = dufp;
		this.dufpRInt = dufpRInt;
		this.dufpREst = dufpREst;
		this.ibaseline = ibaseline;
		this.icaricamento = icaricamento;
		this.ierr = ierr;
		this.dateAgg = dateAgg;
		this.sfunzAgg = sfunzAgg;
		this.ienabled = ienabled;
	}

	public Integer getIdTblElementoFzDett() {
		return this.idTblElementoFzDett;
	}

	public void setIdTblElementoFzDett(Integer idTblElementoFzDett) {
		this.idTblElementoFzDett = idTblElementoFzDett;
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

	public String getScodeFunzioneUtilizz() {
		return this.scodeFunzioneUtilizz;
	}

	public void setScodeFunzioneUtilizz(String scodeFunzioneUtilizz) {
		this.scodeFunzioneUtilizz = scodeFunzioneUtilizz;
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

	public String getScodeFunzionePropriet() {
		return this.scodeFunzionePropriet;
	}

	public void setScodeFunzionePropriet(String scodeFunzionePropriet) {
		this.scodeFunzionePropriet = scodeFunzionePropriet;
	}

	public String getScodeElementoFz() {
		return this.scodeElementoFz;
	}

	public void setScodeElementoFz(String scodeElementoFz) {
		this.scodeElementoFz = scodeElementoFz;
	}

	public String getScodeObiet() {
		return this.scodeObiet;
	}

	public void setScodeObiet(String scodeObiet) {
		this.scodeObiet = scodeObiet;
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

	public Integer getIriusoInterno() {
		return this.iriusoInterno;
	}

	public void setIriusoInterno(Integer iriusoInterno) {
		this.iriusoInterno = iriusoInterno;
	}

	public Integer getIriusoEsterno() {
		return this.iriusoEsterno;
	}

	public void setIriusoEsterno(Integer iriusoEsterno) {
		this.iriusoEsterno = iriusoEsterno;
	}

	public String getStipo() {
		return this.stipo;
	}

	public void setStipo(String stipo) {
		this.stipo = stipo;
	}

	public Double getDnumeroDet() {
		return this.dnumeroDet;
	}

	public void setDnumeroDet(Double dnumeroDet) {
		this.dnumeroDet = dnumeroDet;
	}

	public Double getDnumeroFtr() {
		return this.dnumeroFtr;
	}

	public void setDnumeroFtr(Double dnumeroFtr) {
		this.dnumeroFtr = dnumeroFtr;
	}

	public String getStipoVers() {
		return this.stipoVers;
	}

	public void setStipoVers(String stipoVers) {
		this.stipoVers = stipoVers;
	}

	public String getScomplessita() {
		return this.scomplessita;
	}

	public void setScomplessita(String scomplessita) {
		this.scomplessita = scomplessita;
	}

	public Double getDufp() {
		return this.dufp;
	}

	public void setDufp(Double dufp) {
		this.dufp = dufp;
	}

	public Double getDufpRInt() {
		return this.dufpRInt;
	}

	public void setDufpRInt(Double dufpRInt) {
		this.dufpRInt = dufpRInt;
	}

	public Double getDufpREst() {
		return this.dufpREst;
	}

	public void setDufpREst(Double dufpREst) {
		this.dufpREst = dufpREst;
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

	public Integer getIerr() {
		return this.ierr;
	}

	public void setIerr(Integer ierr) {
		this.ierr = ierr;
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
