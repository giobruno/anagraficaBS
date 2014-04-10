package com.ddway.anagraficaBS.web.dto;

import static com.ddway.anagraficaBS.web.dto.ValidatorUtil.validateEmail;
import static com.ddway.anagraficaBS.web.dto.ValidatorUtil.validatePasswordFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
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
    	
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "field.required", "Required field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cognome", "field.required", "Required field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user", "field.required", "Required field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "field.required", "Required field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "field.required", "Required field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confermaPassword", "field.required", "Required field");
        
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
