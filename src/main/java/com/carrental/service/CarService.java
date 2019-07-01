package com.carrental.service;

import com.carrental.domain.model.car.Car;
import com.carrental.domain.model.rentDepartment.Department;
import com.carrental.domain.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    public void createCar(Car car){
        carRepository.save(car);
    }

    public Optional<Car> getCarById(Integer id){
        return carRepository.findById(id);
    }

    public void editCar (Car car){
        carRepository.save(car);
    }

    public void deleteCar (Integer id){
        carRepository.deleteById(id);
    }
}
