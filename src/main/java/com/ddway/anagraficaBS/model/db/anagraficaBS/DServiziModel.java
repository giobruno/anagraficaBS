package com.ddway.anagraficaBS.model.db.anagraficaBS;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class DServiziModel implements java.io.Serializable {

	private DServiziModelId id;
	private DModelApplicativi DModelApplicativi;
	private DBusinessServices DBusinessServices;
	private Date dataFineAssociazione;

	public DServiziModel() {
	}

	public DServiziModel(DServiziModelId id, DBusinessServices DBusinessServices) {
		this.id = id;
		this.DBusinessServices = DBusinessServices;
	}

	public DServiziModel(DServiziModelId id,
			DModelApplicativi DModelApplicativi,
			DBusinessServices DBusinessServices, Date dataFineAssociazione) {
		this.id = id;
		this.DModelApplicativi = DModelApplicativi;
		this.DBusinessServices = DBusinessServices;
		this.dataFineAssociazione = dataFineAssociazione;
	}

	public DServiziModelId getId() {
		return this.id;
	}

	public void setId(DServiziModelId id) {
		this.id = id;
	}

	public DModelApplicativi getDModelApplicativi() {
		return this.DModelApplicativi;
	}

	public void setDModelApplicativi(DModelApplicativi DModelApplicativi) {
		this.DModelApplicativi = DModelApplicativi;
	}

	public DBusinessServices getDBusinessServices() {
		return this.DBusinessServices;
	}

	public void setDBusinessServices(DBusinessServices DBusinessServices) {
		this.DBusinessServices = DBusinessServices;
	}

	public Date getDataFineAssociazione() {
		return this.dataFineAssociazione;
	}

	public void setDataFineAssociazione(Date dataFineAssociazione) {
		this.dataFineAssociazione = dataFineAssociazione;
	}

}
