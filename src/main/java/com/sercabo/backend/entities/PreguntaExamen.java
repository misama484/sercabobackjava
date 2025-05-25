package com.sercabo.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "preguntas_examen")
public class PreguntaExamen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ExamenGenerado examen;

    @ManyToOne
    private Pregunta pregunta;

    @Column(name = "respuesta_usuario")
    private String respuestaUsuario; //A, B, C, D

    @Column(name = "es_correcta")
    private Boolean esCorrecta;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ExamenGenerado getExamen() {
        return examen;
    }

    public void setExamen(ExamenGenerado examen) {
        this.examen = examen;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuestaUsuario() {
        return respuestaUsuario;
    }

    public void setRespuestaUsuario(String respuestaUsuario) {
        this.respuestaUsuario = respuestaUsuario;
    }

    public Boolean getEsCorrecta() {
        return esCorrecta;
    }

    public void setEsCorrecta(Boolean esCorrecta) {
        this.esCorrecta = esCorrecta;
    }
}
