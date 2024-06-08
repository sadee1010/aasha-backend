package com.example.aasha.service;

import com.example.aasha.dto.ProjectCategoryDTO;
import com.example.aasha.entity.ProjectCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectCategoryService {
    List<ProjectCategory> getAllProjectCategories();

    ProjectCategory getProjectCategoryById(Long id);

    ProjectCategory saveProjectCategory(ProjectCategory projectCategory);

    ProjectCategory updateProjectCategory(Long id, ProjectCategory projectCategory);

    void deleteProjectCategory(Long id);

    public ProjectCategoryDTO convertToDTO(ProjectCategory projectCategory);
}
