package com.example.aasha.service;

import com.example.aasha.dto.JobRoleDTO;
import com.example.aasha.dto.ResponseDTO;
import com.example.aasha.entity.JobRole;
import com.example.aasha.repo.JobRoleRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class JobRoleService {
    @Autowired
    JobRoleRepo jobRoleRepo;
    @Autowired
    ModelMapper modelMapper;

    public ResponseDTO saveJobRole(JobRoleDTO jobRoleDTO){
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            JobRole jobRole = modelMapper.map(jobRoleDTO, JobRole.class);

            jobRoleRepo.save(jobRole);
            responseDTO.setContent(jobRoleDTO);
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
    public ResponseDTO getJobRole (){
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            List<JobRole> jobRole = jobRoleRepo.findAll();
            List<JobRoleDTO> jobRoleDTOList = new ArrayList<>();
            for(JobRole jobRole1: jobRole){
                JobRoleDTO jobRoleDTO = modelMapper.map(jobRole1, JobRoleDTO.class);
                jobRoleDTOList.add(jobRoleDTO);
            }
            responseDTO.setContent(jobRoleDTOList);
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

    public ResponseDTO deleteJobRole (Long jrId){
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            jobRoleRepo.deleteById(jrId);
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
