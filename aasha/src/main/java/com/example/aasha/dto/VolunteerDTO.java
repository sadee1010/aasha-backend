package com.example.aasha.dto;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VolunteerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private Boolean isMale;
    private String mobileNo;
    private String nationality;
    private String email;
}
