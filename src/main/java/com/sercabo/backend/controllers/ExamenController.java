package com.sercabo.backend.controllers;

import com.sercabo.backend.entities.ExamenGenerado;
import com.sercabo.backend.services.ExamenService;
import org.apache.coyote.Response;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // ENDPOINT PARA OBTENER UN EXAMEN POR ID
    @GetMapping("/{id}")
    public ResponseEntity<ExamenGenerado> getExamenById(@PathVariable Long id) {
        ExamenGenerado examenRecuperado = examenService.getExamenById(id);
        return ResponseEntity.ok(examenRecuperado);
    };

    // ENDPOINT PARA OBTENER TODOS LOS EXAMENES DE UN USUARIO
    @GetMapping("/all")
    public ResponseEntity<?> getAllExamenes(@RequestParam Long usuarioId) {
        List<ExamenGenerado> examenes = examenService.getAllExamenesByUsuario(usuarioId);
        return ResponseEntity.ok(examenes);
    }

}
