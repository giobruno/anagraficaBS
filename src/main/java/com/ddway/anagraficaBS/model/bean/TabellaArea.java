package com.ddway.anagraficaBS.model.bean;

public class TabellaArea {

	private Integer idTblArea;
	private String scodeArea;
	private String sdescrizione;
	private String scodedescrizione;
	
	public TabellaArea(){}
	
	public TabellaArea(Integer idTblArea,
					String scodeArea,
					String sdescrizione,String scodedescrizione){
		
		this.idTblArea = idTblArea;
		this.scodeArea = scodeArea;
		this.sdescrizione = sdescrizione;
		this.scodedescrizione = scodedescrizione;
	}
	
	public String getScodedescrizione() {
		return scodedescrizione;
	}

	public void setScodedescrizione(String scodedescrizione) {
		this.scodedescrizione = scodedescrizione;
	}

	public Integer getIdTblArea() {
		return idTblArea;
	}

	public void setIdTblArea(Integer idTblArea) {
		this.idTblArea = idTblArea;
	}

	public String getScodeArea() {
		return scodeArea;
	}

	public void setScodeArea(String scodeArea) {
		this.scodeArea = scodeArea;
	}

	public String getSdescrizione() {
		return sdescrizione;
	}

	public void setSdescrizione(String sdescrizione) {
		this.sdescrizione = sdescrizione;
	}
	
	
}
