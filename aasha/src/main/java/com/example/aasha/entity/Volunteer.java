package com.example.aasha.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table (name = "Volunteer")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Volunteer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private LocalDate dob;
    @Column
    private Boolean isMale;
    @Column
    private String mobileNo;
    @Column
    private String nationality;
    @Column
    private String email;

    @OneToOne(mappedBy = "volunteer", fetch = FetchType.LAZY)
    @JsonBackReference
    private Booking booking;

}
