package com.betacom.fe.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((requests) -> requests
            .requestMatchers("/", "/home", "/uomo", "/donna", "/accessori", "/register", "/listById", "/carrello").permitAll()
            .requestMatchers("/create", "/save", "/login", "/img/**", "/css/**").permitAll() // PERMETTI REGISTRAZIONE SENZA LOGIN
            .requestMatchers("/admin", "/admin/").hasRole("ADMIN") // SOLO ADMIN PUÒ ACCEDERE A QUESTI URL
            .anyRequest().authenticated() // TUTTE LE ALTRE RICHIESTE RICHIEDONO LOGIN
        )
        .formLogin((form) -> form
            .loginPage("/login") // PAGINA DI LOGIN
            .defaultSuccessUrl("/home", true)
            .permitAll()
        )
        .logout((logout) -> logout.permitAll());

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}