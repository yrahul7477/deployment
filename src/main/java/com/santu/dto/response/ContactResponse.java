package com.santu.dto.response;

public record ContactResponse(
        Long id,
        String subject,
        String message,
        Long userId
) {
}
