package com.rentcar.backend.service;

import com.rentcar.backend.model.Car;
import org.springframework.stereotype.Service;
import com.rentcar.backend.repository.CarRepository;
import java.util.List;

@Service
public class CarService {
    private final CarRepository repo;

    public CarService(CarRepository repo) {
        this.repo = repo;
    }

    public List<Car> getTopByBrand(String brand) {
        return repo.findByBrandAndAvailableTrueOrderByRentalCountDesc(brand);
    }

    public List<Car> filter(Integer year, Boolean available, String brand) {
        // combinează după nevoi: exemplu simplu
        if (brand != null) {
            return repo.findByBrandAndAvailableTrueOrderByRentalCountDesc(brand);
        } else if (year != null) {
            return repo.findByYearGreaterThanEqualAndAvailableTrue(year);
        } else {
            return repo.findAll().stream()
                    .filter(Car::isAvailable)
                    .toList();
        }
    }
}