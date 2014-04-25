package com.ddway.anagraficaBS.utility;

import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DBusinessServices;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DCategorieInfr;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DCategorieMac;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DDipartimenti;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DProcessi;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DServiziFunzioni;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DServiziFunzioniId;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DServiziProcessi;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DServiziProcessiId;
import com.ddway.anagraficaBS.model.db.anagraficaBS.Users;
import com.ddway.anagraficaBS.model.forms.AssociazioneBSFunzUtenteForm;
import com.ddway.anagraficaBS.model.forms.AssociazioneBSProcessoForm;
import com.ddway.anagraficaBS.model.forms.BusinessServiceForm;
import com.ddway.anagraficaBS.model.forms.ElencoFunzioniForm;
import com.ddway.anagraficaBS.model.forms.ProcessoForm;
import com.ddway.anagraficaBS.model.forms.RegistrazioneForm;
import com.ddway.anagraficaBS.model.forms.RicercaFunzioniUtenteForm;

@Service
public class PopolaModelDb {
	
	private static final Logger log = LoggerFactory.getLogger(PopolaModelDb.class);
	
	@Autowired
	DServiziProcessiId dServiziProcessiId;
	
	@Autowired
	DServiziFunzioniId dServiziFunzioniId;
	
	@Autowired
	DServiziFunzioni dServiziFunzioni;
	
	@Autowired
	GestioneDataBase gestioneDataBase;
	
	public PopolaModelDb() {}
	
	public void popolaUsersBean(RegistrazioneForm registrazioneForm, Users user) throws Exception{
		log.info("Inizio metodo PopolaModelDb.popolaUsersBean!");
		
		try{
			if(registrazioneForm != null){
				if(registrazioneForm.getUserId() != null && !registrazioneForm.getUserId().equalsIgnoreCase(""))
					user.setUserId(Integer.parseInt(registrazioneForm.getUserId()));
				user.setNome(registrazioneForm.getNome());
				user.setCognome(registrazioneForm.getCognome());
				user.setUsername(registrazioneForm.getUser());
				user.setEmail(registrazioneForm.getEmail());
				user.setPassword(registrazioneForm.getPassword());							
			}
			
		}catch(Exception e){
			log.error(e.getMessage()+" on PopolaModelDb.popolaUsersBean!");
			throw e;
		}		
	}
	
	public void popolaDProcessiBean(ProcessoForm processoForm, DProcessi dProcessi) throws Exception{
		log.info("Inizio metodo PopolaModelDb.popolaDProcessiBean!");
		
		try{
			if(processoForm != null){
				dProcessi.setTextSiglaProcesso(processoForm.getTextSiglaProcesso());
				dProcessi.setDescProcesso(processoForm.getDescProcesso());
				dProcessi.setDataInizioValidita(new Date());
				dProcessi.setDataFineValidita(null);							
			}			
		}catch(Exception e){
			log.error(e.getMessage()+" on PopolaModelDb.popolaDProcessiBean!");
			throw e;
		}		
	}
	
	public void popolaDBusinessServiceBean(DBusinessServices businessServiceFormOld,BusinessServiceForm businessServiceForm, DBusinessServices dBusinessService) throws Exception{
		log.info("Inizio metodo PopolaModelDb.popolaDBusinessServiceBean!");
		
		try{
			if(businessServiceForm != null){
				if(businessServiceFormOld != null){
					dBusinessService.setCodiBusinessService(businessServiceFormOld.getCodiBusinessService());	
					dBusinessService.setFlagConvenzione(businessServiceFormOld.getFlagConvenzione());
				}
				else dBusinessService.setFlagConvenzione(businessServiceForm.getFlagConvenzione());
				dBusinessService.setDDipartimenti(new DDipartimenti(Integer.parseInt(businessServiceForm.getCodiDipartimento())));
				dBusinessService.setDescBusinessService(businessServiceForm.getDescBusinessService());
				dBusinessService.setTextNomeBusinessService(businessServiceForm.getTextNomeBusinessService());
				dBusinessService.setPersRespBusinessService(businessServiceForm.getPersRespBusinessService());
				dBusinessService.setTextUrlBusinessService(businessServiceForm.getTextUrlBusinessService());					
				dBusinessService.setDataInizioValidita(new Date());
				dBusinessService.setDataFineValidita(null);						
			}			
		}catch(Exception e){
			log.error(e.getMessage()+" on PopolaModelDb.popolaDBusinessServiceBean!");
			throw e;
		}		
	}
	
	public void popolaDServiziProcessiBean(AssociazioneBSProcessoForm associazioneBSProcessoForm, DServiziProcessi dServiziProcessi) throws Exception{
		log.info("Inizio metodo PopolaModelDb.popolaDServiziProcessiBean!");
		
		DProcessi dProcessi;
		DBusinessServices dBusinessServices;
		DCategorieInfr dCategorieInfr;
		DCategorieMac dCategorieMac;
		DServiziProcessiId dServiziProcessiId = new DServiziProcessiId();
		
		try{
			if(associazioneBSProcessoForm != null){	
				
				dProcessi = gestioneDataBase.getProcesso(associazioneBSProcessoForm.getCodiProcesso());
				dBusinessServices = gestioneDataBase.getBusinessServices(associazioneBSProcessoForm.getCodiBusinessServiceOld() != null ? associazioneBSProcessoForm.getCodiBusinessServiceOld()+"" : associazioneBSProcessoForm.getCodiBusinessService() );
				dCategorieInfr = gestioneDataBase.getCategorieInfr(associazioneBSProcessoForm.getCodiCategoriaInfr());
				dCategorieMac = gestioneDataBase.getCategorieMac(associazioneBSProcessoForm.getCodiCategoriaMac());
				dServiziProcessiId.setCodiBusinessService(associazioneBSProcessoForm.getCodiBusinessServiceOld() != null ? Integer.parseInt(associazioneBSProcessoForm.getCodiBusinessServiceOld()) : Integer.parseInt(associazioneBSProcessoForm.getCodiBusinessService()));
				dServiziProcessiId.setCodiProcesso(Integer.parseInt(associazioneBSProcessoForm.getCodiProcesso()));
				dServiziProcessiId.setCodiCategoriaMac(Integer.parseInt(associazioneBSProcessoForm.getCodiCategoriaMac()));
				dServiziProcessiId.setCodiCategoriaInfr(Integer.parseInt(associazioneBSProcessoForm.getCodiCategoriaInfr()));
				dServiziProcessiId.setDataInizioValidita(new Date());
				dServiziProcessi.setId(dServiziProcessiId);
				dServiziProcessi.setDProcessi(dProcessi);
				dServiziProcessi.setDBusinessServices(dBusinessServices);
				dServiziProcessi.setDCategorieInfr(dCategorieInfr);
				dServiziProcessi.setDCategorieMac(dCategorieMac);
				dServiziProcessi.setDataFineValidita(null);
				dServiziProcessi.setMisuTmpLavorativo((Integer.parseInt(associazioneBSProcessoForm.getMisuTmpLavorativoOre())*60)+Integer.parseInt(associazioneBSProcessoForm.getMisuTmpLavorativoMinuti()));
				dServiziProcessi.setMisuTmpSolare((Integer.parseInt(associazioneBSProcessoForm.getMisuTmpSolareOre())*60)+Integer.parseInt(associazioneBSProcessoForm.getMisuTmpSolareMinuti()));
				dServiziProcessi.setOrarioLavFine(new Date(0, 0, 0, Integer.parseInt(associazioneBSProcessoForm.getOrarioLavFineOre()), Integer.parseInt(associazioneBSProcessoForm.getOrarioLavFineMinuti())));
				dServiziProcessi.setOrarioLavIni(new Date(0, 0, 0, Integer.parseInt(associazioneBSProcessoForm.getOrarioLavIniOre()), Integer.parseInt(associazioneBSProcessoForm.getOrarioLavIniMinuti())));				
			}
			
		}catch(Exception e){
			log.error(e.getMessage()+" on PopolaModelDb.popolaDServiziProcessiBean!");
			throw e;
		}		
	}
	
	public void popolaDServiziFunzioniBean(AssociazioneBSFunzUtenteForm associazioneBSFunzUtenteForm, DServiziFunzioni dServiziFunzioni) throws Exception{
		log.info("Inizio metodo PopolaModelDb.popolaDServiziFunzioniBean!");
		
		try{
			if(associazioneBSFunzUtenteForm != null){	
				dServiziFunzioniId.setCodiApplicazione(Integer.parseInt(associazioneBSFunzUtenteForm.getCodiApplicazione()));
				dServiziFunzioniId.setCodiBusinessService(Integer.parseInt(associazioneBSFunzUtenteForm.getCodiBusinessService()));
				dServiziFunzioniId.setCodiArea(Integer.parseInt(associazioneBSFunzUtenteForm.getCodiArea()));				
				dServiziFunzioniId.setDataInizioAssociazione(new Date());
				dServiziFunzioni.setId(dServiziFunzioniId);
				dServiziFunzioni.setDataFineAssociazione(null);
				dServiziFunzioni.setDescApplicazione(associazioneBSFunzUtenteForm.getDescApplicazione());
				dServiziFunzioni.setDescArea(associazioneBSFunzUtenteForm.getDescArea());				
			}
			
		}catch(Exception e){
			log.error(e.getMessage()+" on PopolaModelDb.popolaDServiziFunzioniBean!");
			throw e;
		}		
	}	
	

	
	public void popolaDServiziFunzioniBeanList(ElencoFunzioniForm elencoFunzioniForm,int codiBusinessService,RicercaFunzioniUtenteForm ricercaFunzioniUtenteForm,List<DServiziFunzioni> dServiziFunzioniList) throws Exception{
		log.info("Inizio metodo PopolaModelDb.popolaDServiziFunzioniBeanList!");
		
		String[] funzioneSplit;
		DServiziFunzioniId dServiziFunzioneId;
		DServiziFunzioni dServiziFunzione;
		
		
		try{
			if(elencoFunzioniForm != null && ricercaFunzioniUtenteForm != null && dServiziFunzioniList != null){					
								
				for(int i=0;i<elencoFunzioniForm.getFunzioniDaInserire().size();i++){
					funzioneSplit = elencoFunzioniForm.getFunzioniDaInserire().get(i).split("/");
					dServiziFunzioneId = new DServiziFunzioniId();
					dServiziFunzioneId.setCodiBusinessService(codiBusinessService);
					dServiziFunzioneId.setDataInizioAssociazione(new Date());
					dServiziFunzioneId.setCodiArea(Integer.parseInt(funzioneSplit[0]));
					dServiziFunzioneId.setCodiApplicazione(Integer.parseInt(funzioneSplit[2]));
					dServiziFunzioneId.setCodiFunzione(Integer.parseInt(funzioneSplit[4]));
					dServiziFunzione = new DServiziFunzioni();
					dServiziFunzione.setId(dServiziFunzioneId);
					dServiziFunzione.setDataFineAssociazione(null);					
					dServiziFunzione.setDescArea(funzioneSplit[1]);
					dServiziFunzione.setDescApplicazione(funzioneSplit[3]);
					dServiziFunzione.setDescFunzione(funzioneSplit[5]);
					dServiziFunzioniList.add(dServiziFunzione);
				}				
			}			
		}catch(Exception e){
			log.error(e.getMessage()+" on PopolaModelDb.popolaDServiziFunzioniBeanList!");
			throw e;
		}		
	}

}
