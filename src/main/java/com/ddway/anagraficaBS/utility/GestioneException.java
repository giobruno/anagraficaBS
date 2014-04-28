package com.ddway.anagraficaBS.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class GestioneException {
	
	private static final Logger log = LoggerFactory.getLogger(GestioneException.class);
	
	public void gestisciException(ModelAndView model, Exception e, String oggettoDuplicato){
		
		String[] errorSplit = e.getMessage().split("/");
		
		model.addObject("presenzaMessaggio","si");
		if(e.getCause().toString().equals("org.hibernate.exception.ConstraintViolationException: Could not execute JDBC batch update")){
			model.addObject("message","Si sta cercando di inserire un oggetto '"+oggettoDuplicato+"' già presente nel sistema!");
			model.setViewName("exception");
		}
		else if(errorSplit[0].equalsIgnoreCase("getlistvalues"))
			model.addObject("message",errorSplit[1]);		
		else model.setViewName("exception");		
	}
}
