package com.rentcar.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    @NotBlank @Pattern(regexp="\\d{13}", message="CNP invalid, trebuie 13 cifre")
    private String cnp;

    @NotBlank(message="Parola nu poate fi goală")
    private String password;
}
