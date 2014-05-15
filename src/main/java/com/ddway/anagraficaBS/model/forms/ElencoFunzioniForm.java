package com.ddway.anagraficaBS.model.forms;

import java.util.List;
import org.springframework.stereotype.Service;

import com.ddway.anagraficaBS.model.bean.TriplaInfap;


@Service
public class ElencoFunzioniForm {
	
	private String[] funzioniDaInserire;
	
	public ElencoFunzioniForm(){};
	
	public ElencoFunzioniForm(String[] funzioniDaInserire){
		
		this.funzioniDaInserire = funzioniDaInserire;
	}

	public String[] getFunzioniDaInserire() {
		return funzioniDaInserire;
	}

	public void setFunzioniDaInserire(String[] funzioniDaInserire) {
		this.funzioniDaInserire = funzioniDaInserire;
	}

	
}
