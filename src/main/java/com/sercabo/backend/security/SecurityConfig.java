package com.sercabo.backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtFilter jwtFilter) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Deshabilita CSRF si no es necesario
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/auth/**").permitAll()
                    .anyRequest().authenticated() // Permite acceso a todos los endpoints sin autenticación
            )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Configura la sesión como sin estado
            .headers(headers -> headers
                .frameOptions(frameOptions -> frameOptions.disable()) // Deshabilita X-Frame-Options
            );
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class); // Añade el filtro JWT antes del filtro de autenticación por nombre de usuario y contraseña

        return http.build();
    }
}
