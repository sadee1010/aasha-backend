//package com.example.aasha.service;
//
//import com.example.aasha.dto.BookingDTO;
//import com.example.aasha.dto.ProjectBookingDTO;
//import com.example.aasha.dto.ProjectDTO;
//import com.example.aasha.entity.ProjectBooking;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//import java.util.NoSuchElementException;
//
//
//public class ProjectBookingServiceImpl implements ProjectBookingService{
//
//    private ProjectBookingRepo projectBookingRepo;
//
//    @Autowired
//    public ProjectBookingServiceImpl(ProjectBookingRepo projectBookingRepo) {
//        this.projectBookingRepo = projectBookingRepo;
//    }
//
//    @Override
//    public List<ProjectBooking> getAllProjectBookings() {
//        return projectBookingRepo.findAll();
//    }
//
//    @Override
//    public ProjectBooking getProjectBookingById(Long id) {
//        return projectBookingRepo.findById(id)
//                .orElseThrow(() -> new NoSuchElementException("Project Booking not found with id " + id));
//    }
//
//    @Override
//    public ProjectBooking saveProjectBooking(ProjectBooking projectBooking) {
//        return projectBookingRepo.save(projectBooking);
//    }
//
//    @Override
//    public ProjectBooking updateProjectBooking(Long id, ProjectBooking updatedProjectBooking) {
//        ProjectBooking existingProjectBooking = projectBookingRepo.findById(id)
//                .orElseThrow(() -> new NoSuchElementException("Project Booking not found with id " + id));
//
//        existingProjectBooking.setPstartDate(updatedProjectBooking.getPstartDate());
//        existingProjectBooking.setPendDate(updatedProjectBooking.getPendDate());
//        existingProjectBooking.setProject(updatedProjectBooking.getProject());
//        existingProjectBooking.setBookings(updatedProjectBooking.getBookings());
//
//        return projectBookingRepo.save(existingProjectBooking);
//    }
//
//    @Override
//    public void deleteProjectBooking(Long id) {
//        projectBookingRepo.deleteById(id);
//    }
//
//    @Override
//    public ProjectBookingDTO convertToDTO(ProjectBooking projectBooking) {
//        ProjectDTO projectDTO = new ProjectDTO();
//        projectDTO.setPrId(projectBooking.getProject().getPrId());
//        projectDTO.setPrName(projectBooking.getProject().getPrName());
//
//        ProjectBookingDTO projectBookingDTO = new ProjectBookingDTO();
//        projectBookingDTO.setPbId(projectBooking.getPbId());
//        projectBookingDTO.setStartDate(projectBooking.getPstartDate());
//        projectBookingDTO.setEndDate(projectBooking.getPendDate());
//        projectBookingDTO.setProject(projectDTO);
//
//        BookingDTO bookingDTO = new BookingDTO();
//        bookingDTO.setBookingId(projectBooking.getBookings().getBookingId());
//        bookingDTO.setBookingDate(projectBooking.getBookings().getBookingDate());
//        bookingDTO.setStartDate(projectBooking.getBookings().getStartDate());
//        bookingDTO.setEndDate(projectBooking.getBookings().getEndDate());
//        bookingDTO.setBookingStatus(projectBooking.getBookings().getBookingStatus());
//        projectBookingDTO.setBookings(bookingDTO);
//
//        return projectBookingDTO;
//    }
//}
