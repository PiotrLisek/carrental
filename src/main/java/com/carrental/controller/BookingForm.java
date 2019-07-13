package com.carrental.controller;

import lombok.Data;

@Data
public class BookingForm {

    private String beginningOfRent;
    private String endOfRent;
    private Integer carId;
}
