package com.ddway.anagraficaBS.utility;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ddway.anagraficaBS.model.db.Authorities;
import com.ddway.anagraficaBS.model.db.AuthoritiesId;
import com.ddway.anagraficaBS.model.db.DBusinessServices;
import com.ddway.anagraficaBS.model.db.DProcessi;
import com.ddway.anagraficaBS.model.db.DServiziFunzioni;
import com.ddway.anagraficaBS.model.db.DServiziModel;
import com.ddway.anagraficaBS.model.db.DServiziModelId;
import com.ddway.anagraficaBS.model.db.DServiziProcessi;
import com.ddway.anagraficaBS.model.db.Users;
import com.ddway.anagraficaBS.model.db.VInfap;
import com.ddway.anagraficaBS.model.forms.BusinessServiceForm;
import com.ddway.anagraficaBS.model.forms.ProcessoForm;
import com.ddway.anagraficaBS.service.IDataSourceService;

@Service
public class GestioneDataBase {
	
	private static final Logger log = LoggerFactory.getLogger(GestioneDataBase.class);
	
	@Autowired
	IDataSourceService dataSourceService;	
	
	@Autowired
	PopolaModelDb popolaModelDb;
	
	@Autowired
	DServiziFunzioni dServiziFunzioni;
	
	@Autowired
	DBusinessServices dBusinessService;
	
	@Autowired
	DProcessi dProcessi;
	
	public GestioneDataBase() {}
	
	@Transactional
	public void registraUtente(Users user) throws Exception{
		log.info("Inizio metodo GestioneDataBase.registraUtente!");
		
		String query = "from com.ddway.anagraficaBS.model.db.Users tab order by tab.userId desc";		
		int idUser = 0;
		
		try{							
			dataSourceService.insert(user);
			List<Object> maxidUser = (List<Object>) dataSourceService.genericquery(query);
			if(maxidUser != null && !maxidUser.isEmpty()){
				user = (Users) maxidUser.get(0);
				idUser = user.getUserId();
			}
			dataSourceService.insert(new Authorities(new AuthoritiesId(2, idUser)));
		}catch(Exception e){
			log.error(e.getMessage()+" on GestioneDataBase.registraUtente");
			throw e;
			}
		}
	
	@Transactional
	public void inserisciProcesso(DProcessi dProcessi) throws Exception{
		log.info("Inizio metodo GestioneDataBase.inserisciProcesso!");
		
		try{							
			dataSourceService.insert(dProcessi);			
			
		}catch(Exception e){
			log.error(e.getMessage()+" on GestioneDataBase.inserisciProcesso");
			throw e;
			}
		}
	
	@Transactional
	public int inserisciBusinessService(BusinessServiceForm businessServiceForm) throws Exception{
		log.info("Inizio metodo GestioneDataBase.inserisciBusinessService!");
		
		String query = "from com.ddway.anagraficaBS.model.db.DBusinessServices tab order by tab.codiBusinessService desc";		
		int codiBusinessService = 0;
		
		try{							
			popolaModelDb.popolaDBusinessServiceBean(businessServiceForm,dBusinessService);
			dataSourceService.insert(dBusinessService);
			
			List<Object> maxCodiBusinessService = (List<Object>) dataSourceService.genericquery(query);
			if(maxCodiBusinessService != null && !maxCodiBusinessService.isEmpty()){
				dBusinessService = (DBusinessServices) maxCodiBusinessService.get(0);
				codiBusinessService = dBusinessService.getCodiBusinessService();
			}
			dataSourceService.insert(new DServiziModel(new DServiziModelId(codiBusinessService, new Date()),Integer.parseInt(businessServiceForm.getCodiModelApplicativo()),null));
		}catch(Exception e){
			log.error(e.getMessage()+" on GestioneDataBase.inserisciBusinessService");
			throw e;
			}
		return codiBusinessService;
		}
	
	@Transactional
	public int modificaBusinessService(BusinessServiceForm businessServiceForm,DBusinessServices businessServiceFormOld) throws Exception{
		log.info("Inizio metodo GestioneDataBase.modificaBusinessService!");
		
		String query;
		int codiBusinessService = 0;	
		
		try{		
			businessServiceFormOld.setDataValiditaFine(new Date());
			dataSourceService.update(businessServiceFormOld);
			popolaModelDb.popolaDBusinessServiceBean(businessServiceForm,dBusinessService);
			dataSourceService.insert(dBusinessService);
			
			query = "from com.ddway.anagraficaBS.model.db.DBusinessServices tab order by tab.codiBusinessService desc";
			List<Object> maxCodiBusinessService = (List<Object>) dataSourceService.genericquery(query);
			if(maxCodiBusinessService != null && !maxCodiBusinessService.isEmpty()){
				dBusinessService = (DBusinessServices) maxCodiBusinessService.get(0);
				codiBusinessService = dBusinessService.getCodiBusinessService();
			}
			dataSourceService.insert(new DServiziModel(new DServiziModelId(codiBusinessService, new Date()),Integer.parseInt(businessServiceForm.getCodiModelApplicativo()),null));
		}catch(Exception e){
			log.error(e.getMessage()+" on GestioneDataBase.modificaBusinessService");
			throw e;
			}
		return codiBusinessService;
	}
	
	@Transactional
	public int modificaProcesso(ProcessoForm processoForm,DProcessi processoOld) throws Exception{
		log.info("Inizio metodo GestioneDataBase.modificaProcesso!");
		
		String query;
		int codiBusinessService = 0;	
		
		try{		
			processoOld.setDataValiditaFine(new Date());
			dataSourceService.update(processoOld);
			popolaModelDb.popolaDProcessiBean(processoForm, dProcessi);
			dataSourceService.insert(dProcessi);			
		}catch(Exception e){
			log.error(e.getMessage()+" on GestioneDataBase.modificaProcesso");
			throw e;
			}
		return codiBusinessService;
	}
	
	@Transactional
	public void cancellaBusinessService(DBusinessServices businessService) throws Exception{
		log.info("Inizio metodo GestioneDataBase.cancellaBusinessService!");		
		
		try{
			businessService.setDataValiditaFine(new Date());
			dataSourceService.update(businessService);
		}catch(Exception e){
			log.error(e.getMessage()+" on GestioneDataBase.cancellaBusinessService");
			throw e;
			}		
	}
	
	@Transactional
	public void cancellaProcesso(DProcessi dProcessi) throws Exception{
		log.info("Inizio metodo GestioneDataBase.cancellaProcesso!");		
		
		try{
			dProcessi.setDataValiditaFine(new Date());
			dataSourceService.update(dProcessi);
		}catch(Exception e){
			log.error(e.getMessage()+" on GestioneDataBase.cancellaProcesso");
			throw e;
			}		
	}
	
	
		
		@Transactional
		public void inserisciAssociazioniBSFunzUtente(List<DServiziFunzioni> dServiziFunzioniList) throws Exception{
			log.info("Inizio metodo GestioneDataBase.inserisciAssociazioneBSFunzUtente!");			
			
			Iterator<DServiziFunzioni> itr;
			try{											
				itr = dServiziFunzioniList.iterator();
				while(itr.hasNext())
					dataSourceService.insert(itr.next());				
				
			}catch(Exception e){
				log.error(e.getMessage()+" on GestioneDataBase.inserisciAssociazioneBSFunzUtente");
				throw e;
				}
			}
		
		@Transactional
		public void inserisciAssociazioneBSProcesso(DServiziProcessi dServiziProcessi) throws Exception{
			log.info("Inizio metodo GestioneDataBase.inserisciAssociazioneBSProcesso!");		
			
			try{											
				dataSourceService.insert(dServiziProcessi);
				
			}catch(Exception e){
				log.error(e.getMessage()+" on GestioneDataBase.inserisciAssociazioneBSProcesso");
				throw e;
				}
			}
			

		@Transactional
		public String getDescApplicazione(int codiApplicazione) throws Exception{
			log.info("Inizio metodo GestioneDataBase.getDescApplicazione!");		
			
			String query = "Select tab.id.descApplicazione from com.ddway.anagraficaBS.model.db.VInfap tab where tab.id.codiApplicazione = '"+codiApplicazione+"'";
			String descApplicazione = ""; 
			
			try{											
				Object ob = dataSourceService.genericquery(query);
				descApplicazione = "descApplicazione";
			}catch(Exception e){
				log.error(e.getMessage()+" on GestioneDataBase.getDescApplicazione");
				throw e;
				}
			return descApplicazione;
			}
		
		@Transactional
		public String getDescArea(int codiArea) throws Exception{
			log.info("Inizio metodo GestioneDataBase.getDescArea!");		
			
			String query = "Select tab.id.descArea from com.ddway.anagraficaBS.model.db.VInfap tab where tab.id.codiArea = '"+codiArea+"' order by tab.id.descFunzione";
			String descArea = "";
			
			try{											
				Object ob = dataSourceService.genericquery(query);
				descArea = "descArea";
				
			}catch(Exception e){
				log.error(e.getMessage()+" on GestioneDataBase.getDescArea");
				throw e;
				}
			return descArea;
			}
		
		@Transactional
		public String getDescFunzione(int codiFunzione) throws Exception{
			log.info("Inizio metodo GestioneDataBase.getDescArea!");		
			
			String query = "Select tab.id.descFunzione from com.ddway.anagraficaBS.model.db.VInfap tab where tab.id.codiFunzione = '"+codiFunzione+"' order by tab.id.descFunzione";
			String descFunzione = "";
			
			try{											
				Object ob = dataSourceService.genericquery(query);
				descFunzione = "descFunzione";
				
			}catch(Exception e){
				log.error(e.getMessage()+" on GestioneDataBase.getDescFunzione");
				throw e;
				}
			return descFunzione;
			}
		
		@Transactional
		public  List<VInfap> getListaFunzioniUtente(String codiArea, String codiApplicazione) throws Exception{
			log.debug("Start GestioneDataBase.getListaFunzioniUtente method");
			
			List<VInfap> codiFunzioneList;
			String query;
			
			try{			
				if(codiApplicazione != null && !codiApplicazione.equalsIgnoreCase(""))
					query = "from com.ddway.anagraficaBS.model.db.VInfap tab where tab.id.codiArea = '"+codiArea+"' and tab.id.codiApplicazione = '"+codiApplicazione+"' order by tab.id.descFunzione";
				else query = "from com.ddway.anagraficaBS.model.db.VInfap tab where tab.id.codiArea = '"+codiArea+"' order by tab.id.descFunzione";
				codiFunzioneList = (List<VInfap>) dataSourceService.genericquery(query);				
			}catch(Exception e){
				log.error(e.getMessage()+" on GestioneDataBase.getListaFunzioniUtente");
				throw e;
			}
			return codiFunzioneList;	
		}
		
		@Transactional
		public  List<DBusinessServices> getElencoBusinessServices() throws Exception{
			log.debug("Start GestioneDataBase.getElencoBusinessServices method");
			
			List<DBusinessServices> elencoBusinessServices;
			String query = "from com.ddway.anagraficaBS.model.db.DBusinessServices tab where tab.dataValiditaFine is null order by tab.descBusinessService";
			
			try{		
				elencoBusinessServices = (List<DBusinessServices>) dataSourceService.genericquery(query);								
			}catch(Exception e){
				log.error(e.getMessage()+" on GestioneDataBase.getListaFunzioniUtente");
				throw e;
			}
			return elencoBusinessServices;	
		}
		
		@Transactional
		public  List<DProcessi> getElencoProcessi() throws Exception{
			log.debug("Start GestioneDataBase.getElencoProcessi method");
			
			List<DProcessi> elencoProcessi;
			String query = "from com.ddway.anagraficaBS.model.db.DProcessi tab where tab.dataValiditaFine is null order by tab.descProcesso";
			
			try{		
				elencoProcessi = (List<DProcessi>) dataSourceService.genericquery(query);								
			}catch(Exception e){
				log.error(e.getMessage()+" on GestioneDataBase.getElencoProcessi");
				throw e;
			}
			return elencoProcessi;	
		}
		
		@Transactional
		public  DBusinessServices getBusinessServices(String cosiBusinessServise) throws Exception{
			log.debug("Start GestioneDataBase.getBusinessServices method");
			
			List<DBusinessServices> elencoBusinessServices;
			String query = "from com.ddway.anagraficaBS.model.db.DBusinessServices tab where tab.codiBusinessService = '"+cosiBusinessServise+"'";
			
			try{		
				elencoBusinessServices = (List<DBusinessServices>) dataSourceService.genericquery(query);
				if(elencoBusinessServices == null || elencoBusinessServices.isEmpty())
					throw new Exception("Nessun Business Service trovato con il codice "+cosiBusinessServise);
			}catch(Exception e){
				log.error(e.getMessage()+" on GestioneDataBase.getListaFunzioniUtente");
				throw e;
			}
			return elencoBusinessServices.get(0);	
		}
		
		@Transactional
		public  DServiziModel getModelApplicativo(String cosiBusinessServise) throws Exception{
			log.debug("Start GestioneDataBase.getModelApplicativo method");
			
			List<DServiziModel> modelApplicativoList;
			String query = "from com.ddway.anagraficaBS.model.db.DServiziModel tab where tab.id.codiBusinessService = '"+cosiBusinessServise+"'";
			
			try{		
				modelApplicativoList = (List<DServiziModel>) dataSourceService.genericquery(query);
				if(modelApplicativoList == null || modelApplicativoList.isEmpty())
					throw new Exception("Nessun Model Applicativo trovato con il codice Business Service "+cosiBusinessServise);
			}catch(Exception e){
				log.error(e.getMessage()+" on GestioneDataBase.getModelApplicativo");
				throw e;
			}
			return modelApplicativoList.get(0);	
		}
		
		@Transactional
		public  DProcessi getProcesso(String cosiProcesso) throws Exception{
			log.debug("Start GestioneDataBase.getProcesso method");
			
			List<DProcessi> elencoProcessi;
			String query = "from com.ddway.anagraficaBS.model.db.DProcessi tab where tab.codiProcesso = '"+cosiProcesso+"'";
			
			try{		
				elencoProcessi = (List<DProcessi>) dataSourceService.genericquery(query);
				if(elencoProcessi == null || elencoProcessi.isEmpty())
					throw new Exception("Nessun Processo trovato con il codice "+cosiProcesso);
			}catch(Exception e){
				log.error(e.getMessage()+" on GestioneDataBase.getProcesso");
				throw e;
			}
			return elencoProcessi.get(0);	
		}
		
		@Transactional
		public  List<DServiziFunzioni> getListaAssociazioniFunzioniUtenteBS(String codiBusinessService) throws Exception{
			log.debug("Start GestioneDataBase.getListaAssociazioniFunzioniUtenteBS method");
			
			List<DServiziFunzioni> elencoFunzioni;
			String query = "from com.ddway.anagraficaBS.model.db.DServiziFunzioni tab where tab.id.codiBusinessService = '"+codiBusinessService+"'";
			
			try{		
				elencoFunzioni = (List<DServiziFunzioni>) dataSourceService.genericquery(query);				
			}catch(Exception e){
				log.error(e.getMessage()+" on GestioneDataBase.getListaAssociazioniFunzioniUtenteBS");
				throw e;
			}
			return elencoFunzioni;	
		}
		
		@Transactional
		public  List<DServiziProcessi> getListaAssociazioniProcessiBS(String codiBusinessService) throws Exception{
			log.debug("Start GestioneDataBase.getListaAssociazioniProcessiBS method");
			
			List<DServiziProcessi> elencoProcessi;
			String query = "from com.ddway.anagraficaBS.model.db.DServiziProcessi tab where tab.id.codiBusinessService = '"+codiBusinessService+"'";
			
			try{		
				elencoProcessi = (List<DServiziProcessi>) dataSourceService.genericquery(query);				
			}catch(Exception e){
				log.error(e.getMessage()+" on GestioneDataBase.getListaAssociazioniProcessiBS");
				throw e;
			}
			return elencoProcessi;	
		}
	}
