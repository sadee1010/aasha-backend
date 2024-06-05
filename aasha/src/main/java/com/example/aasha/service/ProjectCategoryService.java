package com.example.aasha.service;

import com.example.aasha.dto.ProjectCategoryDTO;
import com.example.aasha.dto.ResponseDTO;
import com.example.aasha.entity.ProjectCategory;
import com.example.aasha.repo.ProjectCategoryRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectCategoryService {
    @Autowired
    ProjectCategoryRepo projectCategoryRepo;
    @Autowired
    ModelMapper modelMapper;

    public ResponseDTO saveProjectCategory (ProjectCategoryDTO projectCategoryDTO){
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            ProjectCategory projectCategory = modelMapper.map(projectCategoryDTO, ProjectCategory.class);
//            projectCategory.setPcId(projectCategoryDTO.getPcId());
//            projectCategory.setPcName(projectCategoryDTO.getPcName());
            projectCategoryRepo.save(projectCategory);
            responseDTO.setContent(projectCategoryDTO);
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

    public ResponseDTO getProjectCategory (){
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            List<ProjectCategory> projectCategory = projectCategoryRepo.findAll();
            List<ProjectCategoryDTO> projectCategoryDTOList = new ArrayList<>();
            for (ProjectCategory projectCategory1: projectCategory) {
                ProjectCategoryDTO projectCategoryDTO = modelMapper.map(projectCategory1, ProjectCategoryDTO.class);
                projectCategoryDTOList.add(projectCategoryDTO);
            }
            responseDTO.setContent(projectCategoryDTOList);
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

    public ResponseDTO deleteProjectCategory (Long id){
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            projectCategoryRepo.deleteById(id);
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

