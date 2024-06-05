package com.example.aasha.service;

import com.example.aasha.entity.Booking;
import com.example.aasha.entity.ProjectBooking;
import com.example.aasha.entity.Volunteer;
import com.example.aasha.repo.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private BookingRepo bookingRepo;

    @Autowired
    public BookingServiceImpl(BookingRepo bookingRepo) {
        this.bookingRepo = bookingRepo;
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepo.findAll();
    }

    @Override
    public Booking getBookingById(Long id) {
        return bookingRepo.findById(id).orElseThrow(() -> new RuntimeException("Booking not found with id " + id));
    }

    @Override
    public Booking saveBooking(Booking booking) {
        return bookingRepo.save(booking);
    }

    @Override
    public Booking updateBooking(Long id, Booking updatedBooking) {
        Booking existingBooking = bookingRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with id " + id));

        existingBooking.setBookingDate(updatedBooking.getBookingDate());
        existingBooking.setStartDate(updatedBooking.getStartDate());
        existingBooking.setBookingStatus(updatedBooking.getBookingStatus());
        existingBooking.setEndDate(updatedBooking.getEndDate());

        if (updatedBooking.getVolunteer() != null) {
            Volunteer existingVolunteer = existingBooking.getVolunteer();
            Volunteer updatedVolunteer = updatedBooking.getVolunteer();

            if (existingVolunteer == null) {
                existingBooking.setVolunteer(updatedVolunteer);
                updatedVolunteer.setBooking(existingBooking);
            } else {
                existingVolunteer.setFirstName(updatedVolunteer.getFirstName());
                existingVolunteer.setLastName(updatedVolunteer.getLastName());
                existingVolunteer.setEmail(updatedVolunteer.getEmail());
                existingVolunteer.setDob(updatedVolunteer.getDob());
                existingVolunteer.setIsMale(updatedVolunteer.getIsMale());
                existingVolunteer.setMobileNo(updatedVolunteer.getMobileNo());
                existingVolunteer.setNationality(updatedVolunteer.getNationality());
            }
        }

//        if (updatedBooking.getProjectBookings() != null) {
//            ProjectBooking existingProjectBooking = (ProjectBooking) existingBooking.getProjectBookings();
//            ProjectBooking updatedProjectBooking = updatedBooking.getProjectBookings();
//
//            if (existingProjectBooking == null) {
//                existingBooking.setProjectBookings((List<ProjectBooking>));
//                updatedProjectBooking.setBooking(existingBooking);
//            } else {
//                existingProjectBooking.setProject(updatedProjectBooking.getProject());
//                existingProjectBooking.setStartDate(updatedProjectBooking.getStartDate());
//                existingProjectBooking.setEndDate(updatedProjectBooking.getEndDate());
//            }
//        }

        return bookingRepo.save(existingBooking);
    }



}
