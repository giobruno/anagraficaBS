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
import com.ddway.anagraficaBS.model.db.infap.TblApplicazione;
import com.ddway.anagraficaBS.utility.CaricaSelect;

@Controller
public class CaricaSelectController {
	
	private static final Logger log = LoggerFactory.getLogger(CaricaSelectController.class);
	
	@Autowired
	CaricaSelect caricaSelect;
	
	
	@RequestMapping(value = "/caricaApplicazioni")
	public void caricaRegioni(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.debug("Start CaricaSelectController.caricaApplicazioni method");
		
		String codiArea = request.getParameter("codiArea");
		if(codiArea != null){
			PrintWriter out = response.getWriter();		
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");	
			List<TblApplicazione> codiApplicazioneList = (List<TblApplicazione>) caricaSelect.getApplicazioniList(codiArea);
			out.println( applicazioniXml(codiApplicazioneList) );
			out.close();		
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

	
	