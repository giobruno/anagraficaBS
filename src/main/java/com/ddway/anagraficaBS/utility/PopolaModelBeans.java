package com.ddway.anagraficaBS.utility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ddway.anagraficaBS.model.bean.BusinessServiceBean;
import com.ddway.anagraficaBS.model.bean.ModelApplicativoPiuBSAssoicatiBean;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DBusinessServices;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DModelApplicativi;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DServiziFunzioni;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DServiziFunzioniId;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DServiziModel;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DServiziProcessiId;

@Service
public class PopolaModelBeans {
	
private static final Logger log = LoggerFactory.getLogger(PopolaModelBeans.class);
	
	@Autowired
	DServiziProcessiId dServiziProcessiId;
	
	@Autowired
	DServiziFunzioniId dServiziFunzioniId;
	
	@Autowired
	DServiziFunzioni dServiziFunzioni;
	
	@Autowired
	GestioneDataBase gestioneDataBase;
	
	public PopolaModelBeans() {}
	
	@Transactional
	public List<ModelApplicativoPiuBSAssoicatiBean> popolaModelApplicativoPiuBSAssoicatiBean(String tipoModelApplicativi) throws Exception{
		log.info("Inizio metodo PopolaModelDb.popolaModelApplicativoPiuBSAssoicatiBean!");
		
		Iterator itr1;
		Iterator itr2;
		List<DServiziModel> dServiziModelList;
		DServiziModel dServiziModel;
		List<DModelApplicativi> modelApplicativiList;
		DModelApplicativi modelApplicativo;
		List<ModelApplicativoPiuBSAssoicatiBean> modelApplicativoPiuBSAssoicatiBeanList = new ArrayList<ModelApplicativoPiuBSAssoicatiBean>();
		ModelApplicativoPiuBSAssoicatiBean modelApplicativoPiuBSAssoicatiBean;
		List<BusinessServiceBean> businessServiceBeanList;
		BusinessServiceBean businessServiceBean;
		
		
		try{
			if(tipoModelApplicativi.equalsIgnoreCase("validi"))
				modelApplicativiList = gestioneDataBase.getElencoModelApplicativi();
			else modelApplicativiList = gestioneDataBase.getElencoModelApplicativiNonValidi();
			if(modelApplicativiList != null && !modelApplicativiList.isEmpty()){
			itr1 = modelApplicativiList.iterator();
			while(itr1.hasNext()){
				modelApplicativo = (DModelApplicativi) itr1.next();
				businessServiceBeanList = new ArrayList<BusinessServiceBean>();
				dServiziModelList = gestioneDataBase.getElencoDServiziModel(modelApplicativo.getCodiModelApplicativo());
				if(dServiziModelList != null && !dServiziModelList.isEmpty()){					
					itr2 = dServiziModelList.iterator();
					while(itr2.hasNext()){
						dServiziModel = (DServiziModel) itr2.next();
						businessServiceBean = new BusinessServiceBean();
						businessServiceBean.setCodiBusinessService(dServiziModel.getDBusinessServices().getCodiBusinessService().toString());
						businessServiceBean.setTextNomeBusinessService(dServiziModel.getDBusinessServices().getTextNomeBusinessService());
						businessServiceBeanList.add(businessServiceBean);
					}			
					modelApplicativoPiuBSAssoicatiBean = new ModelApplicativoPiuBSAssoicatiBean();
					modelApplicativoPiuBSAssoicatiBean.setModelApplicativo(modelApplicativo);
					modelApplicativoPiuBSAssoicatiBean.setBusinessServiceBeanList(businessServiceBeanList);
					modelApplicativoPiuBSAssoicatiBeanList.add(modelApplicativoPiuBSAssoicatiBean);
				}					
			}
			}
		}catch(Exception e){
			log.error(e.getMessage()+" on PopolaModelDb.popolaModelApplicativoPiuBSAssoicatiBean!");
			throw e;
		}		
		return modelApplicativoPiuBSAssoicatiBeanList;
	}

}
