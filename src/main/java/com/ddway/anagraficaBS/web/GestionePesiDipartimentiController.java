package com.ddway.anagraficaBS.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.ddway.anagraficaBS.model.bean.DipartimentoBean;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DPesoDip;
import com.ddway.anagraficaBS.model.forms.ModificaPesiForm;
import com.ddway.anagraficaBS.utility.GestioneDataBase;
import com.ddway.anagraficaBS.utility.GestioneException;
import com.ddway.anagraficaBS.web.dto.ModificaPesiFormValidator;
 
@Controller
public class GestionePesiDipartimentiController {
	
	private static final Logger logger = LoggerFactory.getLogger(GestionePesiDipartimentiController.class);
	
	@Autowired
	GestioneDataBase gestioneDataBase;
	
	@Autowired
	GestioneException gestioneException;
	
	@Autowired
	ModificaPesiFormValidator modificaPesiFormValidator;
	
	@RequestMapping(value="/visualizzaElencoDipartimenti", method = RequestMethod.GET)
	public ModelAndView visualizzaElencoDipartimenti(ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo GestionePesiDipartimentiController.visualizzaElencoDipartimenti!");
			
		try{
			List<DipartimentoBean> dipartimentiList = (List<DipartimentoBean>) gestioneDataBase.getElencoDipartimentiWithPesi();
			if(dipartimentiList == null || dipartimentiList.isEmpty()){
				model.addObject("presenzaMessaggio","si");
				model.addObject("message","Non e' stato trovato nessun Dipartimento nel sistema!");
			}
			session.setAttribute("dipartimentiList", dipartimentiList);
			model.addObject("dipartimentiList", dipartimentiList);
			model.setViewName("elencoDipartimenti");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on GestionePesiDipartimentiController.visualizzaElencoDipartimenti");
			gestioneException.gestisciException(model, e,"");
		}
		return model;
	}
	
	@RequestMapping(value="/formModificaPesiDipartimenti", method = RequestMethod.GET)
	public ModelAndView formModificaPesiDipartimenti(ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo GestionePesiDipartimentiController.formModificaPesiDipartimenti!");
			
		List<DipartimentoBean> dipartimentiList = null;
		ModificaPesiForm modificaPesiForm = new ModificaPesiForm();
		
		try{
			dipartimentiList = (List<DipartimentoBean>) session.getAttribute("dipartimentiList");
			if(!dipartimentiList.isEmpty()){
				for (int i = 0; i < dipartimentiList.size(); i++) {
					modificaPesiForm.getValoriPesiList().add(dipartimentiList.get(i).getMisuPesoDip().toString());				
				}
			}			
			model.addObject("dipartimentiList", dipartimentiList);
			model.addObject("modificaPesiDipartimentiForm",modificaPesiForm);
			model.setViewName("modificaPesiDipartimenti");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on GestionePesiDipartimentiController.formModificaPesiDipartimenti");
			gestioneException.gestisciException(model, e,"");
		}
		return model;
	}
	
	@RequestMapping(value="/modificaPesiDipartimenti", method = RequestMethod.GET)
	public ModelAndView modificaPesiDipartimenti(ModificaPesiForm modificaPesiForm, BindingResult errors,ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo GestionePesiDipartimentiController.modificaPesiDipartimenti!");
			
		List<DipartimentoBean> dipartimentiList = null;
		DipartimentoBean dipartimentoBean = null;
		DPesoDip pesoDip = null;
		
		modificaPesiFormValidator.validate(modificaPesiForm, errors);
		if(errors.hasErrors()){				
			model.setViewName("modificaPesiDipartimenti");
			return model;
		}
	
		try{
			dipartimentiList = (List<DipartimentoBean>) session.getAttribute("dipartimentiList");
			if(dipartimentiList != null){
				for (int i = 0; i < dipartimentiList.size(); i++) {
					dipartimentoBean = dipartimentiList.get(i);
					pesoDip = gestioneDataBase.getDPesoDipByCodiDipartimento(dipartimentoBean.getCodiDipartimento()+"");
					gestioneDataBase.modificaDPesoDip(dipartimentoBean.getCodiDipartimento(),pesoDip,modificaPesiForm.getValoriPesiList().get(i));
					}
				}						
			model.setViewName("forward:/visualizzaElencoDipartimenti");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on GestionePesiDipartimentiController.modificaPesiDipartimenti");
			gestioneException.gestisciException(model, e,"");
		}
		return model;
	}
}