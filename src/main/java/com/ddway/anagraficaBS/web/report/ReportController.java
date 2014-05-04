package com.ddway.anagraficaBS.web.report;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import com.ddway.anagraficaBS.model.bean.BusinessServiceBean;
import com.ddway.anagraficaBS.model.bean.ModelApplicativoPiuBSAssoicatiBean;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DBusinessServices;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DDipartimenti;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DModelApplicativi;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DProcessi;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DServiziFunzioni;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DServiziModel;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DServiziProcessi;
import com.ddway.anagraficaBS.utility.GestioneDataBase;
import com.ddway.anagraficaBS.utility.PopolaModelBeans;
import com.ddway.anagraficaBS.utility.PopolaModelForms;

public class ReportController extends AbstractController  { 
    
	private static final Logger logger = LoggerFactory.getLogger(ReportController.class);
	
	@Autowired
	PopolaModelForms popolaModelForms;
	
	@Autowired
	GestioneDataBase gestioneDataBase;	
	
	@Autowired
	PopolaModelBeans popolaModelBeans;	
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("Inizio metodo ReportController.handleRequestInternal!");
		
		ModelAndView model = new ModelAndView();		
		HttpSession session = request.getSession();
		List<BusinessServiceBean> businessServicesList;
		List<DProcessi> processiList;
		List<DModelApplicativi> modelApplicativiList;
		List<ModelApplicativoPiuBSAssoicatiBean> modelApplicativoPiuBSAssoicatiBeanList;
		
		int report =  Integer.parseInt(request.getParameter("report"));
		
		try{
			switch (report) {
			case 1: 						
					businessServicesList = (List<BusinessServiceBean>) request.getSession().getAttribute("businessServicesList");	
					if(businessServicesList == null || businessServicesList.isEmpty()){
						model.addObject("presenzaMessaggio","si");
						model.addObject("message","Non risulta presente nessun Business Service nel sistema!");
						model.setViewName("elencoReport");	
					}
					else model.setViewName("PdfReport1");			
				break;
				
				case 2:
					businessServicesList = (List<BusinessServiceBean>) request.getSession().getAttribute("businessServicesList");	
					if(businessServicesList == null || businessServicesList.isEmpty()){
						model.addObject("presenzaMessaggio","si");
						model.addObject("message","Non risulta presente nessun Business Service nel sistema!");
						model.setViewName("elencoReport");	
					}
					else model.setViewName("PdfReport2");	
				break;
				
				case 3: 
					processiList = (List<DProcessi>) gestioneDataBase.getElencoProcessi();
					if(processiList == null || processiList.isEmpty()){						
						model.addObject("presenzaMessaggio","si");
						model.addObject("message","Non risulta presente nessun Processo nel sistema!");
						model.setViewName("elencoReport");	
					}
					else{
						session.setAttribute("processiList", processiList);
						model.setViewName("PdfReport3");	
					}
				break;
				
				case 4:
					modelApplicativiList = (List<DModelApplicativi>) gestioneDataBase.getElencoModelApplicativi();
					if(modelApplicativiList == null || modelApplicativiList.isEmpty()){						
						model.addObject("presenzaMessaggio","si");
						model.addObject("message","Non risulta presente nessun Model Applicativo nel sistema!");
						model.setViewName("elencoReport");	
					}
					else{
						session.setAttribute("modelApplicativiList", modelApplicativiList);
						model.setViewName("PdfReport4");	
					}
				break;
				
				case 5: 
					modelApplicativoPiuBSAssoicatiBeanList = popolaModelBeans.popolaModelApplicativoPiuBSAssoicatiBean("validi");
					if(modelApplicativoPiuBSAssoicatiBeanList == null || modelApplicativoPiuBSAssoicatiBeanList.isEmpty()){						
						model.addObject("presenzaMessaggio","si");
						model.addObject("message","Non risulta presente nessun Model Applicativo nel sistema!");
						model.setViewName("elencoReport");	
					}
					else{
						session.setAttribute("modelApplicativiList", modelApplicativoPiuBSAssoicatiBeanList);
						model.setViewName("PdfReport5");
					}
				break;
				
				case 6: 					
					model.setViewName("PdfReport6");
				break;
		
				default: model.setViewName("exception");
				}
			}catch(Exception e){
				e.printStackTrace();
				logger.error(e.getMessage()+" on method ReportController.handleRequestInternal!");
			}
		return model;
	} 
}