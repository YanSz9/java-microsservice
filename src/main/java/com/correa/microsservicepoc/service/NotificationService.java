package com.correa.microsservicepoc.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.correa.microsservicepoc.dto.ProposalResponseDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class NotificationService {

    private RabbitTemplate rabbitTemplate;

    public void Notificate(ProposalResponseDto proposal, String exchange) {
        rabbitTemplate.convertAndSend(exchange, "", proposal);
    }
}
