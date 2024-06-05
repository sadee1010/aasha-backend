package com.example.aasha.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Event {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long eid;
    private String eventTitle;
    private LocalDate date;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String category;


}
