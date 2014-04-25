package com.ddway.anagraficaBS.model.forms;

import java.util.List;
import org.springframework.stereotype.Service;

import com.ddway.anagraficaBS.model.bean.TriplaInfap;


@Service
public class ElencoFunzioniForm {
	
	private List<String> funzioniDaInserire;
	
	public ElencoFunzioniForm(){};
	
	public ElencoFunzioniForm(List<String> funzioniDaInserire){
		
		this.funzioniDaInserire = funzioniDaInserire;
	}

	public List<String> getFunzioniDaInserire() {
		return funzioniDaInserire;
	}

	public void setFunzioniDaInserire(List<String> funzioniDaInserire) {
		this.funzioniDaInserire = funzioniDaInserire;
	}	
}
