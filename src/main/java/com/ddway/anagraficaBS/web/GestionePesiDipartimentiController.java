package com.ddway.anagraficaBS.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ddway.anagraficaBS.model.bean.BusinessServiceBean;
import com.ddway.anagraficaBS.model.bean.DipartimentoBean;
import com.ddway.anagraficaBS.model.db.anagraficaBS.Authorities;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DBusinessServices;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DDipartimenti;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DPesoDip;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DProcessi;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DServiziProcessi;
import com.ddway.anagraficaBS.model.db.anagraficaBS.Users;
import com.ddway.anagraficaBS.model.forms.AssociazioneBSProcessoForm;
import com.ddway.anagraficaBS.model.forms.BusinessServiceForm;
import com.ddway.anagraficaBS.model.forms.ModificaPesiDipartimentiForm;
import com.ddway.anagraficaBS.model.forms.ProcessoForm;
import com.ddway.anagraficaBS.service.IDataSourceService;
import com.ddway.anagraficaBS.utility.CaricaSelect;
import com.ddway.anagraficaBS.utility.GestioneDataBase;
import com.ddway.anagraficaBS.utility.GestioneException;
import com.ddway.anagraficaBS.utility.PopolaModelDb;
import com.ddway.anagraficaBS.utility.PopolaModelForms;
import com.ddway.anagraficaBS.web.dto.AssociazioneBSProcessoFormValidator;
import com.ddway.anagraficaBS.web.dto.ModificaAssociazioneBSProcessoFormValidator;
import com.ddway.anagraficaBS.web.dto.ModificaPesiDipartimentiFormValidator;
import com.ddway.anagraficaBS.web.dto.ProcessoFormValidator;
 
@Controller
public class GestionePesiDipartimentiController {
	
	private static final Logger logger = LoggerFactory.getLogger(GestionePesiDipartimentiController.class);
	
	@Autowired
	IDataSourceService dataSourceService;
	
	@Autowired
	ProcessoFormValidator processoFormValidator;
	
	@Autowired
	AssociazioneBSProcessoFormValidator associazioneBSProcessoFormValidator;
	
	@Autowired
	ModificaAssociazioneBSProcessoFormValidator modificaAssociazioneBSProcessoFormValidator;
	
	@Autowired
	DProcessi dProcessi;
	
	@Autowired
	DServiziProcessi dServiziProcessi;
	
	@Autowired
	PopolaModelDb popolaModelDb;
	
	@Autowired
	GestioneDataBase gestioneDataBase;
	
	@Autowired
	CaricaSelect caricaSelect;
	
	@Autowired
	ProcessoForm processoFormAutoWired;
	
	@Autowired
	PopolaModelForms popolaModelForms;
	
	@Autowired
	GestioneException gestioneException;
	
	@Autowired
	ModificaPesiDipartimentiFormValidator modificaPesiDipartimentiFormValidator;
	
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
		ModificaPesiDipartimentiForm modificaPesiDipartimentiForm = new ModificaPesiDipartimentiForm();
		
		try{
			dipartimentiList = (List<DipartimentoBean>) session.getAttribute("dipartimentiList");
			if(!dipartimentiList.isEmpty()){
				for (int i = 0; i < dipartimentiList.size(); i++) {
					modificaPesiDipartimentiForm.getValoriPesiList().add(dipartimentiList.get(i).getMisuPesoDip().toString());				
				}
			}			
			model.addObject("dipartimentiList", dipartimentiList);
			model.addObject("modificaPesiDipartimentiForm",modificaPesiDipartimentiForm);
			model.setViewName("modificaPesiDipartimenti");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage()+" on GestionePesiDipartimentiController.formModificaPesiDipartimenti");
			gestioneException.gestisciException(model, e,"");
		}
		return model;
	}
	
	@RequestMapping(value="/modificaPesiDipartimenti", method = RequestMethod.GET)
	public ModelAndView modificaPesiDipartimenti(ModificaPesiDipartimentiForm modificaPesiDipartimentiForm, BindingResult errors,ModelAndView model, HttpSession session, HttpServletRequest request) throws Exception { 
		logger.info("Inizio metodo GestionePesiDipartimentiController.modificaPesiDipartimenti!");
			
		List<DipartimentoBean> dipartimentiList = null;
		DipartimentoBean dipartimentoBean = null;
		DPesoDip pesoDip = null;
		
		modificaPesiDipartimentiFormValidator.validate(modificaPesiDipartimentiForm, errors);
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
					gestioneDataBase.modificaDPesoDip(pesoDip,modificaPesiDipartimentiForm.getValoriPesiList().get(i));
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