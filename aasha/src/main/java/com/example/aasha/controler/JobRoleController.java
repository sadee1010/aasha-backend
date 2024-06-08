package com.example.aasha.controler;

import com.example.aasha.dto.JobRoleDTO;
import com.example.aasha.entity.JobRole;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@CrossOrigin(origins = "*")
public interface JobRoleController {

    @GetMapping("/jobRoles")
    ResponseEntity<List<JobRoleDTO>> getAllJobRoles();

    @GetMapping("/jobRoles/{id}")
    ResponseEntity<JobRoleDTO> getJobRoleById(@PathVariable Long id);

    @PostMapping("/jobRoles")
    ResponseEntity<JobRoleDTO> saveJobRole(@RequestBody JobRole jobRole);

    @PutMapping("/jobRoles/{id}")
    ResponseEntity<JobRoleDTO> updateJobRole(@PathVariable Long id, @RequestBody JobRole jobRole);

    @DeleteMapping("/jobRoles/{id}")
    ResponseEntity<Void> deleteJobRole(@PathVariable Long id);
}
