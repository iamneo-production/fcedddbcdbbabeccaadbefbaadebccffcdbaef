package com.examly.springapp;

import com.example.model.Car;
import com.example.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Optional<Car> getCarById(String carId) {
        return carRepository.findById(carId);
    }

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public void deleteCar(String carId) {
        carRepository.deleteById(carId);
    }
}

