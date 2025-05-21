package com.rentcar.backend.dto;



import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class CreateCheckoutSessionResponse {
    private String sessionUrl;
}
