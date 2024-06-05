package com.example.aasha.service;

import com.example.aasha.dto.ProjectCategoryDTO;
import com.example.aasha.dto.ProjectDTO;
import com.example.aasha.dto.ResponseDTO;
import com.example.aasha.entity.Project;
import com.example.aasha.entity.ProjectCategory;
import com.example.aasha.repo.ProjectRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProjectService {
    @Autowired
    ProjectRepo projectRepo;
    @Autowired
    ModelMapper modelMapper;

    public ResponseDTO saveProject (ProjectDTO projectDTO){
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            Project project = modelMapper.map(projectDTO, Project.class);
            project.setProjectCategory(modelMapper.map(projectDTO.getProjectCategory(), ProjectCategory.class));
            ProjectCategory projectCategory = new ProjectCategory();
            projectCategory.setPcId(projectDTO.getProjectCategory().getPcId());
            project.setProjectCategory(projectCategory);

            projectRepo.save(project);
            responseDTO.setContent(projectDTO);
            responseDTO.setResponseMsg("success");
            responseDTO.setResponseCode("00");
            responseDTO.setHttpStatus(HttpStatus.ACCEPTED);
        }catch (Exception e){
            System.out.println(e);
            responseDTO.setContent(null);
            responseDTO.setResponseMsg("Failed");
            responseDTO.setResponseCode("99");
            responseDTO.setHttpStatus(HttpStatus.CONFLICT);
        }
        return responseDTO;
    }

    public ResponseDTO getProject (){
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            List<Project> project = projectRepo.findAll();
            List<ProjectDTO> projectDTOList = new ArrayList<>();
            for (Project project1: project) {
                ProjectDTO projectDTO = new ProjectDTO();
                ProjectCategoryDTO projectCategoryDTO = new ProjectCategoryDTO();
                projectDTO.setPrId(project1.getPrId());
                projectDTO.setPrName(project1.getPrName());
                projectCategoryDTO.setPcId(project1.getProjectCategory().getPcId());
                projectCategoryDTO.setPcName(project1.getProjectCategory().getPcName());
                projectDTO.setProjectCategory(projectCategoryDTO);
                projectDTOList.add(projectDTO);
            }
            responseDTO.setContent(projectDTOList);
            responseDTO.setResponseMsg("success");
            responseDTO.setResponseCode("00");
            responseDTO.setHttpStatus(HttpStatus.ACCEPTED);
        }catch (Exception e){
            System.out.println(e);
            responseDTO.setContent(null);
            responseDTO.setResponseMsg("Failed");
            responseDTO.setResponseCode("99");
            responseDTO.setHttpStatus(HttpStatus.CONFLICT);
        }
        return responseDTO;
    }

    public ResponseDTO deleteProject (Long id){
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            projectRepo.deleteById(id);
            responseDTO.setContent(null);
            responseDTO.setResponseMsg("success");
            responseDTO.setResponseCode("00");
            responseDTO.setHttpStatus(HttpStatus.ACCEPTED);
        }catch (Exception e){
            System.out.println(e);
            responseDTO.setContent(null);
            responseDTO.setResponseMsg("Failed");
            responseDTO.setResponseCode("99");
            responseDTO.setHttpStatus(HttpStatus.CONFLICT);
        }
        return responseDTO;
    }

}
