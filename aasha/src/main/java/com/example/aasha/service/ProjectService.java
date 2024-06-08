package com.example.aasha.service;

import com.example.aasha.dto.ProjectDTO;
import com.example.aasha.entity.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {
    List<Project> getAllProjects();

    Project getProjectById(Long id);

    Project saveProject(Project project);

    Project updateProject(Long id, Project project);

    void deleteProject(Long id);

    public ProjectDTO convertToDTO(Project project);

}
