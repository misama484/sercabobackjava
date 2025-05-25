package com.sercabo.backend.repositories;

import com.sercabo.backend.entities.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PreguntaRepository extends JpaRepository<Pregunta, String> {
    @Query(value = "SELECT * FROM preguntas WHERE tema = :tema ORDER BY random() LIMIT :cantidad", nativeQuery = true)
    List<Pregunta> findRandomByTema(@Param("tema") int tema, @Param("cantidad") int cantidad);
    // buscar preguntas por tema:
    List<Pregunta> findByTema(Integer tema);
}

/*
    public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {

}
 */