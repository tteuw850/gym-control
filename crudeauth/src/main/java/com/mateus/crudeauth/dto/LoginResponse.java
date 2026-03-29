package com.mateus.crudeauth.dto;

public record LoginResponse(String accessToken, Long expiresIn) {
}
