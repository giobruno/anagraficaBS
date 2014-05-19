package com.ddway.anagraficaBS.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.ddway.anagraficaBS.model.db.anagraficaBS.Users;
import com.ddway.anagraficaBS.model.forms.RegistrazioneForm;
import com.ddway.anagraficaBS.utility.GestioneDataBase;
import com.ddway.anagraficaBS.utility.PopolaModelForms;

@Service
public class Validator {
	
	private static final Logger log = LoggerFactory.getLogger(Validator.class);
	
	@Autowired
	GestioneDataBase gestioneDataBase; 
	
	public void controlloUtenteGiaPresente(RegistrazioneForm registrazioneForm,BindingResult errors) throws Exception{
		log.info("Inizio metodo Validator.controlloUtenteGiaPresente!");
		
		Users user;
		
		try{
			user = gestioneDataBase.getUtenteByUserName(registrazioneForm.getUsername());
			if(user != null)
				errors.addError(new ObjectError("errorUtente", "Attenzione! Risulta gia' un utente registrato con lo stesso nome!"));
		}catch(Exception e){
			log.error(e.getMessage()+ "on method Validator.controlloUtenteGiaPresente.");
			e.printStackTrace();
			throw e;
		}
		
	}

}
