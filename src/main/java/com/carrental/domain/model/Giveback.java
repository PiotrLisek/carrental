package com.carrental.domain.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Giveback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String givebackDate;
    private String givebackNotes;
    private Integer extraCharge;

    @OneToOne(cascade = CascadeType.ALL)
    private Booking booking;
}
