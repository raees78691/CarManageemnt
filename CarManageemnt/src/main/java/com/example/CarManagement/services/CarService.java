package com.example.CarManagement.services;

import com.example.CarManagement.entity.Car;
import com.example.CarManagement.repository.CarDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    @Autowired
    private CarDAO carDAO;

    public Car bookCar(Car car)
    {
        return carDAO.save(car);
    }
    public Car showBookingDetails(String carNumber)
    {
        return carDAO.findCarByCarNumber(carNumber);

    }




}
