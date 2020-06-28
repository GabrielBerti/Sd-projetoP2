package br.edu.logatti.projetoP2.service;

import br.edu.logatti.projetoP2.exception.ResourceNotFoundException;
import br.edu.logatti.projetoP2.model.Aluno;
import br.edu.logatti.projetoP2.rabbit.producer.AlunoProducer;
import br.edu.logatti.projetoP2.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    @Autowired
    private AlunoProducer alunoProducer;

    public void sendRabbit(final Aluno aluno) {
        alunoProducer.send(aluno);
    }

    public Aluno save(final Aluno aluno) {
        return repository.save(aluno);
    }

    public List<Aluno> findAll() {
        return repository.findAll();
    }

    public Optional<Aluno> findById(final String id) {
        return Optional.ofNullable(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Aluno.class.getSimpleName())));
    }

    public void delete(final String id) {
        findById(id);
        repository.deleteById(id);
    }
}
