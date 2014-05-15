package com.ddway.anagraficaBS.web.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.ddway.anagraficaBS.model.forms.RicercaFunzioniUtenteForm;

@Component
public class RicercaFunzioniUtenteFormValidator implements Validator {
	
	private static final Logger logger = LoggerFactory.getLogger(RicercaFunzioniUtenteFormValidator.class);

    public RicercaFunzioniUtenteFormValidator(){}   

    public boolean supports(Class<?> clazz) {
        return RicercaFunzioniUtenteForm.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {
    	logger.info("Inizio metodo RicercaFunzioniUtenteFormValidator.validate!");
    	
    	RicercaFunzioniUtenteForm form = (RicercaFunzioniUtenteForm) target;    	    	
       
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codiArea", "field.required.codiArea", "Per effettuare la ricerca e' necessario selezionare il campo Area!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codiApplicazione", "field.required.codiApplicazione", "Per effettuare la ricerca e' necessario selezionare il campo Applicazione!");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codiApplicazione", "field.required", "Required field");
      
       }
}
