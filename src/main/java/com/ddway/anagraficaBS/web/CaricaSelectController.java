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

import com.ddway.anagraficaBS.model.bean.CategorieMac;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DCategorieInfr;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DProcessi;
import com.ddway.anagraficaBS.model.db.infap.TblApplicazione;
import com.ddway.anagraficaBS.utility.CaricaSelect;
import com.ddway.anagraficaBS.utility.GestioneDataBase;
import com.ddway.anagraficaBS.utility.GestioneException;

@Controller
public class CaricaSelectController {
	
	private static final Logger log = LoggerFactory.getLogger(CaricaSelectController.class);
	
	@Autowired
	CaricaSelect caricaSelect;
	
	@Autowired
	GestioneException gestioneException;
	
	@Autowired
	GestioneDataBase gestioneDataBase;
	
	@RequestMapping(value = "/caricaApplicazioni")
	public void caricaApplicazioni(ModelAndView model,HttpServletRequest request, HttpServletResponse response) throws Exception {
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
				e.printStackTrace();
				log.error(e.getMessage()+" on CaricaSelectController.caricaApplicazioni");
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
	
	@RequestMapping(value = "/caricaCategoriaMac")
	public void caricaCategoriaMac(ModelAndView model,HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.debug("Start CaricaSelectController.caricaCategoriaMac method");
		
		String codiProcesso;
		DProcessi processo;
		
		try{
			codiProcesso = request.getParameter("codiProcesso");
			if(codiProcesso != null){
				processo = gestioneDataBase.getProcesso(codiProcesso);
				if(processo.getFlagCatMac()){
					PrintWriter out = response.getWriter();		
					response.setContentType("text/xml");
					response.setHeader("Cache-Control", "no-cache");	
					List<CategorieMac> categoriaMacList = (List<CategorieMac>) caricaSelect.getCategoriaMacList();
					out.println( categoriaMacXml(categoriaMacList) );
					out.close();
				}
				}
			}catch(Exception e){
				e.printStackTrace();
				log.error(e.getMessage()+" on CaricaSelectController.caricaCategoriaMac");
				gestioneException.gestisciException(model, e,"");
			}
		}
	
	private String categoriaMacXml(List<CategorieMac> categoriaMac){
		log.debug("Start CaricaSelectController.categoriaMacXml method");
		  StringBuffer sb=new StringBuffer();
		  sb.append("<elementi>");
		  for(CategorieMac p:categoriaMac){
		   sb.append("<elemento>");
		   sb.append("<codice>");
		   sb.append(p.getCodiCategoriaMac());
		   sb.append("</codice>");
		   sb.append("<descrizione>");
		   sb.append(p.getCodiDescCategoriaMac());
		   sb.append("</descrizione>");
		   sb.append("</elemento>");
		  }
		  sb.append("</elementi>");
		  return sb.toString();
		 }
	
	@RequestMapping(value = "/caricaCategoriaInfr")
	public void caricaCategoriaInfr(ModelAndView model,HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.debug("Start CaricaSelectController.caricaCategoriaInfr method");
		
		String codiProcesso;
		DProcessi processo;
		
		try{
			codiProcesso = request.getParameter("codiProcesso");
			if(codiProcesso != null){
				processo = gestioneDataBase.getProcesso(codiProcesso);
				if(processo.getFlagCatInfr()){
					PrintWriter out = response.getWriter();		
					response.setContentType("text/xml");
					response.setHeader("Cache-Control", "no-cache");	
					List<DCategorieInfr> categoriaInfrList = (List<DCategorieInfr>) caricaSelect.getCategoriaInfrList();
					out.println( categoriaInfrXml(categoriaInfrList) );
					out.close();
				}
				}
			}catch(Exception e){
				e.printStackTrace();
				log.error(e.getMessage()+" on CaricaSelectController.caricaCategoriaInfr");
				gestioneException.gestisciException(model, e,"");
			}
		}
	
	private String categoriaInfrXml(List<DCategorieInfr> categoriaInfr){
		log.debug("Start CaricaSelectController.categoriaMacXml method");
		  StringBuffer sb=new StringBuffer();
		  sb.append("<elementi>");
		  for(DCategorieInfr p:categoriaInfr){
		   sb.append("<elemento>");
		   sb.append("<codice>");
		   sb.append(p.getCodiCategoriaInfr());
		   sb.append("</codice>");
		   sb.append("<descrizione>");
		   sb.append(p.getDescCategoriaInfr());
		   sb.append("</descrizione>");
		   sb.append("</elemento>");
		  }
		  sb.append("</elementi>");
		  return sb.toString();
		 }
		 
}

	
	