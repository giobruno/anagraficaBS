package com.ddway.anagraficaBS.web;

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
import com.ddway.anagraficaBS.model.db.anagraficaBS.Users;
import com.ddway.anagraficaBS.model.forms.AccountForm;
import com.ddway.anagraficaBS.model.forms.ModificaPasswordForm;
import com.ddway.anagraficaBS.model.forms.RegistrazioneForm;
import com.ddway.anagraficaBS.service.IDataSourceService;
import com.ddway.anagraficaBS.utility.GestioneDataBase;
import com.ddway.anagraficaBS.utility.GestioneException;
import com.ddway.anagraficaBS.utility.GestioneMail;
import com.ddway.anagraficaBS.utility.PopolaModelDb;
import com.ddway.anagraficaBS.utility.PopolaModelForms;
import com.ddway.anagraficaBS.web.dto.AccountFormValidator;
import com.ddway.anagraficaBS.web.dto.ModificaPasswordFormValidator;
import com.ddway.anagraficaBS.web.dto.RegistrazioneFormValidator;
 
@Controller
public class AccountController {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	IDataSourceService dataSourceService;
	
	@Autowired
	RegistrazioneFormValidator validator;
	
	@Autowired
	AccountFormValidator accountFormValidator;
	
	@Autowired
	PopolaModelDb popolaModelDb; 
	
	@Autowired
	PopolaModelForms popolaModelForms; 
	
	@Autowired
	Users user;
	
	@Autowired
	GestioneDataBase gestioneDataBase; 
	
	@Autowired
	GestioneException gestioneException;
	
	@Autowired
	ModificaPasswordFormValidator modificaPasswordFormValidator;
 
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
		
		String messaggio;
		String oggetto;
		Users administrator;
		
		try{
			validator.validate(registrazioneForm, errors);
			if(errors.hasErrors()){
				model.setViewName("registrazione");
				return model;
			}		
			popolaModelDb.popolaUsersBean(registrazioneForm, user);
			gestioneDataBase.registraUtente(user);		
			administrator = (Users) gestioneDataBase.getAdministretor();
			messaggio = "Salve "+administrator.getNome()+" "+administrator.getCognome()+",\n\nil signor "+user.getNome()+" "+user.getCognome()+" si e' appena registrato al portale 'AnagraficaBS' ed e' in attesa di essere abilitato per effettuare l'accesso.\n\nCordiali Saluti.\n\nassistenza.utilita@tesoro.it ";
			oggetto= "Registrazione nuovo utente su 'AnagraficaBS''";
			GestioneMail.sendEmail(administrator.getEmail(), oggetto, messaggio);
			model.addObject("presenzaMessaggio","si");		
			model.addObject("message","La registrazione e' avvenuta con successo! Appena riceverai l'email di validazione del tuo account, potrai effettuare l'accesso!");
			model.setViewName("login");		
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on AccountController.registrazione");
			gestioneException.gestisciException(model, e,"");						
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
			
		String username;
		
		try{
			username = (String) session.getAttribute("username");
			List<Users> utentiList = (List<Users>) gestioneDataBase.getElencoUtenti(username);
			model.addObject("utentiList", utentiList);	
			model.setViewName("elencoUtenti");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on AccountController.visualizzaElencoProcessi");
			gestioneException.gestisciException(model, e,"");	
			model.setViewName("forward:/visualizzaElencoBusinessServices");
		}
		
		return model;
	}
	
	@RequestMapping(value="/visualizzaAccount", method = RequestMethod.GET)
	public ModelAndView visualizzaAccount(ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo AccountController.visualizzaAccount!");
			
		String username;
		Users user;		
		
		try{
			username = (String) session.getAttribute("username");
			user = (Users) gestioneDataBase.getUtenteByUserName(username);	
			session.setAttribute("user", user);
			model.addObject("user", user);
			model.setViewName("visualizzaAccount");
			return model; 
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on AccountController.visualizzaAccount");
			gestioneException.gestisciException(model, e,"");
		}
		return model;
	}
	
	@RequestMapping(value="/modificaAccountForm", method = RequestMethod.GET)
	public ModelAndView modificaAccountForm(ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo AccountController.modificaAccountForm!");
			
		String username;
		Users users;
		AccountForm accountForm = new AccountForm();
		
		try{
			username = (String) session.getAttribute("username");
			users = (Users) gestioneDataBase.getUtenteByUserName(username);	
			popolaModelForms.popolaAccountForm(users,accountForm);
			model.addObject("accountForm", accountForm);
			model.setViewName("modificaAccount");
			return model; 
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on AccountController.modificaAccountForm");
			gestioneException.gestisciException(model, e,"");
		}
		return model;
	}
	
	@RequestMapping(value="/modificaAccount", method = RequestMethod.GET, params="Modifica")
	public ModelAndView modificaAccount(AccountForm accountForm, BindingResult errors,ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo AccountController.modificaAccount!");
			
		Users user = new Users();
		
		try{
			accountFormValidator.validate(accountForm, errors);
			if(errors.hasErrors()){
				model.setViewName("modificaAccount");
				return model;
				}
			popolaModelDb.popolaUsersBeanFromAccountForm(accountForm, user);	
			gestioneDataBase.modificaUtente(user);	
			session.setAttribute("username",user.getUsername());
			session.setAttribute("utente", user.getNome()+" "+user.getCognome());
			model.addObject("presenzaMessaggio","si");		
			model.addObject("message","I tuoi dati sono stati aggiornati con successo!");
			model.addObject("user", user);
			model.setViewName("visualizzaAccount");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on AccountController.modificaAccount");
			gestioneException.gestisciException(model, e,"");
		}
		return model;
	}
	
	@RequestMapping(value="/modificaAccount", method = RequestMethod.GET, params="Annulla")
	public ModelAndView modificaAccountAnnulla(ModelAndView model) { 
		logger.info("Inizio metodo AccountController.modificaAccountAnnulla!");		
		
		model.setViewName("forward:/visualizzaAccount");
		return model; 
	}
	
	@RequestMapping(value="/modificaPasswordForm", method = RequestMethod.GET)
	public ModelAndView modificaPasswordForm(ModelAndView model,HttpSession session) { 
		logger.info("Inizio metodo AccountController.modificaPasswordForm!");			
		
		Users user;
		ModificaPasswordForm modificaPasswordForm = new ModificaPasswordForm();
		
		try{	
			user = (Users) session.getAttribute("user");
			popolaModelForms.popolaModificaPasswordForm(user, modificaPasswordForm);
			model.addObject("modificaPasswordForm", modificaPasswordForm);
			model.setViewName("modificaPassword");
			return model; 
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on AccountController.modificaPasswordForm");
			gestioneException.gestisciException(model, e,"");
		}
		return model;
	}
	
	@RequestMapping(value="/modificaPassword", method = RequestMethod.GET, params="Modifica")
	public ModelAndView modificaPassword(ModificaPasswordForm modificaPasswordForm, BindingResult errors,ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo AccountController.modificaPassword!");		
		
		Users user = new Users();
		
		try{
			modificaPasswordFormValidator.validate(modificaPasswordForm, errors);
			if(errors.hasErrors()){
				model.setViewName("modificaPassword");
				return model;
				}
			popolaModelDb.popolaUsersBeanFromModificaPasswordForm(modificaPasswordForm, user);	
			gestioneDataBase.modificaUtente(user);	
			session.setAttribute("username",user.getUsername());
			session.setAttribute("utente", user.getNome()+" "+user.getCognome());
			model.addObject("presenzaMessaggio","si");		
			model.addObject("message","La password e' stata modificata con successo!");
			model.addObject("user", user);
			model.setViewName("visualizzaAccount");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on AccountController.modificaAccount");
			gestioneException.gestisciException(model, e,"");
		}
		return model;
	}
	
	@RequestMapping(value="/modificaPassword", method = RequestMethod.GET, params="Annulla")
	public ModelAndView modificaPasswordAnnulla(ModelAndView model) { 
		logger.info("Inizio metodo AccountController.modificaPasswordAnnulla!");		
		
		model.setViewName("forward:/visualizzaAccount");
		return model; 
	}
	
	@RequestMapping(value="/abilitaUtente", method = RequestMethod.GET)
	public ModelAndView abilitaUtente(ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo AccountController.abilitaUtente!");
			
		String userId;
		String username;
		String messaggio;
		String oggetto;
		
		try{
			username = (String) session.getAttribute("username");
			userId = (String) request.getParameter("userId");
			Users utente = (Users) gestioneDataBase.getUtente(userId);			
			gestioneDataBase.abilitaUtente(utente);	
			messaggio = "Ciao "+utente.getNome()+",\n\nti informiamo che il tuo account registrato al portale 'AnagraficaBS' e' stato attivato! \nAdesso potrai effettuare l'accesso.\n\nCordiali Saluti.\n\nassistenza.utilita@tesoro.it ";
			oggetto= "Abilitazione account portale 'AnagraficaBS'";
			GestioneMail.sendEmail(utente.getEmail(), oggetto, messaggio);
			model.addObject("presenzaMessaggio","si");		
			model.addObject("message","L' utente "+utente.getNome()+" "+utente.getCognome()+" e' stato abilitato!");
			List<Users> utentiList = (List<Users>) gestioneDataBase.getElencoUtenti(username);
			model.addObject("utentiList", utentiList);
			model.setViewName("elencoUtenti");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on AccountController.abilitaUtente");
			gestioneException.gestisciException(model, e,"");
		}
		return model;
	}
	
	@RequestMapping(value="/disabilitaUtente", method = RequestMethod.GET)
	public ModelAndView disabilitaUtente(ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo AccountController.disabilitaUtente!");
			
		String userId;
		String username;
		
		try{
			username = (String) session.getAttribute("username");
			userId = (String) request.getParameter("userId");
			Users utente = (Users) gestioneDataBase.getUtente(userId);			
			gestioneDataBase.disabilitaUtente(utente);	
			model.addObject("presenzaMessaggio","si");		
			model.addObject("message","L' utente "+utente.getNome()+" "+utente.getCognome()+" e' stato disabilitato!");
			List<Users> utentiList = (List<Users>) gestioneDataBase.getElencoUtenti(username);
			model.addObject("utentiList", utentiList);
			model.setViewName("elencoUtenti");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on AccountController.disabilitaUtente");
			gestioneException.gestisciException(model, e,"");
		}
		return model;
	}
	
	@RequestMapping(value="/cancellaUtente", method = RequestMethod.GET)
	public ModelAndView cancellaUtente(ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo AccountController.cancellaUtente!");
			
		String userId;
		String username;
		
		try{
			username = (String) session.getAttribute("username");
			userId = (String) request.getParameter("userId");
			Users utente = (Users) gestioneDataBase.getUtente(userId);			
			gestioneDataBase.cancellaUtente(utente);	
			model.addObject("presenzaMessaggio","si");		
			model.addObject("message","L' utente "+utente.getNome()+" "+utente.getCognome()+" e' stato cancellato!");
			List<Users> utentiList = (List<Users>) gestioneDataBase.getElencoUtenti(username);
			model.addObject("utentiList", utentiList);
			model.setViewName("elencoUtenti");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on AccountController.cancellaUtente");
			gestioneException.gestisciException(model, e,"");
		}
		return model;
	}
	
	@RequestMapping(value="/richiestaDatiAccessoForm", method = RequestMethod.GET)
	public ModelAndView richiestaDatiAccessoForm(ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo AccountController.richiestaDatiAccessoForm!");
			
		String userId;
		String username;
		
		try{
			model.addObject("presenzaMessaggio","si");		
			model.addObject("message","La tua richiesta e' stata inoltrata! A breve riceverai un'email all'indirizzo di posta elettronica utilizzato per registrarti, con i tuoi dati di accesso.");
			model.setViewName("login");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on AccountController.richiestaDatiAccessoForm");
			gestioneException.gestisciException(model, e,"");
		}
		return model;
	}
	
	@RequestMapping(value="/richiestaDatiAccesso", method = RequestMethod.GET)
	public ModelAndView richiestaDatiAccesso(ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo AccountController.richiestaDatiAccesso!");
			
		String userId;
		String username;
		
		try{
			model.addObject("presenzaMessaggio","si");		
			model.addObject("message","La tua richiesta e' stata inoltrata! A breve riceverai un'email all'indirizzo di posta elettronica utilizzato per registrarti, con i tuoi dati di accesso.");
			model.setViewName("login");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on AccountController.richiestaDatiAccesso");
			gestioneException.gestisciException(model, e,"");
		}
		return model;
	}
}