package com.ddway.anagraficaBS.web.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.ddway.anagraficaBS.model.forms.ElencoFunzioniForm;

@Component
public class ElencoFunzioniFormValidator implements Validator {
	
	private static final Logger logger = LoggerFactory.getLogger(ElencoFunzioniFormValidator.class);

    public ElencoFunzioniFormValidator(){}   

    public boolean supports(Class<?> clazz) {
        return ElencoFunzioniForm.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {
    	logger.info("Inizio metodo ElencoFunzioniFormValidator.validate!");
    	
    	ElencoFunzioniForm form = (ElencoFunzioniForm) target;
    	
    	if(form.getFunzioniDaInserire() == null || form.getFunzioniDaInserire().length == 0)
    		errors.reject("field.required", "Required field");
//    		rejectValue("funzioniDaInserire", "field.required", "Required field");    	
    	
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "funzioniDaInserire", "field.required", "Required field");        
       }
   
}
