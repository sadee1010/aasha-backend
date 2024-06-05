package com.example.aasha.controler;

import com.example.aasha.entity.Booking;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@CrossOrigin(origins = "*")
public interface BookingController {

    @GetMapping("/bookings")
    ResponseEntity<List<Booking>> getAllBookings();

    @GetMapping("/bookings/{id}")
    ResponseEntity<Booking> getBookingById(@PathVariable Long id);

    @PostMapping("/bookings")
    ResponseEntity<Booking> saveBooking(@RequestBody Booking bookings);

    @PutMapping("bookings/{id}")
    ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking bookings);

}
