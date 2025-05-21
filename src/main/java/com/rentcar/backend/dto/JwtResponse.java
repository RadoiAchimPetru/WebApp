package com.rentcar.backend.dto;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long userId;
    private String role;

    public JwtResponse(String token, Long userId, String role) {
        this.token = token;
        this.userId = userId;
        this.role = role;
        this.type = "Bearer";
    }
}
