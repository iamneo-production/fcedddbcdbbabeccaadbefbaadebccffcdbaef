package com.examly.springapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/saveCar")
    public ResponseEntity<String> saveCar(@RequestBody Car car) {
        carService.saveCar(car);
        return ResponseEntity.ok("Car added successfully");
    }

    @PostMapping("/editCar")
    public ResponseEntity<String> editCar(@RequestParam String id, @RequestBody Car car) {
        Optional<Car> existingCar = carService.getCarById(id);
        if (existingCar.isPresent()) {
            Car editedCar = existingCar.get();
            editedCar.setCarModel(car.getCarModel());
            editedCar.setCarNo(car.getCarNo());
            editedCar.setStatus(car.getStatus());
            carService.saveCar(editedCar);
            return ResponseEntity.ok("Car details updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/deleteCar")
    public ResponseEntity<String> deleteCar(@RequestParam String id) {
        Optional<Car> existingCar = carService.getCarById(id);
        if (existingCar.isPresent()) {
            carService.deleteCar(id);
            return ResponseEntity.ok("Car deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getCars")
    public ResponseEntity<List<Car>> getCars() {
        List<Car> cars = carService.getAllCars();
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/getCar")
    public ResponseEntity<Car> getCarById(@RequestParam String id) {
        Optional<Car> car = carService.getCarById(id);
        if (car.isPresent()) {
            return ResponseEntity.ok(car.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
