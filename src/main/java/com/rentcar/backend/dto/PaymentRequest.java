package com.rentcar.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {
    @NotNull(message="ID-ul de închiriere e obligatoriu")
    private Long rentalId;

    @NotNull @Min(value=100, message="Suma minimă este 100 cenți (1.00 EUR)")
    private Long amount;  // în cenți
}
