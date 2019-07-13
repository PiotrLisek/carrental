package com.carrental.controller;

import com.carrental.domain.model.Booking;
import com.carrental.domain.model.Department;
import com.carrental.domain.model.car.Car;
import com.carrental.service.BookingService;
import com.carrental.service.CarService;
import com.carrental.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/booking")
@Slf4j
public class BookingController {

    private final BookingService bookingService;
    private final CarService carService;
    private final DepartmentService departmentService;

    @GetMapping("/create")
    public String createBookingForm(Model model) {
        List<Department> departments = departmentService.getAllDepartments();

        model.addAttribute("departments", departments);
        return "booking/form";
    }

    @GetMapping("/create-car")
    public String createBooking(@RequestParam("department") Integer depId, Model model) {


        //log.info("Created new booking {}", booking);
        model.addAttribute("cars", bookingService.getCarsByDepartmentId(depId));
        model.addAttribute("bookingForm", new BookingForm());
        return "booking/form-with-id";
    }

    @PostMapping("/create/finish")
    public String bookingListById(@ModelAttribute("bookingForm") BookingForm bookingForm, Model model) {
//        bookingService.createBooking(booking);
        System.out.println(bookingForm);
        List<Booking> bookings = bookingService.getAllBookings();
        List<Department> departments = departmentService.getAllDepartments();
        List<Car> cars = carService.getAllCars();

        model.addAttribute("cars", cars);
        model.addAttribute("departments", departments);
        model.addAttribute("bookings", bookings);
        return "booking/form-with-id";
    }

    @GetMapping("/list")
    public String bookingList(Model model) {
        List<Booking> bookings = bookingService.getAllBookings();
        List<Department> departments = departmentService.getAllDepartments();

        model.addAttribute("departments", departments);
        model.addAttribute("bookings", bookings);
        return "booking/list";
    }

    @GetMapping("/edit/{id}")
    public String editBookingForm(@PathVariable("id") Integer id, Model model) {
        Optional<Booking> maybeBooking = bookingService.getBookingById(id);

        if (maybeBooking.isPresent()) {
            model.addAttribute("booking", maybeBooking.get());
            return "booking/edit-form";
        } else {
            return "redirect:/booking/create";
        }
    }

    @PostMapping("/edit/{id}")
    public String editBooking(@ModelAttribute("booking") Booking booking) {
        bookingService.editBooking(booking);

        return "redirect:/booking/list";
    }

    @GetMapping("/delete")
    public String deleteBooking(@RequestParam("id") Integer id) {
        bookingService.deleteById(id);
        return "redirect:/booking/list";
    }
}
