package com.ddway.anagraficaBS.model.db.anagraficaBS;

import org.springframework.stereotype.Service;

@Service
public class Authorities implements java.io.Serializable {

	private AuthoritiesId id;

	public Authorities() {
	}

	public Authorities(AuthoritiesId id) {
		this.id = id;
	}

	public AuthoritiesId getId() {
		return this.id;
	}

	public void setId(AuthoritiesId id) {
		this.id = id;
	}

}
