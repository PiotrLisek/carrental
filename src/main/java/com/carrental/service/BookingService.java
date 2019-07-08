package com.carrental.service;

import com.carrental.domain.model.Booking;
import com.carrental.domain.model.Department;
import com.carrental.domain.model.car.Car;
import com.carrental.domain.repository.BookingRepository;
import com.carrental.domain.repository.CarRepository;
import com.carrental.domain.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final DepartmentRepository departmentRepository;
    private final CarRepository carRepository;

    public void createBooking (Booking booking) {
        bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() { return bookingRepository.findAll(); }

    public Optional<Booking> getBookingById(Integer id) { return bookingRepository.findById(id); }

    public void editBooking(Booking booking) { bookingRepository.save(booking); }

    public void deleteById(Integer id) { bookingRepository.deleteById(id); }

    public List<Car> getCarsByDepartmentId(Integer depId) {

        Department department = departmentRepository.findById(depId).get();

        return carRepository.findAllByDepartment(department);
    }
}
