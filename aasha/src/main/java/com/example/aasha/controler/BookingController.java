package com.example.aasha.controler;

import com.example.aasha.dto.BookingDTO;
import com.example.aasha.entity.Booking;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@CrossOrigin(origins = "*")
public interface BookingController {

    @GetMapping("/bookings")
    ResponseEntity<List<BookingDTO>> getAllBookings();

    @GetMapping("/bookings/{id}")
    ResponseEntity<BookingDTO> getBookingById(@PathVariable Long id);

    @PostMapping("/bookings")
    ResponseEntity<BookingDTO> saveBooking(@RequestBody Booking bookings);

    @PutMapping("bookings/{id}")
    ResponseEntity<BookingDTO> updateBooking(@PathVariable Long id, @RequestBody Booking bookings);

    @DeleteMapping("bookings/{id}")
    ResponseEntity<Void> deleteBooking(@PathVariable Long id);

}
