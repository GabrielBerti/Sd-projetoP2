package br.edu.logatti.projetoP2.repository;

import br.edu.logatti.projetoP2.model.Aluno;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends MongoRepository<Aluno, String> {
}