package com.sercabo.backend.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "examenes_generados")
public class ExamenGenerado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Usuario usuario;

    private int tema;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    private int respuestasCorrectas;

    private boolean completado = false;

    @OneToMany(mappedBy = "examen", cascade = CascadeType.ALL)
    private List<PreguntaExamen> preguntas = new ArrayList<>();

}
