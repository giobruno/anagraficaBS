package com.ddway.anagraficaBS.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class AccountController {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
 
	@RequestMapping(value="/formRegistrazione", method = RequestMethod.GET)
	public String formRegistrazione(ModelMap model, HttpSession session, HttpServletRequest request) { 
		logger.info("Inizio metodo AccountController.formRegistrazione!");
		
		return "registrazione"; 
	}	
	
	@RequestMapping(value="/registrazione", method = RequestMethod.GET)
	public String registrazione(ModelMap model, HttpSession session, HttpServletRequest request) { 
		logger.info("Inizio metodo AccountController.registrazione!");
		
		return "login";
 
	}
}