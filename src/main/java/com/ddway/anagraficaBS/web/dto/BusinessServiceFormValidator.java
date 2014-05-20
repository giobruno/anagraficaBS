package com.ddway.anagraficaBS.web.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.ddway.anagraficaBS.model.forms.BusinessServiceForm;

@Component
public class BusinessServiceFormValidator implements Validator {
	
	private static final Logger logger = LoggerFactory.getLogger(BusinessServiceFormValidator.class);

    public BusinessServiceFormValidator(){}   

    public boolean supports(Class<?> clazz) {
        return BusinessServiceForm.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {
    	logger.info("Inizio metodo BusinessServiceFormValidator.validate!");
    	
    	BusinessServiceForm form = (BusinessServiceForm) target;
    	
    	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "textNomeBusinessService", "field.required.textNomeBusinessService", "Required field");
    	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descBusinessService", "field.required.descBusinessService", "Required field");
    	if(form.getPersRespBusinessService() != null)
    		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "persRespBusinessService", "field.required.persRespBusinessService", "Required field");
    	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "textUrlBusinessService", "field.required.textUrlBusinessService", "Required field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codiDipartimento", "field.required.codiDipartimento", "Required field");                        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codiModelApplicativo", "field.required.codiModelApplicativo", "Required field");  
        
//        if(form.getFlagConvenzione())
//        	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codiArea", "field.required", "Required field");
       }
   
}
