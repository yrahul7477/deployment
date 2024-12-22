package com.santu.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PartnerExpectations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String generalRequirement;

    @Column(nullable = false)
    private int minimumAge;

    @Column(nullable = false)
    private int maximumAge;

    @Column(nullable = false)
    private int maximumWeight;

    @Column(nullable = false)
    private String maritalStatus;

    @Column(nullable = false)
    private String religion;

    private String complexion;

    private String smokingHabits;

    private String drinkingStatus;

    private String minimumDegree;

    private String profession;

    private String languages;

    private String personality;

    private String financialCondition;

    private String familyPosition;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Getters and Setters
}

