package com.examly.springapp;

import org.springframework.data.repository.CrudRepository;
import com.example.carrentalmanagement.model.Car;

public interface CarRepository extends CrudRepository<Car, String> {
    // Add any custom queries if needed
}
