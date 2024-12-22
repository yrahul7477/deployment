package com.santu.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class FamilyInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fathersName;

    private String fathersProfession;

    private String fathersContact;

    @Column(nullable = false)
    private String mothersName;

    private String mothersProfession;

    private String mothersContact;

    @Column(nullable = false)
    private int totalBrother;

    @Column(nullable = false)
    private int totalSister;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}

