package com.sercabo.backend.controllers;

import com.sercabo.backend.entities.Usuario;
import com.sercabo.backend.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> datos) {
        String token = authService.login(datos.get("email"), datos.get("password"));
        return ResponseEntity.ok(Map.of("token", token));
    }

    @PostMapping("/register")
    public ResponseEntity<Usuario> register(@RequestBody Map<String, String> datos) {
        Usuario nuevo = authService.register(
                datos.get("email"),
                datos.get("nombre"),
                datos.get("password")
        );
        return ResponseEntity.ok(nuevo);
    }
}
