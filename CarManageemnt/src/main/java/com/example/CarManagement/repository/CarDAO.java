package com.example.CarManagement.repository;

import com.example.CarManagement.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarDAO extends JpaRepository<Car, String> {
    Car findCarByCarNumber(String carNumber);


}
