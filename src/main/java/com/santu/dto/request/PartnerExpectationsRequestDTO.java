package com.santu.dto.request;

import lombok.Data;

@Data

public class PartnerExpectationsRequestDTO {
    private String generalRequirement;
    private int minimumAge;
    private int maximumAge;
    private int maximumWeight;
    private String maritalStatus;
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
    private Long userId;

    // Getters and Setters
}

