package com.example.cursos.controller;

import com.example.cursos.model.Curso;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CursosController {

    private List<Curso> cursos;

    @PostConstruct
    public void init(){
        cursos = new ArrayList<>();
        cursos.add(new Curso("Python",50,"night"));
        cursos.add(new Curso("Spring",25,"afternoon"));
        cursos.add(new Curso("Springboot",30,"morning"));
        cursos.add(new Curso("Java EE",50,"weekend"));
        cursos.add(new Curso("Java basic",70,"morning"));
    }

    @GetMapping(value = "curso", produces = MediaType.APPLICATION_JSON_VALUE)
    public Curso getCurso(){
        return new Curso("Java", 100, "morning");
    }

    @GetMapping(value = "listaCursos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> getListCurso(){
        return cursos;
    }

    @GetMapping(value = "buscarCurso/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> findCursos(@PathVariable("name") String nombre){
        List<Curso> cursoEncontrado = new ArrayList<>();
        for (Curso curso: cursos) {
            if (curso.getName().equals(nombre)){
                cursoEncontrado.add(curso);
            }
        }
        return cursoEncontrado;
    }

    @DeleteMapping(value = "eliminarCurso/{name}",produces = MediaType.TEXT_PLAIN_VALUE)
    public String deleteCurso(@PathVariable("name") String nombre){
        cursos.removeIf(curso->curso.getName().equals(nombre));
        return "Eliminado";
    }

    @PostMapping(value = "añadirCurso",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> addCurso(@RequestBody Curso curso){
        cursos.add(curso);
        return cursos;
    }

    @PutMapping(value = "actualizarCurso", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> updateCurso(@RequestBody Curso curso){
        for (int i = 0; i<cursos.size() ; i++){
            if (cursos.get(i).getName().equals(curso.getName())){
                cursos.set(i,curso);
            }
        }
        return cursos;
    }
}
