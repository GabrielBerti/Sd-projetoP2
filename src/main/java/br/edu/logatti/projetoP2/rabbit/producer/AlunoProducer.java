package br.edu.logatti.projetoP2.rabbit.producer;

import br.edu.logatti.projetoP2.model.Aluno;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AlunoProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Qualifier("alunoQueue")
    @Autowired
    private Queue queue;

    public void send(final Aluno aluno) {
        rabbitTemplate.convertAndSend(queue.getName(), aluno);
    }
}