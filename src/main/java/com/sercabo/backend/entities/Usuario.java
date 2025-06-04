package com.sercabo.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import org.hibernate.cache.spi.entry.StructuredCacheEntry;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String passwordHash;
    @Column(nullable = false, columnDefinition = "integer default 0")
    private int avatarCode = 0;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<ExamenGenerado> examenes;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro = LocalDateTime.now();

    public Usuario(Long id, String nombre, String email, String passwordHash, int avatarCode) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.passwordHash = passwordHash;
        this.avatarCode = avatarCode;
    }

    public Usuario() {
        // Constructor por defecto necesario para JPA
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public int getAvatarCode() {
        return avatarCode;
    }
    public void setAvatarCode(int avatarCode) {
        this.avatarCode = avatarCode;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(getId(), usuario.getId()) && Objects.equals(getEmail(), usuario.getEmail()) && Objects.equals(getPasswordHash(), usuario.getPasswordHash());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), getPasswordHash());
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }
}
