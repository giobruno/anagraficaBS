package com.ddway.anagraficaBS.web.dto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;

public class ValidatorUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(RegistrazioneFormValidator.class);

	private static Matcher matcher;
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String FORMAT_PASSWORD_PATTERN = "((?=.*[0-9])(?=.*[a-zA-Z]).{8,})";
	private static Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    private static Pattern pattern_password_format = Pattern.compile(FORMAT_PASSWORD_PATTERN);
	
	public static void validateEmail(String fieldName,String email, Errors errors){
		logger.info("Inizio metodo ValidatorUtil.validateEmail!");
		matcher = pattern.matcher(email);
		if(!matcher.matches()){
			errors.rejectValue(fieldName, "field.emailError");
		}
	}    
    
    public static void validatePasswordFormat(String fieldName,String email, Errors errors){
    	logger.info("Inizio metodo ValidatorUtil.validatePasswordFormat!");
        matcher = pattern_password_format.matcher(email);
        if(!matcher.matches()){
            errors.rejectValue(fieldName, "field.password");
        }
    }
    
}
