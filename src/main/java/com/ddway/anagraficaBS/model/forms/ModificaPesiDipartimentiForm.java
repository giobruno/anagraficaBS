package com.ddway.anagraficaBS.model.forms;

import java.util.ArrayList;
import java.util.List;

public class ModificaPesiDipartimentiForm {
	
	private List<String> valoriPesiList = new ArrayList<String>();
	
	public ModificaPesiDipartimentiForm(){}

	public List<String> getValoriPesiList() {
		return valoriPesiList;
	}

	public void setValoriPesiList(List<String> valoriPesiList) {
		this.valoriPesiList = valoriPesiList;
	}
	
	

}
