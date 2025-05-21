package com.rentcar.backend.repository;

import com.rentcar.backend.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    // Listează cele disponibile, ordonate după număr de închirieri
    List<Car> findByBrandAndAvailableTrueOrderByRentalCountDesc(String brand);

    // Filtrare după an și disponibilitate, exemplu:
    List<Car> findByYearGreaterThanEqualAndAvailableTrue(int year);
}
