package com.examly.springapp;

import com.example.carrentalmanagement.model.Car;
import com.example.carrentalmanagement.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarRepository carRepository;

    // Add a new Car
    @PostMapping("/saveCar")
    public ResponseEntity<String> saveCar(@RequestBody Car car) {
        carRepository.saveCar(car);
        return ResponseEntity.ok("Car added successfully");
    }

    // Edit a Car Details
    @PostMapping("/editCar")
    public ResponseEntity<String> editCar(@RequestParam String id, @RequestBody Car car) {
        Car existingCar = carRepository.getCarById(id);
        if (existingCar != null) {
            existingCar.setCarModel(car.getCarModel());
            existingCar.setCarNo(car.getCarNo());
            existingCar.setStatus(car.getStatus());
            return ResponseEntity.ok("Car details updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a Car
    @GetMapping("/deleteCar")
    public ResponseEntity<String> deleteCar(@RequestParam String id) {
        Car existingCar = carRepository.getCarById(id);
        if (existingCar != null) {
            carRepository.deleteCar(id);
            return ResponseEntity.ok("Car deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Get All Cars
    @GetMapping("/getCars")
    public ResponseEntity<List<Car>> getCars() {
        List<Car> cars = carRepository.getAllCars();
        return ResponseEntity.ok(cars);
    }

    // Get Car By ID
    @GetMapping("/getCar")
    public ResponseEntity<Car> getCarById(@RequestParam String id) {
        Car car = carRepository.getCarById(id);
        if (car != null) {
            return ResponseEntity.ok(car);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
