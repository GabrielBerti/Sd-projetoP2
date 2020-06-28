package br.edu.logatti.projetoP2.rabbit.producer;

import br.edu.logatti.projetoP2.model.Curso;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CursoProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Qualifier("cursoQueue")
    @Autowired
    private Queue queue;

    public void send(final Curso curso) {
        rabbitTemplate.convertAndSend(queue.getName(), curso);
    }
}