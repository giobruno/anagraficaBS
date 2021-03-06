package com.ddway.anagraficaBS.web.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.ddway.anagraficaBS.model.forms.AssociazioneBSProcessoForm;

@Component
public class ModificaAssociazioneBSProcessoFormValidator implements Validator {
	
	private static final Logger logger = LoggerFactory.getLogger(AssociazioneBSProcessoFormValidator.class);

    public ModificaAssociazioneBSProcessoFormValidator(){}   

    public boolean supports(Class<?> clazz) {
        return AssociazioneBSProcessoForm.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {
    	logger.info("Inizio metodo ModificaAssociazioneBSProcessoFormValidator.validate!");
    	
    	AssociazioneBSProcessoForm form = (AssociazioneBSProcessoForm) target;    	
    	
    	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codiBusinessService", "field.required.codiBusinessService", "Required field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codiProcesso", "field.required.codiProcesso", "Required field");
        
        if(form.getMisuTmpLavorativoMinuti().equalsIgnoreCase("") && form.getMisuTmpLavorativoOre().equalsIgnoreCase(""))
        	errors.rejectValue("misuTmpLavorativoOre", "field.required.misuTmpLavorativoOre","field.required");
        if(form.getMisuTmpSolareMinuti().equalsIgnoreCase("") && form.getMisuTmpSolareOre().equalsIgnoreCase(""))
        	errors.rejectValue("misuTmpSolareOre", "field.required.misuTmpSolareOre","field.required");
        
        if(!form.getMisuTmpLavorativoOre().equalsIgnoreCase(""))
        	ValidatorUtil.validateNumberFormat("misuTmpLavorativoOre", form.getMisuTmpLavorativoOre(), errors);
        
        if(!form.getMisuTmpLavorativoMinuti().equalsIgnoreCase("")){
        	ValidatorUtil.validateNumberFormat("misuTmpLavorativoMinuti", form.getMisuTmpLavorativoMinuti(), errors);
        	if(Integer.parseInt(form.getMisuTmpLavorativoMinuti()) < 0 || Integer.parseInt(form.getMisuTmpLavorativoMinuti()) > 59)
        		errors.rejectValue("misuTmpLavorativoMinuti", "field.misuTmpLavorativoMinuti.maxError","field.required");
        	}        
        if(!form.getMisuTmpSolareOre().equalsIgnoreCase(""))
        	ValidatorUtil.validateNumberFormat("misuTmpSolareOre", form.getMisuTmpSolareOre(), errors);
        
        if(!form.getMisuTmpSolareMinuti().equalsIgnoreCase("")){
        	ValidatorUtil.validateNumberFormat("misuTmpSolareMinuti", form.getMisuTmpSolareMinuti(), errors);
        	if(Integer.parseInt(form.getMisuTmpSolareMinuti()) < 0 || Integer.parseInt(form.getMisuTmpSolareMinuti()) > 59)
        		errors.rejectValue("misuTmpSolareMinuti", "field.misuTmpSolareMinuti.maxError","field.required");
        	}        
       }
}
