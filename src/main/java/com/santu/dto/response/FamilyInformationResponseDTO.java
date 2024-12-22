package com.santu.dto.response;



import lombok.Data;

@Data
public class FamilyInformationResponseDTO {
    private Long id;
    private String fathersName;
    private String fathersProfession;
    private String fathersContact;
    private String mothersName;
    private String mothersProfession;
    private String mothersContact;
    private int totalBrother;
    private int totalSister;
    private Long userId;
}

