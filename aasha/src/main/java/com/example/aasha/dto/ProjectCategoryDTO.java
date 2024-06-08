package com.example.aasha.dto;

import com.example.aasha.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectCategoryDTO {
    private Long pcId;
    private String pcName;
    private List<ProjectDTO> projectList;

}
