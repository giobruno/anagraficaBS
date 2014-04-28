package com.ddway.anagraficaBS.web.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.ddway.anagraficaBS.model.forms.ModificaPasswordForm;

@Component
public class ModificaPasswordFormValidator implements Validator {
	
	private static final Logger logger = LoggerFactory.getLogger(ModificaPasswordFormValidator.class);

    public ModificaPasswordFormValidator(){}   

    public boolean supports(Class<?> clazz) {
        return ModificaPasswordForm.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {
    	logger.info("Inizio metodo ModificaPasswordFormValidator.validate!");
    	
    	ModificaPasswordForm form = (ModificaPasswordForm) target;
    	
    	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "oldPassword", "field.required.oldPassword", "Required field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "field.required.nuova.password", "Required field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confermaPassword", "field.required.conferma.nuova.Password", "Required field");        

       }
}
