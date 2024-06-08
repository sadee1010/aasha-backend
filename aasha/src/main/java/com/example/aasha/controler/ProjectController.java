package com.example.aasha.controler;

import com.example.aasha.dto.ProjectDTO;
import com.example.aasha.entity.Project;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@CrossOrigin(origins = "*")
public interface ProjectController {

    @GetMapping("/project")
    ResponseEntity<List<ProjectDTO>> getAllProjects();

    @GetMapping("/project/{id}")
    ResponseEntity<ProjectDTO> getProjectById(@PathVariable Long id);

    @PostMapping("/project")
    ResponseEntity<ProjectDTO> saveProject(@RequestBody Project project);

    @PutMapping("/project/{id}")
    ResponseEntity<ProjectDTO> updateProject(@PathVariable Long id, @RequestBody Project project);

    @DeleteMapping("/project/{id}")
    ResponseEntity<Void> deleteProject(@PathVariable Long id);

}
