package com.carrental.domain.repository;

import com.carrental.domain.model.car.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository <Car, Integer> {
}
