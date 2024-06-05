package com.example.aasha.repo;

import com.example.aasha.entity.JobRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRoleRepo extends JpaRepository<JobRole, Long> {
}
