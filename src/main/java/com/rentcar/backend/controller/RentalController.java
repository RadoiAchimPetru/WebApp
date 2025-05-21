package com.rentcar.backend.controller;

import com.rentcar.backend.model.Rental;
import com.rentcar.backend.service.RentalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {
    private final RentalService service;

    public RentalController(RentalService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Rental> rent(
            @RequestParam Long userId,
            @RequestParam Long carId,
            @RequestBody Rental rentalData
    ) {
        Rental r = service.createRental(userId, carId, rentalData);
        return ResponseEntity.ok(r);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rental>> getForUser(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getRentalsForUser(userId));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Rental> updateStatus(
            @PathVariable Long id,
            @RequestParam String status
    ) {
        return service.updateStatus(id, status)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}