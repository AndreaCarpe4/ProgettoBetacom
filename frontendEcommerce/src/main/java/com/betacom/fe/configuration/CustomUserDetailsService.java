package com.betacom.fe.configuration;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class CustomUserDetailsService {
	
	@Autowired
	private RestTemplate res;
	
	@Autowired
	Logger log;
	
	@Value("${jpa.backend}")
	String backend;
	
	@Autowired
	private PasswordEncoder getPasswordEncoder;
	
	public InMemoryUserDetailsManager loadUsers() {
		
		List<UserDetails> userDetailsList = new ArrayList<UserDetails>();
		
		URI uri = UriComponentsBuilder.fromUriString(backend + "utente/listSecurity").build().toUri();
		
		log.debug("uri: " + uri);
		
		List<HashMap<String, Object>> r = res.getForObject(uri, ArrayList.class);
		
		for(HashMap<String, Object> it : r) {
			
			log.debug("loadUsers....." + it.get("userName"));
			
			userDetailsList.add(
					User.withUsername(it.get("userName").toString())
					.password(getPasswordEncoder.encode(it.get("password").toString()))
					.roles(it.get("ruolo").toString())
					.build()
					);
			
				}
		
		return new InMemoryUserDetailsManager(userDetailsList);

			}

}