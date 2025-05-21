package com.sercabo.backend.controllers;

import com.sercabo.backend.entities.Pregunta;
import com.sercabo.backend.services.PreguntaService;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
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

    @GetMapping("/getAllPreguntasTema") ///getAllPreguntasTema?tema=1
    public List<Pregunta> getAllPreguntasTema(@RequestParam int tema) {
        return preguntaService.getAllPreguntasTema(tema);
    }

    //devuelve una lista de preguntas con el limite pasado por parametro, debe devolver preguntas aleatorias
    @GetMapping("/getAllPreguntasTemaLimit") ///getAllPreguntasTema?tema=1
    public List<Pregunta> getAllPreguntasTemaLimit(@RequestParam int tema, @RequestParam int limit) {
        List<Pregunta> lista = preguntaService.getAllPreguntasTema(tema);
        Collections.shuffle(lista);//Mezcla la lista de preguntas para dar un orden aleatorio
        if (limit > lista.size()) {
            limit = lista.size();
        }
        return lista.stream().limit(limit).toList();

    }

}