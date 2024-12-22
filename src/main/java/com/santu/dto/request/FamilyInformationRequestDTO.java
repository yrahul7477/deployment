package com.santu.dto.request;



import lombok.Data;

@Data
public class FamilyInformationRequestDTO {
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

