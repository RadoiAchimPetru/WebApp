package com.rentcar.backend.controller;

import com.rentcar.backend.dto.RegisterRequest;
import com.rentcar.backend.model.User;
import com.rentcar.backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(
            @Valid @RequestBody RegisterRequest req,
            BindingResult br
    ) throws IOException {
        if (br.hasErrors()) {
            var errs = br.getFieldErrors().stream()
                    .map(e -> e.getField()+": "+e.getDefaultMessage())
                    .toList();
            return ResponseEntity.badRequest().build();
        }
        User created = service.register(req);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivate(@PathVariable Long id) {
        service.deactivateUser(id);
        return ResponseEntity.noContent().build();

    }


}