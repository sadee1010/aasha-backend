package com.example.aasha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PrivateHotelDTO {
    private Long phId;
    private String phName;
    private List<BookingDTO> bookings;

}
