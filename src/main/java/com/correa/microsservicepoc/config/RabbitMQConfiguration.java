package com.correa.microsservicepoc.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
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

    @Bean
    public RabbitAdmin createRabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> initializeAdmin(RabbitAdmin rabbitAdmin) {
        return event -> rabbitAdmin.initialize();
    }

    public FanoutExchange createFanoutExchangePendingProposal() {
        return ExchangeBuilder.fanoutExchange("pending-proposal.ex").build();
    }

    @Bean
    public Binding createBindingPendingProposalMsCreditAnalisys() {
        return BindingBuilder.bind(createQueuePendingProposalMsCreditAnalisys())
                .to(createFanoutExchangePendingProposal());
    }

    @Bean
    public Binding createBindingPendingProposalMsNotification() {
        return BindingBuilder.bind(createQueuePendingProposalMsNotification())
                .to(createFanoutExchangePendingProposal());
    }

}
