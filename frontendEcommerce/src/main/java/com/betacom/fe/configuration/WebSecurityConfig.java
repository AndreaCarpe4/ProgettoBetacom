//package com.betacom.fe.configuration;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig {
//
//    // Definizione delle regole di security
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        http.authorizeHttpRequests((requests) -> requests
//            .requestMatchers("/admin", "/admin/").hasRole("ADMIN") // URL solo per utenti admin
//            .requestMatchers("/").permitAll() // Altri URL che non sono protetti
//            .anyRequest().authenticated() // Tutte le richieste sono autenticate di suo
//        )
//        .formLogin((form) -> form
//            .loginPage("/login") // URL di login
//            .permitAll() // Login URL sempre valido
//        )
//        .logout((logout) -> logout.permitAll());
//
//        return http.build();
//    }
//
//
//    @Bean
//    PasswordEncoder passwordEncoder() {
//    	
//        return new BCryptPasswordEncoder();
//    }
//}
