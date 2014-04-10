package com.ddway.anagraficaBS.model.db;

import org.springframework.stereotype.Service;

@Service
public class VInfap implements java.io.Serializable {

	private VInfapId id;

	public VInfap() {
	}

	public VInfap(VInfapId id) {
		this.id = id;
	}

	public VInfapId getId() {
		return this.id;
	}

	public void setId(VInfapId id) {
		this.id = id;
	}

}
