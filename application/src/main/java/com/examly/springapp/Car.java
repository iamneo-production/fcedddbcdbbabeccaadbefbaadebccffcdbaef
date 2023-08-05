package com.examly.springapp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car {

    @Id
    private String carId;
    private String carModel;
    private String carNo;
    private String status;

    // Default constructor (required by JPA)
    public Car() {
    }

    // Parameterized constructor
    public Car(String carId, String carModel, String carNo, String status) {
        this.carId = carId;
        this.carModel = carModel;
        this.carNo = carNo;
        this.status = status;
    }

    // Getters and Setters
    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

