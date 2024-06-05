package com.example.aasha.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pcId;
    private String pcName;
    @OneToMany (mappedBy = "projectCategory" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Project> projectList;
}
