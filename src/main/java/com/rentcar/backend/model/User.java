
package com.rentcar.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=100)
    private String fullName;

    @Column(nullable=false, length=255)
    private String address;

    @Column(nullable=false, unique=true, length=20)
    private String cnp;

    @Column(nullable = false)
    private String password;

    @Column(nullable=false, length=10)
    private String role;       // "CLIENT" sau "ADMIN"

    // date permis (opțional manual)
    private String licenseNumber;
    private LocalDate licenseExpiry;
    private String licenseCategories;

    // poze permis (upload BLOB)
    @Lob
    private byte[] licensePhotoFront;
    @Lob
    private byte[] licensePhotoBack;

    private boolean active = true;
}
