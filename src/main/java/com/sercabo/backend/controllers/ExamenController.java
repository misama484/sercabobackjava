package com.sercabo.backend.controllers;

import com.sercabo.backend.entities.ExamenGenerado;
import com.sercabo.backend.services.ExamenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/examenes")
public class ExamenController {

    private final ExamenService examenService;

    public ExamenController(ExamenService examenService) {
        this.examenService = examenService;
    }

    //ENDPOINT PARA GENERAR UN EXAMEN
    @PostMapping("generar")
    public ResponseEntity<ExamenGenerado> generarExamen(
            @RequestParam Long usuarioId,
            @RequestParam int tema,
            @RequestParam(defaultValue = "10") int cantidad
    ) {
        ExamenGenerado examen = examenService.generarExamen(usuarioId, tema, cantidad);
        return ResponseEntity.ok(examen);
    }

}
