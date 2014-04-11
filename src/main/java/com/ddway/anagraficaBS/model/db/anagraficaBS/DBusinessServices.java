package com.ddway.anagraficaBS.model.db.anagraficaBS;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class DBusinessServices implements java.io.Serializable {

	private Integer codiBusinessService;
	private DDipartimenti DDipartimenti;
	private String textNomeBusinessService;
	private String descBusinessService;
	private Date dataValiditaInizio;
	private Date dataValiditaFine;
	private String persRespBusinessService;
	private String textUrlBusinessService;
	private Boolean flagConvenzione;
	private Set<DServiziProcessi> DServiziProcessis = new HashSet<DServiziProcessi>(
			0);
	private Set<DServiziFunzioni> DServiziFunzionis = new HashSet<DServiziFunzioni>(
			0);
	private Set<DServiziModel> DServiziModels = new HashSet<DServiziModel>(0);

	public DBusinessServices() {
	}

	public DBusinessServices(DDipartimenti DDipartimenti) {
		this.DDipartimenti = DDipartimenti;
	}

	public DBusinessServices(DDipartimenti DDipartimenti,
			String textNomeBusinessService, String descBusinessService,
			Date dataValiditaInizio, Date dataValiditaFine,
			String persRespBusinessService, String textUrlBusinessService,
			Boolean flagConvenzione, Set<DServiziProcessi> DServiziProcessis,
			Set<DServiziFunzioni> DServiziFunzionis,
			Set<DServiziModel> DServiziModels) {
		this.DDipartimenti = DDipartimenti;
		this.textNomeBusinessService = textNomeBusinessService;
		this.descBusinessService = descBusinessService;
		this.dataValiditaInizio = dataValiditaInizio;
		this.dataValiditaFine = dataValiditaFine;
		this.persRespBusinessService = persRespBusinessService;
		this.textUrlBusinessService = textUrlBusinessService;
		this.flagConvenzione = flagConvenzione;
		this.DServiziProcessis = DServiziProcessis;
		this.DServiziFunzionis = DServiziFunzionis;
		this.DServiziModels = DServiziModels;
	}

	public Integer getCodiBusinessService() {
		return this.codiBusinessService;
	}

	public void setCodiBusinessService(Integer codiBusinessService) {
		this.codiBusinessService = codiBusinessService;
	}

	public DDipartimenti getDDipartimenti() {
		return this.DDipartimenti;
	}

	public void setDDipartimenti(DDipartimenti DDipartimenti) {
		this.DDipartimenti = DDipartimenti;
	}

	public String getTextNomeBusinessService() {
		return this.textNomeBusinessService;
	}

	public void setTextNomeBusinessService(String textNomeBusinessService) {
		this.textNomeBusinessService = textNomeBusinessService;
	}

	public String getDescBusinessService() {
		return this.descBusinessService;
	}

	public void setDescBusinessService(String descBusinessService) {
		this.descBusinessService = descBusinessService;
	}

	public Date getDataValiditaInizio() {
		return this.dataValiditaInizio;
	}

	public void setDataValiditaInizio(Date dataValiditaInizio) {
		this.dataValiditaInizio = dataValiditaInizio;
	}

	public Date getDataValiditaFine() {
		return this.dataValiditaFine;
	}

	public void setDataValiditaFine(Date dataValiditaFine) {
		this.dataValiditaFine = dataValiditaFine;
	}

	public String getPersRespBusinessService() {
		return this.persRespBusinessService;
	}

	public void setPersRespBusinessService(String persRespBusinessService) {
		this.persRespBusinessService = persRespBusinessService;
	}

	public String getTextUrlBusinessService() {
		return this.textUrlBusinessService;
	}

	public void setTextUrlBusinessService(String textUrlBusinessService) {
		this.textUrlBusinessService = textUrlBusinessService;
	}

	public Boolean getFlagConvenzione() {
		return this.flagConvenzione;
	}

	public void setFlagConvenzione(Boolean flagConvenzione) {
		this.flagConvenzione = flagConvenzione;
	}

	public Set<DServiziProcessi> getDServiziProcessis() {
		return this.DServiziProcessis;
	}

	public void setDServiziProcessis(Set<DServiziProcessi> DServiziProcessis) {
		this.DServiziProcessis = DServiziProcessis;
	}

	public Set<DServiziFunzioni> getDServiziFunzionis() {
		return this.DServiziFunzionis;
	}

	public void setDServiziFunzionis(Set<DServiziFunzioni> DServiziFunzionis) {
		this.DServiziFunzionis = DServiziFunzionis;
	}

	public Set<DServiziModel> getDServiziModels() {
		return this.DServiziModels;
	}

	public void setDServiziModels(Set<DServiziModel> DServiziModels) {
		this.DServiziModels = DServiziModels;
	}

}
