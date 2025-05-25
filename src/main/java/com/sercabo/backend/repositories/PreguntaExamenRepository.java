package com.sercabo.backend.repositories;


import com.sercabo.backend.entities.PreguntaExamen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PreguntaExamenRepository extends JpaRepository<PreguntaExamen, Long> {

}
