package com.carrental.domain.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String dateOfBooking;
    private String beginningOfRent;
    private String endOfRent;
    private Integer price;
//    private Customer customer;

//    TODO: make relationships
//    private Car car;
//    private Department department;
}
