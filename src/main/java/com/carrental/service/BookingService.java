package com.carrental.service;

import com.carrental.domain.model.Booking;
import com.carrental.domain.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;

    public void createBooking (Booking booking) {
        bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() { return bookingRepository.findAll(); }

    public Optional<Booking> getBookingById(Integer id) { return bookingRepository.findById(id); }

    public void editBooking(Booking booking) { bookingRepository.save(booking); }

    public void deleteById(Integer id) { bookingRepository.deleteById(id); }
}
