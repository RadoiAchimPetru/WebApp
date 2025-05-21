package com.rentcar.backend.controller;

import com.rentcar.backend.dto.*;
import com.rentcar.backend.service.StripeService;
import com.stripe.exception.StripeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    private final StripeService stripeService;

    public PaymentController(StripeService stripeService) {
        this.stripeService = stripeService;
    }

    @PostMapping("/create-session")
    public ResponseEntity<CreateCheckoutSessionResponse> createSession(
            @Valid @RequestBody PaymentRequest req
    ) throws StripeException {
        String url = stripeService.createCheckoutSession(req);
        return ResponseEntity.ok(new CreateCheckoutSessionResponse(url));
    }
}
