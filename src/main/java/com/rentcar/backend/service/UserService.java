package com.rentcar.backend.service;

import com.rentcar.backend.dto.RegisterRequest;
import com.rentcar.backend.model.User;
import com.rentcar.backend.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Service
public class UserService {
    private final UserRepository userRepo;
    private final PasswordEncoder encoder;

    public UserService(UserRepository userRepo,
                       PasswordEncoder encoder) {
        this.userRepo = userRepo;
        this.encoder  = encoder;
    }

    public User register(RegisterRequest req) throws IOException {
        if (userRepo.findByCnp(req.getCnp()).isPresent()) {
            throw new RuntimeException("CNP deja folosit");
        }
        User u = new User();
        u.setFullName(req.getFullName());
        u.setAddress(req.getAddress());
        u.setCnp(req.getCnp());
        u.setPassword(encoder.encode(req.getPassword()));
        u.setRole(req.getRole());
        u.setLicenseNumber(req.getLicenseNumber());
        u.setLicenseExpiry(req.getLicenseExpiry());
        u.setLicenseCategories(req.getLicenseCategories());
        MultipartFile front = req.getLicensePhotoFront();
        if (front != null && !front.isEmpty()) {
            u.setLicensePhotoFront(front.getBytes());
        }
        MultipartFile back = req.getLicensePhotoBack();
        if (back != null && !back.isEmpty()) {
            u.setLicensePhotoBack(back.getBytes());
        }
        return userRepo.save(u);
    }

    public void deactivateUser(Long userId) {
        userRepo.findById(userId).ifPresent(u -> {
            u.setActive(false);
            userRepo.save(u);
        });
    }
}
