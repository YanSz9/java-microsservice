package com.correa.microsservicepoc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.correa.microsservicepoc.entity.Proposal;

@Repository
public interface ProposalRepository extends CrudRepository<Proposal, Long> {

}
