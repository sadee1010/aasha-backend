package com.example.aasha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectBookingDTO {
    private Long pbId;
    private LocalDate startDate;
    private LocalDate endDate;
    private BookingDTO bookings;
    private ProjectDTO project;

}
