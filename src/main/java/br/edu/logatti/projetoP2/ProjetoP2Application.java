package br.edu.logatti.projetoP2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class ProjetoP2Application {

    @Value("${queue.curso.name}")
    private String cursoQueue;

    @Value("${queue.aluno.name}")
    private String alunoQueue;

    public static void main(String[] args) {
        SpringApplication.run(ProjetoP2Application.class, args);
        log.info("********** Aplicação iniciada com sucesso **********");
        log.info("Aplicação disponível em: http://localhost:8080");
        log.info("Swagger disponível em: http://localhost:8080/swagger-ui.html");
        log.info("RabbitMQ disponível em: http://localhost:15672");
    }

    @Bean
    public Queue alunoQueue() {
        return new Queue(alunoQueue, true);
    }

    @Bean
    public Queue cursoQueue() {
        return new Queue(cursoQueue, true);
    }
}