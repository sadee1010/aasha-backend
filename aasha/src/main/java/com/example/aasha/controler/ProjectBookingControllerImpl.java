package com.example.aasha.controler;

import com.example.aasha.dto.ProjectBookingDTO;
import com.example.aasha.entity.ProjectBooking;
import com.example.aasha.service.ProjectBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

public class ProjectBookingControllerImpl implements ProjectBookingController {
    private final ProjectBookingService projectBookingService;

    @Autowired
    public ProjectBookingControllerImpl(ProjectBookingService projectBookingService) {
        this.projectBookingService = projectBookingService;
    }

    @Override
    public ResponseEntity<List<ProjectBookingDTO>> getAllProjectBookings() {
        List<ProjectBookingDTO> projectBookingDTOs = projectBookingService.getAllProjectBookings()
                .stream()
                .map(projectBookingService::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(projectBookingDTOs);
    }

    @Override
    public ResponseEntity<ProjectBookingDTO> getProjectBookingById(Long id) {
        ProjectBookingDTO projectBookingDTO = projectBookingService.convertToDTO(projectBookingService.getProjectBookingById(id));
        return ResponseEntity.status(HttpStatus.OK).body(projectBookingDTO);
    }

    @Override
    public ResponseEntity<ProjectBookingDTO> saveProjectBooking(ProjectBooking projectBooking) {
        ProjectBooking newProjectBooking = projectBookingService.saveProjectBooking(projectBooking);
        ProjectBookingDTO newProjectBookingDTO = projectBookingService.convertToDTO(newProjectBooking);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProjectBookingDTO);
    }

    @Override
    public ResponseEntity<ProjectBookingDTO> updateProjectBooking(Long id, ProjectBooking projectBooking) {
        ProjectBooking updatedProjectBooking = projectBookingService.updateProjectBooking(id, projectBooking);
        ProjectBookingDTO updatedProjectBookingDTO = projectBookingService.convertToDTO(updatedProjectBooking);
        return ResponseEntity.status(HttpStatus.OK).body(updatedProjectBookingDTO);
    }

    @Override
    public ResponseEntity<Void> deleteProjectBooking(Long id) {
        projectBookingService.deleteProjectBooking(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
