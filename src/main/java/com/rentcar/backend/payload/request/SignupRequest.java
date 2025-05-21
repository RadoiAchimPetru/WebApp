package com.rentcar.backend.payload.request;


import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;


public class SignupRequest {
    @NotBlank private String fullName;
    @NotBlank private String address;
    @NotBlank private String cnp;
    @NotBlank private String licenseNumber;
    @NotBlank private String licenseCategories;
    private LocalDate licenseExpiry;
    private String licensePhotoFront;
    private String licensePhotoBack;
    @NotBlank private String password;
    // …generate getters & setters for all…

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getLicenseCategories() {
        return licenseCategories;
    }

    public void setLicenseCategories(String licenseCategories) {
        this.licenseCategories = licenseCategories;
    }

    public LocalDate getLicenseExpiry() {
        return licenseExpiry;
    }

    public void setLicenseExpiry(LocalDate licenseExpiry) {
        this.licenseExpiry = licenseExpiry;
    }

    public String getLicensePhotoFront() {
        return licensePhotoFront;
    }

    public void setLicensePhotoFront(String licensePhotoFront) {
        this.licensePhotoFront = licensePhotoFront;
    }

    public String getLicensePhotoBack() {
        return licensePhotoBack;
    }

    public void setLicensePhotoBack(String licensePhotoBack) {
        this.licensePhotoBack = licensePhotoBack;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
