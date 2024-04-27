package com.correa.microsservicepoc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Proposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double requestedAmount;

    private int paymentTerm;

    private Boolean approved;

    private boolean integrated;

    private String observation;

    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;
}
