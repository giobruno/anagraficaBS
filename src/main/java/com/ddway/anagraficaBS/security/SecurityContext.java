package com.ddway.anagraficaBS.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.ddway.anagraficaBS.model.db.Users;

public class SecurityContext {

	public static Users getCurrentUser() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	
		if (auth != null &&  (auth.getDetails() instanceof Users)  ) {
			Users userlogged = (Users) auth.getDetails();
			return userlogged;
		} else
			return null;
	}

}
