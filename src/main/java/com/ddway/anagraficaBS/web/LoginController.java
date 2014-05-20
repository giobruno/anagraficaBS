package com.ddway.anagraficaBS.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ddway.anagraficaBS.model.db.anagraficaBS.Users;
import com.ddway.anagraficaBS.utility.GestioneControlli;
import com.ddway.anagraficaBS.utility.GestioneDataBase;
import com.ddway.anagraficaBS.utility.GestioneException;
import com.ddway.anagraficaBS.utility.GestioneMail;
 
@Controller
public class LoginController {
	
	@Autowired
	GestioneDataBase gestioneDataBase;
	
	@Autowired
	GestioneException gestioneException;		
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
 
	@RequestMapping(value="/dashboard", method = RequestMethod.GET)
	public ModelAndView dashboard(ModelAndView model, HttpSession session, HttpServletRequest request) { 
		logger.info("Inizio metodo LoginController.dashboard!");
		
		Authentication auth;	
		User user; 		
		Users users;
		
		try{
//			GestioneMail.sendEmail("bruno_giovanni@hotmail.it", "prova", "prova");
			auth = SecurityContextHolder.getContext().getAuthentication();		
			user = (User) auth.getPrincipal();
			session.setAttribute("username", user.getUsername());
			users = (Users) gestioneDataBase.getUtenteByUserName(user.getUsername());
			session.setAttribute("utente", users.getNome()+" "+users.getCognome());
			session.setAttribute("user", users);			
			model.setViewName("forward:/visualizzaElencoBusinessServices");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on LoginController.dashboard");
			gestioneException.gestisciException(model, e,"");
		}
		return model;
	}
 
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView login(ModelAndView model) {
		logger.info("Inizio metodo LoginController.login!");
		
		model.setViewName("login");
		return model;
 
	}
	
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public ModelAndView loginfailed(ModelAndView model) {
		logger.info("Inizio metodo LoginController.loginfailed!");
 
		model.addObject("error", "true");
		model.setViewName("login");
		return model;
 
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public ModelAndView logout(ModelAndView model) {
		logger.info("Inizio metodo LoginController.logout!");
		
		model.setViewName("forward:/home");
		return model;
 
	}
	
}