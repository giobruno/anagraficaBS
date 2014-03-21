package com.ddway.anagraficaBS.model.bean;

public class Restriction {
	
	private String propertyName;
	private Object value;
	
	public Restriction(){};
	
	public Restriction(String propertyName,Object value){
		this.propertyName = propertyName;
		this.value = value;
	}
	

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
