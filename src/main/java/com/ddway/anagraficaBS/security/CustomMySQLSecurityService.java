package com.ddway.anagraficaBS.security;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.ddway.anagraficaBS.service.IDataSourceService;

@Service
public class CustomMySQLSecurityService extends
org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider {


	@Autowired
	IDataSourceService dataSourceService;

	@Override
	protected UserDetails retrieveUser(String username,	UsernamePasswordAuthenticationToken authentication)	throws AuthenticationException {
		
		Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		String password = (String) authentication.getCredentials();
//		com.ddway.anagraficaBS.model.bean.User user =null;
//		
//		if (!StringUtils.hasText(password)) {
//			throw new BadCredentialsException("Inserire la password per effettuare l'accesso!");
//		}        
//		try {
//			user = (com.ddway.anagraficaBS.model.bean.User) dataSourceService.findbyId("", 1);
//					if(user == null)
//						throw new EmptyResultDataAccessException("", 0);
//        } catch (EmptyResultDataAccessException e) {
//            throw new BadCredentialsException("Errore nell' effettuare il login!");
//        }  catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//		authentication.setDetails(user);
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));			
			
		return new User(username, password, true, // enabled
				true, // account not expired
				true, // credentials not expired
				true, // account not locked
				grantedAuthorities);
		}

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		
	}

}
