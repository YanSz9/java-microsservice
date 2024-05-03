package com.correa.microsservicepoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.correa.microsservicepoc.dto.ProposalRequestDto;
import com.correa.microsservicepoc.dto.ProposalResponseDto;
import com.correa.microsservicepoc.entity.Proposal;
import com.correa.microsservicepoc.mapper.ProposalMapper;
import com.correa.microsservicepoc.repository.ProposalRepository;

@Service
public class ProposalService {
    private ProposalRepository proposalRepository;
    private NotificationService notificationService;
    private String exchange;

    public ProposalService(ProposalRepository proposalRepository,
            NotificationService notificationService,
            @Value("${rabbitmq.pendingproposal.exchange}") String exchange) {
        this.proposalRepository = proposalRepository;
        this.notificationService = notificationService;
        this.exchange = exchange;
    }

    public ProposalResponseDto create(ProposalRequestDto requestDto) {
        Proposal proposal = ProposalMapper.INSTANCE.convertDtoToProposal(requestDto);
        proposalRepository.save(proposal);

        ProposalResponseDto response = ProposalMapper.INSTANCE.convertEntityToDto(proposal);
        notificationService.Notificate(response, exchange);

        return response;
    }

    public List<ProposalResponseDto> getProposal() {
        return ProposalMapper.INSTANCE.convertListEntityToListDto(proposalRepository.findAll());
    }

}
