package com.example.aasha.service;

import com.example.aasha.dto.*;
import com.example.aasha.entity.Booking;
import com.example.aasha.entity.Partner;
import com.example.aasha.repo.PartnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class PartnerServiceImpl implements PartnerService{

    private PartnerRepo partnerRepo;

    @Autowired
    public PartnerServiceImpl(PartnerRepo partnerRepo) {
        this.partnerRepo = partnerRepo;
    }

    @Override
    public List<Partner> getAllPartners() {
        return partnerRepo.findAll();
    }

    @Override
    public Partner getPartnerById(Long id) {
        return partnerRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Partner not found with " + id));
    }

    @Override
    public Partner savePartner(Partner partner) {
        return partnerRepo.save(partner);
    }

    @Override
    public Partner updatePartner(Long id, Partner updatedPartner) {
        Partner existingPartner = partnerRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Partner not found with id " + id));

        existingPartner.setPname(updatedPartner.getPname());

        return partnerRepo.save(existingPartner);
    }

    @Override
    public void deletePartner(Long id) {
        partnerRepo.deleteById(id);
    }

    @Override
    public PartnerDTO convertToDTO(Partner partner) {
        PartnerDTO partnerDTO = new PartnerDTO();
        partnerDTO.setPid(partner.getPid());
        partnerDTO.setPname(partner.getPname());

        List<BookingDTO> bookingDTOs = partner.getBookings() != null ?
                partner.getBookings().stream()
                        .map(booking -> convertToDTO(booking))
                        .collect(Collectors.toList()) : new ArrayList<>();
        partnerDTO.setBookings(bookingDTOs);

        return partnerDTO;
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
