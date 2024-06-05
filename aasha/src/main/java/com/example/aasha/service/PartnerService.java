package com.example.aasha.service;

import com.example.aasha.dto.PartnerDTO;
import com.example.aasha.dto.ResponseDTO;
import com.example.aasha.entity.Partner;
import com.example.aasha.entity.PrivateHotel;
import com.example.aasha.repo.PartnerRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class PartnerService {
    @Autowired
    PartnerRepo partnerRepo;
    @Autowired
    ModelMapper modelMapper;

    public ResponseDTO savePartner(PartnerDTO partnerDTO){
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            Partner partners = modelMapper.map(partnerDTO, Partner.class);

            partnerRepo.save(partners);
            responseDTO.setContent(partnerDTO);
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

    public ResponseDTO getPartner (){
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            List<Partner> partner = partnerRepo.findAll();
            List<PartnerDTO> partnerDTOList = new ArrayList<>();
            for (Partner partner1: partner) {
                PartnerDTO partnerDTO = modelMapper.map(partner1, PartnerDTO.class);
                partnerDTOList.add(partnerDTO);
            }
            responseDTO.setContent(partnerDTOList);
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

    public ResponseDTO deletePartner(Long id){
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            partnerRepo.deleteById(id);
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
