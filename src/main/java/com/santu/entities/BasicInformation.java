package com.santu.entities;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "basic_details")
public class BasicInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "date_of_birth", nullable = false)
    private String dateOfBirth;

    @Column(nullable = false)
    private String religion;

    @Column(nullable = false)
    private String gender;

    @Column(name = "marital_status", nullable = false)
    private String maritalStatus;

    @Column(nullable = false)
    private String language;

    @Column(nullable = false)
    private String profession;

    @Column(name = "present_address", nullable = false)
    private String presentAddress;

    @Column(name = "financial_condition", nullable = false)
    private String financialCondition;

    @Column(name = "smoking_habits", nullable = false)
    private String smokingHabits;

    @Column(name = "drinking_status", nullable = false)
    private String drinkingStatus;

    @Column(nullable = false)
    private String district;

    @Column(nullable = false)
    private String division;

    @Column(nullable = false)
    private String taluk;

    @Column(name = "zip_code", nullable = false)
    private String zipCode;
}
