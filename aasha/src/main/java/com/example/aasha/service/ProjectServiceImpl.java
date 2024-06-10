package com.example.aasha.service;

import com.example.aasha.dto.*;
import com.example.aasha.entity.Booking;
import com.example.aasha.entity.Project;
import com.example.aasha.entity.ProjectCategory;
import com.example.aasha.repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService{
    private ProjectRepo projectRepo;

    @Autowired
    public ProjectServiceImpl(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepo.findAll();
    }

    @Override
    public Project getProjectById(Long id) {
        return projectRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Project not found with id " + id));
    }

    @Override
    public Project saveProject(Project project) {
        return projectRepo.save(project);
    }

    @Override
    public Project updateProject(Long id, Project updatedProject) {
        Project existingProject = projectRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Project not found with id " + id));

        existingProject.setPrName(updatedProject.getPrName());
        existingProject.setCapacity(updatedProject.getCapacity());

        if (updatedProject.getProjectCategory() != null) {
            ProjectCategory existingProjectCategory = existingProject.getProjectCategory();
            ProjectCategory updatedProjectCategory = updatedProject.getProjectCategory();

            if (existingProjectCategory == null ){
                existingProject.setProjectCategory(updatedProjectCategory);
                updatedProjectCategory.setProjectList(List.of(existingProject));
            } else {
                existingProjectCategory.setPcName(updatedProjectCategory.getPcName());
            }
        }
        return projectRepo.save(existingProject);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepo.deleteById(id);
    }

    @Override
    public ProjectDTO convertToDTO(Project project) {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setPrId(project.getPrId());
        projectDTO.setPrName(project.getPrName());
        projectDTO.setCapacity(project.getCapacity());

        ProjectCategoryDTO projectCategoryDTO = new ProjectCategoryDTO();
        projectCategoryDTO.setPcId(project.getProjectCategory().getPcId());
        projectCategoryDTO.setPcName(project.getProjectCategory().getPcName());
        projectDTO.setProjectCategory(projectCategoryDTO);

        List<BookingDTO> bookingDTOs = project.getBookings() != null ?
                project.getBookings().stream()
                        .map(booking -> convertToDTO(booking))
                        .collect(Collectors.toList()) : new ArrayList<>();
        projectDTO.setBookings(bookingDTOs);


        return projectDTO;
    }

    public BookingDTO convertToDTO(Booking booking) {
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setBookingId(booking.getBookingId());
        bookingDTO.setBookingDate(booking.getBookingDate());
        bookingDTO.setStartDate(booking.getStartDate());
        bookingDTO.setEndDate(booking.getEndDate());
        bookingDTO.setBookingStatus(booking.getBookingStatus());

        if (booking.getVolunteer() != null) {
            VolunteerDTO volunteerDTO = new VolunteerDTO();
            volunteerDTO.setId(booking.getVolunteer().getId());
            volunteerDTO.setFirstName(booking.getVolunteer().getFirstName());
            volunteerDTO.setLastName(booking.getVolunteer().getLastName());
            volunteerDTO.setEmail(booking.getVolunteer().getEmail());
            volunteerDTO.setDob(booking.getVolunteer().getDob());
            volunteerDTO.setIsMale(booking.getVolunteer().getIsMale());
            volunteerDTO.setMobileNo(booking.getVolunteer().getMobileNo());
            volunteerDTO.setNationality(booking.getVolunteer().getNationality());
            bookingDTO.setVolunteer(volunteerDTO);
        }

        if (booking.getPartner() != null) {
            PartnerDTO partnerDTO = new PartnerDTO();
            partnerDTO.setPid(booking.getPartner().getPid());
            partnerDTO.setPname(booking.getPartner().getPname());
            bookingDTO.setPartner(partnerDTO);
        }

        if (booking.getRoom() != null) {
            RoomDTO roomDTO = new RoomDTO();
            roomDTO.setRid(booking.getRoom().getRid());
            roomDTO.setRname(booking.getRoom().getRname());
            roomDTO.setCapacity(booking.getRoom().getCapacity());
            bookingDTO.setRoom(roomDTO);
        }

        if (booking.getPrivateHotel() != null) {
            PrivateHotelDTO privateHotelDTO = new PrivateHotelDTO();
            privateHotelDTO.setPhId(booking.getPrivateHotel().getPhId());
            privateHotelDTO.setPhName(booking.getPrivateHotel().getPhName());
            bookingDTO.setPrivateHotel(privateHotelDTO);
        }

        if (booking.getProject() != null) {
            ProjectDTO projectDTO = new ProjectDTO();
            projectDTO.setPrId(booking.getProject().getPrId());
            projectDTO.setPrName(booking.getProject().getPrName());
            bookingDTO.setProject(projectDTO);
        }

        return bookingDTO;
    }
}
