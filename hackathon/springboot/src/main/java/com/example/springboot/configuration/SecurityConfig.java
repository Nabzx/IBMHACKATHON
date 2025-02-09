package com.example.springboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/oauth2/**").permitAll() // Allow public access to login and OAuth2 routes
                        .anyRequest().authenticated() // Secure all other routes
                )
                .oauth2Login(oauth2 -> oauth2
                        .loginPage("/login") // Custom login page (optional)
                        .defaultSuccessUrl("/home", true) // Redirect on success
                        .failureUrl("/login?error=true") // Redirect on failure
                );

        return http.build();
    }
}
