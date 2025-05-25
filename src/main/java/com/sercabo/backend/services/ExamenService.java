package com.sercabo.backend.services;

import com.sercabo.backend.entities.ExamenGenerado;
import com.sercabo.backend.entities.Pregunta;
import com.sercabo.backend.entities.PreguntaExamen;
import com.sercabo.backend.entities.Usuario;
import com.sercabo.backend.repositories.ExamenGeneradoRepository;
import com.sercabo.backend.repositories.PreguntaRepository;
import com.sercabo.backend.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ExamenService {

    private final PreguntaRepository preguntaRepo;
    private final UsuarioRepository usuarioRepo;
    private final ExamenGeneradoRepository examenRepo;

    public ExamenService(PreguntaRepository preguntaRepo, UsuarioRepository usuarioRepo, ExamenGeneradoRepository examenRepo) {
        this.preguntaRepo = preguntaRepo;
        this.usuarioRepo = usuarioRepo;
        this.examenRepo = examenRepo;
    }

    // CREA UN EXAMEN GENERADO PARA UN USUARIO
    public ExamenGenerado generarExamen(Long usuarioId, int tema, int cantidadPreguntas) {
        Usuario usuario = usuarioRepo.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        List<Pregunta> preguntas = preguntaRepo.findRandomByTema(tema, cantidadPreguntas);

        ExamenGenerado examen = new ExamenGenerado();
        examen.setUsuario(usuario);
        examen.setTema(tema);
        examen.setCompletado(false);

        List<PreguntaExamen> preguntasExamen = preguntas.stream().map(p -> {
            PreguntaExamen pe = new PreguntaExamen();
            pe.setPregunta(p);
            pe.setExamen(examen);
            return pe;
        }).toList();

        examen.setPreguntas(preguntasExamen);

        return examenRepo.save(examen);
    };
}
