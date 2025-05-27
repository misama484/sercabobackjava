package com.sercabo.backend.controllers;

import com.sercabo.backend.services.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String getUsuarioById(Long id) {
        return usuarioService.getUsuarioById(id).toString();
    }
}
