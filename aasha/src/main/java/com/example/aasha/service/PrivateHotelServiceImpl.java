package com.example.aasha.service;

import com.example.aasha.dto.*;
import com.example.aasha.entity.Booking;
import com.example.aasha.entity.PrivateHotel;
import com.example.aasha.repo.PrivateHotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PrivateHotelServiceImpl implements PrivateHotelService{
    private PrivateHotelRepo privateHotelRepo;

    @Autowired
    public PrivateHotelServiceImpl(PrivateHotelRepo privateHotelRepo) {
        this.privateHotelRepo = privateHotelRepo;
    }

    @Override
    public List<PrivateHotel> getAllPrivateHotels() {
        return privateHotelRepo.findAll();
    }

    @Override
    public PrivateHotel getPrivateHotelById(Long id) {
        return privateHotelRepo.findById(id).orElseThrow(() -> new NoSuchElementException("PrivateHotel not found with " + id));
    }

    @Override
    public PrivateHotel savePrivateHotel(PrivateHotel privateHotel) {
        return privateHotelRepo.save(privateHotel);
    }

    @Override
    public PrivateHotel updatePrivateHotel(Long id, PrivateHotel updatedPrivateHotel) {
        PrivateHotel existingPrivateHotel = privateHotelRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("PrivateHotel not found with id " + id));

        existingPrivateHotel.setPhName(updatedPrivateHotel.getPhName());
        return privateHotelRepo.save(existingPrivateHotel);
    }

    @Override
    public void deletePrivateHotel(Long id) {
        privateHotelRepo.deleteById(id);
    }

    @Override
    public PrivateHotelDTO convertToDTO(PrivateHotel privateHotel) {
        PrivateHotelDTO privateHotelDTO = new PrivateHotelDTO();
        privateHotelDTO.setPhId(privateHotel.getPhId());
        privateHotelDTO.setPhName(privateHotel.getPhName());
        return privateHotelDTO;
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
