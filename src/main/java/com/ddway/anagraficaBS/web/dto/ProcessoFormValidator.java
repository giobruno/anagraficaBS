package com.ddway.anagraficaBS.web.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.ddway.anagraficaBS.model.forms.ProcessoForm;

@Component
public class ProcessoFormValidator implements Validator {
	
	private static final Logger logger = LoggerFactory.getLogger(ProcessoFormValidator.class);

    public ProcessoFormValidator(){}   

    public boolean supports(Class<?> clazz) {
        return ProcessoForm.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {
    	logger.info("Inizio metodo ProcessoFormValidator.validate!");
    	
    	ProcessoForm form = (ProcessoForm) target;
    	
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "textSiglaProcesso", "field.required", "Required field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descProcesso", "field.required", "Required field");
    
       }
}
