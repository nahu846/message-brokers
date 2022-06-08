package org.example;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessageComponent {

    @Value("${spring.rabbitmq.routingkey}")
    private String routingKey;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(routingKey, message);
    }

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listenMessage(String in) {
        System.out.println("Message retrieved from myQueue : " + in);
    }
}
