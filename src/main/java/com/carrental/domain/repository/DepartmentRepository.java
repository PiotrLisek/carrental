package com.carrental.domain.repository;

import com.carrental.domain.model.car.Car;
import com.carrental.domain.model.rentDepartment.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
