package com.example.aasha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EventDTO {
    private Long eid;
    private String eventTitle;
    private LocalDate date;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String category;

}
