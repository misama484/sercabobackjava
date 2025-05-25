package com.sercabo.backend.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    private final String SECRET = "sercabo_secret_key";

    public String generateToken(String email) {
        // Aquí iría la lógica para generar el token JWT usando la clave secreta

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // Expira en 24 horas
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }
    public String extractEmail(String token) {
        // Aquí iría la lógica para extraer el email del token JWT usando la clave secreta

        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean isTokenValid(String token, String email) {
        // Aquí iría la lógica para validar el token JWT usando la clave secreta

        return extractEmail(token).equals(email);
    }

}
