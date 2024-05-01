package com.correa.microsservicepoc.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    @Bean
    public Queue createQueuePendingProposalMsCreditAnalisys() {
        return QueueBuilder.durable("pending-proposal.ms-credit-analysis").build();
    }

    @Bean
    public Queue createQueuePendingProposalMsNotification() {
        return QueueBuilder.durable("pending-proposal.ms-notification").build();
    }

    @Bean
    public Queue createQueueProposalCompletedMsProposal() {
        return QueueBuilder.durable("proposal-completed.ms-proposal").build();
    }

    @Bean
    public Queue createQueueProposalCompletedMsNotification() {
        return QueueBuilder.durable("proposal-completed.ms-notification").build();
    }
}
