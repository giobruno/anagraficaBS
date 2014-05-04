package com.ddway.anagraficaBS.utility;

import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ddway.anagraficaBS.model.bean.AssociazioneBSProcessoBean;
import com.ddway.anagraficaBS.model.bean.BusinessServiceBean;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DBusinessServices;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DModelApplicativi;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DProcessi;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DServiziFunzioni;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DServiziFunzioniId;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DServiziModel;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DServiziProcessi;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DServiziProcessiId;
import com.ddway.anagraficaBS.model.db.anagraficaBS.Users;
import com.ddway.anagraficaBS.model.forms.AccountForm;
import com.ddway.anagraficaBS.model.forms.AssociazioneBSProcessoForm;
import com.ddway.anagraficaBS.model.forms.BusinessServiceForm;
import com.ddway.anagraficaBS.model.forms.ModificaPasswordForm;
import com.ddway.anagraficaBS.model.forms.ProcessoForm;
import com.ddway.anagraficaBS.model.forms.RegistrazioneForm;

@Service
public class PopolaModelForms {
	
	private static final Logger log = LoggerFactory.getLogger(PopolaModelForms.class);
	
	@Autowired
	DServiziProcessiId dServiziProcessiId;
	
	@Autowired
	DServiziFunzioniId dServiziFunzioniId;
	
	@Autowired
	DServiziFunzioni dServiziFunzioni;	
	
	@Autowired
	GestioneDataBase gestioneDataBase;
	
	public PopolaModelForms() {}
	
	public void popolaBusinessServiceForm(DBusinessServices dBusinessService, DServiziModel dServiziModel,BusinessServiceForm businessServiceForm) throws Exception{
		log.info("Inizio metodo PopolaModelForms.popolaBusinessServiceForm!");
		
		try{
			if(dBusinessService != null && dServiziModel != null){
				businessServiceForm.setCodiBusinessServiceOld(dBusinessService.getCodiBusinessService()+"");
				businessServiceForm.setTextNomeBusinessService(dBusinessService.getTextNomeBusinessService());
				businessServiceForm.setCodiDipartimento(dBusinessService.getDDipartimenti().getCodiDipartimento()+"");
				businessServiceForm.setDescBusinessService(dBusinessService.getDescBusinessService());
				businessServiceForm.setPersRespBusinessService(dBusinessService.getPersRespBusinessService());
				businessServiceForm.setTextUrlBusinessService(dBusinessService.getTextUrlBusinessService());
				businessServiceForm.setCodiModelApplicativo(dServiziModel.getDModelApplicativi().getCodiModelApplicativo()+"");
				businessServiceForm.setFlagConvenzione(dBusinessService.getFlagConvenzione());								
			}			
		}catch(Exception e){
			log.error(e.getMessage()+" on PopolaModelForms.popolaBusinessServiceForm!");
			throw e;
		}		
	}
	
	public void popolaAssociazioneBSProcessoForm(DServiziProcessi dServiziProcessi,AssociazioneBSProcessoForm associazioneBSProcessoForm) throws Exception{
		log.info("Inizio metodo PopolaModelForms.popolaAssociazioneBSProcessoForm!");
		
		try{
			if(dServiziProcessi != null && associazioneBSProcessoForm != null){
				associazioneBSProcessoForm.setCodiBusinessServiceOld(dServiziProcessi.getDBusinessServices().getCodiBusinessService()+"");
				associazioneBSProcessoForm.setCodiBusinessService(dServiziProcessi.getDBusinessServices().getCodiBusinessService()+"");				
				associazioneBSProcessoForm.setCodiCategoriaInfr(dServiziProcessi.getDCategorieInfr().getCodiCategoriaInfr()+"");
				associazioneBSProcessoForm.setCodiCategoriaMac(dServiziProcessi.getDCategorieMac().getCodiCategoriaMac()+"");
				associazioneBSProcessoForm.setCodiProcesso(dServiziProcessi.getDProcessi().getCodiProcesso()+"");
				associazioneBSProcessoForm.setOrarioLavIniOre(dServiziProcessi.getOrarioLavIni().getHours()+"");	
				associazioneBSProcessoForm.setOrarioLavIniMinuti(dServiziProcessi.getOrarioLavIni().getMinutes()+"");
				associazioneBSProcessoForm.setOrarioLavFineOre(dServiziProcessi.getOrarioLavFine().getHours()+"");	
				associazioneBSProcessoForm.setOrarioLavFineMinuti(dServiziProcessi.getOrarioLavFine().getMinutes()+"");				
				associazioneBSProcessoForm.setMisuTmpLavorativoMinuti(dServiziProcessi.getMisuTmpLavorativo().toString());
				associazioneBSProcessoForm.setMisuTmpLavorativoOre("");				
				associazioneBSProcessoForm.setMisuTmpSolareMinuti(dServiziProcessi.getMisuTmpSolare().toString());
				associazioneBSProcessoForm.setMisuTmpSolareOre("");
			}			
		}catch(Exception e){
			log.error(e.getMessage()+" on PopolaModelForms.popolaAssociazioneBSProcessoForm!");
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
	
	public void popolaAssociazioneBSProcessoBeanList(List<DServiziProcessi> dserviziProcessiList,List<AssociazioneBSProcessoBean> associazioneBSProcessoBeanList) throws Exception{
		log.info("Inizio metodo PopolaModelForms.popolaAssociazioneBSProcessoBeanList!");
		
		Iterator<DServiziProcessi> itr = dserviziProcessiList.iterator();
		DServiziProcessi dServiziProcessi;
		AssociazioneBSProcessoBean associazioneBSProcessoBean;
		
		try{
			if(dserviziProcessiList != null){				
				while(itr.hasNext()){
					associazioneBSProcessoBean = new AssociazioneBSProcessoBean();
					dServiziProcessi = (DServiziProcessi) itr.next();
					associazioneBSProcessoBean.setCodiBusinessService(dServiziProcessi.getId().getCodiBusinessService());
					associazioneBSProcessoBean.setCodiCategoriaInfr(dServiziProcessi.getId().getCodiCategoriaInfr());
					associazioneBSProcessoBean.setCodiCategoriaMac(dServiziProcessi.getId().getCodiCategoriaMac());
					associazioneBSProcessoBean.setCodiProcesso(dServiziProcessi.getId().getCodiProcesso());
					associazioneBSProcessoBean.setDataInizioValidita(dServiziProcessi.getId().getDataInizioValidita());
					associazioneBSProcessoBean.setDataFineValidita(dServiziProcessi.getDProcessi().getDataFineValidita() == null ? null: dServiziProcessi.getDProcessi().getDataFineValidita()+"");					
					associazioneBSProcessoBean.setTextSiglaProcesso(dServiziProcessi.getDProcessi().getTextSiglaProcesso());
					associazioneBSProcessoBean.setDescProcesso(dServiziProcessi.getDProcessi().getDescProcesso());
					associazioneBSProcessoBeanList.add(associazioneBSProcessoBean);					
				}
			}			
		}catch(Exception e){
			log.error(e.getMessage()+" on PopolaModelForms.popolaAssociazioneBSProcessoBeanList!");
			throw e;
		}
		
	}
	
	@Transactional
	public void popolaListaBusinessService(List<DBusinessServices> businessServiceList,List<BusinessServiceBean> businessServiceBeanList) throws Exception{
		log.info("Inizio metodo PopolaModelForms.popolaListaBusinessService!");
		
		Iterator itr;
		DBusinessServices dbusinessService;
		BusinessServiceBean businessServiceBean;
		
		try{
			if(businessServiceList != null && !businessServiceList.isEmpty()){
				itr = businessServiceList.iterator();
				while(itr.hasNext()){
					businessServiceBean = new BusinessServiceBean();
					dbusinessService = (DBusinessServices) itr.next();
					businessServiceBean.setCodiBusinessService(dbusinessService.getCodiBusinessService()+"");
					businessServiceBean.setTextNomeBusinessService(dbusinessService.getTextNomeBusinessService());
					businessServiceBean.setPersRespBusinessService(dbusinessService.getPersRespBusinessService());
					businessServiceBean.setFlagConvenzione(dbusinessService.getFlagConvenzione());
					businessServiceBean.setTextSiglaDipartimento(dbusinessService.getDDipartimenti().getTextSiglaDipartimento());
					
					DServiziModel dServiziModel = gestioneDataBase.getModelApplicativoFromDServiziModel(dbusinessService.getCodiBusinessService()+"");
					DModelApplicativi dModelApplicativo = gestioneDataBase.getModelApplicativoFromDModelApplicativi(dServiziModel.getDModelApplicativi().getCodiModelApplicativo()+"");
					
					businessServiceBean.setDescModelApplicativo(dModelApplicativo.getDescModelApplicativo());		
					businessServiceBeanList.add(businessServiceBean);
				}
			}
		}catch(Exception e){
			log.error(e.getMessage()+" on PopolaModelForms.popolaListaBusinessService!");
			throw e;
		}		
	}
	
	@Transactional
	public void popolaBusinessServiceBean(DBusinessServices dbusinessService,BusinessServiceBean businessServiceBean) throws Exception{
		log.info("Inizio metodo PopolaModelForms.popolaBusinessServiceBean!");
		
		try{
			if(dbusinessService != null){							
					businessServiceBean.setCodiBusinessService(dbusinessService.getCodiBusinessService()+"");
					businessServiceBean.setDescBusinessService(dbusinessService.getDescBusinessService());
					businessServiceBean.setTextNomeBusinessService(dbusinessService.getTextNomeBusinessService());
					businessServiceBean.setTextUrlBusinessService(dbusinessService.getTextUrlBusinessService());
					businessServiceBean.setPersRespBusinessService(dbusinessService.getPersRespBusinessService());
					businessServiceBean.setFlagConvenzione(dbusinessService.getFlagConvenzione());
					businessServiceBean.setTextSiglaDipartimento(dbusinessService.getDDipartimenti().getTextSiglaDipartimento());
					
					DServiziModel dServiziModel = gestioneDataBase.getModelApplicativoFromDServiziModel(dbusinessService.getCodiBusinessService()+"");
					DModelApplicativi dModelApplicativo = gestioneDataBase.getModelApplicativoFromDModelApplicativi(dServiziModel.getDModelApplicativi().getCodiModelApplicativo()+"");
					
					businessServiceBean.setDescModelApplicativo(dModelApplicativo.getDescModelApplicativo());					
			}
		}catch(Exception e){
			log.error(e.getMessage()+" on PopolaModelForms.popolaBusinessServiceBean!");
			throw e;
		}		
	}
	
	public void popolaRegistrazioneForm(Users users,RegistrazioneForm registrazioneForm) throws Exception{
		log.info("Inizio metodo PopolaModelForms.popolaRegistrazioneForm!");		
		
		try{
			if(users != null){	
				registrazioneForm.setUserId(users.getUserId().toString());
				registrazioneForm.setNome(users.getNome());
				registrazioneForm.setCognome(users.getCognome());				
				registrazioneForm.setEmail(users.getEmail());		
				registrazioneForm.setUsername(users.getUsername());
			}
		}catch(Exception e){
			log.error(e.getMessage()+" on PopolaModelForms.popolaRegistrazioneForm!");
			throw e;
		}		
	}	
	
	public void popolaModificaPasswordForm(Users users,ModificaPasswordForm modificaPasswordForm) throws Exception{
		log.info("Inizio metodo PopolaModelForms.popolaModificaPasswordForm!");		
		
		try{
			if(users != null){	
				modificaPasswordForm.setUserId(users.getUserId().toString());
				modificaPasswordForm.setNome(users.getNome());
				modificaPasswordForm.setCognome(users.getCognome());				
				modificaPasswordForm.setEmail(users.getEmail());		
				modificaPasswordForm.setUsername(users.getUsername());
				modificaPasswordForm.setOldPassword(users.getPassword());
			}
		}catch(Exception e){
			log.error(e.getMessage()+" on PopolaModelForms.popolaModificaPasswordForm!");
			throw e;
		}		
	}	
	
	public void popolaAccountForm(Users user,AccountForm accountForm) throws Exception{
		log.info("Inizio metodo PopolaModelForms.popolaAccountForm!");		
		
		try{
			if(user != null){		
				accountForm.setUserId(user.getUserId().toString());
				accountForm.setNome(user.getNome());
				accountForm.setCognome(user.getCognome());				
				accountForm.setEmail(user.getEmail());		
				accountForm.setUsername(user.getUsername());
				accountForm.setPassword(user.getPassword());
			}
		}catch(Exception e){
			log.error(e.getMessage()+" on PopolaModelForms.popolaAccountForm!");
			throw e;
		}		
	}	
}