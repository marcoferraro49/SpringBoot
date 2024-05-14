package com.example.eser8Crud.controllers;

import com.example.eser8Crud.entities.Car;
import com.example.eser8Crud.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @PostMapping
    public Car create(@RequestBody Car car) {
        return carRepository.saveAndFlush(car);
    }

    @GetMapping
    public List<Car> getCars() {
        return carRepository.findAll();
    }

    @GetMapping("/{id}")
    public Car getCarById (@PathVariable long id) {
        if(carRepository.existsById(id)){
            return carRepository.getById(id);
        } else {
            return new Car();
        }
    }

    @PutMapping("/{id}")
    public Car updateType(@PathVariable long id, @RequestParam String type){
        Car carTemp = carRepository.getById(id);
        if(carRepository.existsById(id)){
            carTemp.setType(type);
            return carTemp;
        } else {
            return new Car();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteOne (@PathVariable long id) {
        if(carRepository.existsById(id)){
            carRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping
    public void deleteAll(){
        carRepository.deleteAll();
    }
}
