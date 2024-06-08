package com.example.aasha.dto;

import com.example.aasha.entity.ProjectCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectDTO {
    private Long prId;
    private String prName;
    private ProjectCategoryDTO projectCategory;
    private List<BookingDTO> bookings;
}
