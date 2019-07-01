package com.carrental.domain.model;

import lombok.Data;

import javax.persistence.*;

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

    @ManyToOne
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    private Rent rent;

//    TODO: make relationships
//    private Car car;
//    private Department department;
}
