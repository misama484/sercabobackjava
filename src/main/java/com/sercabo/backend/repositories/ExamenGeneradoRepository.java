package com.sercabo.backend.repositories;

import com.sercabo.backend.entities.ExamenGenerado;
import com.sercabo.backend.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamenGeneradoRepository extends JpaRepository<ExamenGenerado, Long> {

    List<ExamenGenerado> findByUsuario(Usuario usuario);
}
