package com.ddway.anagraficaBS.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

import com.ddway.anagraficaBS.model.bean.BusinessServiceBean;
import com.ddway.anagraficaBS.model.bean.ModelApplicativoPiuBSAssoicatiBean;
import com.ddway.anagraficaBS.model.db.anagraficaBS.Users;
import com.ddway.anagraficaBS.utility.GestioneException;
import com.ddway.anagraficaBS.utility.GestioneMail;

@Controller
public class HomeController {
	
	@Autowired
	GestioneException gestioneException;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView model) {
		logger.info("Inizio metodo HomeController.home!");			
		
		model.setViewName("forward:/home");
		return model;
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home2(ModelAndView model,HttpSession session) {
		logger.info("Inizio metodo HomeController.home2!");			
		

		Authentication auth;	
		User user; 			
		
		String utente = (String) session.getAttribute("utente");
		if(utente == null)
			model.setViewName("home");
		else model.setViewName("forward:/visualizzaElencoBusinessServices");
		return model;
	}
	
	@RequestMapping(value="/elencoReport", method = RequestMethod.GET)
	public ModelAndView elencoReport(ModelAndView model, HttpSession session, HttpServletRequest request) { 
		logger.info("Inizio metodo ReportController.elencoReport!");
		
		model.setViewName("elencoReport");
		return model; 
	}
	
	@RequestMapping(value="/invioEmail", method = RequestMethod.GET)
	public ModelAndView invioEmail(ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo HomeController.invioEmail!");
			
		try{
			GestioneMail.sendEmail("bruno_giovanni@hotmail.it", "prova", "prova");
			model.addObject("presenzaMessaggio","si");
			model.addObject("message","Email spedita con successo!");
			model.setViewName("avviso");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on HomeController.invioEmail");
			gestioneException.gestisciException(model, e,"");
		}						
		return model;
	}
	
	@RequestMapping(value="/visualizzaAvvisi", method = RequestMethod.GET)
	public ModelAndView visualizzaAvvisi(ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo HomeController.visualizzaAvvisi!");
			
		List<ModelApplicativoPiuBSAssoicatiBean> modelApplicativiNonValidiConBSAssociati;	
		Iterator itr1;
		Iterator itr2;
		ModelApplicativoPiuBSAssoicatiBean modelApplicativoPiuBSAssoicatiBean;
		List<String> listaAvvisi = new ArrayList<String>();
		String avviso;
		List<BusinessServiceBean> businessServicelist;
		BusinessServiceBean businessServiceBean;
		
		try{
			modelApplicativiNonValidiConBSAssociati = (List<ModelApplicativoPiuBSAssoicatiBean>) session.getAttribute("modelApplicativiNonValidiConBSAssociati");
			itr1 = modelApplicativiNonValidiConBSAssociati.iterator();
			while(itr1.hasNext()){
				modelApplicativoPiuBSAssoicatiBean = (ModelApplicativoPiuBSAssoicatiBean) itr1.next();
				avviso = "Il model applicativo '"+modelApplicativoPiuBSAssoicatiBean.getModelApplicativo().getDescModelApplicativo()+"' non è più valido!";
				listaAvvisi.add(avviso);
				businessServicelist = modelApplicativoPiuBSAssoicatiBean.getBusinessServiceBeanList();
				itr2 = businessServicelist.iterator();
				while(itr2.hasNext()){
					businessServiceBean = (BusinessServiceBean) itr2.next();
					avviso = "E' necessario associare un altro model applicativo al Business Service '"+businessServiceBean.getTextNomeBusinessService()+"'!";
					listaAvvisi.add(avviso);
				}				
			}	
			model.addObject("listaAvvisi",listaAvvisi);			
			model.setViewName("avviso");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on HomeController.visualizzaAvvisi");
			gestioneException.gestisciException(model, e,"");
		}						
		return model;
	}
	
}
