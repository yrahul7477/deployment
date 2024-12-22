package com.santu.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class EducationRequest {

    @NotBlank(message = "Institute name cannot be blank")
    private String institute;

    @NotBlank(message = "Degree cannot be blank")
    private String degree;

    private String fieldOfStudy;

    private String registrationNo;

    private String rollNo;

    @NotNull(message = "Starting year is required")
    @Positive(message = "Starting year must be a positive number")
    private Integer startingYear;

    @NotNull(message = "Ending year is required")
    @Positive(message = "Ending year must be a positive number")
    private Integer endingYear;

    @Positive(message = "Result must be a positive number")
    private Double result;

    @Positive(message = "Result out of must be a positive number")
    private Double resultOutOf;

    // Getters and Setters
    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public Integer getStartingYear() {
        return startingYear;
    }

    public void setStartingYear(Integer startingYear) {
        this.startingYear = startingYear;
    }

    public Integer getEndingYear() {
        return endingYear;
    }

    public void setEndingYear(Integer endingYear) {
        this.endingYear = endingYear;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public Double getResultOutOf() {
        return resultOutOf;
    }

    public void setResultOutOf(Double resultOutOf) {
        this.resultOutOf = resultOutOf;
    }
}
