package com.ddway.anagraficaBS.web.report;

import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;



public class ReportController extends AbstractController  { 
    
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest reuqest, HttpServletResponse response) throws Exception {
		
		ModelAndView model = new ModelAndView();
		
		HttpSession session = reuqest.getSession();
		
		model.setViewName("PdfReport");
		return model;
	}
 
}