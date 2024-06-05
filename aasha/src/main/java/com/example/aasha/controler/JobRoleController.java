package com.example.aasha.controler;

import com.example.aasha.dto.JobRoleDTO;
import com.example.aasha.dto.ResponseDTO;
import com.example.aasha.service.JobRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/jobrole")
@CrossOrigin
public class JobRoleController {
    @Autowired
    JobRoleService jobRoleService;


    @PostMapping("/save")
    public ResponseEntity saveJobRole(@RequestBody JobRoleDTO jobRoleDTO){
        ResponseDTO responseDTO =  jobRoleService.saveJobRole(jobRoleDTO);
        System.out.println(responseDTO.getContent());
        return new ResponseEntity(responseDTO,responseDTO.getHttpStatus());
    }

    @GetMapping( "/get")
    public ResponseEntity getJobRole (){
        ResponseDTO responseDTO = jobRoleService.getJobRole();
        return new ResponseEntity(responseDTO,responseDTO.getHttpStatus());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteJobRole(@PathVariable Long id){
        ResponseDTO responseDTO = jobRoleService.deleteJobRole(id);
        return new ResponseEntity(responseDTO,responseDTO.getHttpStatus());
    }

}
