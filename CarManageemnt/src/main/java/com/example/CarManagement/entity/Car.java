package com.example.CarManagement.entity;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigInteger;

@Entity
public class Car {
    @Id
    @NotNull
    private String carNumber;
    private String carCategory;
    private BigInteger rateHour;
    @OneToOne(cascade = CascadeType.ALL)
    private BookingDetail bookingDetail;
    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }
    public String getCarNumber() {
        return carNumber;
    }
    public void setCarCategory(String carCategory) {
        this.carCategory = carCategory;
    }
    public String getCarCategory() {
        return carCategory;
    }
    public void setRateHour(BigInteger rateHour) {
        this.rateHour = rateHour;
    }
    public BigInteger getRateHour() {
        return rateHour;
    }


    public void setBookingDetail(BookingDetail bookingDetail) {
        this.bookingDetail = bookingDetail;
    }
    public BookingDetail getBookingDetail() {
        return bookingDetail;
    }



}
