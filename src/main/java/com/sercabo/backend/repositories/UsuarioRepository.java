package com.sercabo.backend.repositories;

import com.sercabo.backend.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);

    boolean existByEmail(boolean b);
}
