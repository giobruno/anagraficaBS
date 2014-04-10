package com.ddway.anagraficaBS.web;

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
import com.ddway.anagraficaBS.model.db.DProcessi;
import com.ddway.anagraficaBS.model.db.DServiziModel;
import com.ddway.anagraficaBS.model.db.DServiziProcessi;
import com.ddway.anagraficaBS.model.forms.AssociazioneBSProcessoForm;
import com.ddway.anagraficaBS.model.forms.BusinessServiceForm;
import com.ddway.anagraficaBS.model.forms.ProcessoForm;
import com.ddway.anagraficaBS.service.IDataSourceService;
import com.ddway.anagraficaBS.utility.CaricaSelect;
import com.ddway.anagraficaBS.utility.GestioneDataBase;
import com.ddway.anagraficaBS.utility.PopolaModelDb;
import com.ddway.anagraficaBS.utility.PopolaModelForms;
import com.ddway.anagraficaBS.web.dto.AssociazioneBSProcessoFormValidator;
import com.ddway.anagraficaBS.web.dto.ProcessoFormValidator;
 
@Controller
public class ProcessiController {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	IDataSourceService dataSourceService;
	
	@Autowired
	ProcessoFormValidator processoFormValidator;
	
	@Autowired
	AssociazioneBSProcessoFormValidator associazioneBSProcessoFormValidator;
	
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
			model.addObject("message","Il nuovo processo è stato inserito con successo!");
			List<DProcessi> processiList = (List<DProcessi>) gestioneDataBase.getElencoProcessi();
			model.addObject("processiList", processiList);
			model.setViewName("elencoProcessi");
		}catch(Exception e){
			logger.error(e.getMessage()+" on ProcessiController.inserimentoprocesso");
		}
		return model;
	}
	
	@RequestMapping(value="/inserimentoProcesso", method = RequestMethod.POST, params="Annulla")
	public ModelAndView formProcessoAnnulla(ModelAndView model) throws Exception { 
		logger.info("Inizio metodo ProcessiController.formProcessoAnnulla!");		
		
		List<DProcessi> processiList = (List<DProcessi>) gestioneDataBase.getElencoProcessi();
		model.addObject("processiList", processiList);
		model.setViewName("elencoProcessi");
		return model; 
	}
	
	@RequestMapping(value="/formAssociazioneBSProcesso", method = RequestMethod.GET)
	public ModelAndView formAssociazioneBSProcesso(ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo ProcessiController.formAssociazioneBSProcesso!");		
		
		HashMap<String, List> selectboxes;
		
		try{
			selectboxes = caricaSelect.getSelectsInserimentoAssociazioneBSProcesso("formAssociazioneBSProcesso");	
			
			model.addObject("associazioneBSProcessoForm", new AssociazioneBSProcessoForm());
			model.addAllObjects(selectboxes);
			model.setViewName("associazione_BS_processo");
		}catch(Exception e){
			logger.error(e.getMessage()+" on ProcessiController.formAssociazioneBSProcesso");
		}
		return model;
	}
	
	@RequestMapping(value="/inserimentoAssociazioneBSProcesso", method = RequestMethod.POST, params="Associa")
	public ModelAndView inserimentoAssociazioneBSProcesso(AssociazioneBSProcessoForm associazioneBSProcessoForm, BindingResult errors, ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo ProcessiController.inserimentoAssociazioneBSProcesso!");
		
		HashMap<String, List> selectboxes;
		
		try{
			selectboxes = caricaSelect.getSelectsInserimentoAssociazioneBSProcesso("formAssociazioneBSProcesso");
			
			associazioneBSProcessoFormValidator.validate(associazioneBSProcessoForm, errors);
			if(errors.hasErrors()){
				model.addAllObjects(selectboxes);
				model.setViewName("associazione_BS_processo");
				return model;
			}
			popolaModelDb.popolaDServiziProcessiBean(associazioneBSProcessoForm,dServiziProcessi);
			gestioneDataBase.inserisciAssociazioneBSProcesso(dServiziProcessi);			
			model.addObject("presenzaMessaggio","si");
			model.addObject("message","L'associazione Business Service - Processo è stata inserita con successo!");
			List<DBusinessServices> businessServiceList = (List<DBusinessServices>) gestioneDataBase.getElencoBusinessServices();
			model.addObject("businessServiceList", businessServiceList);
			model.setViewName("elencoBusinessService");
		}catch(Exception e){
			logger.error(e.getMessage()+" on ProcessiController.inserimentoAssociazioneBSProcesso");
		}
		return model;
	}
	
	@RequestMapping(value="/inserimentoAssociazioneBSProcesso", method = RequestMethod.POST, params="Annulla")
	public ModelAndView inserimentoAssociazioneBSProcessoAnnulla(ModelAndView model) { 
		logger.info("Inizio metodo ProcessiController.inserimentoAssociazioneBSProcessoAnnulla!");		
		
		try{
			List<DBusinessServices> businessServiceList = (List<DBusinessServices>) gestioneDataBase.getElencoBusinessServices();
			model.addObject("businessServiceList", businessServiceList);
			model.setViewName("elencoBusinessService");
		}catch(Exception e){
			logger.error(e.getMessage()+" on BusinessServiceController.visualizzaElencoBusinessServices");
		}
		return model;
	}
	
	@RequestMapping(value="/visualizzaElencoProcessi", method = RequestMethod.GET)
	public ModelAndView visualizzaElencoProcessi(ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo BusinessServiceController.visualizzaElencoProcessi!");
			
		try{
			List<DProcessi> processiList = (List<DProcessi>) gestioneDataBase.getElencoProcessi();
			model.addObject("processiList", processiList);
			model.setViewName("elencoProcessi");
		}catch(Exception e){
			logger.error(e.getMessage()+" on BusinessServiceController.visualizzaElencoProcessi");
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
			logger.error(e.getMessage()+" on BusinessServiceController.modificaProcessoForm");
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
			model.addObject("message","Il Processo è stato modificato con successo!");
			List<DProcessi> processiList = (List<DProcessi>) gestioneDataBase.getElencoProcessi();
			model.addObject("processiList", processiList);
			model.setViewName("elencoProcessi");
		}catch(Exception e){
			logger.error(e.getMessage()+" on BusinessServiceController.modificaProcesso!");
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
			logger.error(e.getMessage()+" on BusinessServiceController.visualizzaElencoProcessi");
		}
		return model;
	}
	
	@RequestMapping(value="/cancellaProcesso", method = RequestMethod.GET)
	public ModelAndView cancellaProcesso(ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo BusinessServiceController.cancellaProcesso!");
			
		String codiProcesso;
		DProcessi processo;
		
		try{
			codiProcesso = request.getParameter("codiProcesso");
			processo = (DProcessi) gestioneDataBase.getProcesso(codiProcesso);
			gestioneDataBase.cancellaProcesso(processo);
			model.addObject("presenzaMessaggio","si");
			model.addObject("message","Il Processo è stato cancellato con successo!");
			List<DProcessi> processiList = (List<DProcessi>) gestioneDataBase.getElencoProcessi();
			model.addObject("processiList", processiList);
			model.setViewName("elencoProcessi");
		}catch(Exception e){
			logger.error(e.getMessage()+" on BusinessServiceController.cancellaProcesso");
		}
		return model;
	}
}