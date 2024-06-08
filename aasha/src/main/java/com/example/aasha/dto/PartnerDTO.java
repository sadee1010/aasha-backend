package com.example.aasha.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PartnerDTO {
    private Long pid;
    private String pname;
    private List<BookingDTO> bookings;

}
