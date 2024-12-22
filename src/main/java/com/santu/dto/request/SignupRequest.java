package com.santu.dto.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class SignupRequest {

    @NotBlank
    @Size(min = 2, max = 50)
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 50)
    private String lastName;

    @NotNull
    private LocalDate dob;

    @NotBlank
    private String religion;

    @NotBlank
    private String gender;

    private String maritalStatus;

    private String language;

    private String profession;

    private String financialCondition;

    private String smokingHabits;

    private String drinkingStatus;

    @NotBlank
    private String presentAddress;

    @NotBlank
    private String district;

    @NotBlank
    private String division;

    @NotBlank
    private String taluk;

    @NotBlank
    @Size(min = 6, max = 6)
    private String zipCode;

    @NotBlank
    @Size(min = 10, max = 10)
    private String phoneNumber1;

    private String phoneNumber2;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max = 50)
    private String password;

    @NotBlank
    @Size(min = 6, max = 50)
    private String confirmPassword;

    private String photo;

    @NotBlank
    private String role;

    public @NotBlank @Size(min = 2, max = 50) String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotBlank @Size(min = 2, max = 50) String firstName) {
        this.firstName = firstName;
    }

    public @NotBlank @Size(min = 2, max = 50) String getLastName() {
        return lastName;
    }

    public void setLastName(@NotBlank @Size(min = 2, max = 50) String lastName) {
        this.lastName = lastName;
    }

    public @NotNull LocalDate getDob() {
        return dob;
    }

    public void setDob(@NotNull LocalDate dob) {
        this.dob = dob;
    }

    public @NotBlank String getReligion() {
        return religion;
    }

    public void setReligion(@NotBlank String religion) {
        this.religion = religion;
    }

    public @NotBlank String getGender() {
        return gender;
    }

    public void setGender(@NotBlank String gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getFinancialCondition() {
        return financialCondition;
    }

    public void setFinancialCondition(String financialCondition) {
        this.financialCondition = financialCondition;
    }

    public String getSmokingHabits() {
        return smokingHabits;
    }

    public void setSmokingHabits(String smokingHabits) {
        this.smokingHabits = smokingHabits;
    }

    public String getDrinkingStatus() {
        return drinkingStatus;
    }

    public void setDrinkingStatus(String drinkingStatus) {
        this.drinkingStatus = drinkingStatus;
    }

    public @NotBlank String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(@NotBlank String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public @NotBlank String getDistrict() {
        return district;
    }

    public void setDistrict(@NotBlank String district) {
        this.district = district;
    }

    public @NotBlank String getDivision() {
        return division;
    }

    public void setDivision(@NotBlank String division) {
        this.division = division;
    }

    public @NotBlank String getTaluk() {
        return taluk;
    }

    public void setTaluk(@NotBlank String taluk) {
        this.taluk = taluk;
    }

    public @NotBlank @Size(min = 6, max = 6) String getZipCode() {
        return zipCode;
    }

    public void setZipCode(@NotBlank @Size(min = 6, max = 6) String zipCode) {
        this.zipCode = zipCode;
    }

    public @NotBlank @Size(min = 10, max = 10) String getPhoneNumber1() {
        return phoneNumber1;
    }

    public void setPhoneNumber1(@NotBlank @Size(min = 10, max = 10) String phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }

    public String getPhoneNumber2() {
        return phoneNumber2;
    }

    public void setPhoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

    public @NotBlank @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank @Email String email) {
        this.email = email;
    }

    public @NotBlank @Size(min = 6, max = 50) String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank @Size(min = 6, max = 50) String password) {
        this.password = password;
    }

    public @NotBlank @Size(min = 6, max = 50) String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(@NotBlank @Size(min = 6, max = 50) String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public @NotBlank String getRole() {
        return role;
    }

    public void setRole(@NotBlank String role) {
        this.role = role;
    }
}
