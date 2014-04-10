package com.ddway.anagraficaBS.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.ddway.anagraficaBS.model.db.Users;
import com.ddway.anagraficaBS.model.forms.RegistrazioneForm;
import com.ddway.anagraficaBS.service.IDataSourceService;
import com.ddway.anagraficaBS.utility.GestioneDataBase;
import com.ddway.anagraficaBS.utility.PopolaModelDb;
import com.ddway.anagraficaBS.web.dto.RegistrazioneFormValidator;
 
@Controller
public class AccountController {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	IDataSourceService dataSourceService;
	
	@Autowired
	RegistrazioneFormValidator validator;
	
	@Autowired
	PopolaModelDb popolaModelDb;
	
	@Autowired
	Users user;
	
	@Autowired
	GestioneDataBase gestioneDataBase; 
 
	@RequestMapping(value="/formRegistrazione", method = RequestMethod.GET)
	public ModelAndView formRegistrazione(ModelAndView model, HttpSession session, HttpServletRequest request) { 
		logger.info("Inizio metodo AccountController.formRegistrazione!");
		
		model.addObject("registrazioneForm", new RegistrazioneForm());
		model.setViewName("registrazione");
		return model; 
	}	
	
	@RequestMapping(value="/registrazione", method = RequestMethod.POST, params="Invia")
	public ModelAndView registrazione(RegistrazioneForm registrazioneForm, BindingResult errors, ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo AccountController.registrazione!");
		
		try{
			validator.validate(registrazioneForm, errors);
			if(errors.hasErrors()){
				model.setViewName("registrazione");
				return model;
			}		
			popolaModelDb.popolaUsersBean(registrazioneForm, user);
			gestioneDataBase.registraUtente(user);		
			model.addObject("presenzaMessaggio","si");		
			model.addObject("messaggio","La registrazione è avvenuta con successo! Adesso puoi effettuare il login!");
			model.setViewName("login");		
		}catch(Exception e){
			logger.error(e.getMessage()+" on AccountController.registrazione");
		}
		return model; 
	}
	
	@RequestMapping(value="/registrazione", method = RequestMethod.POST, params="Annulla")
	public ModelAndView registrazioneAnnulla(ModelAndView model) { 
		logger.info("Inizio metodo AccountController.registrazioneAnnulla!");		
		
		model.setViewName("dashboard");
		return model; 
	}
}