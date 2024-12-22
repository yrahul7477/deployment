package com.santu.dto.response;

public record EducationResponse(
        String institute,
        String degree,
        String fieldOfStudy,
        String registrationNo,
        String rollNo,
        int startingYear,
        int endingYear,
        double result,
        double resultOutOf
) {
}
