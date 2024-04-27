package com.correa.microsservicepoc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.correa.microsservicepoc.dto.ProposalRequestDto;
import com.correa.microsservicepoc.dto.ProposalResponseDto;
import com.correa.microsservicepoc.service.ProposalService;

@RestController
@RequestMapping("/proposal")
public class ProposalController {

    @Autowired
    private ProposalService proposalService;

    @PostMapping
    public ResponseEntity<ProposalResponseDto> create(@RequestBody ProposalRequestDto requestDto) {
        ProposalResponseDto response = proposalService.create(requestDto);
        return ResponseEntity.ok(response);

    }

}
