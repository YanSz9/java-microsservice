package com.correa.microsservicepoc.job;

import java.util.concurrent.TimeUnit;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.correa.microsservicepoc.entity.Proposal;
import com.correa.microsservicepoc.repository.ProposalRepository;
import com.correa.microsservicepoc.service.NotificationRabbitService;
import org.slf4j.Logger;

@Component
public class ProposalWithoutIntegration {
    private final ProposalRepository proposalRepository;
    private final NotificationRabbitService notificationRabbitService;
    private final String exchange;
    private final Logger logger = LoggerFactory.getLogger(ProposalWithoutIntegration.class);

    public ProposalWithoutIntegration(ProposalRepository proposalRepository,
            NotificationRabbitService notificationRabbitService,
            @Value("${rabbitmq.pendingproposal.exchange}") String exchange) {
        this.proposalRepository = proposalRepository;
        this.notificationRabbitService = notificationRabbitService;
        this.exchange = exchange;
    }

    @Scheduled(fixedDelay = 10, timeUnit = TimeUnit.SECONDS)
    public void findProposalWithoutIntegration() {
        proposalRepository.findAllByIntegratedIsFalse().forEach(proposal -> {
            try {
                notificationRabbitService.notificate(proposal, exchange);
                updateProposal(proposal);

            } catch (RuntimeException ex) {
                logger.error(ex.getMessage());
            }
        });
    }

    private void updateProposal(Proposal proposal) {
        proposal.setIntegrated(true);
        proposalRepository.save(proposal);
    }
}
