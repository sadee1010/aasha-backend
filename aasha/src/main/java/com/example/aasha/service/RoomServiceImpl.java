package com.example.aasha.service;

import com.example.aasha.dto.*;
import com.example.aasha.entity.Booking;
import com.example.aasha.entity.Room;
import com.example.aasha.repo.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService{
    private RoomRepo roomRepo;

    @Autowired
    public RoomServiceImpl(RoomRepo roomRepo) {
        this.roomRepo = roomRepo;
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepo.findAll();
    }

    @Override
    public Room getRoomById(Long id) {
        return roomRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Room not found with " + id));
    }

    @Override
    public Room saveRoom(Room room) {
        return roomRepo.save(room);
    }

    @Override
    public Room updateRoom(Long id, Room updatedRoom) {
        Room existingRoom = roomRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Room not found with id " + id));

        existingRoom.setRname(updatedRoom.getRname());
        existingRoom.setCapacity(updatedRoom.getCapacity());

        return roomRepo.save(existingRoom);
    }

    @Override
    public void deleteRoom(Long id) {
        roomRepo.deleteById(id);
    }

    @Override
    public RoomDTO convertToDTO(Room room) {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setRid(room.getRid());
        roomDTO.setRname(room.getRname());
        roomDTO.setCapacity(room.getCapacity());

        List<BookingDTO> bookingDTOs = room.getBookings() != null ?
                room.getBookings().stream()
                        .map(booking -> convertToDTO(booking))
                        .collect(Collectors.toList()) : new ArrayList<>();
        roomDTO.setBookings(bookingDTOs);

        return roomDTO;
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
