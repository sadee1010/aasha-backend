package com.example.aasha.service;

import com.example.aasha.dto.JobRoleDTO;
import com.example.aasha.entity.JobRole;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobRoleService {

    List<JobRole> getAllJobRoles();

    JobRole getJobRoleById(Long id);

    JobRole saveJobRole(JobRole jobRole);

    JobRole updateJobRole(Long id, JobRole jobRole);

    void deleteJobRole(Long id);

    public JobRoleDTO convertToDTO(JobRole jobRole);

}
