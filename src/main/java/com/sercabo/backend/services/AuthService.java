package com.sercabo.backend.services;

import com.sercabo.backend.entities.Usuario;
import com.sercabo.backend.repositories.UsuarioRepository;
import com.sercabo.backend.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepo;
    @Autowired
    private JwtUtil jwtUtil;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String login(String email, String Password) {
        // Verificar si el usuario existe
        Usuario usuario = usuarioRepo.findByEmail(email);
        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado");
        }

        // Verificar la contraseña
        if (!passwordEncoder.matches(Password, usuario.getPasswordHash())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        // Generar y devolver el token JWT
        return jwtUtil.generateToken(usuario.getEmail());
    }

    public Usuario register(String email, String nombre, String password) {
        // Verificar si el usuario ya existe
        if (usuarioRepo.existByEmail(email != null)) {
            throw new RuntimeException("El usuario ya existe");
        }

        Usuario user = new Usuario();
        user.setEmail(email);
        user.setNombre(nombre);
        user.setPasswordHash(passwordEncoder.encode(password));


        // Guardar el nuevo usuario
        return usuarioRepo.save(user);
    }

}
