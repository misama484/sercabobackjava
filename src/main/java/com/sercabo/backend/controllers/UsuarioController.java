package com.sercabo.backend.controllers;

import com.sercabo.backend.entities.Usuario;
import com.sercabo.backend.services.UsuarioService;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/getAllUsuarios")
    public String getAllUsuarios() {
        return usuarioService.getAllUsuarios().toString();
    }
    @GetMapping("/getUsuarioById")
    public Usuario getUsuarioById(Long id) {
        return usuarioService.getUsuarioById(id);
    }
    @PostMapping("/getUsuarioByEmail")
    public Usuario getUsuarioByEmail(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        return usuarioService.getUsuarioByEmail(email);
    }
}
