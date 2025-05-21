package com.rentcar.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.rentcar.backend.model.User;
import com.rentcar.backend.repository.UserRepository;
@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	CommandLineRunner initUsers(UserRepository userRepo, PasswordEncoder encoder) {
		return args -> {
			// ADMIN
			if (userRepo.findByCnp("1111111111111").isEmpty()) {
				User admin = new User();
				admin.setFullName("Admin Root");
				admin.setAddress("Str. Principala 1");
				admin.setCnp("1111111111111");
				admin.setPassword(encoder.encode("admin123"));
				admin.setRole("ADMIN");
				admin.setActive(true);
				userRepo.save(admin);
			}
		};
	}
}

