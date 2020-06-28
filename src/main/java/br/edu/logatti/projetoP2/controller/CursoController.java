package br.edu.logatti.projetoP2.controller;

import br.edu.logatti.projetoP2.constant.Constant;
import br.edu.logatti.projetoP2.model.Curso;
import br.edu.logatti.projetoP2.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = Constant.CURSO_API)
public class CursoController {

    @Autowired
    private CursoService service;

    @PostMapping
    public ResponseEntity save(@RequestBody final Curso curso) {
        service.sendRabbit(curso);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Curso>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @PutMapping
    public ResponseEntity<Curso> update(@RequestBody final Curso curso) {
        return ResponseEntity.ok().body(service.save(curso));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") final String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Curso>> findById(@PathVariable("id") final String id) {
        return ResponseEntity.ok().body(service.findById(id));
    }
}