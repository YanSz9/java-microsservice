package com.correa.microsservicepoc.service;

import org.springframework.stereotype.Service;

import com.correa.microsservicepoc.dto.ProposalRequestDto;
import com.correa.microsservicepoc.dto.ProposalResponseDto;
import com.correa.microsservicepoc.entity.Proposal;
import com.correa.microsservicepoc.repository.ProposalRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProposalService {
    private ProposalRepository proposalRepository;

    public ProposalResponseDto create(ProposalRequestDto requestDto) {
        proposalRepository.save(new Proposal());
        return null;
    }
}
