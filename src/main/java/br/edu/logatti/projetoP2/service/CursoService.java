package br.edu.logatti.projetoP2.service;

import br.edu.logatti.projetoP2.exception.ResourceNotFoundException;
import br.edu.logatti.projetoP2.model.Aluno;
import br.edu.logatti.projetoP2.model.Curso;
import br.edu.logatti.projetoP2.rabbit.producer.CursoProducer;
import br.edu.logatti.projetoP2.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

        @Autowired
        private CursoRepository repository;

        @Autowired
        private CursoProducer cursoProducer;

        public void sendRabbit(final Curso curso) {
            cursoProducer.send(curso);
        }

        public Curso save(final Curso curso) {
            return repository.save(curso);
        }

        public List<Curso> findAll() {
            return repository.findAll();
        }

        public Optional<Curso> findById(final String id) {
            return Optional.ofNullable(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Curso.class.getSimpleName())));
        }

        public void delete(final String id) {
            findById(id);
            repository.deleteById(id);
        }

        public void deleteAll(){
            repository.deleteAll();
        }

}
