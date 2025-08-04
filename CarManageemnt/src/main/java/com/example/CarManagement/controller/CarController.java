package com.example.CarManagement.controller;

import com.example.CarManagement.entity.Car;
import com.example.CarManagement.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/cars")
@CrossOrigin("*")
public class CarController {

    @Autowired
    private CarService carService;
    @PostMapping("/book")
    public Car bookCar(@RequestBody Car car)
    {
        return carService.bookCar(car);
    }
    @GetMapping("{carNumber}")
    public Car showBookingDetails(@PathVariable String carNumber)
    {
        return carService.showBookingDetails(carNumber);
    }


}
