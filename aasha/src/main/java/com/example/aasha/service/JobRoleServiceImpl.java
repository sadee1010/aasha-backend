package com.example.aasha.service;

import com.example.aasha.dto.JobRoleDTO;
import com.example.aasha.dto.StaffDTO;
import com.example.aasha.entity.JobRole;
import com.example.aasha.repo.JobRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class JobRoleServiceImpl implements JobRoleService{

    private JobRoleRepo jobRoleRepo;

    @Autowired
    public JobRoleServiceImpl(JobRoleRepo jobRoleRepo) {
        this.jobRoleRepo = jobRoleRepo;
    }

    @Override
    public List<JobRole> getAllJobRoles() {
        return jobRoleRepo.findAll();
    }

    @Override
    public JobRole getJobRoleById(Long id) {
        return jobRoleRepo.findById(id).orElseThrow(() -> new NoSuchElementException("JobRole not found with " + id));
    }

    @Override
    public JobRole saveJobRole(JobRole jobRole) {
        return jobRoleRepo.save(jobRole);
    }

    @Override
    public JobRole updateJobRole(Long id, JobRole updatedJobRole) {
        JobRole existingJobRole = jobRoleRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("JobRole not found with id " + id));

        existingJobRole.setJname(updatedJobRole.getJname());

        return jobRoleRepo.save(existingJobRole);
    }

    @Override
    public void deleteJobRole(Long id) {
        jobRoleRepo.deleteById(id);
    }

    @Override
    public JobRoleDTO convertToDTO(JobRole jobRole) {
        JobRoleDTO jobRoleDTO = new JobRoleDTO();
        jobRoleDTO.setJid(jobRole.getJid());
        jobRoleDTO.setJname(jobRole.getJname());

        return jobRoleDTO;
    }
}
