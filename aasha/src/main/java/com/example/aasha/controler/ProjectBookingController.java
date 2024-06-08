package com.example.aasha.controler;

import com.example.aasha.dto.ProjectBookingDTO;
import com.example.aasha.entity.ProjectBooking;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;



public interface ProjectBookingController {

    @GetMapping("/projectbookings")
    ResponseEntity<List<ProjectBookingDTO>> getAllProjectBookings();

    @GetMapping("/projectbookings/{id}")
    ResponseEntity<ProjectBookingDTO> getProjectBookingById(@PathVariable Long id);

    @PostMapping("/projectbookings")
    ResponseEntity<ProjectBookingDTO> saveProjectBooking(@RequestBody ProjectBooking projectBooking);

    @PutMapping("projectbookings/{id}")
    ResponseEntity<ProjectBookingDTO> updateProjectBooking(@PathVariable Long id, @RequestBody ProjectBooking projectBooking);

    @DeleteMapping("projectbookings/{id}")
    ResponseEntity<Void> deleteProjectBooking(@PathVariable Long id);

}