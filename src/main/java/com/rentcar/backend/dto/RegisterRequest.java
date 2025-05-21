package com.rentcar.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.*;
import org.springframework.web.multipart.MultipartFile;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    @NotBlank @Size(max=100)
    private String fullName;

    @NotBlank @Size(max=255)
    private String address;

    @NotBlank @Pattern(regexp="\\d{13}", message="CNP trebuie să aibă exact 13 cifre")
    private String cnp;

    @NotBlank @Size(min=6, message="Parola trebuie să aibă minim 6 caractere")
    private String password;

    @NotBlank @Pattern(regexp="CLIENT|ADMIN", message="Rol invalid, trebuie CLIENT sau ADMIN")
    private String role;

    // Date permis manual (opțional)
    @Size(max=50)
    private String licenseNumber;
    private LocalDate licenseExpiry;
    @Size(max=20)
    private String licenseCategories;

    // Upload imagine permis
    private MultipartFile licensePhotoFront;
    private MultipartFile licensePhotoBack;
}