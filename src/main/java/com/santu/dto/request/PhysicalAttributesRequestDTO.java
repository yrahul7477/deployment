package com.santu.dto.request;

import lombok.Data;

@Data
public class PhysicalAttributesRequestDTO {
    private String complexion;
    private String height;
    private String weight;
    private String religion;
    private String eyeColor;
    private String hairColor;
    private String disability;
    private Long userId;

    // Getters and Setters
}
