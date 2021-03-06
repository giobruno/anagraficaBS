package com.ddway.anagraficaBS.utility;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ddway.anagraficaBS.model.bean.TriplaInfap;
import com.ddway.anagraficaBS.model.db.anagraficaBS.Authorities;
import com.ddway.anagraficaBS.model.db.anagraficaBS.AuthoritiesId;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DBusinessServices;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DCategorieInfr;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DCategorieMac;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DDipartimenti;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DModelApplicativi;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DProcessi;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DServiziFunzioni;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DServiziFunzioniId;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DServiziModel;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DServiziModelId;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DServiziProcessi;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DServiziProcessiId;
import com.ddway.anagraficaBS.model.db.anagraficaBS.Users;
import com.ddway.anagraficaBS.model.forms.BusinessServiceForm;
import com.ddway.anagraficaBS.model.forms.ProcessoForm;
import com.ddway.anagraficaBS.model.forms.RicercaFunzioniUtenteForm;
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
	DProcessi dProcessi;
	
	@Autowired
	DServiziModel dServiziModel;
	
	@Autowired
	DModelApplicativi dModelApplicativo;
	
	public GestioneDataBase() {}
	
	@Transactional
	public void registraUtente(Users user) throws Exception{
		log.info("Inizio metodo GestioneDataBase.registraUtente!");
		
		String query = "from com.ddway.anagraficaBS.model.db.anagraficaBS.Users tab order by tab.userId desc";		
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
	public void abilitaUtente(Users user) throws Exception{
		log.info("Inizio metodo GestioneDataBase.abilitaUtente!");	
		
		try{				
			user.setEnabled(true);
			dataSourceService.update(user);			
		}catch(Exception e){
			log.error(e.getMessage()+" on GestioneDataBase.abilitaUtente");
			throw e;
			}
		}
	
	@Transactional
	public void cancellaUtente(Users user) throws Exception{
		log.info("Inizio metodo GestioneDataBase.abilitaUtente!");	
		
		AuthoritiesId authoritiesId = new AuthoritiesId();
		Authorities authorities;
		
		String query = "from com.ddway.anagraficaBS.model.db.anagraficaBS.Users tab order by tab.userId desc";
		
		try{				
			authoritiesId.setRoleId(1);
			authoritiesId.setUserId(user.getUserId());
			authorities = (Authorities) dataSourceService.findbyId(authoritiesId);
			dataSourceService.delete(authorities);
			dataSourceService.delete(user);			
		}catch(Exception e){
			log.error(e.getMessage()+" on GestioneDataBase.abilitaUtente");
			throw e;
			}
		}
	
	@Transactional
	public void modificaUtente(Users user) throws Exception{
		log.info("Inizio metodo GestioneDataBase.modificaUtente!");					
		
		try{					
			user.setEnabled(true);
			dataSourceService.update(user);			
		}catch(Exception e){
			log.error(e.getMessage()+" on GestioneDataBase.modificaUtente");
			throw e;
			}
		}
	
	@Transactional
	public void disabilitaUtente(Users user) throws Exception{
		log.info("Inizio metodo GestioneDataBase.disabilitaUtente!");	
		
		try{			
			user.setEnabled(false);
			dataSourceService.update(user);			
		}catch(Exception e){
			log.error(e.getMessage()+" on GestioneDataBase.disabilitaUtente");
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
		
		String query = "from com.ddway.anagraficaBS.model.db.anagraficaBS.DBusinessServices tab order by tab.codiBusinessService desc";		
		int codiBusinessService = 0;
		DBusinessServices dBusinessService = new DBusinessServices();
		
		try{							
			popolaModelDb.popolaDBusinessServiceBean(null,businessServiceForm,dBusinessService);
			dataSourceService.insert(dBusinessService);
			
			List<Object> maxCodiBusinessService = (List<Object>) dataSourceService.genericquery(query);
			if(maxCodiBusinessService != null && !maxCodiBusinessService.isEmpty()){
				dBusinessService = (DBusinessServices) maxCodiBusinessService.get(0);
				codiBusinessService = dBusinessService.getCodiBusinessService();				
			}
			DModelApplicativi dModelApplicativo = getModelApplicativo(businessServiceForm.getCodiModelApplicativo());
			dataSourceService.insert(new DServiziModel(new DServiziModelId(codiBusinessService, new Date()), dModelApplicativo, dBusinessService, null));
		}catch(Exception e){
			log.error(e.getMessage()+" on GestioneDataBase.inserisciBusinessService");
			throw e;
			}
		return codiBusinessService;
		}
	
	@Transactional
	public int modificaBusinessService(BusinessServiceForm businessServiceForm,BusinessServiceForm businessServiceFormOld) throws Exception{
		log.info("Inizio metodo GestioneDataBase.modificaBusinessService!");
		
		String query;
		int codiBusinessService = 0;	
		DServiziModel dServiziModel;			
		DBusinessServices dBusinessService = new DBusinessServices();
		
		try{			
			popolaModelDb.popolaDBusinessServiceBean(businessServiceFormOld,businessServiceForm,dBusinessService);
			dataSourceService.update(dBusinessService);
			
			if(!businessServiceFormOld.getCodiModelApplicativo().equalsIgnoreCase(businessServiceForm.getCodiModelApplicativo())){
				query = "from com.ddway.anagraficaBS.model.db.anagraficaBS.DServiziModel tab where tab.id.codiBusinessService = '"+businessServiceFormOld.getCodiBusinessServiceOld()+"' and tab.dataFineAssociazione is null ";
				List<DServiziModel> dServiziModelList = (List<DServiziModel>) dataSourceService.genericquery(query);
				if(dServiziModelList != null && !dServiziModelList.isEmpty()){
					dServiziModel = dServiziModelList.get(0);
					if(FormatUtility.formattaDataToString("yyyy-MM-dd",dServiziModel.getId().getDataInizioAssociazione()).equals(FormatUtility.formattaDataToString("yyyy-MM-dd", new Date() )))
						dataSourceService.delete(dServiziModel);
					else {
						dServiziModel.setDataFineAssociazione(new Date());
						dataSourceService.update(dServiziModel);
					}												
				}			
			
				DModelApplicativi dModelApplicativo = getModelApplicativo(businessServiceForm.getCodiModelApplicativo());		
				dataSourceService.insert(new DServiziModel(new DServiziModelId(Integer.parseInt(businessServiceFormOld.getCodiBusinessServiceOld()), new Date()),dModelApplicativo,dBusinessService, null));
			}
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
			popolaModelDb.popolaDProcessiBean(processoForm, dProcessi);
			dProcessi.setCodiProcesso(processoOld.getCodiProcesso());
			dataSourceService.update(dProcessi);			
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
			businessService.setDataFineValidita(new Date());
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
			dProcessi.setDataFineValidita(new Date());
			dataSourceService.update(dProcessi);
		}catch(Exception e){
			log.error(e.getMessage()+" on GestioneDataBase.cancellaProcesso");
			throw e;
			}		
	}
	
	@Transactional
	public void cancellaFunzioneUtente(DServiziFunzioni dServiziFunzione) throws Exception{
		log.info("Inizio metodo GestioneDataBase.cancellaFunzioneUtente!");		
		
		try{
			if(FormatUtility.formattaDataToString("yyyy-MM-dd",dServiziFunzione.getId().getDataInizioAssociazione()).equals(FormatUtility.formattaDataToString("yyyy-MM-dd", new Date() )))
				dataSourceService.delete(dServiziFunzione);
			else{
				dServiziFunzione.setDataFineAssociazione(new Date());
				dataSourceService.update(dServiziFunzione);				
			}				
		}catch(Exception e){
			log.error(e.getMessage()+" on GestioneDataBase.cancellaFunzioneUtente");
			throw e;
			}		
	}
	
	@Transactional
	public void cancellaElencoAssociazioniBSFunzioniUtente(String codiBusinessService) throws Exception{
		log.info("Inizio metodo GestioneDataBase.cancellaElencoAssociazioniBSFunzioniUtente!");		
		
		List<DServiziFunzioni> resultList;
		Iterator<DServiziFunzioni> itr;
		
		try{
			resultList = getListaAssociazioniFunzioniUtenteBS(codiBusinessService);
			itr = resultList.iterator();
			while (itr.hasNext()) {
				cancellaFunzioneUtente((DServiziFunzioni)itr.next());
				}						
			}catch(Exception e){
			log.error(e.getMessage()+" on GestioneDataBase.cancellaElencoAssociazioniBSFunzioniUtente");
			throw e;
			}
		}
	
	@Transactional
	public void cancellaElencoAssociazioniBSProcesso(String codiBusinessService) throws Exception{
		log.info("Inizio metodo GestioneDataBase.cancellaElencoAssociazioniBSProcesso!");		
		
		List<DServiziProcessi> resultList;
		Iterator<DServiziProcessi> itr;
		
		try{
			resultList = getListaAssociazioniProcessiBS(codiBusinessService,null);
			itr = resultList.iterator();
			while (itr.hasNext()) {
				cancellaAssociazioneBSProcesso((DServiziProcessi)itr.next());
				}						
			}catch(Exception e){
			log.error(e.getMessage()+" on GestioneDataBase.cancellaElencoAssociazioniBSProcesso");
			throw e;
			}
		}

	
	@Transactional
	public void cancellaAssociazioneBSProcesso(DServiziProcessi dServiziProcessi) throws Exception{
		log.info("Inizio metodo GestioneDataBase.cancellaAssociazioneBSProcesso!");		
		
		try{
			dServiziProcessi.setDataFineValidita(new Date());
			dataSourceService.update(dServiziProcessi);
		}catch(Exception e){
			log.error(e.getMessage()+" on GestioneDataBase.cancellaAssociazioneBSProcesso");
			throw e;
			}		
	}
	
	@Transactional
	public void modificaAssociazioneBSProcesso(DServiziProcessi dServiziProcessi,DServiziProcessi dServiziProcessiOld) throws Exception{
		log.info("Inizio metodo GestioneDataBase.modificaAssociazioneBSProcesso!");		
		
		try{
			dServiziProcessiOld.setDataFineValidita(new Date());		
			if(FormatUtility.formattaDataToString("yyyy-MM-dd",dServiziProcessiOld.getId().getDataInizioValidita()).equals(FormatUtility.formattaDataToString("yyyy-MM-dd", new Date() )))
				dataSourceService.delete(dServiziProcessiOld);
			else dataSourceService.update(dServiziProcessiOld);
			dataSourceService.insert(dServiziProcessi);
		}catch(Exception e){
			log.error(e.getMessage()+" on GestioneDataBase.modificaAssociazioneBSProcesso");
			throw e;
			}		
	}
	
	
		
		@Transactional
		public void inserisciAssociazioniBSFunzUtente(List<DServiziFunzioni> dServiziFunzioniList) throws Exception{
			log.info("Inizio metodo GestioneDataBase.inserisciAssociazioneBSFunzUtente!");			
			
			List<DServiziFunzioni> dServiziFunzioniGiaPresente;
			Iterator<DServiziFunzioni> itr;
			String query;
			
			try{						
				itr = dServiziFunzioniList.iterator();
				while(itr.hasNext()){
					DServiziFunzioni dServiziFunzione = new DServiziFunzioni();
					dServiziFunzione = (DServiziFunzioni) itr.next();
					query = "from com.ddway.anagraficaBS.model.db.anagraficaBS.DServiziFunzioni tab where tab.id.codiBusinessService = '"+dServiziFunzione.getId().getCodiBusinessService()+"' and tab.id.codiArea = '"+dServiziFunzione.getId().getCodiArea()+"' and tab.id.codiApplicazione = '"+dServiziFunzione.getId().getCodiApplicazione()+"' and tab.id.codiFunzione = '"+dServiziFunzione.getId().getCodiFunzione()+"'";
					dServiziFunzioniGiaPresente = (List<DServiziFunzioni>) dataSourceService.genericquery(query);
					if(dServiziFunzioniGiaPresente != null && !dServiziFunzioniGiaPresente.isEmpty()){
						if(dServiziFunzioniGiaPresente.get(0).getDataFineAssociazione() != null)
							dataSourceService.insert(dServiziFunzione);	
					}
					else dataSourceService.insert(dServiziFunzione);	
				}				
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
			
			String query = "Select tab.id.descApplicazione from com.ddway.anagraficaBS.model.db.anagraficaBS.VInfap tab where tab.id.codiApplicazione = '"+codiApplicazione+"'";
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
		public String getDescArea(String codiArea) throws Exception{
			log.info("Inizio metodo GestioneDataBase.getDescArea!");					
			
			String query = "Select tab.sdescrizione from com.ddway.anagraficaBS.model.db.common.TblArea tab where tab.scodeArea = '"+codiArea+"'";
			String descArea = "";
			System.out.print(codiArea);
			
			try{											
				List<Object> objectList = (List<Object>) dataSourceService.genericqueryCommon(query);
				Object obj = (Object) objectList.get(0);	
				descArea = (String) obj;
			}catch(Exception e){
				log.error(e.getMessage()+" on GestioneDataBase.getDescArea");
				throw e;
				}
			return descArea;
			}
		
		@Transactional
		public String getDescFunzione(int codiFunzione) throws Exception{
			log.info("Inizio metodo GestioneDataBase.getDescArea!");		
			
			String query = "Select tab.id.descFunzione from com.ddway.anagraficaBS.model.db.anagraficaBS.VInfap tab where tab.id.codiFunzione = '"+codiFunzione+"' order by tab.id.descFunzione";
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
		public  DServiziFunzioni getFunzioneUtente(String codiArea, String codiApplicazione, String codiFunzione,String codiBusinessService, String dataInizioAssociazione) throws Exception{
			log.debug("Start GestioneDataBase.getFunzioneUtente method");
			
			DServiziFunzioniId dServiziFunzioniId = new DServiziFunzioniId();
			DServiziFunzioni dServiziFunzione;
			String query;
			
			try{
				dServiziFunzioniId.setCodiBusinessService(Integer.parseInt(codiBusinessService));
				dServiziFunzioniId.setCodiArea(Integer.parseInt(codiArea));
				dServiziFunzioniId.setCodiApplicazione(Integer.parseInt(codiApplicazione));
				dServiziFunzioniId.setCodiFunzione(Integer.parseInt(codiFunzione));	
				dServiziFunzioniId.setDataInizioAssociazione(FormatUtility.formattaStringaToData("yyyy-MM-dd",dataInizioAssociazione));
				dServiziFunzione = (DServiziFunzioni) dataSourceService.findbyId(dServiziFunzioniId);				
			}catch(Exception e){
				log.error(e.getMessage()+" on GestioneDataBase.getFunzioneUtente");
				throw e;
			}
			return dServiziFunzione;
		}
		
		@Transactional
		public  List<TriplaInfap> getListaFunzioniUtente(RicercaFunzioniUtenteForm ricercaFunzioniUtenteForm) throws Exception{
			log.debug("Start GestioneDataBase.getListaFunzioniUtente method");
			
			List<Object> resultList;
			String query;
			ArrayList<TriplaInfap> codiFunzioneList;
//			codiArea = "00"+codiArea;
			
			
			try{			
				if(ricercaFunzioniUtenteForm.getCodiApplicazione() != null && !ricercaFunzioniUtenteForm.getCodiApplicazione().equalsIgnoreCase(""))					
				query = "select distinct a.idTblApplicazione,a.sdescrizioneBreve,f.idTblFunzione,f.sdescrizione"+
							" from com.ddway.anagraficaBS.model.db.infap.TblElementoFzDett fe ,com.ddway.anagraficaBS.model.db.infap.TblFunzione f,"+
							" com.ddway.anagraficaBS.model.db.infap.TblApplicazione a "+
							" where fe.scodeFunzionePropriet = f.scodeFunzione and fe.scodeAreaPropriet = f.scodeAreaPropriet and "+
							" fe.scodeApplicazionePropriet = f.scodeApplicazionePropriet and f.scodeApplicazionePropriet = a.scodeApplicazione and"+
							" f.scodeAreaPropriet = a.scodeArea and fe.dateEnd is null and a.scodeArea = '"+ricercaFunzioniUtenteForm.getCodiArea()+"' and a.scodeApplicazione = '"+ricercaFunzioniUtenteForm.getCodiApplicazione()+"' ";
									
				else query = "select distinct a.idTblApplicazione,a.sdescrizioneBreve,f.idTblFunzione,f.sdescrizione"+
						" from com.ddway.anagraficaBS.model.db.infap.TblElementoFzDett fe ,com.ddway.anagraficaBS.model.db.infap.TblFunzione f,"+
						" com.ddway.anagraficaBS.model.db.infap.TblApplicazione a "+
						" where fe.scodeFunzionePropriet = f.scodeFunzione and fe.scodeAreaPropriet = f.scodeAreaPropriet and "+
						" fe.scodeApplicazionePropriet = f.scodeApplicazionePropriet and f.scodeApplicazionePropriet = a.scodeApplicazione and"+
						" f.scodeAreaPropriet = a.scodeArea and fe.dateEnd is null and a.scodeArea = '"+ricercaFunzioniUtenteForm.getCodiArea()+"' ";						
						
				resultList = (List<Object>) dataSourceService.genericqueryInfap(query);	
				codiFunzioneList = new ArrayList<TriplaInfap>();
				Iterator<Object> itr = resultList.iterator();
				while(itr.hasNext()){
						Object[] obj = (Object[]) itr.next(); 
						codiFunzioneList.add(new TriplaInfap(ricercaFunzioniUtenteForm.getCodiArea(),ricercaFunzioniUtenteForm.getDescArea(),(Integer) obj[0]+"",(String) obj[1],(Integer) obj[2]+"",(String) obj[3]));													
					}				
			}catch(Exception e){
				log.error(e.getMessage()+" on GestioneDataBase.getListaFunzioniUtente");
				throw e;
			}
			return codiFunzioneList;	
		}
		
		
		public  List<DBusinessServices> getElencoBusinessServices(HttpSession session) throws Exception{
			log.debug("Start GestioneDataBase.getElencoBusinessServices method");
			
			List<DBusinessServices> elencoBusinessServices;
			String query; 			
			Users utente;
			List<Authorities> authorities;
			String role = "standard";				
			
			try{		
				utente = (Users) session.getAttribute("user");
				authorities = getAuthorities(utente);
				if(authorities.size() == 2)
					role = "admin";
				if(role.equalsIgnoreCase("admin"))
					query = "from com.ddway.anagraficaBS.model.db.anagraficaBS.DBusinessServices tab where tab.dataFineValidita is null  order by tab.textNomeBusinessService";
				else query = "from com.ddway.anagraficaBS.model.db.anagraficaBS.DBusinessServices tab where tab.dataFineValidita is null and tab.persRespBusinessService = '"+utente.getNome()+" "+utente.getCognome()+"' order by tab.textNomeBusinessService";
				elencoBusinessServices = (List<DBusinessServices>) dataSourceService.genericquery(query);								
			}catch(Exception e){
				log.error(e.getMessage()+" on GestioneDataBase.getElencoBusinessServices");
				throw e;
			}
			return elencoBusinessServices;	
		}		
		
		public  List<DServiziModel> getElencoDServiziModel(int codiModelApplicativo) throws Exception{
			log.debug("Start GestioneDataBase.getElencoBusinessServices method");
			
			List<DServiziModel> elencoDServiziModel;
			String query = "from com.ddway.anagraficaBS.model.db.anagraficaBS.DServiziModel tab where tab.DModelApplicativi.codiModelApplicativo = '"+codiModelApplicativo+"' and tab.dataFineAssociazione is null";
			
			try{		
				elencoDServiziModel = (List<DServiziModel>) dataSourceService.genericquery(query);								
			}catch(Exception e){
				log.error(e.getMessage()+" on GestioneDataBase.getElencoBusinessServices");
				throw e;
			}
			return elencoDServiziModel;	
		}
		
		public  List<DProcessi> getElencoProcessi() throws Exception{
			log.debug("Start GestioneDataBase.getElencoProcessi method");
			
			List<DProcessi> elencoProcessi;
			String query = "from com.ddway.anagraficaBS.model.db.anagraficaBS.DProcessi tab where tab.dataFineValidita is null order by tab.codiProcesso";
			
			try{		
				elencoProcessi = (List<DProcessi>) dataSourceService.genericquery(query);								
			}catch(Exception e){
				log.error(e.getMessage()+" on GestioneDataBase.getElencoProcessi");
				throw e;
			}
			return elencoProcessi;	
		}		
		
		public  List<DModelApplicativi> getElencoModelApplicativi() throws Exception{
			log.debug("Start GestioneDataBase.getElencoModelApplicativi method");
			
			List<DModelApplicativi> elencoModelApplicativi;
			String query = "from com.ddway.anagraficaBS.model.db.anagraficaBS.DModelApplicativi tab where tab.dataFineValidita is null order by tab.codiModelApplicativo";
			
			try{		
				elencoModelApplicativi = (List<DModelApplicativi>) dataSourceService.genericquery(query);								
			}catch(Exception e){
				log.error(e.getMessage()+" on GestioneDataBase.getElencoModelApplicativi");
				throw e;
			}
			return elencoModelApplicativi;	
		}
		
		public  List<DModelApplicativi> getElencoModelApplicativiNonValidi() throws Exception{
			log.debug("Start GestioneDataBase.getElencoModelApplicativiNonValidi method");
			
			List<DModelApplicativi> elencoModelApplicativi;
			String query = "from com.ddway.anagraficaBS.model.db.anagraficaBS.DModelApplicativi tab where tab.dataFineValidita is not null order by tab.descModelApplicativo";
			
			try{		
				elencoModelApplicativi = (List<DModelApplicativi>) dataSourceService.genericquery(query);								
			}catch(Exception e){
				log.error(e.getMessage()+" on GestioneDataBase.getElencoModelApplicativiNonValidi");
				throw e;
			}
			return elencoModelApplicativi;	
		}
				
		public  List<Users> getElencoUtenti(String username) throws Exception{
			log.debug("Start GestioneDataBase.getElencoUtenti method");
			
			List<Users> elencoUtenti;
			String query = "from com.ddway.anagraficaBS.model.db.anagraficaBS.Users tab where tab.username != '"+username+"'  order by tab.nome";
			
			try{		
				elencoUtenti = (List<Users>) dataSourceService.genericquery(query);	
				if(elencoUtenti == null || elencoUtenti.isEmpty())
					throw new Exception("getlistvalues/Non risulta nessun Utente registrato nel sistema!");
			}catch(Exception e){
				log.error(e.getMessage()+" on GestioneDataBase.getElencoUtenti");
				throw e;
			}
			return elencoUtenti;	
		}
				
		public  Users getUtenteByUserName(String username) throws Exception{
			log.debug("Start GestioneDataBase.getUtenteByUserName method");
			
			List<Users> elencoUtenti;
			String query = "from com.ddway.anagraficaBS.model.db.anagraficaBS.Users tab where tab.username = '"+username+"'";
			
			try{		
				elencoUtenti = (List<Users>) dataSourceService.genericquery(query);	
				if(elencoUtenti == null || elencoUtenti.isEmpty())
					return null;
			}catch(Exception e){
				log.error(e.getMessage()+" on GestioneDataBase.getUtenteByUserName");
				throw e;
			}
			return elencoUtenti.get(0);	
		}
		
		public  Users getUtenteByEmail(String email) throws Exception{
			log.debug("Start GestioneDataBase.getUtenteByEmail method");
			
			List<Users> elencoUtenti;
			String query = "from com.ddway.anagraficaBS.model.db.anagraficaBS.Users tab where tab.email = '"+email+"'";
			
			try{		
				elencoUtenti = (List<Users>) dataSourceService.genericquery(query);	
				if(elencoUtenti == null || elencoUtenti.isEmpty())
					return null;
			}catch(Exception e){
				log.error(e.getMessage()+" on GestioneDataBase.getUtenteByEmail");
				throw e;
			}
			return elencoUtenti.get(0);	
		}
				
		public  DBusinessServices getBusinessServices(String cosiBusinessServise) throws Exception{
			log.debug("Start GestioneDataBase.getBusinessServices method");
			
			List<DBusinessServices> elencoBusinessServices;
			String query = "from com.ddway.anagraficaBS.model.db.anagraficaBS.DBusinessServices tab where tab.codiBusinessService = '"+cosiBusinessServise+"'";
			
			try{		
				elencoBusinessServices = (List<DBusinessServices>) dataSourceService.genericquery(query);
				if(elencoBusinessServices == null || elencoBusinessServices.isEmpty())
					throw new Exception("Nessun Business Service trovato con il codice "+cosiBusinessServise);
			}catch(Exception e){
				log.error(e.getMessage()+" on GestioneDataBase.getBusinessServices");
				throw e;
			}
			return elencoBusinessServices.get(0);	
		}
				
		public  DServiziModel getModelApplicativoFromDServiziModel(String codiBusinessService) throws Exception{
			log.debug("Start GestioneDataBase.getModelApplicativoFromDServiziModel method");
			
			List<DServiziModel> modelApplicativoList;
			String query = "from com.ddway.anagraficaBS.model.db.anagraficaBS.DServiziModel tab where tab.id.codiBusinessService = '"+codiBusinessService+"' and tab.dataFineAssociazione is null";
			
			try{		
				modelApplicativoList = (List<DServiziModel>) dataSourceService.genericquery(query);
				if(modelApplicativoList == null || modelApplicativoList.isEmpty())
					throw new Exception("Nessun Model Applicativo trovato con il codice Business Service "+codiBusinessService);
			}catch(Exception e){
				log.error(e.getMessage()+" on GestioneDataBase.getModelApplicativoFromDServiziModel");
				throw e;
			}
			return modelApplicativoList.get(0);	
		}		
		
		
		public  DModelApplicativi getModelApplicativoFromDModelApplicativi(String codiModelApplicativo) throws Exception{
			log.debug("Start GestioneDataBase.getModelApplicativoFromDModelApplicativi method");
			
			List<DModelApplicativi> modelApplicativoList;
			String query = "from com.ddway.anagraficaBS.model.db.anagraficaBS.DModelApplicativi tab where tab.codiModelApplicativo = '"+codiModelApplicativo+"'";
			
			try{		
				modelApplicativoList = (List<DModelApplicativi>) dataSourceService.genericquery(query);
				if(modelApplicativoList == null || modelApplicativoList.isEmpty())
					throw new Exception("Nessun Model Applicativo trovato con il codice Business Service "+codiModelApplicativo);
			}catch(Exception e){
				log.error(e.getMessage()+" on GestioneDataBase.getModelApplicativoFromDModelApplicativi");
				throw e;
			}
			return modelApplicativoList.get(0);	
		}
		
		@Transactional
		public  DProcessi getProcesso(String codiProcesso) throws Exception{
			log.debug("Start GestioneDataBase.getProcesso method");
			
			List<DProcessi> elencoProcessi;
			String query = "from com.ddway.anagraficaBS.model.db.anagraficaBS.DProcessi tab where tab.codiProcesso = '"+codiProcesso+"'";
			
			try{		
				elencoProcessi = (List<DProcessi>) dataSourceService.genericquery(query);
				if(elencoProcessi == null || elencoProcessi.isEmpty())
					throw new Exception("Nessun Processo trovato con il codice "+codiProcesso);
			}catch(Exception e){
				log.error(e.getMessage()+" on GestioneDataBase.getProcesso");
				throw e;
			}
			return elencoProcessi.get(0);	
		}
		
		
		public  DModelApplicativi getModelApplicativo(String codiModelApplicativo) throws Exception{
			log.debug("Start GestioneDataBase.getModelApplicativo method");
			
			List<DModelApplicativi> elencoModelApplicativi;
			String query = "from com.ddway.anagraficaBS.model.db.anagraficaBS.DModelApplicativi tab where tab.codiModelApplicativo = '"+codiModelApplicativo+"'";
			
			try{		
				elencoModelApplicativi = (List<DModelApplicativi>) dataSourceService.genericquery(query);
				if(elencoModelApplicativi == null || elencoModelApplicativi.isEmpty())
					throw new Exception("Nessun Model Applicativo trovato con il codice "+codiModelApplicativo);
			}catch(Exception e){
				log.error(e.getMessage()+" on GestioneDataBase.getModelApplicativo");
				throw e;
			}
			return elencoModelApplicativi.get(0);	
		}
		
		@Transactional
		public  DCategorieInfr getCategorieInfr(String codiCategorieInfr) throws Exception{
			log.debug("Start GestioneDataBase.getCategorieInfr method");
			
			List<DCategorieInfr> elencoCategorieInfr;
			String query = "from com.ddway.anagraficaBS.model.db.anagraficaBS.DCategorieInfr tab where tab.codiCategoriaInfr = '"+codiCategorieInfr+"'";
			
			try{		
				elencoCategorieInfr = (List<DCategorieInfr>) dataSourceService.genericquery(query);
				if(elencoCategorieInfr == null || elencoCategorieInfr.isEmpty())
					throw new Exception("Nessuna Categoria Infr trovata con il codice "+codiCategorieInfr);
			}catch(Exception e){
				log.error(e.getMessage()+" on GestioneDataBase.getCategorieInfr");
				throw e;
			}
			return elencoCategorieInfr.get(0);	
		}
		
		@Transactional
		public  DCategorieMac getCategorieMac(String codiCategorieMac) throws Exception{
			log.debug("Start GestioneDataBase.getCategorieMac method");
			
			List<DCategorieMac> elencoCategorieMac;
			String query = "from com.ddway.anagraficaBS.model.db.anagraficaBS.DCategorieMac tab where tab.codiCategoriaMac = '"+codiCategorieMac+"'";
			
			try{		
				elencoCategorieMac = (List<DCategorieMac>) dataSourceService.genericquery(query);
				if(elencoCategorieMac == null || elencoCategorieMac.isEmpty())
					throw new Exception("Nessuna Categoria Mac trovata con il codice "+codiCategorieMac);
			}catch(Exception e){
				log.error(e.getMessage()+" on GestioneDataBase.getCategorieMac");
				throw e;
			}
			return elencoCategorieMac.get(0);	
		}
		
		
		public  Users getUtente(String userId) throws Exception{
			log.debug("Start GestioneDataBase.getUtente method");
			
			List<Users> elencoUtenti;
			String query = "from com.ddway.anagraficaBS.model.db.anagraficaBS.Users tab where tab.userId = '"+userId+"' order by tab.nome";
			
			try{		
				elencoUtenti = (List<Users>) dataSourceService.genericquery(query);	
				if(elencoUtenti == null || elencoUtenti.isEmpty())
					throw new Exception("Nessun Processo trovato con il codice "+userId);
			}catch(Exception e){
				log.error(e.getMessage()+" on GestioneDataBase.getUtente");
				throw e;
			}
			return elencoUtenti.get(0);	
		}
		
		public  Users getAdministretor() throws Exception{
			log.debug("Start GestioneDataBase.getAdministretor method");
			
			List<Object[]> elencoUtenti;
			String query = "from com.ddway.anagraficaBS.model.db.anagraficaBS.Users u, com.ddway.anagraficaBS.model.db.anagraficaBS.Authorities a  where u.userId = a.id.userId and a.id.roleId = 1";
			Users admin;
			
			try{		
				elencoUtenti = (List<Object[]>) dataSourceService.genericquery(query);	
				if(elencoUtenti == null || elencoUtenti.isEmpty())
					throw new Exception("Nessun Utente Amministratore trovato ne sistema!");
				Object[] obj = elencoUtenti.get(0);
				admin = (Users) obj[0];
			}catch(Exception e){
				log.error(e.getMessage()+" on GestioneDataBase.getAdministretor");
				throw e;
			}
			return admin;	
		}
		
		
		public  DDipartimenti getDipartimento(String codiDipartimento) throws Exception{
			log.debug("Start GestioneDataBase.getDipartimento method");
			
			List<DDipartimenti> elencoDipartimenti;
			String query = "from com.ddway.anagraficaBS.model.db.anagraficaBS.DDipartimenti tab where tab.codiDipartimento = '"+codiDipartimento+"'";
			
			try{		
				elencoDipartimenti = (List<DDipartimenti>) dataSourceService.genericquery(query);	
				if(elencoDipartimenti == null || elencoDipartimenti.isEmpty())
					throw new Exception("Nessun Processo trovato con il codice "+codiDipartimento);						
			}catch(Exception e){
				log.error(e.getMessage()+" on GestioneDataBase.getDipartimento");
				throw e;
			}
			return elencoDipartimenti.get(0);	
		}
		
		public List<Authorities> getAuthorities(Users utente) throws Exception{
			log.debug("Start GestioneDataBase.getAuthorities method");
			
			List<Authorities> elencoAuthorities;
			String query = "from com.ddway.anagraficaBS.model.db.anagraficaBS.Authorities tab where tab.id.userId = '"+utente.getUserId()+"'";
			
			try{		
				elencoAuthorities = (List<Authorities>) dataSourceService.genericquery(query);	
				if(elencoAuthorities == null || elencoAuthorities.isEmpty())
					throw new Exception("Nessun Ruolo trovato con il codice "+utente.getUserId());						
			}catch(Exception e){
				log.error(e.getMessage()+" on GestioneDataBase.getAuthorities");
				throw e;
			}
			return elencoAuthorities;	
		}
		
		
		public  List<DServiziFunzioni> getListaAssociazioniFunzioniUtenteBS(String codiBusinessService) throws Exception{
			log.debug("Start GestioneDataBase.getListaAssociazioniFunzioniUtenteBS method");
			
			List<DServiziFunzioni> elencoFunzioni;
			String query = "from com.ddway.anagraficaBS.model.db.anagraficaBS.DServiziFunzioni tab where tab.id.codiBusinessService = '"+codiBusinessService+"' and tab.dataFineAssociazione is null";
			
			try{		
				elencoFunzioni = (List<DServiziFunzioni>) dataSourceService.genericquery(query);				
			}catch(Exception e){
				log.error(e.getMessage()+" on GestioneDataBase.getListaAssociazioniFunzioniUtenteBS");
				throw e;
			}
			return elencoFunzioni;	
		}
		
		
		public  List<DServiziProcessi> getListaAssociazioniProcessiBS(String codiBusinessService, String codiProcesso) throws Exception{
			log.debug("Start GestioneDataBase.getListaAssociazioniProcessiBS method");
			
			List<DServiziProcessi> elencoProcessi;
			String query;
			String query1 = "from com.ddway.anagraficaBS.model.db.anagraficaBS.DServiziProcessi tab where tab.id.codiBusinessService = '"+codiBusinessService+"' and tab.dataFineValidita is null";
			String query2 = "from com.ddway.anagraficaBS.model.db.anagraficaBS.DServiziProcessi tab where tab.id.codiProcesso = '"+codiProcesso+"' and tab.dataFineValidita is null";
			
			try{		
				if(codiBusinessService == null)
					query = query2;
				else query = query1;
				elencoProcessi = (List<DServiziProcessi>) dataSourceService.genericquery(query);				
			}catch(Exception e){
				log.error(e.getMessage()+" on GestioneDataBase.getListaAssociazioniProcessiBS");
				throw e;
			}
			return elencoProcessi;	
		}
		
		
		public  DServiziProcessi getDServiziProcesso(String codiBusinessService,String codiProcesso,String codiCategoriaMac,String codiCategoriaInfr,String dataInizioValidita) throws Exception{
			log.debug("Start GestioneDataBase.getDServiziProcesso method");
			
			DServiziProcessiId dServiziProcessiId = new DServiziProcessiId();
			DServiziProcessi dServiziProcesso;
			String query;
			
			try{
				dServiziProcessiId.setCodiBusinessService(Integer.parseInt(codiBusinessService));
				dServiziProcessiId.setCodiProcesso(Integer.parseInt(codiProcesso));
				dServiziProcessiId.setCodiCategoriaMac(Integer.parseInt(codiCategoriaMac));
				dServiziProcessiId.setCodiCategoriaInfr(Integer.parseInt(codiCategoriaInfr));	
				dServiziProcessiId.setDataInizioValidita(FormatUtility.formattaStringaToData("yyyy-MM-dd",dataInizioValidita));
				dServiziProcesso = (DServiziProcessi) dataSourceService.findbyId(dServiziProcessiId);				
			}catch(Exception e){
				log.error(e.getMessage()+" on GestioneDataBase.getDServiziProcesso");
				throw e;
			}
			return dServiziProcesso;
		}
		
		@Transactional
		public int inserisciBusinessServiceWithConvenzione(BusinessServiceForm businessServiceForm, List<DServiziFunzioni> dServiziFunzioniList) throws Exception{
			log.info("Inizio metodo GestioneDataBase.inserisciBusinessServiceWithConvenzione!");
			
			String query = "from com.ddway.anagraficaBS.model.db.anagraficaBS.DBusinessServices tab order by tab.codiBusinessService desc";		
			int codiBusinessService = 0;	
			Iterator<DServiziFunzioni> itr;	
			DBusinessServices dBusinessService = new DBusinessServices();
			
			try{							
				popolaModelDb.popolaDBusinessServiceBean(null,businessServiceForm,dBusinessService);
				dataSourceService.insert(dBusinessService);
				
				List<Object> maxCodiBusinessService = (List<Object>) dataSourceService.genericquery(query);
				if(maxCodiBusinessService != null && !maxCodiBusinessService.isEmpty()){
					dBusinessService = (DBusinessServices) maxCodiBusinessService.get(0);
					codiBusinessService = dBusinessService.getCodiBusinessService();				
				}
				DModelApplicativi dModelApplicativo = getModelApplicativo(businessServiceForm.getCodiModelApplicativo());
				dataSourceService.insert(new DServiziModel(new DServiziModelId(codiBusinessService, new Date()),dModelApplicativo,dBusinessService, null));
//				dataSourceService.insert(new DServiziModel(new DServiziModelId(codiBusinessService, new Date()), dBusinessService));
				itr = dServiziFunzioniList.iterator();
				while(itr.hasNext()){
					dServiziFunzioni = (DServiziFunzioni) itr.next();
					dataSourceService.insert(dServiziFunzioni);	
				}
			}catch(Exception e){
				log.error(e.getMessage()+" on GestioneDataBase.inserisciBusinessServiceWithConvenzione");
				throw e;
				}
			return codiBusinessService;
			}
		
	}
