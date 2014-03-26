package com.ddway.anagraficaBS.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
 
	@RequestMapping(value="/dashboard", method = RequestMethod.GET)
	public String dashboard(ModelMap model, HttpSession session, HttpServletRequest request) { 
		logger.info("Inizio metodo LoginController.dashboard!");
		
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		User user = (User) auth.getPrincipal();
		String name = user.getUsername();
	
		model.addAttribute("username", name);
		model.addAttribute("message", "Spring Security login + database example");
		return "dashboard"; 
	}
 
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		logger.info("Inizio metodo LoginController.login!");
 
		return "login";
 
	}
	
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginfailed(ModelMap model) {
		logger.info("Inizio metodo LoginController.loginfailed!");
 
		model.addAttribute("error", "true");
		return "login";
 
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		logger.info("Inizio metodo LoginController.logout!");
 
		return "login";
 
	}
	
}