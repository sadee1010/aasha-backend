package com.example.aasha.controler;

import com.example.aasha.dto.ProjectCategoryDTO;
import com.example.aasha.entity.ProjectCategory;
import com.example.aasha.service.ProjectCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProjectCategoryControllerImpl implements ProjectCategoryController {
    private final ProjectCategoryService projectCategoryService;

    @Autowired
    public ProjectCategoryControllerImpl(ProjectCategoryService projectCategoryService) {
        this.projectCategoryService = projectCategoryService;
    }

    @Override
    public ResponseEntity<List<ProjectCategoryDTO>> getAllProjectCategories() {
        List<ProjectCategoryDTO> projectCategoryDTOs = projectCategoryService.getAllProjectCategories()
                .stream()
                .map(projectCategoryService::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(projectCategoryDTOs);
    }

    @Override
    public ResponseEntity<ProjectCategoryDTO> getProjectCategoryById(@PathVariable Long id) {
        ProjectCategoryDTO projectCategoryDTO = projectCategoryService.convertToDTO(projectCategoryService.getProjectCategoryById(id));
        return ResponseEntity.status(HttpStatus.OK).body(projectCategoryDTO);
    }

    @Override
    public ResponseEntity<ProjectCategoryDTO> saveProjectCategory(@RequestBody ProjectCategory projectCategory) {
        ProjectCategory newProjectCategory = projectCategoryService.saveProjectCategory(projectCategory);
        ProjectCategoryDTO newProjectCategoryDTO = projectCategoryService.convertToDTO(newProjectCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProjectCategoryDTO);
    }

    @Override
    public ResponseEntity<ProjectCategoryDTO> updateProjectCategory(@PathVariable Long id, @RequestBody ProjectCategory projectCategory) {
        ProjectCategory updatedProjectCategory = projectCategoryService.updateProjectCategory(id, projectCategory);
        ProjectCategoryDTO updatedProjectCategoryDTO = projectCategoryService.convertToDTO(updatedProjectCategory);
        return ResponseEntity.status(HttpStatus.OK).body(updatedProjectCategoryDTO);
    }

    @Override
    public ResponseEntity<Void> deleteProjectCategory(@PathVariable Long id) {
        projectCategoryService.deleteProjectCategory(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
