package com.ddway.anagraficaBS.web.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.ddway.anagraficaBS.model.forms.RegistrazioneForm;

@Component
public class RegistrazioneFormValidator implements Validator {
	
	private static final Logger logger = LoggerFactory.getLogger(RegistrazioneFormValidator.class);

    public RegistrazioneFormValidator(){}   

    public boolean supports(Class<?> clazz) {
        return RegistrazioneForm.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {
    	logger.info("Inizio metodo RegistrazioneFormValidator.validate!");
    	
    	RegistrazioneForm form = (RegistrazioneForm) target;
    	
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "field.required.nome", "Required field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cognome", "field.required.cognome", "Required field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "field.required.username", "Required field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "field.required.email", "Required field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "field.required.password", "Required field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confermaPassword", "field.required.confermaPassword", "Required field");
        
        if(!form.getEmail().equalsIgnoreCase(""))
        	ValidatorUtil.validateEmail("email",form.getEmail(), errors); 
        
        if(!form.getPassword().equalsIgnoreCase("") && !form.getConfermaPassword().equalsIgnoreCase(""))
        	if(!form.getPassword().equalsIgnoreCase(form.getConfermaPassword()))
        		errors.rejectValue("confermaPassword", "field.confirmPassword.different2","field.confirmPassword.different");
        
//        validateEmail("email",form.getEmail(), errors);  
//        validatePasswordFormat("password",form.getPassword(),errors);
//
//        if(StringUtils.hasText(form.getPassword()) && StringUtils.hasText(form.getConfermaPassword())) {
//        	
//        	if(!form.getPassword().equalsIgnoreCase(form.getConfermaPassword())){
//                errors.rejectValue("Password", "field.confirmPassword.different");
//            }
//        }
       }
}
