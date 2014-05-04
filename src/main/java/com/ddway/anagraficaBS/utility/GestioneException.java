package com.ddway.anagraficaBS.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class GestioneException {
	
	private static final Logger log = LoggerFactory.getLogger(GestioneException.class);
	
	public void gestisciException(ModelAndView model, Exception e, String message){
		log.info("Inizio metodo GestioneException.gestisciException!");
		
		String[] errorSplit = e.getMessage().split("/");		
			
		try{
			model.addObject("presenzaMessaggio","si");
			if(e instanceof  org.hibernate.exception.ConstraintViolationException || e instanceof  org.hibernate.NonUniqueObjectException ){
				message = "ERRORE: Si sta cercando di inserire un oggetto '"+message+"' gia' presente nel sistema!";
				model.addObject("message",message);
				model.setViewName("exception");
			}
			else if(errorSplit[0].equalsIgnoreCase("getlistvalues"))
				model.addObject("message",errorSplit[1]);		
			else model.setViewName("exception");	
		}catch(Exception ex){
			ex.printStackTrace();
			log.error(ex+" on  method GestioneException.gestisciException!");
			model.setViewName("exception");
		}
	}
}
