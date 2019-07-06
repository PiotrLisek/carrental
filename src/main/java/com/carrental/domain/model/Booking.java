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

    @OneToOne(mappedBy = "booking")
    private Rent rent;

    @OneToOne(mappedBy = "booking")
    private Giveback giveback;


//    TODO: make relationships
//    private Car car;
//    private Department department;
}