package com.rentcar.backend.repository;



import com.rentcar.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByCnp(String cnp);
    Optional<User> findByIdAndActiveTrue(Long id);
}
