package com.example.aasha.controler;

import com.example.aasha.dto.ProjectCategoryDTO;
import com.example.aasha.dto.ResponseDTO;
import com.example.aasha.service.ProjectCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projectcategory")
@CrossOrigin
public class ProjectCategoryController {
    @Autowired
    ProjectCategoryService projectCategoryService;

    @PostMapping ("/save")
    public ResponseEntity saveProjectCategory(@RequestBody ProjectCategoryDTO projectCategoryDTO){
        ResponseDTO responseDTO = projectCategoryService.saveProjectCategory(projectCategoryDTO);
        System.out.println(responseDTO.getContent());
        return new ResponseEntity(responseDTO,responseDTO.getHttpStatus());
    }

    @GetMapping ( "/get")
    public ResponseEntity getProjectCategory (){
        ResponseDTO responseDTO = projectCategoryService.getProjectCategory();
        return new ResponseEntity(responseDTO, responseDTO.getHttpStatus());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProjectCategory(@PathVariable Long id){
        ResponseDTO responseDTO = projectCategoryService.deleteProjectCategory(id);
        return new ResponseEntity(responseDTO,responseDTO.getHttpStatus());
    }


}
