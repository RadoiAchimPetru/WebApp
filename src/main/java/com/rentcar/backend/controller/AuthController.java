package com.rentcar.backend.controller;

import com.rentcar.backend.dto.LoginRequest;
import com.rentcar.backend.dto.RegisterRequest;
import com.rentcar.backend.dto.JwtResponse;
import com.rentcar.backend.service.UserService;
import com.rentcar.backend.security.JwtUtils;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authManager;
    private final JwtUtils jwtUtils;

    public AuthController(UserService userService,
                          AuthenticationManager authManager,
                          JwtUtils jwtUtils) {
        this.userService = userService;
        this.authManager = authManager;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> authenticateUser(
            @Valid @RequestBody LoginRequest loginRequest
    ) {
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getCnp(),           // ← use cnp, not getUsername()
                        loginRequest.getPassword()
                )
        );
        String jwt = jwtUtils.generateJwtToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(
            @Valid @RequestBody RegisterRequest registerRequest
    ) {
        var user = userService.registerNewUser(registerRequest);
        return ResponseEntity.ok(user);
    }
}
