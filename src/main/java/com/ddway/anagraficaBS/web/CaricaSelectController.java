package com.ddway.anagraficaBS.web;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ddway.anagraficaBS.model.db.infap.TblApplicazione;
import com.ddway.anagraficaBS.utility.CaricaSelect;
import com.ddway.anagraficaBS.utility.GestioneException;

@Controller
public class CaricaSelectController {
	
	private static final Logger log = LoggerFactory.getLogger(CaricaSelectController.class);
	
	@Autowired
	CaricaSelect caricaSelect;
	
	@Autowired
	GestioneException gestioneException;
	
	@RequestMapping(value = "/caricaApplicazioni")
	public void caricaRegioni(ModelAndView model,HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.debug("Start CaricaSelectController.caricaApplicazioni method");
		
		String codiArea = request.getParameter("codiArea");
		try{
			if(codiArea != null){
				PrintWriter out = response.getWriter();		
				response.setContentType("text/xml");
				response.setHeader("Cache-Control", "no-cache");	
				List<TblApplicazione> codiApplicazioneList = (List<TblApplicazione>) caricaSelect.getApplicazioniList(codiArea);
				out.println( applicazioniXml(codiApplicazioneList) );
				out.close();
				}
			}catch(Exception e){
				log.error(e.getMessage()+" on CaricaSelectController.caricaRegioni");
				gestioneException.gestisciException(model, e,"");
			}
		}
	
	private String applicazioniXml(List<TblApplicazione> applicazioni){
		log.debug("Start CaricaSelectController.applicazioniXml method");
		  StringBuffer sb=new StringBuffer();
		  sb.append("<elementi>");
		  for(TblApplicazione p:applicazioni){
		   sb.append("<elemento>");
		   sb.append("<codice>");
		   sb.append(p.getScodeApplicazione());
		   sb.append("</codice>");
		   sb.append("<descrizione>");
		   sb.append(p.getSdescrizioneBreve());
		   sb.append("</descrizione>");
		   sb.append("</elemento>");
		  }
		  sb.append("</elementi>");
		  return sb.toString();
		 }
		 
}

	
	