package com.rentcar.backend.service;

import com.rentcar.backend.model.Car;
import com.rentcar.backend.model.Rental;
import com.rentcar.backend.model.User;
import com.rentcar.backend.repository.CarRepository;
import com.rentcar.backend.repository.RentalRepository;
import com.rentcar.backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RentalService {
    private final RentalRepository rentalRepo;
    private final UserRepository userRepo;
    private final CarRepository carRepo;

    public RentalService(RentalRepository rentalRepo,
                         UserRepository userRepo,
                         CarRepository carRepo) {
        this.rentalRepo = rentalRepo;
        this.userRepo   = userRepo;
        this.carRepo    = carRepo;
    }

    public Rental createRental(Long userId, Long carId, Rental rentalData) {
        User user = userRepo.findByIdAndActiveTrue(userId)
                .orElseThrow(() -> new RuntimeException("User invalid"));
        Car car   = carRepo.findById(carId)
                .orElseThrow(() -> new RuntimeException("Car invalid"));

        // marchează ca indisponibil și incrementează contor
        car.setAvailable(false);
        car.setRentalCount(car.getRentalCount() + 1);
        carRepo.save(car);

        rentalData.setUser(user);
        rentalData.setCar(car);
        return rentalRepo.save(rentalData);
    }

    public List<Rental> getRentalsForUser(Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return rentalRepo.findByUser(user);
    }

    public Optional<Rental> updateStatus(Long rentalId, String status) {
        return rentalRepo.findById(rentalId).map(r -> {
            r.setStatus(status);
            return rentalRepo.save(r);
        });
    }
}
