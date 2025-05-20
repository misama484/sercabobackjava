package com.sercabo.backend.controllers;

import com.sercabo.backend.entities.Pregunta;
import com.sercabo.backend.services.PreguntaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
public class PreguntaController {

    private final PreguntaService preguntaService;

    public PreguntaController(PreguntaService preguntaService) {
        this.preguntaService = preguntaService;
    }

    @GetMapping("/cargar-preguntas")
    public String cargarPreguntas(@RequestParam String rutaArchivo) {
        preguntaService.cargarPreguntasDesdeJson("preguntasTema1RROO_con_tema.json");
        return "Preguntas cargadas correctamente";
    }

    @GetMapping("/getAllPreguntas")
    public List<Pregunta> getAllPreguntas() {
        return preguntaService.getAllPreguntas();
    }

}