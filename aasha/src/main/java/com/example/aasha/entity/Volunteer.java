package com.example.aasha.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Volunteer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String firstName;
    private String lastName;
    private LocalDate dob;
    private Boolean isMale;
    private String mobileNo;
    private String nationality;
    private String email;

    @OneToOne(mappedBy = "volunteer", fetch = FetchType.LAZY)
    @JsonBackReference
    private Booking booking;




}
