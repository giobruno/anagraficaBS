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

import com.ddway.anagraficaBS.model.bean.BusinessServiceBean;
import com.ddway.anagraficaBS.model.db.anagraficaBS.Authorities;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DBusinessServices;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DProcessi;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DServiziProcessi;
import com.ddway.anagraficaBS.model.db.anagraficaBS.Users;
import com.ddway.anagraficaBS.model.forms.AssociazioneBSProcessoForm;
import com.ddway.anagraficaBS.model.forms.BusinessServiceForm;
import com.ddway.anagraficaBS.model.forms.ProcessoForm;
import com.ddway.anagraficaBS.service.IDataSourceService;
import com.ddway.anagraficaBS.utility.CaricaSelect;
import com.ddway.anagraficaBS.utility.GestioneDataBase;
import com.ddway.anagraficaBS.utility.GestioneException;
import com.ddway.anagraficaBS.utility.PopolaModelDb;
import com.ddway.anagraficaBS.utility.PopolaModelForms;
import com.ddway.anagraficaBS.web.dto.AssociazioneBSProcessoFormValidator;
import com.ddway.anagraficaBS.web.dto.ModificaAssociazioneBSProcessoFormValidator;
import com.ddway.anagraficaBS.web.dto.ProcessoFormValidator;
 
@Controller
public class ProcessiController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProcessiController.class);
	
	@Autowired
	IDataSourceService dataSourceService;
	
	@Autowired
	ProcessoFormValidator processoFormValidator;
	
	@Autowired
	AssociazioneBSProcessoFormValidator associazioneBSProcessoFormValidator;
	
	@Autowired
	ModificaAssociazioneBSProcessoFormValidator modificaAssociazioneBSProcessoFormValidator;
	
	@Autowired
	DProcessi dProcessi;
	
	@Autowired
	DServiziProcessi dServiziProcessi;
	
	@Autowired
	PopolaModelDb popolaModelDb;
	
	@Autowired
	GestioneDataBase gestioneDataBase;
	
	@Autowired
	CaricaSelect caricaSelect;
	
	@Autowired
	ProcessoForm processoFormAutoWired;
	
	@Autowired
	PopolaModelForms popolaModelForms;
	
	@Autowired
	GestioneException gestioneException;
	
	@RequestMapping(value="/formProcesso", method = RequestMethod.GET)
	public ModelAndView formProcesso(ModelAndView model, HttpSession session, HttpServletRequest request) { 
		logger.info("Inizio metodo ProcessiController.formProcesso!");
		
		model.addObject("processoForm", new ProcessoForm());
		model.setViewName("inserimentoProcesso");
		return model; 
	}
	
	@RequestMapping(value="/inserimentoProcesso", method = RequestMethod.POST, params="Salva")
	public ModelAndView inserimentoProcesso(ProcessoForm processoForm, BindingResult errors, ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo ProcessiController.inserimentoprocesso!");
		
		try{
			processoFormValidator.validate(processoForm, errors);
			if(errors.hasErrors()){
				model.setViewName("inserimentoProcesso");
				return model;
			}
			popolaModelDb.popolaDProcessiBean(processoForm,dProcessi);
			gestioneDataBase.inserisciProcesso(dProcessi);
			model.addObject("presenzaMessaggio","si");
			model.addObject("message","Il nuovo processo e' stato inserito con successo!");
			List<DProcessi> processiList = (List<DProcessi>) gestioneDataBase.getElencoProcessi();
			model.addObject("processiList", processiList);
			model.setViewName("elencoProcessi");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on ProcessiController.inserimentoprocesso");
			gestioneException.gestisciException(model, e,"");
		}
		return model;
	}
	
	@RequestMapping(value="/inserimentoProcesso", method = RequestMethod.POST, params="Annulla")
	public ModelAndView formProcessoAnnulla(ModelAndView model) throws Exception { 
		logger.info("Inizio metodo ProcessiController.formProcessoAnnulla!");		
		
		try{
			List<DProcessi> processiList = (List<DProcessi>) gestioneDataBase.getElencoProcessi();
			model.addObject("processiList", processiList);
			model.setViewName("elencoProcessi");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on ProcessiController.formProcessoAnnulla");
			gestioneException.gestisciException(model, e,"");
		}
		return model; 
	}
	
	@RequestMapping(value="/formAssociazioneBSProcesso", method = RequestMethod.GET)
	public ModelAndView formAssociazioneBSProcesso(ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo ProcessiController.formAssociazioneBSProcesso!");		
		
		HashMap<String, List> selectboxes;
		AssociazioneBSProcessoForm associazioneBSProcessoForm = new AssociazioneBSProcessoForm();
		String codiBusinessService;
		List<BusinessServiceBean> businessServiceBeanList = new ArrayList<BusinessServiceBean>();		
		List<DBusinessServices> businessServiceList;
		
		try{
			businessServiceList = (List<DBusinessServices>) gestioneDataBase.getElencoBusinessServices(session);
			if(businessServiceList == null || businessServiceList.isEmpty()){
				model.addObject("presenzaMessaggio","si");
				model.addObject("message","Non e' stato inserito nessun Business Service nel sistema!");
			}
			
			selectboxes = caricaSelect.getSelectsInserimentoAssociazioneBSProcesso("formAssociazioneBSProcesso");	
			codiBusinessService = (String) request.getParameter("codiBusinessService");
//			if(codiBusinessService != null && codiBusinessService.equalsIgnoreCase("wizard")){
//				BusinessServiceForm businessServiceForm = (BusinessServiceForm) session.getAttribute("businessServiceForm");
//				model.addObject("wizard","SI");				
//				associazioneBSProcessoForm.setTextNomeBusinessService(businessServiceForm.getTextNomeBusinessService());
//			}
			if(codiBusinessService != null){
				associazioneBSProcessoForm.setCodiBusinessService(codiBusinessService);
				session.setAttribute("codiBusinessService", codiBusinessService);
				model.addObject("presenzaBS","SI");
			}
			session.setAttribute("businessServiceList",businessServiceList);
			model.addObject("businessServiceList",businessServiceList);
			model.addObject("associazioneBSProcessoForm", associazioneBSProcessoForm);
			model.addAllObjects(selectboxes);
			model.setViewName("associazione_BS_processo");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on ProcessiController.formAssociazioneBSProcesso");
			gestioneException.gestisciException(model, e,"");			
			model.setViewName("forward:/visualizzaElencoBusinessServices");		
		}
		return model;
	}
	
	
	
	@RequestMapping(value="/inserimentoAssociazioneBSProcesso", method = RequestMethod.GET, params="Associa")
	public ModelAndView inserimentoAssociazioneBSProcesso(AssociazioneBSProcessoForm associazioneBSProcessoForm, BindingResult errors, ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo ProcessiController.inserimentoAssociazioneBSProcesso!");
		
		HashMap<String, List> selectboxes;
		String codiBusinessService;
		List<DServiziProcessi> dServiziProcessoGiaPresente;
		String query;
		List<DBusinessServices> businessServiceList;
		
		try{
			codiBusinessService = (String) session.getAttribute("codiBusinessService");
			if(codiBusinessService != null){
				associazioneBSProcessoForm.setCodiBusinessService(codiBusinessService);
				model.addObject("presenzaBS","SI");
			}
			associazioneBSProcessoFormValidator.validate(associazioneBSProcessoForm, errors);
			if(errors.hasErrors()){
				businessServiceList = (List<DBusinessServices>) session.getAttribute("businessServiceList");
				selectboxes = caricaSelect.getSelectsInserimentoAssociazioneBSProcesso("formAssociazioneBSProcesso");
				model.addAllObjects(selectboxes);
				model.addObject("businessServiceList",businessServiceList);
//				model.addObject("associazioneBSProcessoForm",associazioneBSProcessoForm);
				model.setViewName("associazione_BS_processo");
				return model;
			}			
			query = "from com.ddway.anagraficaBS.model.db.anagraficaBS.DServiziProcessi tab where tab.id.codiBusinessService = '"+associazioneBSProcessoForm.getCodiBusinessService()+"' and tab.id.codiProcesso = '"+associazioneBSProcessoForm.getCodiProcesso()+"' and tab.id.codiCategoriaMac = '"+associazioneBSProcessoForm.getCodiCategoriaMac()+"' and tab.id.codiCategoriaInfr = '"+associazioneBSProcessoForm.getCodiCategoriaInfr()+"'";
			dServiziProcessoGiaPresente = (List<DServiziProcessi>) dataSourceService.genericquery(query);
			if(dServiziProcessoGiaPresente != null && !dServiziProcessoGiaPresente.isEmpty()){
				if(dServiziProcessoGiaPresente.get(0).getDataFineValidita() == null){
					model.addObject("message","L'associazione Business Service - Processo che si sta tentando di inserire risulta gia' presente nel sistema!");
					businessServiceList = (List<DBusinessServices>) session.getAttribute("businessServiceList");
					selectboxes = caricaSelect.getSelectsInserimentoAssociazioneBSProcesso("formAssociazioneBSProcesso");
					model.addAllObjects(selectboxes);
					model.addObject("businessServiceList",businessServiceList);
					model.addObject("associazioneBSProcessoForm",associazioneBSProcessoForm);
					model.setViewName("associazione_BS_processo");
				}				
			}	
			else {
				popolaModelDb.popolaDServiziProcessiBean(associazioneBSProcessoForm,dServiziProcessi);
				gestioneDataBase.inserisciAssociazioneBSProcesso(dServiziProcessi);			
				model.addObject("message","L'associazione Business Service - Processo e' stata inserita con successo!");
				model.setViewName("forward:/dettaglioBusinessService?codiBusinessService="+associazioneBSProcessoForm.getCodiBusinessService());
				session.removeAttribute("codiBusinessService");
				session.removeAttribute("businessServiceList");
			}
			model.addObject("presenzaMessaggio","si");						
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on ProcessiController.inserimentoAssociazioneBSProcesso");
			gestioneException.gestisciException(model, e,"Il processo che si sta cercando di associare risulta gia' associato al Business Service selezionato!");
			model.setViewName("forward:/formAssociazioneBSProcesso");
		}
		return model;
	}
	
	@RequestMapping(value="/formAssociazioneBSProcessoWizard", method = RequestMethod.GET)
	public ModelAndView formAssociazioneBSProcessoWizard(ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo ProcessiController.formAssociazioneBSProcessoWizard!");		
		
		HashMap<String, List> selectboxes;
		AssociazioneBSProcessoForm associazioneBSProcessoForm = new AssociazioneBSProcessoForm();
		String codiBusinessService;
		List<BusinessServiceBean> businessServiceBeanList = new ArrayList<BusinessServiceBean>();		
		List<DBusinessServices> businessServiceList;
		
		try{
//			businessServiceList = (List<DBusinessServices>) gestioneDataBase.getElencoBusinessServices(session);
//			if(businessServiceList == null || businessServiceList.isEmpty()){
//				model.addObject("presenzaMessaggio","si");
//				model.addObject("message","Non e' stato inserito nessun Business Service nel sistema!");
//			}
			
			selectboxes = caricaSelect.getSelectsInserimentoAssociazioneBSProcesso("formAssociazioneBSProcesso");	
			codiBusinessService = (String) request.getParameter("codiBusinessService");
			if(codiBusinessService != null && codiBusinessService.equalsIgnoreCase("wizard")){
				BusinessServiceForm businessServiceForm = (BusinessServiceForm) session.getAttribute("businessServiceForm");
//				model.addObject("wizard","SI");				
				associazioneBSProcessoForm.setTextNomeBusinessService(businessServiceForm.getTextNomeBusinessService());
			}
//			if(codiBusinessService != null && !codiBusinessService.equalsIgnoreCase("wizard")){
//				associazioneBSProcessoForm.setCodiBusinessService(codiBusinessService);
//				session.setAttribute("codiBusinessService", codiBusinessService);
//			}
//			session.setAttribute("businessServiceList",businessServiceList);
//			model.addObject("businessServiceList",businessServiceList);
			model.addObject("associazioneBSProcessoForm", associazioneBSProcessoForm);
			model.addAllObjects(selectboxes);
			model.setViewName("associazione_BS_processo_wizard");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on ProcessiController.formAssociazioneBSProcessoWizard");
			gestioneException.gestisciException(model, e,"");			
			model.setViewName("forward:/visualizzaElencoBusinessServices");		
		}
		return model;
	}
	
	@RequestMapping(value="/inserimentoAssociazioneBSProcessoWizard", method = RequestMethod.GET, params="Associa")
	public ModelAndView inserimentoAssociazioneBSProcessoWizard(AssociazioneBSProcessoForm associazioneBSProcessoForm, BindingResult errors, ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo ProcessiController.inserimentoAssociazioneBSProcessoWizard!");
		
		HashMap<String, List> selectboxes;
		int codiBusinessService;
		List<DServiziProcessi> dServiziProcessoGiaPresente;
		String query;
		List<DBusinessServices> businessServiceList;
		BusinessServiceForm businessServiceForm;
		String utente;
		
		try{
//			codiBusinessService = (String) session.getAttribute("codiBusinessService");
//			if(codiBusinessService != null)
//				associazioneBSProcessoForm.setCodiBusinessService(codiBusinessService);
			
			associazioneBSProcessoForm.setCodiBusinessService("codiBS");
			associazioneBSProcessoFormValidator.validate(associazioneBSProcessoForm, errors);
			if(errors.hasErrors()){
				businessServiceList = (List<DBusinessServices>) session.getAttribute("businessServiceList");
				selectboxes = caricaSelect.getSelectsInserimentoAssociazioneBSProcesso("formAssociazioneBSProcesso");
				model.addAllObjects(selectboxes);
				model.addObject("businessServiceList",businessServiceList);
				model.addObject("associazioneBSProcessoForm",associazioneBSProcessoForm);
				model.setViewName("associazione_BS_processo_wizard");
				return model;
			}			
//			query = "from com.ddway.anagraficaBS.model.db.anagraficaBS.DServiziProcessi tab where tab.id.codiBusinessService = '"+associazioneBSProcessoForm.getCodiBusinessService()+"' and tab.id.codiProcesso = '"+associazioneBSProcessoForm.getCodiProcesso()+"' and tab.id.codiCategoriaMac = '"+associazioneBSProcessoForm.getCodiCategoriaMac()+"' and tab.id.codiCategoriaInfr = '"+associazioneBSProcessoForm.getCodiCategoriaInfr()+"'";
//			dServiziProcessoGiaPresente = (List<DServiziProcessi>) dataSourceService.genericquery(query);
//			if(dServiziProcessoGiaPresente != null && !dServiziProcessoGiaPresente.isEmpty()){
//				if(dServiziProcessoGiaPresente.get(0).getDataFineValidita() == null){
//					model.addObject("message","L'associazione Business Service - Processo che si sta tentando di inserire risulta gia' presente nel sistema!");
//					businessServiceList = (List<DBusinessServices>) session.getAttribute("businessServiceList");
//					selectboxes = caricaSelect.getSelectsInserimentoAssociazioneBSProcesso("formAssociazioneBSProcesso");
//					model.addAllObjects(selectboxes);
//					model.addObject("businessServiceList",businessServiceList);
//					model.addObject("associazioneBSProcessoForm",associazioneBSProcessoForm);
//					model.setViewName("associazione_BS_processo");
//				}				
//			}	
//			else {
			String codiBS = (String) session.getAttribute("codiBusinessService");
			if(codiBS == null){
				businessServiceForm = (BusinessServiceForm) session.getAttribute("businessServiceForm");
				if(businessServiceForm.getPersRespBusinessService() == null){
					utente = (String) session.getAttribute("utente");
					businessServiceForm.setPersRespBusinessService(utente);
				}
				codiBusinessService = gestioneDataBase.inserisciBusinessService(businessServiceForm);
				session.setAttribute("codiBusinessService", codiBusinessService+"");
				associazioneBSProcessoForm.setCodiBusinessService(codiBusinessService+"");
				model.addObject("presenzaMessaggio","si");
				model.addObject("message","Il nuovo Business Service e' stato inserito con successo! Ora puoi decidere di associare un altro processo al Business Service oppure andare avanti per inserire le Funzioni Utente, oppure fermarti qui!");
			}
			else{
				associazioneBSProcessoForm.setCodiBusinessService(codiBS);
				model.addObject("message","L'associazione Business Service - Processo e' stata inserita con successo! Ora puoi decidere di associare un altro processo al Business Service oppure andare avanti per inserire le Funzioni Utente, oppure fermarti qui! ");
			}
			popolaModelDb.popolaDServiziProcessiBean(associazioneBSProcessoForm,dServiziProcessi);
			gestioneDataBase.inserisciAssociazioneBSProcesso(dServiziProcessi);			
			model.setViewName("forward:/formAssociazioneBSProcessoWizard?codiBusinessService=wizard");
//			model.addObject("message","L'associazione Business Service - Processo e' stata inserita con successo!");
//			model.setViewName("forward:/dettaglioBusinessService?codiBusinessService="+associazioneBSProcessoForm.getCodiBusinessService());
//			session.removeAttribute("codiBusinessService");
//			session.removeAttribute("businessServiceList");
//			}
			model.addObject("presenzaMessaggio","si");						
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on ProcessiController.inserimentoAssociazioneBSProcessoWizard");
			gestioneException.gestisciException(model, e,"Il processo che si sta cercando di associare risulta gia' associato al Business Service selezionato!");
			model.setViewName("forward:/formAssociazioneBSProcesso");
		}
		return model;
	}
	
	@RequestMapping(value="/inserimentoAssociazioneBSProcessoWizard", method = RequestMethod.GET, params="Annulla")
	public ModelAndView inserimentoAssociazioneBSProcessoWizardAnnulla(ModelAndView model) { 
		logger.info("Inizio metodo ProcessiController.inserimentoAssociazioneBSProcessoWizardAnnulla!");		
		
		try{
			model.setViewName("forward:/visualizzaElencoBusinessServices");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on BusinessServiceController.inserimentoAssociazioneBSProcessoWizardAnnulla");
			gestioneException.gestisciException(model, e,"");
		}
		return model;
	}
	
	@RequestMapping(value="/inserimentoAssociazioneBSProcesso", method = RequestMethod.GET, params="Annulla")
	public ModelAndView inserimentoAssociazioneBSProcessoAnnulla(ModelAndView model) { 
		logger.info("Inizio metodo ProcessiController.inserimentoAssociazioneBSProcessoAnnulla!");		
		
		try{
			model.setViewName("forward:/visualizzaElencoBusinessServices");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on BusinessServiceController.visualizzaElencoBusinessServices");
			gestioneException.gestisciException(model, e,"");
		}
		return model;
	}
	
	@RequestMapping(value="/inserimentoAssociazioneBSProcessoWizard", method = RequestMethod.GET, params="Indietro")
	public ModelAndView inserimentoAssociazioneBSProcessoWizardIndietro(ModelAndView model,HttpSession session) { 
		logger.info("Inizio metodo ProcessiController.inserimentoAssociazioneBSProcessoWizardIndietro!");		
		
		HashMap<String, List> selectboxes;
		BusinessServiceForm businessServiceForm;
		
		try{
			businessServiceForm = (BusinessServiceForm) session.getAttribute("businessServiceForm");
			selectboxes = caricaSelect.getSelectsInserimentoBusinessService("formBusinessService");
			model.addAllObjects(selectboxes);
			model.addObject("businessServiceForm",businessServiceForm);
			model.setViewName("inserimentoBusinessService");
			return model;
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on BusinessServiceController.inserimentoAssociazioneBSProcessoWizardIndietro");
			gestioneException.gestisciException(model, e,"");
		}
		return model;
	}
	
	@RequestMapping(value="/visualizzaElencoProcessi", method = RequestMethod.GET)
	public ModelAndView visualizzaElencoProcessi(ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo BusinessServiceController.visualizzaElencoProcessi!");
			
		try{
			List<DProcessi> processiList = (List<DProcessi>) gestioneDataBase.getElencoProcessi();
			if(processiList == null || processiList.isEmpty()){
				model.addObject("presenzaMessaggio","si");
				model.addObject("message","Non e' stato inserito nessun processo nel sistema!");
			}
			model.addObject("processiList", processiList);
			model.setViewName("elencoProcessi");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on BusinessServiceController.visualizzaElencoProcessi");
			gestioneException.gestisciException(model, e,"");
		}
		return model;
	}
	
	@RequestMapping(value="/modificaProcessoForm", method = RequestMethod.GET)
	public ModelAndView modificaProcessoForm(ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo BusinessServiceController.modificaProcessoForm!");	
				
		String codiProcesso;
		DProcessi processo;
		
		try{
			codiProcesso = request.getParameter("codiProcesso");
			processo = (DProcessi) gestioneDataBase.getProcesso(codiProcesso);
			popolaModelForms.popolaProcessoForm(processo,processoFormAutoWired);
			session.setAttribute("processoOld", processo);
			model.addObject("processoForm", processoFormAutoWired);			
			model.setViewName("modificaProcesso");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on BusinessServiceController.modificaProcessoForm");
			gestioneException.gestisciException(model, e,"");
		}
		return model;
	}
	
	@RequestMapping(value="/modificaProcesso", method = RequestMethod.POST, params="Modifica")
	public ModelAndView modificaProcessoForm(ProcessoForm processoForm, BindingResult errors, ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo BusinessServiceController.modificaProcesso!");
			
		HashMap<String, List> selectboxes;
		
		try{
			processoFormValidator.validate(processoForm, errors);
			if(errors.hasErrors()){							
				model.setViewName("modificaProcesso");
				return model;
			}
			DProcessi processoOld = (DProcessi) session.getAttribute("processoOld");
			gestioneDataBase.modificaProcesso(processoForm,processoOld);
			session.removeAttribute("processoOld");
			model.addObject("presenzaMessaggio","si");
			model.addObject("message","Il Processo e' stato modificato con successo!");
			List<DProcessi> processiList = (List<DProcessi>) gestioneDataBase.getElencoProcessi();
			model.addObject("processiList", processiList);
			model.setViewName("elencoProcessi");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on BusinessServiceController.modificaProcesso!");
			gestioneException.gestisciException(model, e,"");
		}
		return model;
	}
	
	@RequestMapping(value="/modificaProcesso", method = RequestMethod.POST, params="Annulla")
	public ModelAndView modificaProcessoAnnulla(ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo BusinessServiceController.modificaProcessoAnnulla!");
			
		try{
			List<DProcessi> processiList = (List<DProcessi>) gestioneDataBase.getElencoProcessi();
			model.addObject("processiList", processiList);
			model.setViewName("elencoProcessi");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on BusinessServiceController.visualizzaElencoProcessi");
			gestioneException.gestisciException(model, e,"");
		}
		return model;
	}
	
	@Transactional
	@RequestMapping(value="/modificaAssociazioneBSProcessoForm", method = RequestMethod.GET)
	public ModelAndView modificaAssociazioneBSProcesso(ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo BusinessServiceController.modificaAssociazioneBSProcesso!");
			
		String codiProcesso;
		String codiCategoriaMac;
		String codiCategoriaInfr;
		String codiBusinessService;
		String dataInizioValidita;
		HashMap<String, List> selectboxes;
		AssociazioneBSProcessoForm associazioneBSProcessoForm = new AssociazioneBSProcessoForm();
		DServiziProcessi dServiziProcessi;
		List<DBusinessServices> businessServiceList;
		
		try{			
			dataInizioValidita = request.getParameter("dataInizioValidita");
			codiBusinessService = request.getParameter("codiBusinessService");
			codiProcesso = request.getParameter("codiProcesso");
			codiCategoriaMac = request.getParameter("codiCategoriaMac");
			codiCategoriaInfr = request.getParameter("codiCategoriaInfr");			
			dServiziProcessi  = gestioneDataBase.getDServiziProcesso(codiBusinessService, codiProcesso, codiCategoriaMac, codiCategoriaInfr,dataInizioValidita);
			session.setAttribute("dServiziProcessiOld", dServiziProcessi);
			popolaModelForms.popolaAssociazioneBSProcessoForm(dServiziProcessi, associazioneBSProcessoForm);			
			businessServiceList = (List<DBusinessServices>) gestioneDataBase.getElencoBusinessServices(session);
			if(businessServiceList == null || businessServiceList.isEmpty()){
				model.addObject("presenzaMessaggio","si");
				model.addObject("message","Non e' stato inserito nessun Business Service nel sistema!");				
			}
			else model.addObject("businessServiceList", businessServiceList);
			selectboxes = caricaSelect.getSelectsInserimentoAssociazioneBSProcesso("formAssociazioneBSProcesso");	
			model.addObject("associazioneBSProcessoForm", associazioneBSProcessoForm);
			model.addAllObjects(selectboxes);
			model.setViewName("modifica_associazione_BS_processo");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on BusinessServiceController.modificaAssociazioneBSProcesso");
			gestioneException.gestisciException(model, e,"");
		}
		return model;
	}
	
	@Transactional
	@RequestMapping(value="/modificaAssociazioneBSProcesso", method = RequestMethod.GET, params="Modifica")
	public ModelAndView modificaAssociazioneBSProcesso(AssociazioneBSProcessoForm associazioneBSProcessoForm, BindingResult errors, ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo ProcessiController.modificaAssociazioneBSProcesso!");
		
		HashMap<String, List> selectboxes;		
		DServiziProcessi dServiziProcessiOld;
		DServiziProcessi dServiziProcessi = new DServiziProcessi();
		List<DBusinessServices> businessServiceList;
		List<DServiziProcessi> dServiziProcessoGiaPresente;
		String query;
		
		try{		
			dServiziProcessiOld = (DServiziProcessi) session.getAttribute("dServiziProcessiOld");
			associazioneBSProcessoForm.setCodiBusinessService(dServiziProcessiOld.getId().getCodiBusinessService()+"");
			modificaAssociazioneBSProcessoFormValidator.validate(associazioneBSProcessoForm, errors);			
			if(errors.hasErrors()){
				associazioneBSProcessoForm.setCodiBusinessService(dServiziProcessiOld.getId().getCodiBusinessService()+"");
				selectboxes = caricaSelect.getSelectsInserimentoAssociazioneBSProcesso("formAssociazioneBSProcesso");
				model.addAllObjects(selectboxes);				
				businessServiceList = (List<DBusinessServices>) gestioneDataBase.getElencoBusinessServices(session);
				if(businessServiceList == null || businessServiceList.isEmpty()){
					model.addObject("presenzaMessaggio","si");
					model.addObject("message","Non e' stato inserito nessun Business Service nel sistema!");				
				}
				else model.addObject("businessServiceList", businessServiceList);
				model.addObject("associazioneBSProcessoForm", associazioneBSProcessoForm);
				model.setViewName("modifica_associazione_BS_processo");
				return model;
			}
			dServiziProcessiOld = (DServiziProcessi) session.getAttribute("dServiziProcessiOld");			
//			query = "from com.ddway.anagraficaBS.model.db.anagraficaBS.DServiziProcessi tab where tab.id.codiBusinessService = '"+associazioneBSProcessoForm.getCodiBusinessService()+"' and tab.id.codiProcesso = '"+associazioneBSProcessoForm.getCodiProcesso()+"' and tab.id.codiCategoriaMac = '"+associazioneBSProcessoForm.getCodiCategoriaMac()+"' and tab.id.codiCategoriaInfr = '"+associazioneBSProcessoForm.getCodiCategoriaInfr()+"'";
//			dServiziProcessoGiaPresente = (List<DServiziProcessi>) dataSourceService.genericquery(query);
//			if(dServiziProcessoGiaPresente != null && !dServiziProcessoGiaPresente.isEmpty()){
//				if(dServiziProcessoGiaPresente.get(0).getDataFineValidita() == null){
//					associazioneBSProcessoForm.setCodiBusinessService(dServiziProcessiOld.getId().getCodiBusinessService()+"");
//					model.addObject("presenzaMessaggio","si");
//					model.addObject("message","L'associazione Business Service - Processo che si sta tentando di inserire risulta gia' presente nel sistema!");
//					businessServiceList = (List<DBusinessServices>) session.getAttribute("businessServiceList");
//					selectboxes = caricaSelect.getSelectsInserimentoAssociazioneBSProcesso("formAssociazioneBSProcesso");
//					model.addAllObjects(selectboxes);
//					businessServiceList = (List<DBusinessServices>) gestioneDataBase.getElencoBusinessServices(session);
//					if(businessServiceList == null || businessServiceList.isEmpty()){
//						model.addObject("presenzaMessaggio","si");
//						model.addObject("message","Non e' stato inserito nessun Business Service nel sistema!");				
//					}
//					else model.addObject("businessServiceList", businessServiceList);
//					model.addObject("associazioneBSProcessoForm",associazioneBSProcessoForm);
//					model.setViewName("modifica_associazione_BS_processo");
//					}
//				}else{			
					popolaModelDb.popolaDServiziProcessiBean(associazioneBSProcessoForm,dServiziProcessi);
					gestioneDataBase.modificaAssociazioneBSProcesso(dServiziProcessi,dServiziProcessiOld);	
					session.removeAttribute("dServiziProcessiOld");
					model.setViewName("forward:/dettaglioBusinessService?codiBusinessService="+associazioneBSProcessoForm.getCodiBusinessServiceOld()+"&messaggio='L'associazione Business Service - Processo e' stata modificata con successo!'");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on ProcessiController.modificaAssociazioneBSProcesso");
			gestioneException.gestisciException(model, e,"Il processo che si sta cercando di associare risulta gia' associato al Business Service selezionato!");
			model.setViewName("forward:/modificaAssociazioneBSProcessoForm");
		}
		return model;
	}
	
	@RequestMapping(value="/modificaAssociazioneBSProcesso", method = RequestMethod.GET, params="Annulla")
	public ModelAndView modificaAssociazioneBSProcessoAnnulla(ModelAndView model,HttpSession session) { 
		logger.info("Inizio metodo ProcessiController.modificaAssociazioneBSProcessoAnnulla!");		
		
		DServiziProcessi dServiziProcessiOld;
		
		try{
			dServiziProcessiOld = (DServiziProcessi) session.getAttribute("dServiziProcessiOld");
			model.setViewName("forward:/dettaglioBusinessService?codiBusinessService="+dServiziProcessiOld.getId().getCodiBusinessService());
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on BusinessServiceController.modificaAssociazioneBSProcessoAnnulla");
			gestioneException.gestisciException(model, e,"");
		}
		return model;
	}
	
	@RequestMapping(value="/cancellaAssociazioneBSProcesso", method = RequestMethod.GET)
	public ModelAndView cancellaAssociazioneBSProcesso(ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo BusinessServiceController.cancellaAssociazioneBSProcesso!");
			
		String codiProcesso;
		String codiCategoriaMac;
		String codiCategoriaInfr;
		String codiBusinessService;
		String dataInizioValidita;
		
		try{
			dataInizioValidita = request.getParameter("dataInizioValidita");
			codiBusinessService = request.getParameter("codiBusinessService");
			codiProcesso = request.getParameter("codiProcesso");
			codiCategoriaMac = request.getParameter("codiCategoriaMac");
			codiCategoriaInfr = request.getParameter("codiCategoriaInfr");			
			dServiziProcessi  = gestioneDataBase.getDServiziProcesso(codiBusinessService, codiProcesso, codiCategoriaMac, codiCategoriaInfr,dataInizioValidita);
			gestioneDataBase.cancellaAssociazioneBSProcesso(dServiziProcessi);
			model.setViewName("forward:/dettaglioBusinessService?messaggio=Il processo e' stato cancellato con successo!");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on BusinessServiceController.cancellaAssociazioneBSProcesso");
			gestioneException.gestisciException(model, e,"");
		}
		return model;
	}
	
	@RequestMapping(value="/cancellaProcesso", method = RequestMethod.GET)
	public ModelAndView cancellaProcesso(ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo BusinessServiceController.cancellaProcesso!");
			
		String codiProcesso;
		DProcessi dProcesso;
		List<DServiziProcessi> dServiziProcessi;
		
		try{
			codiProcesso = request.getParameter("codiProcesso");			
			dServiziProcessi = gestioneDataBase.getListaAssociazioniProcessiBS(null,codiProcesso);
			if(dServiziProcessi == null || dServiziProcessi.isEmpty()){
				dProcesso = (DProcessi) gestioneDataBase.getProcesso(codiProcesso);
				gestioneDataBase.cancellaProcesso(dProcesso);
				model.addObject("presenzaMessaggio","si");
				model.addObject("message","Il processo e' stato cancellato con successo!");
			}
			else {
				model.addObject("presenzaMessaggio","si");
				model.addObject("message","Il processo non puo' essere cancellato perche' risulta associato ad almeno un Business Service!");
			}			
			List<DProcessi> processiList = (List<DProcessi>) gestioneDataBase.getElencoProcessi();
			model.addObject("processiList", processiList);
			model.setViewName("elencoProcessi");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on BusinessServiceController.cancellaProcesso");
			gestioneException.gestisciException(model, e,"");
		}
		return model;
	}
}