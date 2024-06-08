package com.example.aasha.controler;

import com.example.aasha.dto.ProjectDTO;
import com.example.aasha.entity.Project;
import com.example.aasha.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProjectControllerImpl implements ProjectController {
    private final ProjectService projectService;

    @Autowired
    public ProjectControllerImpl(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public ResponseEntity<List<ProjectDTO>> getAllProjects() {
        List<ProjectDTO> projectDTOs = projectService.getAllProjects()
                .stream()
                .map(projectService::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(projectDTOs);
    }

    @Override
    public ResponseEntity<ProjectDTO> getProjectById(@PathVariable Long id) {
        ProjectDTO projectDTO = projectService.convertToDTO(projectService.getProjectById(id));
        return ResponseEntity.status(HttpStatus.OK).body(projectDTO);
    }

    @Override
    public ResponseEntity<ProjectDTO> saveProject(@RequestBody Project project) {
        Project newProject = projectService.saveProject(project);
        ProjectDTO newProjectDTO = projectService.convertToDTO(newProject);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProjectDTO);
    }

    @Override
    public ResponseEntity<ProjectDTO> updateProject(@PathVariable Long id, @RequestBody Project project) {
        Project updatedProject = projectService.updateProject(id, project);
        ProjectDTO updatedProjectDTO = projectService.convertToDTO(updatedProject);
        return ResponseEntity.status(HttpStatus.OK).body(updatedProjectDTO);
    }

    @Override
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
