package com.ddway.anagraficaBS.model.forms;

import org.springframework.stereotype.Service;

@Service
public class ProcessoForm {
	
	private String textSiglaProcesso;
	private String descProcesso;
	
	public ProcessoForm(){}
	
	public ProcessoForm(String textSiglaProcesso,String descProcesso){
		
		this.textSiglaProcesso = textSiglaProcesso;
		this.descProcesso = descProcesso;
	}

	public String getTextSiglaProcesso() {
		return textSiglaProcesso;
	}

	public void setTextSiglaProcesso(String textSiglaProcesso) {
		this.textSiglaProcesso = textSiglaProcesso;
	}

	public String getDescProcesso() {
		return descProcesso;
	}

	public void setDescProcesso(String descProcesso) {
		this.descProcesso = descProcesso;
	}	
}
