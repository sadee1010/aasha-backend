package com.example.aasha.service;

import com.example.aasha.dto.PrivateHotelDTO;
import com.example.aasha.dto.ProjectCategoryDTO;
import com.example.aasha.dto.ResponseDTO;
import com.example.aasha.entity.PrivateHotel;
import com.example.aasha.entity.ProjectCategory;
import com.example.aasha.repo.PrivateHotelRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrivateHotelService {
    @Autowired
    PrivateHotelRepo privateHotelRepo;
    @Autowired
    ModelMapper modelMapper;

    public ResponseDTO savePrivateHotel (PrivateHotelDTO privateHotelDTO){
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            PrivateHotel privateHotel = modelMapper.map(privateHotelDTO, PrivateHotel.class);

            privateHotelRepo.save(privateHotel);
            responseDTO.setContent(privateHotelDTO);
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

    public ResponseDTO getPrivateHotel (){
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            List<PrivateHotel> privateHotel = privateHotelRepo.findAll();
            List<PrivateHotelDTO> privateHotelDTOList = new ArrayList<>();
            for (PrivateHotel privateHotel1: privateHotel) {
                PrivateHotelDTO privateHotelDTO = modelMapper.map(privateHotel1, PrivateHotelDTO.class);
                privateHotelDTOList.add(privateHotelDTO);
            }
            responseDTO.setContent(privateHotelDTOList);
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

    public ResponseDTO deletePrivateHotel (Long id){
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            privateHotelRepo.deleteById(id);
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
