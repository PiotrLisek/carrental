package com.carrental.controller;

import com.carrental.domain.model.car.Car;
import com.carrental.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    @GetMapping("/list")
    public String carList(Model model){
        List<Car> carList = carService.getAllCars();
        model.addAttribute("carLst", carList);
        return ("car/list");
    }

    @GetMapping("/add-car")
    public String addCarForm( Model model){
        model.addAttribute("car", new Car());
        return ("car/form");
    }

    @PostMapping ("/add-car")
    public String addCar(@ModelAttribute("car") Car car){
        carService.createCar(car);
        return ("car/list");
    }



}
