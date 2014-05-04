package com.ddway.anagraficaBS.model.bean;

import java.util.List;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DModelApplicativi;

public class ModelApplicativoPiuBSAssoicatiBean {
	
	DModelApplicativi modelApplicativo;
	List<BusinessServiceBean> businessServiceBeanList;
	
	public ModelApplicativoPiuBSAssoicatiBean(){}
	
	public ModelApplicativoPiuBSAssoicatiBean(DModelApplicativi modelApplicativo,List<BusinessServiceBean> businessServiceBeanList){
		
		this.modelApplicativo = modelApplicativo;
		this.businessServiceBeanList = businessServiceBeanList;
	}

	public DModelApplicativi getModelApplicativo() {
		return modelApplicativo;
	}

	public void setModelApplicativo(DModelApplicativi modelApplicativo) {
		this.modelApplicativo = modelApplicativo;
	}

	public List<BusinessServiceBean> getBusinessServiceBeanList() {
		return businessServiceBeanList;
	}

	public void setBusinessServiceBeanList(
			List<BusinessServiceBean> businessServiceBeanList) {
		this.businessServiceBeanList = businessServiceBeanList;
	}	
}
