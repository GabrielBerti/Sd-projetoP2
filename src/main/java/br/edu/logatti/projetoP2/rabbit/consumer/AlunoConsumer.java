package br.edu.logatti.projetoP2.rabbit.consumer;

import br.edu.logatti.projetoP2.model.Aluno;
import br.edu.logatti.projetoP2.service.AlunoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class AlunoConsumer {

    @Autowired
    private AlunoService alunoService;

    @RabbitListener(queues = {"${queue.aluno.name}"})
    public void receive(@Payload final Aluno aluno) {
        alunoService.save(aluno);
    }
}