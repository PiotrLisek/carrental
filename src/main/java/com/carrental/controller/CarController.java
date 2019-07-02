package com.carrental.controller;

import com.carrental.domain.model.car.Car;
import com.carrental.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/car")
@Slf4j
public class CarController {

    private final CarService carService;

    @GetMapping("/create")
    public String createCarForm(Model model) {
        model.addAttribute("car", new Car());
        return "car/form";
    }

    @PostMapping("/create")
    public String createRent(@ModelAttribute("rent") Car car) {
        carService.createCar(car);
        log.info("Created new car {}", car);

        return "redirect:/car/list";
    }

    @GetMapping("/list")
    public String carList(Model model) {
        List<Car> cars = carService.getAllCars();

        model.addAttribute("cars", cars);
        return "car/list";
    }

    @GetMapping("/edit/{id}")
    public String editRentForm(@PathVariable("id") Integer id, Model model) {
        Optional<Car> maybeCar = carService.getCarById(id);

        if (maybeCar.isPresent()) {
            model.addAttribute("car", maybeCar.get());
            return "car/edit-form";
        } else {
            return "redirect:/car/create";
        }
    }

    @PostMapping("/edit/{id}")
    public String editCar(@ModelAttribute("car") Car car) {
        carService.editCar(car);

        return "redirect:/car/list";
    }

    @GetMapping("/delete")
    public String deleteCar(@RequestParam("id") Integer id) {
        carService.deleteById(id);
        return "redirect:/car/list";
    }
}
