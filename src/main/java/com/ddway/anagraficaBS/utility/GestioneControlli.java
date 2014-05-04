package com.ddway.anagraficaBS.utility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ddway.anagraficaBS.model.bean.ModelApplicativoPiuBSAssoicatiBean;

@Service
public class GestioneControlli {
	
	@Autowired
	GestioneDataBase gestioneDataBase;
	
	@Autowired
	PopolaModelBeans popolaModelBeans;

	private static final Logger log = LoggerFactory.getLogger(GestioneControlli.class);
	
	public GestioneControlli(){}
	
	@Transactional
	public void controlloValidit‡ModelAplicativi(HttpSession session) throws Exception{
		log.info("Inizio metodo GestioneControlli.controlloValidit‡ModelAplicativi!");		
		
		List<ModelApplicativoPiuBSAssoicatiBean> modelApplicativiNonValidi;
		List<ModelApplicativoPiuBSAssoicatiBean> modelApplicativiNonValidiConBSAssociati = new ArrayList<ModelApplicativoPiuBSAssoicatiBean>();
		ModelApplicativoPiuBSAssoicatiBean modelApplicativoPiuBSAssoicatiBean;
		
		Iterator itr;
		
		try{
			modelApplicativiNonValidi = popolaModelBeans.popolaModelApplicativoPiuBSAssoicatiBean("non_validi");
			itr = modelApplicativiNonValidi.iterator();
			while(itr.hasNext()){
				modelApplicativoPiuBSAssoicatiBean = (ModelApplicativoPiuBSAssoicatiBean) itr.next();
				if(modelApplicativoPiuBSAssoicatiBean.getBusinessServiceBeanList() != null && !modelApplicativoPiuBSAssoicatiBean.getBusinessServiceBeanList().isEmpty())
					modelApplicativiNonValidiConBSAssociati.add(modelApplicativoPiuBSAssoicatiBean);
			}
			if(!modelApplicativiNonValidiConBSAssociati.isEmpty())
				session.setAttribute("modelApplicativiNonValidiConBSAssociati", modelApplicativiNonValidiConBSAssociati);
		}catch(Exception e){
			e.printStackTrace();
			log.info(e+" on method GestioneControlli.controlloValidit‡ModelAplicativi!");
			throw e;
		}
	}
}
