package com.rentcar.backend.service;

import com.rentcar.backend.dto.PaymentRequest;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;

@Service
public class StripeService {
    @Value("${stripe.secretKey}") private String secretKey;

    @PostConstruct
    public void init() {
        com.stripe.Stripe.apiKey = secretKey;
    }

    public String createCheckoutSession(PaymentRequest req) throws StripeException {
        SessionCreateParams params = SessionCreateParams.builder()
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setSuccessUrl("https://frontend/checkout/success")
                .setCancelUrl("https://frontend/checkout/cancel")
                .addLineItem(SessionCreateParams.LineItem.builder()
                        .setQuantity(1L)
                        .setPriceData(SessionCreateParams.LineItem.PriceData.builder()
                                .setCurrency("eur")
                                .setUnitAmount(req.getAmount())
                                .setProductData(SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                        .setName("Rental #" + req.getRentalId())
                                        .build())
                                .build())
                        .build())
                .build();

        Session session = Session.create(params);
        return session.getUrl();
    }
}
