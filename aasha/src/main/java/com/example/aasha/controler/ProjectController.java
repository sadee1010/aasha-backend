package com.example.aasha.controler;

import com.example.aasha.dto.ProjectDTO;
import com.example.aasha.dto.ResponseDTO;
import com.example.aasha.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ( "/api/projects")
@CrossOrigin
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @PostMapping("/save")
    public ResponseEntity saveProject(@RequestBody ProjectDTO projectDTO){
        ResponseDTO responseDTO = projectService.saveProject(projectDTO);
        System.out.println(responseDTO.getContent());
        return new ResponseEntity(responseDTO,responseDTO.getHttpStatus());
    }

    @GetMapping ( "/get")
    public ResponseEntity getProject (){
        ResponseDTO responseDTO = projectService.getProject();
        return new ResponseEntity(responseDTO, responseDTO.getHttpStatus());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProject(@PathVariable Long id){
        ResponseDTO responseDTO = projectService.deleteProject(id);
        return new ResponseEntity(responseDTO,responseDTO.getHttpStatus());
    }
}
