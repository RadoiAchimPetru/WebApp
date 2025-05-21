package com.rentcar.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="rentals")
public class Rental {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne @JoinColumn(name="user_id", nullable=false)
    private User user;

    @ManyToOne @JoinColumn(name="car_id", nullable=false)
    private Car car;

    private String pickupLocation;
    private String dropoffLocation;
    private Double dropoffLat;
    private Double dropoffLng;

    private LocalDateTime rentalDate = LocalDateTime.now();

    @Column(nullable=false, length=10)
    private String status = "PENDING"; // PENDING, CONFIRMED, CANCELLED, COMPLETED

    private String stripePaymentId;
}