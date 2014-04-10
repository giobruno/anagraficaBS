package com.ddway.anagraficaBS.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ddway.anagraficaBS.model.db.DBusinessServices;
import com.ddway.anagraficaBS.model.db.DProcessi;
import com.ddway.anagraficaBS.model.db.DServiziFunzioni;
import com.ddway.anagraficaBS.model.db.DServiziFunzioniId;
import com.ddway.anagraficaBS.model.db.DServiziModel;
import com.ddway.anagraficaBS.model.db.DServiziProcessiId;
import com.ddway.anagraficaBS.model.forms.BusinessServiceForm;
import com.ddway.anagraficaBS.model.forms.ProcessoForm;

@Service
public class PopolaModelForms {
	
	private static final Logger log = LoggerFactory.getLogger(PopolaModelForms.class);
	
	@Autowired
	DServiziProcessiId dServiziProcessiId;
	
	@Autowired
	DServiziFunzioniId dServiziFunzioniId;
	
	@Autowired
	DServiziFunzioni dServiziFunzioni;	
	
	public PopolaModelForms() {}
	
	public void popolaBusinessServiceForm(DBusinessServices dBusinessService, DServiziModel dServiziModel,BusinessServiceForm businessServiceForm) throws Exception{
		log.info("Inizio metodo PopolaModelForms.popolaBusinessServiceForm!");
		
		try{
			if(dBusinessService != null && dServiziModel != null){
				businessServiceForm.setCodiBusinessServiceOld(dBusinessService.getCodiBusinessService()+"");
				businessServiceForm.setTextNomeBusinessService(dBusinessService.getTextNomeBusinessService());
				businessServiceForm.setCodiDipartimento(dBusinessService.getCodiDipartimento()+"");
				businessServiceForm.setDescBusinessService(dBusinessService.getDescBusinessService());
				businessServiceForm.setPersRespBusinessService(dBusinessService.getPersRespBusinessService());
				businessServiceForm.setTextUrlBusinessService(dBusinessService.getTextUrlBusinessService());
				businessServiceForm.setCodiModelApplicativo(dServiziModel.getCodiModelApplicativo()+"");
				businessServiceForm.setFlagConvenzione(dBusinessService.getFlagConvenzione());								
			}			
		}catch(Exception e){
			log.error(e.getMessage()+" on PopolaModelForms.popolaBusinessServiceForm!");
			throw e;
		}		
	}
	
	public void popolaProcessoForm(DProcessi dprocessi,ProcessoForm processoForm) throws Exception{
		log.info("Inizio metodo PopolaModelForms.popolaProcessoForm!");
		
		try{
			if(processoForm != null && dprocessi != null){
				processoForm.setDescProcesso(dprocessi.getDescProcesso());
				processoForm.setTextSiglaProcesso(dprocessi.getTextSiglaProcesso());
			}			
		}catch(Exception e){
			log.error(e.getMessage()+" on PopolaModelForms.popolaProcessoForm!");
			throw e;
		}		
	}
}