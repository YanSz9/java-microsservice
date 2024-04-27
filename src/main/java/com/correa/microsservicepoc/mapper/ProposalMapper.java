package com.correa.microsservicepoc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.correa.microsservicepoc.dto.ProposalRequestDto;
import com.correa.microsservicepoc.entity.Proposal;

@Mapper
public interface ProposalMapper {
    @Mapping(target = "user.name", source = "name")
    @Mapping(target = "user.surname", source = "surname")
    @Mapping(target = "user.cpf", source = "cpf")
    @Mapping(target = "user.phone", source = "phone")
    @Mapping(target = "user.income", source = "income")
    @Mapping(target = "user.name", source = "name")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "approved", ignore = true)
    @Mapping(target = "integrated", ignore = true)
    @Mapping(target = "observation", ignore = true)

    Proposal convertDtoToProposal(ProposalRequestDto proposalRequestDto);

}
