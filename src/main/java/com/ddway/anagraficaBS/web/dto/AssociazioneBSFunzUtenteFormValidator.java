package com.ddway.anagraficaBS.web.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.ddway.anagraficaBS.model.forms.AssociazioneBSFunzUtenteForm;

@Component
public class AssociazioneBSFunzUtenteFormValidator implements Validator {
	
	private static final Logger logger = LoggerFactory.getLogger(AssociazioneBSFunzUtenteFormValidator.class);

    public AssociazioneBSFunzUtenteFormValidator(){}   

    public boolean supports(Class<?> clazz) {
        return AssociazioneBSFunzUtenteForm.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {
    	logger.info("Inizio metodo AssociazioneBSInfapFormValidator.validate!");
    	
    	AssociazioneBSFunzUtenteForm form = (AssociazioneBSFunzUtenteForm) target;    	
    	
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codiBusinessService", "field.required", "Required field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codiArea", "field.required", "Required field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codiApplicazione", "field.required", "Required field");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codiFunzione", "field.required", "Required field");       
       }
}
