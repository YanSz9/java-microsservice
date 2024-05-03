package com.correa.microsservicepoc.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.correa.microsservicepoc.entity.Proposal;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class NotificationRabbitService {

    private RabbitTemplate rabbitTemplate;

    public void notificate(Proposal proposal, String exchange) {
        rabbitTemplate.convertAndSend(exchange, "", proposal);
    }
}
