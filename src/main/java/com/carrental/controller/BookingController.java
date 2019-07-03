package com.carrental.controller;

import com.carrental.domain.model.Booking;
import com.carrental.service.BookingService;
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

    @GetMapping("/create")
    public String createBookingForm(Model model) {
        model.addAttribute("booking", new Booking());
        return "booking/form";
    }

    @PostMapping("/create")
    public String createBooking(@ModelAttribute("booking") Booking booking) {
        bookingService.createBooking(booking);
        log.info("Created new booking {}", booking);

        return "redirect:/booking/list";
    }

    @GetMapping("/list")
    public String bookingList(Model model) {
        List<Booking> bookings = bookingService.getAllBookings();

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
