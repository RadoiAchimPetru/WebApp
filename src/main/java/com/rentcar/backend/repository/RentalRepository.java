package com.rentcar.backend.repository;

import com.rentcar.backend.model.Rental;
import com.rentcar.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Long> {
    List<Rental> findByUser(User user);
}
