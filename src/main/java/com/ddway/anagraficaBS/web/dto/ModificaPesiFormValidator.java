package com.ddway.anagraficaBS.web.dto;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ddway.anagraficaBS.model.forms.ModificaPesiForm;

@Component
public class ModificaPesiFormValidator implements Validator {
	
	private static final Logger logger = LoggerFactory.getLogger(ModificaPesiFormValidator.class);

    public ModificaPesiFormValidator(){}   

    public boolean supports(Class<?> clazz) {
        return ModificaPesiFormValidator.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {
    	logger.info("Inizio metodo ModificaPesiDipartimentiFormValidator.validate!");
    	
    	ModificaPesiForm form = (ModificaPesiForm) target;
    	String peso = null;
    	BigDecimal sum = new BigDecimal("0.00");
    	
    	if(form.getValoriPesiList() != null){
    		for (int i = 0; i < form.getValoriPesiList().size(); i++) {
    			peso =  form.getValoriPesiList().get(i).replace(".", ",");
    			ValidatorUtil.validateBigDecimalFormat("valoriPesiList", peso, errors);				
			}
    	}    
    	if(!errors.hasErrors()){
    		for (int i = 0; i < form.getValoriPesiList().size(); i++){
    			peso =  form.getValoriPesiList().get(i).replace(",", ".");
    			sum = sum.add(new BigDecimal(peso));
    		}   		
    		if(sum.compareTo(new BigDecimal("100.00")) != 0)
    			errors.rejectValue("valoriPesiList", "field.valoriPesiList.sum.errata","field.valoriPesiList.sum.errata");    			
    	}
       }
}