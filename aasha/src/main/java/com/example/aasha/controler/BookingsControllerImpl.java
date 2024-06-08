package com.example.aasha.controler;

import com.example.aasha.dto.BookingDTO;
import com.example.aasha.entity.Booking;
import com.example.aasha.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookingsControllerImpl implements BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingsControllerImpl(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Override
    public ResponseEntity<List<BookingDTO>> getAllBookings() {
        List<BookingDTO> bookingDTOs = bookingService.getAllBookings()
                .stream()
                .map(bookingService::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(bookingDTOs);
    }

    @Override
    public ResponseEntity<BookingDTO> getBookingById(@PathVariable Long id) {
        BookingDTO bookingDTO = bookingService.convertToDTO(bookingService.getBookingById(id));
        return ResponseEntity.status(HttpStatus.OK).body(bookingDTO);
    }

    @Override
    public ResponseEntity<BookingDTO> saveBooking(@RequestBody Booking booking) {
        Booking newBooking = bookingService.saveBooking(booking);
        BookingDTO newBookingDTO = bookingService.convertToDTO(newBooking);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBookingDTO);
    }

    @Override
    public ResponseEntity<BookingDTO> updateBooking(@PathVariable Long id, @RequestBody Booking booking) {
        Booking updatedBooking = bookingService.updateBooking(id, booking);
        BookingDTO updatedBookingDTO = bookingService.convertToDTO(updatedBooking);
        return ResponseEntity.status(HttpStatus.OK).body(updatedBookingDTO);
    }

    @Override
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
