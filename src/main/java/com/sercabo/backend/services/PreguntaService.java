package com.sercabo.backend.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sercabo.backend.entities.Pregunta;
import com.sercabo.backend.repositories.PreguntaRepository;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

@Service
public class PreguntaService {

    private final PreguntaRepository preguntaRepository;
    private final ObjectMapper objectMapper;

    public PreguntaService(PreguntaRepository preguntaRepository, ObjectMapper objectMapper) {
        this.preguntaRepository = preguntaRepository;
        this.objectMapper = objectMapper;
    }

    public void cargarPreguntasDesdeJson(String nombreArchivo) {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(nombreArchivo)) {
            if (inputStream == null) {
                throw new FileNotFoundException("Archivo no encontrado: " + nombreArchivo);
            }
            List<Pregunta> preguntas = objectMapper.readValue(inputStream, new TypeReference<>() {});
            preguntaRepository.saveAll(preguntas);
        } catch (Exception e) {
            throw new RuntimeException("Error al cargar preguntas desde JSON", e);
        }
    }

    public List<Pregunta> getAllPreguntas() {
        return preguntaRepository.findAll();
    }

}