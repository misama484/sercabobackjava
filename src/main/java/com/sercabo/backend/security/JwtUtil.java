package com.sercabo.backend.security;

   import io.jsonwebtoken.Jwts;
   import io.jsonwebtoken.SignatureAlgorithm;
   import io.jsonwebtoken.security.Keys;
   import org.springframework.beans.factory.annotation.Value;
   import org.springframework.stereotype.Component;

   import javax.crypto.SecretKey;
   import javax.crypto.spec.SecretKeySpec;
   import java.util.Base64;
   import java.util.Date;

   @Component
   public class JwtUtil {

       private final SecretKey SECRET_KEY;

       public JwtUtil(@Value("${jwt.secret}") String secret) {
           byte[] decodedKey = Base64.getDecoder().decode(secret);
           this.SECRET_KEY = new SecretKeySpec(decodedKey, 0, decodedKey.length, "HmacSHA256");
       }

       public String generateToken(String email) {
           return Jwts.builder()
                   .setSubject(email)
                   .setIssuedAt(new Date())
                   .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // Expira en 24 horas
                   .signWith(SECRET_KEY)
                   .compact();
       }

       public String extractEmail(String token) {
           return Jwts.parserBuilder()
                   .setSigningKey(SECRET_KEY)
                   .build()
                   .parseClaimsJws(token)
                   .getBody()
                   .getSubject();
       }

       public boolean isTokenValid(String token, String email) {
           return extractEmail(token).equals(email);
       }
   }