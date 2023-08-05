package com.examly.springapp;

import com.example.carrentalmanagement.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CarRepository {
    private final Map<String, Car> cars = new HashMap<>();

    public void saveCar(Car car) {
        cars.put(car.getCarId(), car);
    }

    public Car getCarById(String carId) {
        return cars.get(carId);
    }

    public List<Car> getAllCars() {
        return new ArrayList<>(cars.values());
    }

    public void deleteCar(String carId) {
        cars.remove(carId);
    }
}
