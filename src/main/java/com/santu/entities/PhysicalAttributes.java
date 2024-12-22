package com.santu.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PhysicalAttributes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String complexion;

    @Column(nullable = false)
    private String height;

    @Column(nullable = false)
    private String weight;

    @Column(nullable = false)
    private String religion;

    @Column(nullable = false)
    private String eyeColor;

    @Column(nullable = false)
    private String hairColor;

    private String disability;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Getters and Setters
}

