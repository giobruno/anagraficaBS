package com.ddway.anagraficaBS.web.dto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;

public class ValidatorUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(ValidatorUtil.class);

	private static Matcher matcher;
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String FORMAT_PASSWORD_PATTERN = "((?=.*[0-9])(?=.*[a-zA-Z]).{8,})";
	private static Pattern pattern_email = Pattern.compile(EMAIL_PATTERN);
    private static Pattern pattern_password_format = Pattern.compile(FORMAT_PASSWORD_PATTERN);
    
    private static final String NUMBER_PATTERN = "^[0-9]*$";
    private static Pattern pattern_number = Pattern.compile(NUMBER_PATTERN);
    
    private static final String STRING_PATTERN = "^[a-zA-Z]*$";
    private static Pattern pattern_string = Pattern.compile(STRING_PATTERN);
    
    private static final String BIG_DECIMAL_PATTERN = "^(\\d{1,3}\\.(\\d{3}\\.)*\\d{3}|\\d+)(,\\d{1,2})?$";
    private static Pattern pattern_bigDecimal = Pattern.compile(BIG_DECIMAL_PATTERN);
    
   
	
	public static void validateEmail(String fieldName,String email, Errors errors){
		logger.info("Inizio metodo ValidatorUtil.validateEmail!");
		matcher = pattern_email.matcher(email);
		if(!matcher.matches()){
			errors.rejectValue(fieldName, "field.emailError");
		}
	}    
    
    public static void validatePasswordFormat(String fieldName,String password, Errors errors){
    	logger.info("Inizio metodo ValidatorUtil.validatePasswordFormat!");
        matcher = pattern_password_format.matcher(password);
        if(!matcher.matches()){
            errors.rejectValue(fieldName, "field.password");
        }
    }
    
    public static void validateNumberFormat(String fieldName,String number, Errors errors){
    	logger.info("Inizio metodo ValidatorUtil.validateNumberFormat!");
        matcher = pattern_number.matcher(number);
        if(!matcher.matches()){
            errors.rejectValue(fieldName, "field.errorFormat."+fieldName);
        }
    }
    
    public static void validateStringFormat(String fieldName,String number, Errors errors){
    	logger.info("Inizio metodo ValidatorUtil.validateStringFormat!");
        matcher = pattern_string.matcher(number);
        if(!matcher.matches()){
            errors.rejectValue(fieldName, "field.errorFormat."+fieldName);
        }
    }
    
    public static void validateBigDecimalFormat(String fieldName,String number, Errors errors){
    	logger.info("Inizio metodo ValidatorUtil.validateBigDecimalFormat!");
        matcher = pattern_bigDecimal.matcher(number);
        if(!matcher.matches()){
            errors.rejectValue(fieldName, "field.errorFormat."+fieldName);
        }
    }
}
