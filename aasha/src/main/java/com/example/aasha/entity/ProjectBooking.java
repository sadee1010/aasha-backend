package com.example.aasha.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pbId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "prId")
    @JsonBackReference
    private Project project;

    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bookingId")
    @JsonBackReference
    private Booking booking;
}
