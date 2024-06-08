package com.example.aasha.controler;

import com.example.aasha.dto.JobRoleDTO;
import com.example.aasha.entity.JobRole;
import com.example.aasha.service.JobRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class JobRoleImpl implements JobRoleController{

    private final JobRoleService jobRoleService;

    @Autowired
    public JobRoleImpl(JobRoleService jobRoleService) {
        this.jobRoleService = jobRoleService;
    }

    @Override
    public ResponseEntity<List<JobRoleDTO>> getAllJobRoles() {
        List<JobRoleDTO> jobRoleDTOs = jobRoleService.getAllJobRoles()
                .stream()
                .map(jobRoleService::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(jobRoleDTOs);
    }

    @Override
    public ResponseEntity<JobRoleDTO> getJobRoleById(@PathVariable Long id) {
        JobRoleDTO jobRoleDTO = jobRoleService.convertToDTO(jobRoleService.getJobRoleById(id));
        return ResponseEntity.status(HttpStatus.OK).body(jobRoleDTO);
    }

    @Override
    public ResponseEntity<JobRoleDTO> saveJobRole(@RequestBody JobRole jobRole) {
        JobRole newJobRole = jobRoleService.saveJobRole(jobRole);
        JobRoleDTO newJobRoleDTO = jobRoleService.convertToDTO(newJobRole);
        return ResponseEntity.status(HttpStatus.CREATED).body(newJobRoleDTO);
    }

    @Override
    public ResponseEntity<JobRoleDTO> updateJobRole(@PathVariable Long id, @RequestBody JobRole jobRole) {
        JobRole updatedJobRole = jobRoleService.updateJobRole(id, jobRole);
        JobRoleDTO updatedJobRoleDTO = jobRoleService.convertToDTO(updatedJobRole);
        return ResponseEntity.status(HttpStatus.OK).body(updatedJobRoleDTO);
    }

    @Override
    public ResponseEntity<Void> deleteJobRole(@PathVariable Long id) {
        jobRoleService.deleteJobRole(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
