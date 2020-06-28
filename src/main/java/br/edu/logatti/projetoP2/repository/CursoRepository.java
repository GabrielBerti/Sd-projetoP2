package br.edu.logatti.projetoP2.repository;

import br.edu.logatti.projetoP2.model.Curso;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends MongoRepository<Curso, String> {
}