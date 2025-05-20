package com.sercabo.backend.repositories;

import com.sercabo.backend.entities.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreguntaRepository extends JpaRepository<Pregunta, String> {
}