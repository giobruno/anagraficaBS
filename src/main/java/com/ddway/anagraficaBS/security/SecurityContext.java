package com.ddway.anagraficaBS.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.ddway.anagraficaBS.model.bean.User;

public class SecurityContext {

	public static User getCurrentUser() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	
		if (auth != null &&  (auth.getDetails() instanceof User)  ) {
			User userlogged = (User) auth.getDetails();
			return userlogged;
		} else
			return null;
	}

}
