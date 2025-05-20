package com.sercabo.backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Deshabilita CSRF si no es necesario
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() // Permite acceso a todos los endpoints sin autenticación
            )
            .httpBasic().disable(); // Desactiva la autenticación básica

        return http.build();
    }
}
