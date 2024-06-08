package com.example.aasha.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "ProjectBooking")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pbId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "prId")
    private Project project;
    @Column
    private LocalDate pstartDate;
    @Column
    private LocalDate pendDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bookingId")
    private Booking bookings;
}
