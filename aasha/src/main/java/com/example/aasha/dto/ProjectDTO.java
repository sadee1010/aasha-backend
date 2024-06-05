package com.example.aasha.dto;

import com.example.aasha.entity.ProjectCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectDTO {
    private Long prId;
    private String prName;

    private ProjectCategoryDTO projectCategory;
}
