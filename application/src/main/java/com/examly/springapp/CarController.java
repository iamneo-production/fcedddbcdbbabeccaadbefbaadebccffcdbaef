package com.examly.springapp;

import com.example.model.Car;
import com.example.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/saveCar")
    public ResponseEntity<Car> addNewCar(@RequestBody Car car) {
        Car savedCar = carService.saveCar(car);
        return new ResponseEntity<>(savedCar, HttpStatus.OK);
    }

    @GetMapping("/getCars")
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> cars = carService.getAllCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("/getCar")
    public ResponseEntity<Car> getCarById(@RequestParam("carId") String carId) {
        Optional<Car> car = carService.getCarById(carId);
        return car.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/editCar")
    public ResponseEntity<Car> editCarDetails(@RequestParam("id") String carId, @RequestBody Car updatedCar) {
        Optional<Car> existingCar = carService.getCarById(carId);
        if (existingCar.isPresent()) {
            Car carToUpdate = existingCar.get();
            carToUpdate.setCarModel(updatedCar.getCarModel());
            carToUpdate.setCarNo(updatedCar.getCarNo());
            carToUpdate.setStatus(updatedCar.getStatus());

            Car savedCar = carService.saveCar(carToUpdate);
            return new ResponseEntity<>(savedCar, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/deleteCar")
    public ResponseEntity<String> deleteCar(@RequestParam("id") String carId) {
        Optional<Car> car = carService.getCarById(carId);
        if (car.isPresent()) {
            carService.deleteCar(carId);
            return new ResponseEntity<>("Car deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Car not found", HttpStatus.NOT_FOUND);
        }
    }
}
