package com.sercabo.backend.repositories;

import com.sercabo.backend.entities.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PreguntaRepository extends JpaRepository<Pregunta, String> {

    // buscar preguntas por tema:
    List<Pregunta> findByTema(Integer tema);
}