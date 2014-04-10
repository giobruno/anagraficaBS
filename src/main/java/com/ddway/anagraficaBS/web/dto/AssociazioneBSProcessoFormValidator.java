package com.ddway.anagraficaBS.web.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.ddway.anagraficaBS.model.forms.AssociazioneBSProcessoForm;

@Component
public class AssociazioneBSProcessoFormValidator implements Validator {
	
	private static final Logger logger = LoggerFactory.getLogger(AssociazioneBSProcessoFormValidator.class);

    public AssociazioneBSProcessoFormValidator(){}   

    public boolean supports(Class<?> clazz) {
        return AssociazioneBSProcessoForm.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {
    	logger.info("Inizio metodo AssociazioneBSInfapFormValidator.validate!");
    	
    	AssociazioneBSProcessoForm form = (AssociazioneBSProcessoForm) target;    	
    	
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codiBusinessService", "field.required", "Required field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codiProcesso", "field.required", "Required field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codiCategoriaMac", "field.required", "Required field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codiCategoriaInfr", "field.required", "Required field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "orarioLavIniOre", "field.required", "Required field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "orarioLavIniMinuti", "field.required", "Required field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "orarioLavFineOre", "field.required", "Required field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "orarioLavFineMinuti", "field.required", "Required field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "misuTmpLavorativo", "field.required", "Required field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "misuTmpSolare", "field.required", "Required field");
    
       }
}
