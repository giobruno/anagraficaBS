package com.ddway.anagraficaBS.web.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.ddway.anagraficaBS.model.forms.AccountForm;

@Component
public class AccountFormValidator implements Validator {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountFormValidator.class);

    public AccountFormValidator(){}   

    public boolean supports(Class<?> clazz) {
        return AccountForm.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {
    	logger.info("Inizio metodo AccountFormValidator.validate!");
    	
    	AccountForm form = (AccountForm) target;
    	
    	if(form.getNome() != null){
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "field.required.nome", "Required field");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cognome", "field.required.cognome", "Required field");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "field.required.username", "Required field");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "field.required.email", "Required field");   
	        if(!form.getEmail().equalsIgnoreCase(""))
	        	ValidatorUtil.validateEmail("email",form.getEmail(), errors);  
    	}
    	else {
    		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "field.required.email", "Required field"); 
    		if(!form.getEmail().equalsIgnoreCase(""))
    			ValidatorUtil.validateEmail("email",form.getEmail(), errors);
    	}
       }
}
