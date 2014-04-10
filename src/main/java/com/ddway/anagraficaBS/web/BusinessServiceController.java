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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.ddway.anagraficaBS.model.db.DBusinessServices;
import com.ddway.anagraficaBS.model.db.DServiziFunzioni;
import com.ddway.anagraficaBS.model.db.DServiziModel;
import com.ddway.anagraficaBS.model.db.VInfap;
import com.ddway.anagraficaBS.model.forms.AssociazioneBSFunzUtenteForm;
import com.ddway.anagraficaBS.model.forms.BusinessServiceForm;
import com.ddway.anagraficaBS.model.forms.ElencoFunzioniForm;
import com.ddway.anagraficaBS.model.forms.RicercaFunzioniUtenteForm;
import com.ddway.anagraficaBS.service.IDataSourceService;
import com.ddway.anagraficaBS.utility.CaricaSelect;
import com.ddway.anagraficaBS.utility.GestioneDataBase;
import com.ddway.anagraficaBS.utility.PopolaModelDb;
import com.ddway.anagraficaBS.utility.PopolaModelForms;
import com.ddway.anagraficaBS.web.dto.AssociazioneBSFunzUtenteFormValidator;
import com.ddway.anagraficaBS.web.dto.BusinessServiceFormValidator;
import com.ddway.anagraficaBS.web.dto.ElencoFunzioniFormValidator;
import com.ddway.anagraficaBS.web.dto.RicercaFunzioniUtenteFormValidator;
 
@Controller
public class BusinessServiceController {
	
	private static final Logger logger = LoggerFactory.getLogger(BusinessServiceController.class);
	
	@Autowired
	IDataSourceService dataSourceService;	
	
	@Autowired
	AssociazioneBSFunzUtenteFormValidator associazioneBSFunzUtenteFormValidator;
	
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
			logger.error(e.getMessage()+" on BusinessServiceController.formBusinessService");
		}
		return model;
	}
	
	@RequestMapping(value="/inserimentoBusinessService", method = RequestMethod.POST, params="Avanti")
	public ModelAndView inserimentoBusinessService(BusinessServiceForm businessServiceForm, BindingResult errors, ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo BusinessServiceController.inserimentoBusinessService!");
		
		HashMap<String, List> selectboxes;
		
		try{			
			businessServiceFormValidator.validate(businessServiceForm, errors);
			if(errors.hasErrors()){			
				selectboxes = caricaSelect.getSelectsInserimentoBusinessService("formBusinessService");
				model.addAllObjects(selectboxes);
				model.setViewName("inserimentoBusinessService");
				return model;
			}		
			if(!businessServiceForm.getFlagConvenzione()){				
				gestioneDataBase.inserisciBusinessService(businessServiceForm);
				model.addObject("presenzaMessaggio","si");
				model.addObject("message","Il nuovo Business Service è stato inserito con successo!");
				model.setViewName("dashboard");
			}
			else {
				session.setAttribute("businessServiceForm", businessServiceForm);
				selectboxes = caricaSelect.getSelectsRicercaFunzioniUtenteForm("formRicercaFunzioniUtente");			
				model.addAllObjects(selectboxes);
				model.addObject("ricercaFunzioniUtenteForm", new RicercaFunzioniUtenteForm());
				model.setViewName("ricercaFunzioniUtente");
			}
			}catch(Exception e){
				logger.error(e.getMessage()+" on BusinessServiceController.inserimentoBusinessService");
			}
			return model; 		
	}
	
	@RequestMapping(value="/inserimentoBusinessService", method = RequestMethod.POST, params="Annulla")
	public ModelAndView inserimentoBusinessServiceAnnulla(ModelAndView model) { 
		logger.info("Inizio metodo BusinessServiceController.inserimentoBusinessServiceAnnulla!");		
		
		model.setViewName("dashboard");
		return model; 
	}
	
	@RequestMapping(value="/ricercaFunzioniUtente", method = RequestMethod.POST, params="Ricerca")
	public ModelAndView ricercaFunzioniUtente(RicercaFunzioniUtenteForm ricercaFunzioniUtenteForm, BindingResult errors, ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo BusinessServiceController.formAssociazioneBSFunzUtente!");
				
		HashMap<String, List> selectboxes;
		List<VInfap> funzioniList;
		
		try{			
			ricercaFunzioniUtenteFormValidator.validate(ricercaFunzioniUtenteForm, errors);
			if(errors.hasErrors()){			
				selectboxes = caricaSelect.getSelectsRicercaFunzioniUtenteForm("formRicercaFunzioniUtente");
				model.addAllObjects(selectboxes);				
				model.setViewName("ricercaFunzioniUtente");
				return model;
			}	
			session.setAttribute("ricercaFunzioniUtenteForm", ricercaFunzioniUtenteForm);
			funzioniList = gestioneDataBase.getListaFunzioniUtente(ricercaFunzioniUtenteForm.getCodiArea(), ricercaFunzioniUtenteForm.getCodiApplicazione());
			model.addObject("elencoFunzioniForm", new ElencoFunzioniForm());
			model.addObject("funzioniList",funzioniList);
			model.setViewName("elencoFunzioniUtente");
		}catch(Exception e){
			logger.error(e.getMessage()+" on BusinessServiceController.formAssociazioneBSFunzUtente");
		}
		return model; 
	}
	
	@RequestMapping(value="/ricercaFunzioniUtente", method = RequestMethod.POST, params="Indietro")
	public ModelAndView ricercaFunzioniUtenteIndietro(ModelAndView model,HttpSession session) { 
		logger.info("Inizio metodo BusinessServiceController.ricercaFunzioniUtenteIndietro!");		
		
		HashMap<String, List> selectboxes;
		
		try{
			selectboxes = caricaSelect.getSelectsInserimentoBusinessService("formBusinessService");			
			model.addAllObjects(selectboxes);
			model.addObject("businessServiceForm", (BusinessServiceForm) session.getAttribute("businessServiceForm"));
			model.setViewName("inserimentoBusinessService");
		}catch(Exception e){
			logger.error(e.getMessage()+" on BusinessServiceController.ricercaFunzioniUtenteIndietro");
		}		
		return model; 
	}
	
	@RequestMapping(value="/ricercaFunzioniUtente", method = RequestMethod.POST, params="Annulla")
	public ModelAndView ricercaFunzioniUtenteAnnulla(ModelAndView model) { 
		logger.info("Inizio metodo BusinessServiceController.ricercaFunzioniUtenteAnnulla!");		
		
		model.setViewName("dashboard");
		return model; 
	}
	
	@RequestMapping(value="/inserisciFunzioniUtente", method = RequestMethod.POST, params="Associa")
	public ModelAndView inserisciFunzioniUtente(ElencoFunzioniForm elencoFunzioniForm, BindingResult errors, ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo BusinessServiceController.inserisciFunzioniUtente!");
				
		HashMap<String, List> selectboxes;
		ArrayList<DServiziFunzioni> dServiziFunzioniList = new ArrayList<DServiziFunzioni>();
		int codiBusinessService;
		
		try{			
			elencoFunzioniFormValidator.validate(elencoFunzioniForm, errors);
			if(errors.hasErrors()){			
				selectboxes = caricaSelect.getSelectsRicercaFunzioniUtenteForm("formRicercaFunzioniUtente");
				model.addAllObjects(selectboxes);				
				model.setViewName("ricercaFunzioniUtente");
				return model;
			}	
			BusinessServiceForm businessServiceForm = (BusinessServiceForm) session.getAttribute("businessServiceForm");
			RicercaFunzioniUtenteForm ricercaFunzioniUtenteForm = (RicercaFunzioniUtenteForm) session.getAttribute("ricercaFunzioniUtenteForm");
			codiBusinessService = gestioneDataBase.inserisciBusinessService(businessServiceForm);		
			popolaModelDb.popolaDServiziFunzioniBeanList(elencoFunzioniForm,codiBusinessService,ricercaFunzioniUtenteForm,dServiziFunzioniList);
			gestioneDataBase.inserisciAssociazioniBSFunzUtente(dServiziFunzioniList);
			selectboxes = caricaSelect.getSelectsRicercaFunzioniUtenteForm("formRicercaFunzioniUtente");			
			model.addAllObjects(selectboxes);
			model.addObject("ricercaFunzioniUtenteForm", new RicercaFunzioniUtenteForm());			
			model.addObject("presenzaMessaggio","si");
			model.addObject("message","Le seguenti Funzioni Utente sono state associate!");
			model.setViewName("ricercaFunzioniUtente");
		}catch(Exception e){
			logger.error(e.getMessage()+" on BusinessServiceController.formAssociazioneBSFunzUtente");
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
			logger.error(e.getMessage()+" on BusinessServiceController.inserisciFunzioniUtenteIndietro!");
		}
		return model; 
	}
	
	@RequestMapping(value="/inserisciFunzioniUtente", method = RequestMethod.POST, params="Annulla")
	public ModelAndView inserisciFunzioniUtenteAnnulla(ModelAndView model) { 
		logger.info("Inizio metodo BusinessServiceController.inserisciFunzioniUtenteAnnulla!");		
		
		model.setViewName("dashboard");
		return model; 
	}
	
	@RequestMapping(value="/formAssociazioneBSFunzUtente", method = RequestMethod.GET)
	public ModelAndView formAssociazioneBSFunzUtente(ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo BusinessServiceController.formAssociazioneBSFunzUtente!");
				
		HashMap<String, List> selectboxes;
		
		try{
			selectboxes = caricaSelect.getSelectsInserimentoAssociazioneBSFunzUtente("formAssociazioneBSFunzUtente");			
			model.addAllObjects(selectboxes);
			model.addObject("associazioneBSFunzUtenteForm", new AssociazioneBSFunzUtenteForm());
			model.setViewName("associazione_BS_funzioneUtente");
		}catch(Exception e){
			logger.error(e.getMessage()+" on BusinessServiceController.formAssociazioneBSFunzUtente");
		}
		return model; 
	}
	
	@RequestMapping(value="/inserimentoAssociazioneBSFunzUtente", method = RequestMethod.POST, params="Invia")
	public ModelAndView inserimentoAssociazioneBSFunzUtente(AssociazioneBSFunzUtenteForm associazioneBSFunzUtenteForm, BindingResult errors, ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo BusinessServiceController.inserimentoAssociazioneBSFunzUtente!");
		
		HashMap<String, List> selectboxes;
		
		try{
			selectboxes = caricaSelect.getSelectsInserimentoAssociazioneBSFunzUtente("formAssociazioneBSFunzUtente");			
			associazioneBSFunzUtenteFormValidator.validate(associazioneBSFunzUtenteForm, errors);
			if(errors.hasErrors()){			
				model.addAllObjects(selectboxes);
				model.setViewName("associazione_BS_funzioneUtente");
				return model;
			}		
			popolaModelDb.popolaDServiziFunzioniBean(associazioneBSFunzUtenteForm,dServiziFunzioni);
//			gestioneDataBase.inserisciAssociazioneBSFunzUtente(dServiziFunzioni);
			model.addObject("presenzaMessaggio","si");
			model.addObject("message","L'associazione Business Service - Funzione Utente è stata inserita con successo!!");
			model.setViewName("dashboard");
		}catch(Exception e){
			logger.error(e.getMessage()+" on BusinessServiceController.inserimentoAssociazioneBSFunzUtente");
		}
		return model;
	}
	
	@RequestMapping(value="/inserimentoAssociazioneBSFunzUtente", method = RequestMethod.POST, params="Annulla")
	public ModelAndView inserimentoAssociazioneBSFunzUtenteAnnulla(ModelAndView model) { 
		logger.info("Inizio metodo BusinessServiceController.inserimentoAssociazioneBSFunzUtenteAnnulla!");		
		
		model.setViewName("dashboard");
		return model; 
	}
	
	@RequestMapping(value="/visualizzaElencoBusinessServices", method = RequestMethod.GET)
	public ModelAndView visualizzaElencoBusinessServices(ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo BusinessServiceController.visualizzaElencoBusinessServices!");
			
		try{
			List<DBusinessServices> businessServiceList = (List<DBusinessServices>) gestioneDataBase.getElencoBusinessServices();
			model.addObject("businessServiceList", businessServiceList);
			model.setViewName("elencoBusinessService");
		}catch(Exception e){
			logger.error(e.getMessage()+" on BusinessServiceController.visualizzaElencoBusinessServices");
		}
		return model;
	}
	
	
	
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
			dServiziModel = (DServiziModel) gestioneDataBase.getModelApplicativo(codiBusinessService);
			popolaModelForms.popolaBusinessServiceForm(businessService, dServiziModel,businessServiceFormAutoWired);
			session.setAttribute("businessServiceFormOld", businessService);
			model.addObject("businessServiceForm", businessServiceFormAutoWired);
			model.addAllObjects(selectboxes);
			model.setViewName("modificaBusinessService");
		}catch(Exception e){
			logger.error(e.getMessage()+" on BusinessServiceController.modificaBusinessService");
		}
		return model;
	}
	
	@RequestMapping(value="/modificaBusinessService", method = RequestMethod.POST, params="Modifica")
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
			DBusinessServices businessServiceFormOld = (DBusinessServices) session.getAttribute("businessServiceFormOld");
			gestioneDataBase.modificaBusinessService(businessServiceForm,businessServiceFormOld);
			session.removeAttribute("businessServiceFormOld");
			model.addObject("presenzaMessaggio","si");
			model.addObject("message","Il Business Service è stato modificato con successo!");
			model.setViewName("dashboard");
		}catch(Exception e){
			logger.error(e.getMessage()+" on BusinessServiceController.modificaBusinessService!");
		}
		return model;
	}
	
	@RequestMapping(value="/modificaBusinessService", method = RequestMethod.GET, params="Annulla")
	public ModelAndView modificaBusinessServiceAnnulla(ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo BusinessServiceController.modificaBusinessServiceAnnulla!");
			
		model.setViewName("dashboard");
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
			gestioneDataBase.cancellaBusinessService(businessService);
			model.addObject("presenzaMessaggio","si");
			model.addObject("message","Il Business Service è stato cancellato con successo!");
			model.setViewName("dashboard");
		}catch(Exception e){
			logger.error(e.getMessage()+" on BusinessServiceController.cancellaBusinessService");
		}
		return model;
	}	
}