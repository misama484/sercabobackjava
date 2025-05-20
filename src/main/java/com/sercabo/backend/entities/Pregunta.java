package com.sercabo.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.time.Instant;
import java.util.Map;

@Entity
@Table(name = "preguntas")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pregunta {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(nullable = false)
    private String pregunta;

    @Column(name = "respuesta_correcta")
    private String respuestaCorrecta;

    @Column(nullable = false, columnDefinition = "jsonb")
    @Convert(converter = OpcionesConverter.class)
    private Map<String, String> opciones;

    @Column(nullable = false)
    private Integer tema;


    // Getters y Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public Map<String, String> getOpciones() {
        return opciones;
    }

    public void setOpciones(Map<String, String> opciones) {
        this.opciones = opciones;
    }

    public Integer getTema() {
        return tema;
    }

    public void setTema(Integer tema) {
        this.tema = tema;
    }
}