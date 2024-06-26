package com.example.aasha.service;

import com.example.aasha.dto.*;
import com.example.aasha.entity.Booking;
import com.example.aasha.entity.Partner;
import com.example.aasha.entity.ProjectBooking;
import com.example.aasha.entity.Volunteer;
import com.example.aasha.repo.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

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
        return bookingRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Booking not found with id " + id));
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

        if (updatedBooking.getPartner() != null) {
            existingBooking.setPartner(updatedBooking.getPartner());
            }

        if (updatedBooking.getRoom() != null) {
            existingBooking.setRoom(updatedBooking.getRoom());
        }

        if (updatedBooking.getPrivateHotel() != null) {
            existingBooking.setPrivateHotel(updatedBooking.getPrivateHotel());
        }

        if (updatedBooking.getProject() != null) {
            existingBooking.setProject(updatedBooking.getProject());
        }

//        if (updatedBooking.getProjectBookings() != null) {
//            List<ProjectBooking> existingProjectBookings = existingBooking.getProjectBookings();
//            List<ProjectBooking> updatedProjectBookings = updatedBooking.getProjectBookings();
//
//            for (int i = 0; i < updatedProjectBookings.size(); i++) {
//                ProjectBooking updatedProjectBooking = updatedProjectBookings.get(i);
//
//                if (i < existingProjectBookings.size()) {
//                    ProjectBooking existingProjectBooking = existingProjectBookings.get(i);
//                    existingProjectBooking.setProject(updatedProjectBooking.getProject());
//                    updatedProjectBooking.setBookings(existingBooking);
//                } else {
//                    existingProjectBookings.add(updatedProjectBooking);
//                }
//            }
//
//            for (int i = updatedProjectBookings.size(); i < existingProjectBookings.size(); i++) {
//                existingProjectBookings.remove(i);
//            }
//        }

        return bookingRepo.save(existingBooking);
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepo.deleteById(id);
    }

    public BookingDTO convertToDTO(Booking booking) {
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setBookingId(booking.getBookingId());
        bookingDTO.setBookingDate(booking.getBookingDate());
        bookingDTO.setStartDate(booking.getStartDate());
        bookingDTO.setEndDate(booking.getEndDate());
        bookingDTO.setBookingStatus(booking.getBookingStatus());

        if (booking.getVolunteer() != null) {
            VolunteerDTO volunteerDTO = new VolunteerDTO();
            volunteerDTO.setId(booking.getVolunteer().getId());
            volunteerDTO.setFirstName(booking.getVolunteer().getFirstName());
            volunteerDTO.setLastName(booking.getVolunteer().getLastName());
            volunteerDTO.setEmail(booking.getVolunteer().getEmail());
            volunteerDTO.setDob(booking.getVolunteer().getDob());
            volunteerDTO.setIsMale(booking.getVolunteer().getIsMale());
            volunteerDTO.setMobileNo(booking.getVolunteer().getMobileNo());
            volunteerDTO.setNationality(booking.getVolunteer().getNationality());
            bookingDTO.setVolunteer(volunteerDTO);
        }

        if (booking.getPartner() != null) {
            PartnerDTO partnerDTO = new PartnerDTO();
            partnerDTO.setPid(booking.getPartner().getPid());
            partnerDTO.setPname(booking.getPartner().getPname());
            bookingDTO.setPartner(partnerDTO);
        }

        if (booking.getRoom() != null) {
            RoomDTO roomDTO = new RoomDTO();
            roomDTO.setRid(booking.getRoom().getRid());
            roomDTO.setRname(booking.getRoom().getRname());
            roomDTO.setCapacity(booking.getRoom().getCapacity());
            bookingDTO.setRoom(roomDTO);
        }

        if (booking.getPrivateHotel() != null) {
            PrivateHotelDTO privateHotelDTO = new PrivateHotelDTO();
            privateHotelDTO.setPhId(booking.getPrivateHotel().getPhId());
            privateHotelDTO.setPhName(booking.getPrivateHotel().getPhName());
            bookingDTO.setPrivateHotel(privateHotelDTO);
        }

        if (booking.getProject() != null) {
            ProjectDTO projectDTO = new ProjectDTO();
            projectDTO.setPrId(booking.getProject().getPrId());
            projectDTO.setPrName(booking.getProject().getPrName());
            bookingDTO.setProject(projectDTO);
        }

        return bookingDTO;
    }

}

