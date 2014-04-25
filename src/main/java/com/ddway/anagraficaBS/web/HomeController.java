package com.ddway.anagraficaBS.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView model) {
		logger.info("Inizio metodo HomeController.home!");			
		
		model.setViewName("home");
		return model;
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home2(ModelAndView model) {
		logger.info("Inizio metodo HomeController.home2!");			
		
		model.setViewName("home");
		return model;
	}
	
	@RequestMapping(value="/elencoReport", method = RequestMethod.GET)
	public ModelAndView elencoReport(ModelAndView model, HttpSession session, HttpServletRequest request) { 
		logger.info("Inizio metodo ReportController.elencoReport!");
		
		model.setViewName("elencoReport");
		return model; 
	}
	
}
