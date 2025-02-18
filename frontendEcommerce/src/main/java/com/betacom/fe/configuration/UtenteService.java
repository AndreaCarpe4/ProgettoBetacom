//package com.betacom.fe.configuration;
//
//import org.slf4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.stereotype.Service;
//
//import com.betacom.fe.request.UtenteReq;
//
//@Service
//public class UtenteService {
//	
//	@Autowired
//	private PasswordEncoder getPasswordEncoder;
//	
//	@Autowired
//	Logger log;
//	
//	private final InMemoryUserDetailsManager inMemoryUserDetailsManager;
//	
//	public UtenteService(InMemoryUserDetailsManager inMemoryUserDetailsManager) {
//		this.inMemoryUserDetailsManager = inMemoryUserDetailsManager;
//	}
//	
//	public void updateUtente(UtenteReq req) {
//		
//		if(inMemoryUserDetailsManager.userExists(req.getUserName())) {
//			log.debug(req.getUserName() + " exists");
//			inMemoryUserDetailsManager.deleteUser(req.getUserName());
//			log.debug(req.getUserName() + " deleted");
//			
//			UserDetails user1 = User
//					.withUsername(req.getUserName())
//					.password(getPasswordEncoder.encode(req.getPassword().toString()))
//					.roles(req.getRuolo())
//					.build();
//			inMemoryUserDetailsManager.createUser(user1);
//			log.debug("User " + req.getUserName() + " is created");
//			
//		}else {
//			
//			log.debug(req.getUserName() + " non esiste");
//			UserDetails user1 = User
//					.withUsername(req.getUserName())
//					.password(getPasswordEncoder.encode(req.getPassword().toString()))
//					.roles(req.getRuolo())
//					.build();
//			inMemoryUserDetailsManager.createUser(user1);
//			log.debug("User " + req.getUserName() + " is created");
//			
//		}
//		
//	}
//	
//	public void deleteUtente(UtenteReq req) {
//		
//		if(inMemoryUserDetailsManager.userExists(req.getUserName())) {
//			log.debug(req.getUserName() + " exists");
//			inMemoryUserDetailsManager.deleteUser(req.getUserName());
//			log.debug(req.getUserName() + " is deleted");
//		}
//		
//	}
//	
//
//}
