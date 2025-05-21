package com.rentcar.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cars")
public class Car {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=50)
    private String brand;

    @Column(name="model", nullable=false, length=50)
    private String modelName;

    private int year;
    private boolean available = true;
    private int rentalCount = 0;
}
