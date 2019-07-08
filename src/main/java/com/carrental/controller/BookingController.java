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

    @PostMapping("/create/{depId}")
    public String createBooking(Model model, @PathVariable("depId") Integer depId) {


        //log.info("Created new booking {}", booking);
        model.addAttribute("cars", bookingService.getCarsByDepartmentId(depId));
        model.addAttribute("bookingForm", new Booking());
        return "create/{depId}/finish";
    }

    @PostMapping("/create/{depId}/finish")
    public String createBookingById(Model model, @PathVariable Integer depId) {
        bookingService.getCarsByDepartmentId(depId);
        //log.info("Created new booking {}", booking);

        return "redirect:/booking/list";
    }

    @GetMapping("/create/{depId}/finish")
    public String bookingListById(Model model) {
        List<Booking> bookings = bookingService.getAllBookings();
        List<Department> departments = departmentService.getAllDepartments();

        model.addAttribute("departments", departments);
        model.addAttribute("bookings", bookings);
        return "booking/list";
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
