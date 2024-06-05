package com.example.aasha.repo;

import com.example.aasha.entity.ProjectCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectCategoryRepo extends JpaRepository <ProjectCategory, Long> {

}
