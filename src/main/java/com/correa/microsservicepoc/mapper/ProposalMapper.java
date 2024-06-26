package com.correa.microsservicepoc.mapper;

import java.text.NumberFormat;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.correa.microsservicepoc.dto.ProposalRequestDto;
import com.correa.microsservicepoc.dto.ProposalResponseDto;
import com.correa.microsservicepoc.entity.Proposal;

@Mapper
public interface ProposalMapper {

    ProposalMapper INSTANCE = Mappers.getMapper(ProposalMapper.class);

    @Mapping(target = "user.name", source = "name")
    @Mapping(target = "user.surname", source = "surname")
    @Mapping(target = "user.cpf", source = "cpf")
    @Mapping(target = "user.phone", source = "phone")
    @Mapping(target = "user.income", source = "income")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "approved", ignore = true)
    @Mapping(target = "integrated", constant = "true")
    @Mapping(target = "observation", ignore = true)
    Proposal convertDtoToProposal(ProposalRequestDto proposalRequestDto);

    @Mapping(target = "name", source = "user.name")
    @Mapping(target = "surname", source = "user.surname")
    @Mapping(target = "cpf", source = "user.cpf")
    @Mapping(target = "phone", source = "user.phone")
    @Mapping(target = "income", source = "user.income")
    @Mapping(target = "requestedAmount", expression = "java(setRequestedAmount(proposal))")
    ProposalResponseDto convertEntityToDto(Proposal proposal);

    List<ProposalResponseDto> convertListEntityToListDto(Iterable<Proposal> proposal);

    default String setRequestedAmount(Proposal proposal) {
        return NumberFormat.getCurrencyInstance().format(proposal.getRequestedAmount());
    }
}
