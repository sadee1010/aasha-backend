package com.example.aasha.service;

import com.example.aasha.entity.Booking;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BookingService {

    List<Booking> getAllBookings();

    Booking getBookingById(Long id);

    Booking saveBooking(Booking booking);

    Booking updateBooking(Long id, Booking booking);


}
