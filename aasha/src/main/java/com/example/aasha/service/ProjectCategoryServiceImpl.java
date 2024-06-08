package com.example.aasha.service;

import com.example.aasha.dto.ProjectCategoryDTO;
import com.example.aasha.entity.ProjectCategory;
import com.example.aasha.repo.ProjectCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProjectCategoryServiceImpl implements ProjectCategoryService{
    private ProjectCategoryRepo projectCategoryRepo;

    @Autowired
    public ProjectCategoryServiceImpl(ProjectCategoryRepo projectCategoryRepo) {
        this.projectCategoryRepo = projectCategoryRepo;
    }

    @Override
    public List<ProjectCategory> getAllProjectCategories() {
        return projectCategoryRepo.findAll();
    }

    @Override
    public ProjectCategory getProjectCategoryById(Long id) {
        return projectCategoryRepo.findById(id).orElseThrow(() -> new NoSuchElementException("ProjectCategory not found with " + id));
    }

    @Override
    public ProjectCategory saveProjectCategory(ProjectCategory projectCategory) {
        return projectCategoryRepo.save(projectCategory);
    }

    @Override
    public ProjectCategory updateProjectCategory(Long id, ProjectCategory updatedProjectCategory) {
        ProjectCategory existingProjectCategory = projectCategoryRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("ProjectCategory not found with id " + id));

        existingProjectCategory.setPcName(updatedProjectCategory.getPcName());
        return projectCategoryRepo.save(existingProjectCategory);
    }

    @Override
    public void deleteProjectCategory(Long id) {
        projectCategoryRepo.deleteById(id);
    }

    @Override
    public ProjectCategoryDTO convertToDTO(ProjectCategory projectCategory) {
        ProjectCategoryDTO projectCategoryDTO = new ProjectCategoryDTO();
        projectCategoryDTO.setPcId(projectCategory.getPcId());
        projectCategoryDTO.setPcName(projectCategory.getPcName());
        return projectCategoryDTO;
    }
}
