package com.example.aasha.dto;

import com.example.aasha.entity.ProjectBooking;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {
    private Long bookingId;
    private LocalDate bookingDate;
    private LocalDate startDate;
    private LocalDate endDate;
    private String bookingStatus;
    private VolunteerDTO volunteer;
    private PartnerDTO partner;
    private RoomDTO room;
    private PrivateHotelDTO privateHotel;
    private ProjectDTO project;

}
