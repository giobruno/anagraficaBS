package com.ddway.anagraficaBS.model.db.anagraficaBS;

import org.springframework.stereotype.Service;

// Generated Apr 17, 2014 2:11:56 PM by Hibernate Tools 3.4.0.CR1

/**
 * Authorities generated by hbm2java
 */
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
