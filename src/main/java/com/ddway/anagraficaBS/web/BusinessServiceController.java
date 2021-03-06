package com.ddway.anagraficaBS.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ddway.anagraficaBS.model.bean.AssociazioneBSProcessoBean;
import com.ddway.anagraficaBS.model.bean.BusinessServiceBean;
import com.ddway.anagraficaBS.model.bean.TriplaInfap;
import com.ddway.anagraficaBS.model.db.anagraficaBS.Authorities;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DBusinessServices;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DDipartimenti;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DModelApplicativi;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DServiziFunzioni;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DServiziModel;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DServiziProcessi;
import com.ddway.anagraficaBS.model.db.anagraficaBS.Users;
import com.ddway.anagraficaBS.model.forms.AssociazioneBSFunzUtenteForm;
import com.ddway.anagraficaBS.model.forms.BusinessServiceForm;
import com.ddway.anagraficaBS.model.forms.ElencoFunzioniForm;
import com.ddway.anagraficaBS.model.forms.RicercaFunzioniUtenteForm;
import com.ddway.anagraficaBS.service.IDataSourceService;
import com.ddway.anagraficaBS.utility.CaricaSelect;
import com.ddway.anagraficaBS.utility.GestioneControlli;
import com.ddway.anagraficaBS.utility.GestioneDataBase;
import com.ddway.anagraficaBS.utility.GestioneException;
import com.ddway.anagraficaBS.utility.GestioneMail;
import com.ddway.anagraficaBS.utility.PopolaModelDb;
import com.ddway.anagraficaBS.utility.PopolaModelForms;
import com.ddway.anagraficaBS.web.dto.BusinessServiceFormValidator;
import com.ddway.anagraficaBS.web.dto.ElencoFunzioniFormValidator;
import com.ddway.anagraficaBS.web.dto.RicercaFunzioniUtenteFormValidator;
 
@Controller
public class BusinessServiceController {
	
	private static final Logger logger = LoggerFactory.getLogger(BusinessServiceController.class);
	
	@Autowired
	IDataSourceService dataSourceService;		
	
	@Autowired
	BusinessServiceFormValidator businessServiceFormValidator;
	
	@Autowired
	DBusinessServices dBusinessService;
	
	@Autowired
	DServiziFunzioni dServiziFunzioni;
	
	@Autowired
	PopolaModelDb popolaModelDb;
	
	@Autowired
	GestioneDataBase gestioneDataBase;
	
	@Autowired
	CaricaSelect caricaSelect;
	
	@Autowired
	BusinessServiceForm businessServiceFormAutoWired;
	
	@Autowired
	RicercaFunzioniUtenteFormValidator ricercaFunzioniUtenteFormValidator;
	
	@Autowired
	ElencoFunzioniFormValidator elencoFunzioniFormValidator;
	
	@Autowired
	PopolaModelForms popolaModelForms;
	
	@Autowired
	GestioneException gestioneException;
	
	@Autowired
	GestioneControlli gestioneControlli;
	
	@RequestMapping(value="/formBusinessService", method = RequestMethod.GET)
	public ModelAndView formBusinessService(ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo BusinessServiceController.formBusinessService!");
			
		HashMap<String, List> selectboxes;
		
		session.removeAttribute("businessServiceForm");
		session.removeAttribute("ricercaFunzioniUtenteForm");
		try{
			selectboxes = caricaSelect.getSelectsInserimentoBusinessService("formBusinessService");
			
			model.addAllObjects(selectboxes);
			model.addObject("businessServiceForm", new BusinessServiceForm());
			model.setViewName("inserimentoBusinessService");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on BusinessServiceController.formBusinessService");
			gestioneException.gestisciException(model, e,"");
		}
		return model;
	}
	
	@RequestMapping(value="/inserimentoBusinessService", method = RequestMethod.GET, params="Avanti")
	public ModelAndView inserimentoBusinessService(BusinessServiceForm businessServiceForm, BindingResult errors, ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo BusinessServiceController.inserimentoBusinessService!");
		
		HashMap<String, List> selectboxes;
		String utente;
		
		try{			
			businessServiceFormValidator.validate(businessServiceForm, errors);
			if(errors.hasErrors()){			
				selectboxes = caricaSelect.getSelectsInserimentoBusinessService("formBusinessService");
				model.addAllObjects(selectboxes);
				model.setViewName("inserimentoBusinessService");
				return model;
			}		
			if(!businessServiceForm.getFlagConvenzione()){		
			if(businessServiceForm.getPersRespBusinessService() == null){
				utente = (String) session.getAttribute("utente");
				businessServiceForm.setPersRespBusinessService(utente);
			}
				gestioneDataBase.inserisciBusinessService(businessServiceForm);
				model.addObject("presenzaMessaggio","si");
				model.addObject("message","Il nuovo Business Service e' stato inserito con successo!");
//				List<DBusinessServices> businessServiceList = (List<DBusinessServices>) gestioneDataBase.getElencoBusinessServices();
//				model.addObject("businessServiceList", businessServiceList);
				model.setViewName("forward:/visualizzaElencoBusinessServices");
			}
			else {
				session.setAttribute("businessServiceForm", businessServiceForm);				
				model.setViewName("forward:/formAssociazioneBSProcessoWizard?codiBusinessService=wizard");
			}
			}catch(Exception e){
				e.printStackTrace();
				logger.error(e.getMessage()+" on BusinessServiceController.inserimentoBusinessService");
				gestioneException.gestisciException(model, e,"");
			}
			return model; 		
	}
	
	@RequestMapping(value="/inserimentoBusinessService", method = RequestMethod.GET, params="Annulla")
	public ModelAndView inserimentoBusinessServiceAnnulla(ModelAndView model) throws Exception { 
		logger.info("Inizio metodo BusinessServiceController.inserimentoBusinessServiceAnnulla!");			

		model.setViewName("forward:/visualizzaElencoBusinessServices");
		return model; 
	}
	
	@RequestMapping(value="/ricercaFunzioniUtente", method = RequestMethod.GET, params="Ricerca")
	public ModelAndView ricercaFunzioniUtente(RicercaFunzioniUtenteForm ricercaFunzioniUtenteForm, BindingResult errors, ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo BusinessServiceController.ricercaFunzioniUtente!");
				
		HashMap<String, List> selectboxes;
		List<TriplaInfap> funzioniList;
		
		try{			
			ricercaFunzioniUtenteFormValidator.validate(ricercaFunzioniUtenteForm, errors);
			if(errors.hasErrors()){			
				ricercaFunzioniUtenteForm.setCodiArea(null);
				selectboxes = caricaSelect.getSelectsRicercaFunzioniUtenteForm("formRicercaFunzioniUtente");
				model.addAllObjects(selectboxes);				
				model.setViewName("ricercaFunzioniUtente");
				return model;
			}	
			ricercaFunzioniUtenteForm.setDescArea(gestioneDataBase.getDescArea(ricercaFunzioniUtenteForm.getCodiArea()));
			session.setAttribute("ricercaFunzioniUtenteForm", ricercaFunzioniUtenteForm);
			funzioniList = gestioneDataBase.getListaFunzioniUtente(ricercaFunzioniUtenteForm);
			if(funzioniList == null || funzioniList.isEmpty()){
				int codiBusinessService = (Integer) session.getAttribute("codiBusinessService");
				model.addObject("presenzaMessaggio","si");
				model.addObject("message","Non e' stata trovata nessuna Funzione Utente con i criteri di ricerca inseriti!");
				model.setViewName("forward:/formRicercaFunzioniUtente?codiBusinessService="+codiBusinessService);
			}
			else {
				model.addObject("elencoFunzioniForm", new ElencoFunzioniForm());
				model.addObject("funzioniList",funzioniList);
				model.setViewName("elencoFunzioniUtente");
			}
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on BusinessServiceController.ricercaFunzioniUtente");
			gestioneException.gestisciException(model, e,"");
		}
		return model; 
	}
	
	@RequestMapping(value="/formSelezioneBS", method = RequestMethod.GET)
	public ModelAndView formSelezioneBS(ModelAndView model,HttpSession session, HttpServletRequest request) { 
		logger.info("Inizio metodo BusinessServiceController.formSelezioneBS!");		
		
		List<BusinessServiceBean> businessServiceBeanList = new ArrayList<BusinessServiceBean>();		
		List<DBusinessServices> businessServiceList;
		
		try{
			businessServiceList = (List<DBusinessServices>) gestioneDataBase.getElencoBusinessServices(session);
			if(businessServiceList == null || businessServiceList.isEmpty()){
				model.addObject("presenzaMessaggio","si");
				model.addObject("message","Non e' stato inserito nessun Business Service nel sistema!");
			}						
			model.addObject("associazioneBSFunzUtenteForm", new AssociazioneBSFunzUtenteForm());
			model.addObject("businessServiceList", businessServiceList);
			model.setViewName("selezioneBS");			
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on BusinessServiceController.formSelezioneBS");
			gestioneException.gestisciException(model, e,"");
		}		
		return model; 
	}
	
	@RequestMapping(value="/selezioneBS", method = RequestMethod.GET, params="Avanti")
	public ModelAndView selezioneBS(AssociazioneBSFunzUtenteForm associazioneBSFunzUtenteForm,ModelAndView model,HttpSession session, HttpServletRequest request) { 
		logger.info("Inizio metodo BusinessServiceController.selezioneBS!");			
		
		try{			
			model.setViewName("forward:/formRicercaFunzioniUtente?codiBusinessService="+associazioneBSFunzUtenteForm.getCodiBusinessService());			
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on BusinessServiceController.selezioneBS");
			gestioneException.gestisciException(model, e,"");
		}		
		return model; 
	}
	
	@RequestMapping(value="/selezioneBS", method = RequestMethod.GET, params="Annulla")
	public ModelAndView selezioneBSAnnulla(ModelAndView model) throws Exception { 
		logger.info("Inizio metodo BusinessServiceController.selezioneBSAnnulla!");			

		model.setViewName("forward:/visualizzaElencoBusinessServices");
		return model; 
	}
	
	@RequestMapping(value="/formRicercaFunzioniUtente", method = RequestMethod.GET)
	public ModelAndView formRicercaFunzioniUtente(ModelAndView model,HttpSession session, HttpServletRequest request) { 
		logger.info("Inizio metodo BusinessServiceController.formRicercaFunzioniUtente!");		
		
		HashMap<String, List> selectboxes;
		String codiBusinessService;
		
		try{
			codiBusinessService = (String) request.getParameter("codiBusinessService");
			if(codiBusinessService != null && !codiBusinessService.equalsIgnoreCase(""))
				session.setAttribute("codiBusinessService", Integer.parseInt(codiBusinessService));
			selectboxes = caricaSelect.getSelectsRicercaFunzioniUtenteForm("formRicercaFunzioniUtente");			
			model.addAllObjects(selectboxes);
			model.addObject("ricercaFunzioniUtenteForm", new RicercaFunzioniUtenteForm());
			model.setViewName("ricercaFunzioniUtente");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on BusinessServiceController.formRicercaFunzioniUtente");
			gestioneException.gestisciException(model, e,"");
		}		
		return model; 
	}
	
	@RequestMapping(value="/ricercaFunzioniUtente", method = RequestMethod.GET, params="Indietro")
	public ModelAndView ricercaFunzioniUtenteIndietro(ModelAndView model,HttpSession session,HttpServletRequest request) { 
		logger.info("Inizio metodo BusinessServiceController.ricercaFunzioniUtenteIndietro!");		
		
		HashMap<String, List> selectboxes;
		Integer codiBusinessService;
		
		try{
			codiBusinessService = (Integer) session.getAttribute("codiBusinessService");
			if(codiBusinessService != null){	
				model.setViewName("forward:/dettaglioBusinessService?codiBusinessService="+codiBusinessService);
				return model; 
			}
			selectboxes = caricaSelect.getSelectsInserimentoBusinessService("formBusinessService");			
			model.addAllObjects(selectboxes);
			model.addObject("businessServiceForm", (BusinessServiceForm) session.getAttribute("businessServiceForm"));
			model.setViewName("inserimentoBusinessService");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on BusinessServiceController.ricercaFunzioniUtenteIndietro");
			gestioneException.gestisciException(model, e,"");
		}		
		return model; 
	}
	
	@RequestMapping(value="/ricercaFunzioniUtente", method = RequestMethod.GET, params="Annulla")
	public ModelAndView ricercaFunzioniUtenteAnnulla(ModelAndView model) throws Exception { 
		logger.info("Inizio metodo BusinessServiceController.ricercaFunzioniUtenteAnnulla!");			

		model.setViewName("forward:/visualizzaElencoBusinessServices");
		return model; 
	}
	
	@RequestMapping(value="/inserisciFunzioniUtente", method = RequestMethod.POST, params="Associa")
	public ModelAndView inserisciFunzioniUtente(ElencoFunzioniForm elencoFunzioniForm,BindingResult errors, ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo BusinessServiceController.inserisciFunzioniUtente!");
				
		HashMap<String, List> selectboxes;
		ArrayList<DServiziFunzioni> dServiziFunzioniList = new ArrayList<DServiziFunzioni>();
		Integer codiBusinessService;
		List<TriplaInfap> funzioniList;
		RicercaFunzioniUtenteForm ricercaFunzioniUtenteForm;
		
		
		try{			
			elencoFunzioniFormValidator.validate(elencoFunzioniForm, errors);
			ricercaFunzioniUtenteForm = (RicercaFunzioniUtenteForm) session.getAttribute("ricercaFunzioniUtenteForm");
			if(errors.hasErrors()){					
				funzioniList = gestioneDataBase.getListaFunzioniUtente(ricercaFunzioniUtenteForm);
				model.addObject("elencoFunzioniForm", new ElencoFunzioniForm());
				model.addObject("funzioniList",funzioniList);
				model.addObject("presenzaMessaggio","si");
				model.addObject("message","Non e' stata selezionata nessuna Funzione Utente da associare!");
				model.setViewName("elencoFunzioniUtente");				
				return model;
			}	
			codiBusinessService = (Integer) session.getAttribute("codiBusinessService");
			if(codiBusinessService == null){				
				BusinessServiceForm businessServiceForm = (BusinessServiceForm) session.getAttribute("businessServiceForm");
				codiBusinessService = gestioneDataBase.inserisciBusinessService(businessServiceForm);
				}		
			popolaModelDb.popolaDServiziFunzioniBeanList(elencoFunzioniForm,codiBusinessService,ricercaFunzioniUtenteForm,dServiziFunzioniList);
			gestioneDataBase.inserisciAssociazioniBSFunzUtente(dServiziFunzioniList);
			selectboxes = caricaSelect.getSelectsRicercaFunzioniUtenteForm("formRicercaFunzioniUtente");			
			model.addAllObjects(selectboxes);
			List<DServiziFunzioni> hallDServiziFunzioniList = gestioneDataBase.getListaAssociazioniFunzioniUtenteBS(codiBusinessService.toString());
			model.addObject("dServiziFunzioniListAssociate",hallDServiziFunzioniList);	
			model.addObject("ricercaFunzioniUtenteForm", new RicercaFunzioniUtenteForm());			
			model.addObject("presenzaMessaggio","si");
			model.addObject("message","Le Funzioni Utente sono state associate con successo!");
			model.setViewName("ricercaFunzioniUtente");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on BusinessServiceController.inserisciFunzioniUtente");
			gestioneException.gestisciException(model, e,"Si sta cercando di associare delle Funzioni Utente gia' associate al Business Service selezionato!");
			model.setViewName("forward:/formRicercaFunzioniUtente");
		}
		return model; 
	}
	
	@RequestMapping(value="/inserisciFunzioniUtente", method = RequestMethod.POST, params="Indietro")
	public ModelAndView inserisciFunzioniUtenteIndietro(ModelAndView model) { 
		logger.info("Inizio metodo BusinessServiceController.inserisciFunzioniUtenteIndietro!");		
		
		HashMap<String, List> selectboxes;
		try{
			selectboxes = caricaSelect.getSelectsRicercaFunzioniUtenteForm("formRicercaFunzioniUtente");			
			model.addAllObjects(selectboxes);
			model.addObject("ricercaFunzioniUtenteForm", new RicercaFunzioniUtenteForm());
			model.setViewName("ricercaFunzioniUtente");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on BusinessServiceController.inserisciFunzioniUtenteIndietro!");
			gestioneException.gestisciException(model, e,"");
		}
		return model; 
	}
	
//	@RequestMapping(value="/inserisciFunzioniUtente", method = RequestMethod.POST, params="Annulla")
//	public ModelAndView inserisciFunzioniUtenteAnnulla(ModelAndView model) throws Exception { 
//		logger.info("Inizio metodo BusinessServiceController.inserisciFunzioniUtenteAnnulla!");				
//
//		model.setViewName("forward:/visualizzaElencoBusinessServices");
//		return model; 
//	}	

//	@RequestMapping(value="/inserimentoAssociazioneBSFunzUtente", method = RequestMethod.POST, params="Annulla")
//	public ModelAndView inserimentoAssociazioneBSFunzUtenteAnnulla(ModelAndView model) throws Exception { 
//		logger.info("Inizio metodo BusinessServiceController.inserimentoAssociazioneBSFunzUtenteAnnulla!");		
//		
//		String responsabile;
//		
//		responsabile = (String) session.getAttribute("utente");
//		
//		try{
//			List<DBusinessServices> businessServiceList = (List<DBusinessServices>) gestioneDataBase.getElencoBusinessServices(responsabile);
//			model.addObject("businessServiceList", businessServiceList);
//			model.setViewName("elencoBusinessService");
//		}catch(Exception e){
//			e.printStackTrace();
//			logger.error(e.getMessage()+" on usinessServiceController.inserimentoAssociazioneBSFunzUtenteAnnulla!");
//			gestioneException.gestisciException(model, e,"");
//		}
//		return model; 
//	}
	
	@Transactional
	@RequestMapping(value="/visualizzaElencoBusinessServices", method = RequestMethod.GET)
	public ModelAndView visualizzaElencoBusinessServices(ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo BusinessServiceController.visualizzaElencoBusinessServices!");			
		
		session.removeAttribute("codiBusinessService");
		session.removeAttribute("businessServiceList");
		List<BusinessServiceBean> businessServiceBeanList = new ArrayList<BusinessServiceBean>();
		List<DBusinessServices> businessServiceList;		
		
		try{
			session.removeAttribute("modelApplicativiNonValidiConBSAssociati");
			gestioneControlli.controlloValiditaModelAplicativi(session);
			businessServiceList = (List<DBusinessServices>) gestioneDataBase.getElencoBusinessServices(session);
			if(businessServiceList == null || businessServiceList.isEmpty()){
				model.addObject("presenzaMessaggio","si");
				model.addObject("message","Non e' stato inserito nessun Business Service nel sistema!");
			}
			else {
				popolaModelForms.popolaListaBusinessService(businessServiceList,businessServiceBeanList);
			}
			session.setAttribute("businessServicesList", businessServiceBeanList);
			model.addObject("businessServiceBeanList", businessServiceBeanList);
			model.setViewName("elencoBusinessService");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on BusinessServiceController.visualizzaElencoBusinessServices");
			gestioneException.gestisciException(model, e,"");
		}
		return model;
	}
	
	
	@Transactional
	@RequestMapping(value="/modificaBusinessServiceForm", method = RequestMethod.GET)
	public ModelAndView modificaBusinessServiceForm(ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo BusinessServiceController.modificaBusinessService!");	
		
		HashMap<String, List> selectboxes;
		String codiBusinessService;
		DBusinessServices businessService;
		DServiziModel dServiziModel;
		
		session.removeAttribute("businessServiceForm");
		session.removeAttribute("ricercaFunzioniUtenteForm");		
		
		try{
			selectboxes = caricaSelect.getSelectsInserimentoBusinessService("formBusinessService");
			codiBusinessService = request.getParameter("codiBusinessService");
			businessService = (DBusinessServices) gestioneDataBase.getBusinessServices(codiBusinessService);
			dServiziModel = (DServiziModel) gestioneDataBase.getModelApplicativoFromDServiziModel(codiBusinessService+"");
			popolaModelForms.popolaBusinessServiceForm(businessService, dServiziModel,businessServiceFormAutoWired);
			session.setAttribute("businessServiceFormOld", businessServiceFormAutoWired);
			model.addObject("businessServiceForm", businessServiceFormAutoWired);
			model.addAllObjects(selectboxes);
			model.setViewName("modificaBusinessService");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on BusinessServiceController.modificaBusinessService");
			gestioneException.gestisciException(model, e,"");
		}
		return model;
	}
	
	
	@RequestMapping(value="/modificaBusinessService", method = RequestMethod.GET, params="Modifica")
	public ModelAndView modificaBusinessService(BusinessServiceForm businessServiceForm, BindingResult errors, ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo BusinessServiceController.modificaBusinessService!");
			
		HashMap<String, List> selectboxes;
		
		try{
			businessServiceFormValidator.validate(businessServiceForm, errors);
			if(errors.hasErrors()){			
				selectboxes = caricaSelect.getSelectsInserimentoBusinessService("formBusinessService");
				model.addAllObjects(selectboxes);
				model.setViewName("modificaBusinessService");
				return model;
			}
			BusinessServiceForm businessServiceFormOld = (BusinessServiceForm) session.getAttribute("businessServiceFormOld");
			gestioneDataBase.modificaBusinessService(businessServiceForm,businessServiceFormOld);
			session.removeAttribute("businessServiceFormOld");
			model.addObject("presenzaMessaggio","si");
			model.addObject("message","Il Business Service e' stato modificato con successo!");
			model.setViewName("forward:/visualizzaElencoBusinessServices");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on BusinessServiceController.modificaBusinessService!");
			gestioneException.gestisciException(model, e, "Business Service");
			selectboxes = caricaSelect.getSelectsInserimentoBusinessService("formBusinessService");
			model.addAllObjects(selectboxes);
			model.setViewName("modificaBusinessService");
		}
		return model;
	}
	
	
	@RequestMapping(value="/modificaBusinessService", method = RequestMethod.GET, params="Annulla")
	public ModelAndView modificaBusinessServiceAnnulla(ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo BusinessServiceController.modificaBusinessServiceAnnulla!");
			
		try{
			model.setViewName("forward:/visualizzaElencoBusinessServices");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on BusinessServiceController.visualizzaElencoBusinessServices");
			gestioneException.gestisciException(model, e,"");
		}
		return model;
	}
	
	
	@RequestMapping(value="/cancellaBusinessService", method = RequestMethod.GET)
	public ModelAndView cancellaBusinessService(ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo BusinessServiceController.cancellaBusinessService!");
			
		String codiBusinessService;
		DBusinessServices businessService;
		
		try{
			codiBusinessService = request.getParameter("codiBusinessService");
			businessService = (DBusinessServices) gestioneDataBase.getBusinessServices(codiBusinessService);			
			gestioneDataBase.cancellaElencoAssociazioniBSFunzioniUtente(codiBusinessService);
			gestioneDataBase.cancellaElencoAssociazioniBSProcesso(codiBusinessService);
			gestioneDataBase.cancellaBusinessService(businessService);
			model.addObject("presenzaMessaggio","si");
			model.addObject("message","Il Business Service e' stato cancellato con successo!");
			model.setViewName("forward:/visualizzaElencoBusinessServices");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on BusinessServiceController.cancellaBusinessService");
			gestioneException.gestisciException(model, e,"");
		}
		return model;
	}	
	
	@Transactional
	@RequestMapping(value="/dettaglioBusinessService", method = RequestMethod.GET)
	public ModelAndView dettaglioBusinessService(ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo BusinessServiceController.dettaglioBusinessService!");
			
		String codiBusinessService;
		String messaggio;
		List<AssociazioneBSProcessoBean> associazioneBSProcessoBeanList = new ArrayList<AssociazioneBSProcessoBean>();
		BusinessServiceBean businessServiceBean = new BusinessServiceBean();
		
		try{
			messaggio = request.getParameter("messaggio");
			codiBusinessService = request.getParameter("codiBusinessService");
//			session.setAttribute("codiBusinessService", codiBusinessService);
			DBusinessServices businessService = (DBusinessServices) gestioneDataBase.getBusinessServices(codiBusinessService);
//			DDipartimenti dDipartimento  = businessService.getDDipartimenti();
//			DServiziModel dServiziModel = gestioneDataBase.getModelApplicativoFromDServiziModel(codiBusinessService);
//			DModelApplicativi dModelApplicativo = gestioneDataBase.getModelApplicativoFromDModelApplicativi(dServiziModel.getDModelApplicativi().getCodiModelApplicativo()+"");
			popolaModelForms.popolaBusinessServiceBean(businessService, businessServiceBean);
			List<DServiziFunzioni> dServiziFunzioniList = gestioneDataBase.getListaAssociazioniFunzioniUtenteBS(codiBusinessService);
			List<DServiziProcessi> dserviziProcessiList = gestioneDataBase.getListaAssociazioniProcessiBS(codiBusinessService,null);
			popolaModelForms.popolaAssociazioneBSProcessoBeanList(dserviziProcessiList,associazioneBSProcessoBeanList);
//			model.addObject("dDipartimento", dDipartimento);
//			model.addObject("dModelApplicativo", dModelApplicativo);	
			session.setAttribute("dServiziFunzioniList", dServiziFunzioniList);
			session.setAttribute("associazioneBSProcessoBeanList", associazioneBSProcessoBeanList);
			session.setAttribute("businessService", businessServiceBean);
			model.addObject("dServiziFunzioniList", dServiziFunzioniList);
			model.addObject("associazioneBSProcessoBeanList", associazioneBSProcessoBeanList);
			model.addObject("businessService", businessServiceBean);
			if(messaggio != null){
				model.addObject("presenzaMessaggio","si");
				model.addObject("message",messaggio);
			}
			model.setViewName("dettaglioBusinessService");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on BusinessServiceController.dettaglioBusinessService");
			gestioneException.gestisciException(model, e,"");
		}
		return model;
	}
	
	@RequestMapping(value="/cancellaAssociazioneFunzioneUtente", method = RequestMethod.GET)
	public ModelAndView cancellaFunzioneUtente(ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo BusinessServiceController.cancellaAssociazioneFunzioneUtente!");
			
		String codiArea;
		String codiApplicazione;
		String codiFunzione;
		String codiBusinessService;
		String dataInizioAssociazione;
		
		try{
			dataInizioAssociazione = request.getParameter("dataInizioAssociazione");
			codiBusinessService = request.getParameter("codiBusinessService");
			codiArea = request.getParameter("codiArea");
			codiApplicazione = request.getParameter("codiApplicazione");
			codiFunzione = request.getParameter("codiFunzione");			
			dServiziFunzioni  = gestioneDataBase.getFunzioneUtente(codiArea, codiApplicazione, codiFunzione, codiBusinessService,dataInizioAssociazione);
			gestioneDataBase.cancellaFunzioneUtente(dServiziFunzioni);			
			model.setViewName("forward:/dettaglioBusinessService?messaggio=La funzione Utente e' stata cancellata con successo!");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on BusinessServiceController.cancellaAssociazioneFunzioneUtente");
			gestioneException.gestisciException(model, e,"");
		}
		return model;
	}	
}