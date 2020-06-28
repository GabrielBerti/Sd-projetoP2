package br.edu.logatti.projetoP2.controller;

import br.edu.logatti.projetoP2.constant.Constant;
import br.edu.logatti.projetoP2.model.Aluno;
import br.edu.logatti.projetoP2.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = Constant.ALUNO_API)
public class AlunoController {

    @Autowired
    private AlunoService service;

    @PostMapping
    public ResponseEntity save(@RequestBody final Aluno aluno) {
        service.sendRabbit(aluno);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @PutMapping
    public ResponseEntity<Aluno> update(@RequestBody final Aluno aluno) {
        return ResponseEntity.ok().body(service.save(aluno));
    }

    @DeleteMapping(path = "/{ra}")
    public ResponseEntity<Void> delete(@PathVariable("ra") final String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/{ra}")
    public ResponseEntity<Optional<Aluno>> findById(@PathVariable("ra") final String id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

}