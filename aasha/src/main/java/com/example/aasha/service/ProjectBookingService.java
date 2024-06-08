package com.example.aasha.service;

import com.example.aasha.dto.ProjectBookingDTO;
import com.example.aasha.entity.ProjectBooking;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProjectBookingService {

    List<ProjectBooking> getAllProjectBookings();

    ProjectBooking getProjectBookingById(Long id);

    ProjectBooking saveProjectBooking(ProjectBooking projectBooking);

    ProjectBooking updateProjectBooking(Long id, ProjectBooking projectBooking);

    void deleteProjectBooking(Long id);

    public ProjectBookingDTO convertToDTO(ProjectBooking projectBooking);
}
