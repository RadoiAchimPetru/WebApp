package com.rentcar.backend.controller;

import com.rentcar.backend.model.Car;
import com.rentcar.backend.service.CarService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    private final CarService service;

    public CarController(CarService service) {
        this.service = service;
    }

    // Top mașini pe brand
    @GetMapping("/top/{brand}")
    public List<Car> getTop(@PathVariable String brand) {
        return service.getTopByBrand(brand);
    }

    // Filtrare dinamică
    @GetMapping
    public List<Car> filter(
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Boolean available
    ) {
        return service.filter(year, available, brand);
    }
}
