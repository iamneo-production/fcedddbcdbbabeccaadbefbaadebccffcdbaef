package com.examly.springapp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final List<Car> cars = new ArrayList<>();

    public void saveCar(Car car) {
        cars.add(car);
    }

    public List<Car> getAllCars() {
        return cars;
    }

    public Optional<Car> getCarById(String carId) {
        return cars.stream().filter(car -> car.getCarId().equals(carId)).findFirst();
    }

    public void deleteCar(String carId) {
        cars.removeIf(car -> car.getCarId().equals(carId));
    }
}
