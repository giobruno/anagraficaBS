package com.ddway.anagraficaBS.utility;

import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ddway.anagraficaBS.model.db.DBusinessServices;
import com.ddway.anagraficaBS.model.db.DDipartimenti;
import com.ddway.anagraficaBS.model.db.DProcessi;
import com.ddway.anagraficaBS.model.db.DServiziFunzioni;
import com.ddway.anagraficaBS.model.db.DServiziFunzioniId;
import com.ddway.anagraficaBS.model.db.DServiziProcessi;
import com.ddway.anagraficaBS.model.db.DServiziProcessiId;
import com.ddway.anagraficaBS.model.db.Users;
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
				user.setNome(registrazioneForm.getNome());
				user.setCognome(registrazioneForm.getCognome());
				user.setUsername(registrazioneForm.getUser());
				user.setEmail(registrazioneForm.getEmail());
				user.setPassword(registrazioneForm.getPassword());
				user.setEnabled(true);				
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
				dProcessi.setDataValiditaInizio(new Date());
				dProcessi.setDataValiditaFine(null);							
			}
			
		}catch(Exception e){
			log.error(e.getMessage()+" on PopolaModelDb.popolaDProcessiBean!");
			throw e;
		}		
	}
	
	public void popolaDBusinessServiceBean(BusinessServiceForm businessServiceForm, DBusinessServices dBusinessService) throws Exception{
		log.info("Inizio metodo PopolaModelDb.popolaDBusinessServiceBea!");
		
		try{
			if(businessServiceForm != null){
				dBusinessService.setCodiDipartimento(Integer.parseInt(businessServiceForm.getCodiDipartimento()));
				dBusinessService.setDescBusinessService(businessServiceForm.getDescBusinessService());
				dBusinessService.setTextNomeBusinessService(businessServiceForm.getTextNomeBusinessService());
				dBusinessService.setPersRespBusinessService(businessServiceForm.getPersRespBusinessService());
				dBusinessService.setTextUrlBusinessService(businessServiceForm.getTextUrlBusinessService());		
				dBusinessService.setFlagConvenzione(businessServiceForm.getFlagConvenzione());
				dBusinessService.setDataValiditaInizio(new Date());
				dBusinessService.setDataValiditaFine(null);							
			}
			
		}catch(Exception e){
			log.error(e.getMessage()+" on PopolaModelDb.popolaDBusinessServiceBea!");
			throw e;
		}		
	}
	
	public void popolaDServiziProcessiBean(AssociazioneBSProcessoForm associazioneBSProcessoForm, DServiziProcessi dServiziProcessi) throws Exception{
		log.info("Inizio metodo PopolaModelDb.popolaDServiziProcessiBean!");
		
		try{
			if(associazioneBSProcessoForm != null){	
				dServiziProcessiId.setCodiBusinessService(Integer.parseInt(associazioneBSProcessoForm.getCodiBusinessService()));
				dServiziProcessiId.setCodiProcesso(Integer.parseInt(associazioneBSProcessoForm.getCodiProcesso()));
				dServiziProcessiId.setCodiCategoriaMac(Integer.parseInt(associazioneBSProcessoForm.getCodiCategoriaMac()));
				dServiziProcessiId.setCodiCategoriaInfr(Integer.parseInt(associazioneBSProcessoForm.getCodiCategoriaInfr()));
				dServiziProcessiId.setDataInizioValidita(new Date());
				dServiziProcessi.setId(dServiziProcessiId);
				dServiziProcessi.setDataFineValidita(null);
				dServiziProcessi.setMisuTmpLavorativo(associazioneBSProcessoForm.getMisuTmpLavorativo());
				dServiziProcessi.setMisuTmpSolare(associazioneBSProcessoForm.getMisuTmpSolare());
				dServiziProcessi.setOrarioLavFine(new Date());
				dServiziProcessi.setOrarioLavIni(new Date());				
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
		
		String codiFunzione;
		int codiArea;
		int codiApplicazione;
		String descApplicazione;
		String descArea;
		String descFunzione;		
		
		try{
			if(elencoFunzioniForm != null && ricercaFunzioniUtenteForm != null && dServiziFunzioniList != null){
				
				if(ricercaFunzioniUtenteForm.getCodiApplicazione() != null && !ricercaFunzioniUtenteForm.getCodiApplicazione().equalsIgnoreCase("")){
					codiApplicazione = Integer.parseInt(ricercaFunzioniUtenteForm.getCodiApplicazione());
					descApplicazione = gestioneDataBase.getDescApplicazione(codiApplicazione);
					dServiziFunzioniId.setCodiApplicazione(codiApplicazione);
					dServiziFunzioni.setDescApplicazione(descApplicazione);
				}					
				codiArea = Integer.parseInt(ricercaFunzioniUtenteForm.getCodiArea());				
				descArea = gestioneDataBase.getDescArea(codiArea);				
				
				dServiziFunzioniId.setCodiBusinessService(codiBusinessService);								
				dServiziFunzioniId.setCodiArea(codiArea);				
				dServiziFunzioniId.setDataInizioAssociazione(new Date());				
				dServiziFunzioni.setDescArea(descArea);	
				
				for(int i=0;i<elencoFunzioniForm.getFunzioniDaInserire().size();i++){
					codiFunzione = elencoFunzioniForm.getFunzioniDaInserire().get(i);
					dServiziFunzioniId.setCodiFunzione(Integer.parseInt(codiFunzione));
					dServiziFunzioni.setId(dServiziFunzioniId);
					descFunzione = gestioneDataBase.getDescFunzione(Integer.parseInt(codiFunzione));
					dServiziFunzioni.setDescFunzione(descFunzione);
					
					dServiziFunzioniList.add(dServiziFunzioni);
				}				
			}			
		}catch(Exception e){
			log.error(e.getMessage()+" on PopolaModelDb.popolaDServiziFunzioniBeanList!");
			throw e;
		}		
	}

}
