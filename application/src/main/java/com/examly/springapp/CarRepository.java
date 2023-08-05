package com.examly.springapp;

import org.springframework.data.repository.CrudRepository;
import com.examly.springapp.Car;

public interface CarRepository extends CrudRepository<Car, String> {
    
}
