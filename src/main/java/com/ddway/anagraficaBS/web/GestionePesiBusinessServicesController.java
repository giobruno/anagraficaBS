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
import com.ddway.anagraficaBS.model.bean.BusinessServiceBean;
import com.ddway.anagraficaBS.model.bean.DipartimentoBean;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DPesoBs;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DPesoDip;
import com.ddway.anagraficaBS.model.forms.ModificaPesiForm;
import com.ddway.anagraficaBS.utility.GestioneDataBase;
import com.ddway.anagraficaBS.utility.GestioneException;
import com.ddway.anagraficaBS.web.dto.ModificaPesiFormValidator;
 
@Controller
public class GestionePesiBusinessServicesController {
	
	private static final Logger logger = LoggerFactory.getLogger(GestionePesiBusinessServicesController.class);
	
	@Autowired
	GestioneDataBase gestioneDataBase;
	
	@Autowired
	GestioneException gestioneException;
	
	@Autowired
	ModificaPesiFormValidator modificaPesiFormValidator;
	
	@RequestMapping(value="/visualizzaElencoPesiBS", method = RequestMethod.GET)
	public ModelAndView visualizzaElencoPesiBS(ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo GestionePesiBusinessServicesController.visualizzaElencoPesiBS!");
			
		String codiDipartimento = null;
		List<BusinessServiceBean> businessServiceBeanList = null;
		
		try{
			codiDipartimento = (String) request.getParameter("codiDipartimento");
			businessServiceBeanList = (List<BusinessServiceBean>) gestioneDataBase.getElencoBSDipWithPesi(Integer.parseInt(codiDipartimento));			
			session.setAttribute("businessServiceBeanList", businessServiceBeanList);
			model.addObject("businessServiceBeanList", businessServiceBeanList);
			model.setViewName("elencoPesiBS");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on GestionePesiBusinessServicesController.visualizzaElencoPesiBS");
			gestioneException.gestisciException(model, e,"");
		}
		return model;
	}
	
	@RequestMapping(value="/formModificaPesiBs", method = RequestMethod.GET)
	public ModelAndView formModificaPesiBs(ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo GestionePesiBusinessServicesController.formModificaPesiBs!");
			
		List<BusinessServiceBean> businessServiceBeanList = null;
		ModificaPesiForm modificaPesiForm = new ModificaPesiForm();
		
		try{
			businessServiceBeanList = (List<BusinessServiceBean>) session.getAttribute("businessServiceBeanList");
			if(!businessServiceBeanList.isEmpty()){
				for (int i = 0; i < businessServiceBeanList.size(); i++) {
					modificaPesiForm.getValoriPesiList().add(businessServiceBeanList.get(i).getMisuPesoBs().toString());				
				}
			}			
			model.addObject("businessServiceBeanList", businessServiceBeanList);
			model.addObject("modificaPesiForm",modificaPesiForm);
			model.setViewName("modificaPesiBS");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on GestionePesiBusinessServicesController.formModificaPesiBs");
			gestioneException.gestisciException(model, e,"");
		}
		return model;
	}
	
	@RequestMapping(value="/modificaPesiBS", method = RequestMethod.GET)
	public ModelAndView modificaPesiBS(ModificaPesiForm modificaPesiForm, BindingResult errors,ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo GestionePesiBusinessServicesController.modificaPesiBS!");
			
		List<BusinessServiceBean> businessServiceBeanList = null;
		BusinessServiceBean businessServiceBean = null;
		DPesoBs pesoBS = null;
		
		modificaPesiFormValidator.validate(modificaPesiForm, errors);
		if(errors.hasErrors()){				
			model.setViewName("modificaPesiBS");
			return model;
		}
	
		try{
			businessServiceBeanList = (List<BusinessServiceBean>) session.getAttribute("businessServiceBeanList");
			if(businessServiceBeanList != null){
				for (int i = 0; i < businessServiceBeanList.size(); i++) {
					businessServiceBean = businessServiceBeanList.get(i);
					pesoBS = gestioneDataBase.getDPesoBsByCodiBusinessService(businessServiceBean.getCodiBusinessService()+"");
					gestioneDataBase.modificaDPesoBs(Integer.parseInt(businessServiceBean.getCodiBusinessService()),pesoBS,modificaPesiForm.getValoriPesiList().get(i));
					}
				}						
			model.setViewName("forward:/visualizzaElencoPesiBS?codiDipartimento="+businessServiceBean.getCodiDipartimento());
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on GestionePesiBusinessServicesController.modificaPesiBS");
			gestioneException.gestisciException(model, e,"");
		}
		return model;
	}
}