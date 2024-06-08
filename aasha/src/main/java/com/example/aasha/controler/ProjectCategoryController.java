package com.example.aasha.controler;

import com.example.aasha.dto.ProjectCategoryDTO;
import com.example.aasha.entity.ProjectCategory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@CrossOrigin(origins = "*")
public interface ProjectCategoryController {

    @GetMapping("/projectcategory")
    ResponseEntity<List<ProjectCategoryDTO>> getAllProjectCategories();

    @GetMapping("/projectcategory/{id}")
    ResponseEntity<ProjectCategoryDTO> getProjectCategoryById(@PathVariable Long id);

    @PostMapping("/projectcategory")
    ResponseEntity<ProjectCategoryDTO> saveProjectCategory(@RequestBody ProjectCategory projectCategory);

    @PutMapping("/projectcategory/{id}")
    ResponseEntity<ProjectCategoryDTO> updateProjectCategory(@PathVariable Long id, @RequestBody ProjectCategory projectCategory);

    @DeleteMapping("/projectcategory/{id}")
    ResponseEntity<Void> deleteProjectCategory(@PathVariable Long id);

}
