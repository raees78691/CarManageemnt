package com.example.CarManagement.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class BookingDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pickupPoint;
    private String dropPoint;
    private String pickupTime;
    private String dropTime;
    private Date pickupDate;
    private Date dropDate;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Driver> driver;
    public void setPickupPoint(String pickupPoint) {
        this.pickupPoint = pickupPoint;
    }
    public String getPickupPoint() {
        return pickupPoint;
    }
    public void setDropPoint(String dropPoint) {
        this.dropPoint = dropPoint;
    }
    public String getDropPoint() {
        return dropPoint;
    }
    public void setPickupTime(String pickupTime) {
        this.pickupTime = pickupTime;
    }
    public String getPickupTime() {
        return pickupTime;
    }
    public void setDropTime(String dropTime) {
        this.dropTime = dropTime;
    }
    public String getDropTime() {
        return dropTime;
    }
    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }
    public Date getPickupDate() {
        return pickupDate;
    }
    public void setDropDate(Date dropDate) {
        this.dropDate = dropDate;
    }
    public Date getDropDate() {
        return dropDate;
    }

    public void setDriver(List<Driver> driver) {
        this.driver = driver;
    }
    public List<Driver> getDriver() {
        return driver;
    }






}
