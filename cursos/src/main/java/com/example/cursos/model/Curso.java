package com.example.cursos.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

@JacksonXmlRootElement
@Data
public class Curso {

    private String name;
    private int duration;
    private String schedule;

    public Curso(String name, int duration, String schedule) {
        super();
        this.name = name;
        this.duration = duration;
        this.schedule = schedule;
    }
}
