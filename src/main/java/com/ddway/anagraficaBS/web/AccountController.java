package com.ddway.anagraficaBS.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ddway.anagraficaBS.model.db.anagraficaBS.DProcessi;
import com.ddway.anagraficaBS.model.db.anagraficaBS.Users;
import com.ddway.anagraficaBS.model.forms.RegistrazioneForm;
import com.ddway.anagraficaBS.service.IDataSourceService;
import com.ddway.anagraficaBS.utility.GestioneDataBase;
import com.ddway.anagraficaBS.utility.PopolaModelDb;
import com.ddway.anagraficaBS.utility.PopolaModelForms;
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
	PopolaModelForms popolaModelForms; 
	
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
	
	@RequestMapping(value="/registrazione", method = RequestMethod.POST, params="Registrati")
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
			model.addObject("messaggio","La registrazione è avvenuta con successo! Appena riceverai l'email di validazione del tuo account, potrai effettuare l'accesso!");
			model.setViewName("login");		
		}catch(Exception e){
			logger.error(e.getMessage()+" on AccountController.registrazione");
		}
		return model; 
	}
	
	@RequestMapping(value="/registrazione", method = RequestMethod.POST, params="Annulla")
	public ModelAndView registrazioneAnnulla(ModelAndView model) { 
		logger.info("Inizio metodo AccountController.registrazioneAnnulla!");		
		
		model.setViewName("home");
		return model; 
	}
	
	@RequestMapping(value="/visualizzaElencoUtenti", method = RequestMethod.GET)
	public ModelAndView visualizzaElencoUtenti(ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo AccountController.visualizzaElencoUtenti!");
			
		try{
			User user = (User) session.getAttribute("user");
			List<Users> utentiList = (List<Users>) gestioneDataBase.getElencoUtenti(user.getUsername());
			model.addObject("utentiList", utentiList);
			model.setViewName("elencoUtenti");
		}catch(Exception e){
			logger.error(e.getMessage()+" on AccountController.visualizzaElencoProcessi");
		}
		return model;
	}
	
	@RequestMapping(value="/visualizzaAccount", method = RequestMethod.GET)
	public ModelAndView visualizzaAccount(ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo AccountController.visualizzaAccount!");
			
		User user;
		Users users;
		RegistrazioneForm registrazioneForm = new RegistrazioneForm();
		
		try{
			user = (User) session.getAttribute("user");
			users = (Users) gestioneDataBase.getUtenteByUserName(user.getUsername());	
			popolaModelForms.popolaRegistrazioneForm(users,registrazioneForm);
			model.addObject("registrazioneForm", registrazioneForm);
			model.setViewName("visualizzaAccount");
			return model; 
		}catch(Exception e){
			logger.error(e.getMessage()+" on AccountController.visualizzaAccount");
		}
		return model;
	}
	
	@RequestMapping(value="/modificaAccount", method = RequestMethod.GET, params="Modifica")
	public ModelAndView modificaAccount(RegistrazioneForm registrazioneForm, BindingResult errors,ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo AccountController.modificaAccount!");
			
		Users user = new Users();
		
		try{
			validator.validate(registrazioneForm, errors);
			if(errors.hasErrors()){
				model.setViewName("visualizzaAccount");
				return model;
				}
			popolaModelDb.popolaUsersBean(registrazioneForm, user);	
			gestioneDataBase.modificaUtente(user);
			model.addObject("presenzaMessaggio","si");		
			model.addObject("message","I tuoi dati sono stati aggiornati con successo!");
			model.setViewName("visualizzaAccount");
		}catch(Exception e){
			logger.error(e.getMessage()+" on AccountController.modificaAccount");
		}
		return model;
	}
	
	@RequestMapping(value="/modificaAccount", method = RequestMethod.GET, params="Annulla")
	public ModelAndView modificaAccountAnnulla(ModelAndView model) { 
		logger.info("Inizio metodo AccountController.modificaAccountAnnulla!");		
		
		model.setViewName("forward:/visualizzaElencoBusinessServices");
		return model; 
	}
	
	@RequestMapping(value="/abilitaUtente", method = RequestMethod.GET)
	public ModelAndView abilitaUtente(ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo AccountController.abilitaUtente!");
			
		String userId;
		
		try{
			User user = (User) session.getAttribute("user");
			userId = (String) request.getParameter("userId");
			Users utente = (Users) gestioneDataBase.getUtente(userId);			
			gestioneDataBase.abilitaUtente(utente);	
			model.addObject("presenzaMessaggio","si");		
			model.addObject("message","L' utente "+utente.getNome()+" "+utente.getCognome()+" è stato abilitato!");
			List<Users> utentiList = (List<Users>) gestioneDataBase.getElencoUtenti(user.getUsername());
			model.addObject("utentiList", utentiList);
			model.setViewName("elencoUtenti");
		}catch(Exception e){
			logger.error(e.getMessage()+" on AccountController.abilitaUtente");
		}
		return model;
	}
	
	@RequestMapping(value="/disabilitaUtente", method = RequestMethod.GET)
	public ModelAndView disabilitaUtente(ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo AccountController.disabilitaUtente!");
			
		String userId;
		
		try{
			User user = (User) session.getAttribute("user");
			userId = (String) request.getParameter("userId");
			Users utente = (Users) gestioneDataBase.getUtente(userId);			
			gestioneDataBase.disabilitaUtente(utente);	
			model.addObject("presenzaMessaggio","si");		
			model.addObject("message","L' utente "+utente.getNome()+" "+utente.getCognome()+" è stato disabilitato!");
			List<Users> utentiList = (List<Users>) gestioneDataBase.getElencoUtenti(user.getUsername());
			model.addObject("utentiList", utentiList);
			model.setViewName("elencoUtenti");
		}catch(Exception e){
			logger.error(e.getMessage()+" on AccountController.disabilitaUtente");
		}
		return model;
	}
	
	@RequestMapping(value="/cancellaUtente", method = RequestMethod.GET)
	public ModelAndView cancellaUtente(ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo AccountController.cancellaUtente!");
			
		String userId;
		
		try{
			User user = (User) session.getAttribute("user");
			userId = (String) request.getParameter("userId");
			Users utente = (Users) gestioneDataBase.getUtente(userId);			
			gestioneDataBase.cancellaUtente(utente);	
			model.addObject("presenzaMessaggio","si");		
			model.addObject("message","L' utente "+utente.getNome()+" "+utente.getCognome()+" è stato cancellato!");
			List<Users> utentiList = (List<Users>) gestioneDataBase.getElencoUtenti(user.getUsername());
			model.addObject("utentiList", utentiList);
			model.setViewName("elencoUtenti");
		}catch(Exception e){
			logger.error(e.getMessage()+" on AccountController.cancellaUtente");
		}
		return model;
	}
}