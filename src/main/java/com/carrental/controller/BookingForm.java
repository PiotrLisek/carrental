package com.carrental.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class BookingForm {

    private String beginningOfRent;
    private String endOfRent;
    private Integer carId;
}
