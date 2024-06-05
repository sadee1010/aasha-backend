package com.example.aasha.repo;

import com.example.aasha.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepo extends JpaRepository <Project, Long> {
}
