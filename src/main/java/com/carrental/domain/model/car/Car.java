package com.carrental.domain.model.car;

import com.carrental.domain.model.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String company;
    private String model;
    private String category;
    private Integer year;
    private String color;
    private Integer mileage;
    private String status;
    private Double pricePerDay;

    @ManyToOne
    private Department department;
}
