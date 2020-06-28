package br.edu.logatti.projetoP2.rabbit.consumer;

import br.edu.logatti.projetoP2.model.Curso;
import br.edu.logatti.projetoP2.service.CursoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CursoConsumer {

    @Autowired
    private CursoService cursoService;

    @RabbitListener(queues = {"${queue.curso.name}"})
    public void receive(@Payload final Curso curso) {
        cursoService.save(curso);
    }
}