package com.app.instrumentos.service;

import com.app.instrumentos.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private Logger LOGGER = LoggerFactory.getLogger(ProducerService.class);

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.binding.routing.key}")
    private String orderRoutingKey;


    private RabbitTemplate rabbitTemplate;

    public ProducerService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(OrderEvent orderEvent) {
        LOGGER.info(String.format("Enviando aviso de pago MP => %s", orderEvent.toString()));

        // send an order event to order queue
        rabbitTemplate.convertAndSend(exchange, orderRoutingKey, orderEvent);

    }
}