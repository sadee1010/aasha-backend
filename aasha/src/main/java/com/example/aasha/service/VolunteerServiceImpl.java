package com.example.aasha.service;

import com.example.aasha.dto.ResponseDTO;
import com.example.aasha.dto.VolunteerDTO;
import com.example.aasha.entity.Volunteer;
import com.example.aasha.repo.VolunteerRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class VolunteerServiceImpl implements VolunteerService {

    private VolunteerRepo volunteerRepo;

    @Autowired
    public VolunteerServiceImpl(VolunteerRepo volunteerRepo) {
        this.volunteerRepo = volunteerRepo;
    }

@Override
    public List<Volunteer> getAllVolunteers() {
        return volunteerRepo.findAll();
    }

@Override
    public Volunteer getVolunteerById(Long id) {
        return volunteerRepo.findById(id).orElseThrow(() -> new NoSuchElementException("VolunteerNotfound" + id));
    }

@Override
    public Volunteer addVolunteer(Volunteer volunteer) {
        return volunteerRepo.save(volunteer);
    }

@Override
    public Volunteer updateVolunteer(Long id, Volunteer volunteer) {
        Volunteer existingVolunteer = getVolunteerById(id);

        existingVolunteer.setFirstName(volunteer.getFirstName());
        existingVolunteer.setLastName(volunteer.getLastName());
        existingVolunteer.setDob(volunteer.getDob());
        existingVolunteer.setIsMale(volunteer.getIsMale());
        existingVolunteer.setNationality(volunteer.getNationality());
        existingVolunteer.setMobileNo(volunteer.getMobileNo());
        existingVolunteer.setEmail(volunteer.getEmail());

        return volunteerRepo.save(existingVolunteer);
    }

    @Override
    public Volunteer deleteVolunteer(Long id) {
        return null;
    }


//@Override
//    public void deleteVolunteer(Long id) {
//        volunteerRepo.deleteById(id);
//    }
}

//    @Autowired
//    VolunteerRepo volunteerRepo;
//    @Autowired
//    ModelMapper modelMapper;
//
//    public ResponseDTO print(String name){
//        ResponseDTO responseDTO = new ResponseDTO();
//        responseDTO.setResponseCode("00");
//        responseDTO.setResponseMsg("succress");
//        responseDTO.setContent(name);
//        return responseDTO;
//    }
//    public ResponseDTO saveVolunteer(VolunteerDTO volunteerDTO){
//        ResponseDTO responseDTO = new ResponseDTO();
//        try{
//            Volunteer volunteer = modelMapper.map(volunteerDTO, Volunteer.class);
//
////            volunteer.setId(volunteerDTO.getId());
////            volunteer.setFirstName(volunteerDTO.getFirstName());
////            volunteer.setLastName(volunteerDTO.getLastName());
////            volunteer.setDob(volunteerDTO.getDob());
////            volunteer.setIsMale(volunteerDTO.getIsMale());
////            volunteer.setNationality(volunteerDTO.getNationality());
////            volunteer.setMobileNo(volunteerDTO.getMobileNo());
////            volunteer.setEmail(volunteerDTO.getEmail());
//            volunteerRepo.save(volunteer);
//            responseDTO.setContent(volunteerDTO);
//            responseDTO.setResponseMsg("success");
//            responseDTO.setResponseCode("00");
//            responseDTO.setHttpStatus(HttpStatus.ACCEPTED);
//        }catch (Exception e){
//            System.out.println(e);
//            responseDTO.setContent(null);
//            responseDTO.setResponseMsg("Failed");
//            responseDTO.setResponseCode("99");
//            responseDTO.setHttpStatus(HttpStatus.CONFLICT);
//        }
//
//        return responseDTO;
//    }
//    public ResponseDTO getVolunteer (){
//        ResponseDTO responseDTO = new ResponseDTO();
//        try{
//        List<Volunteer> volunteer = volunteerRepo.findAll();
//        List<VolunteerDTO> volunteerDTOList = new ArrayList<>();
//        for(Volunteer volunteer1: volunteer){
//            VolunteerDTO volunteerDTO = modelMapper.map(volunteer1, VolunteerDTO.class);
//            volunteerDTOList.add(volunteerDTO);
//        }
//        responseDTO.setContent(volunteerDTOList);
//        responseDTO.setResponseMsg("success");
//        responseDTO.setResponseCode("00");
//        responseDTO.setHttpStatus(HttpStatus.ACCEPTED);
//    }catch (Exception e){
//        System.out.println(e);
//        responseDTO.setContent(null);
//        responseDTO.setResponseMsg("Failed");
//        responseDTO.setResponseCode("99");
//        responseDTO.setHttpStatus(HttpStatus.CONFLICT);
//    }
//
//        return responseDTO;
//    }
//
//    public ResponseDTO deleteVolunteer(Long id){
//        ResponseDTO responseDTO = new ResponseDTO();
//        try{
//            volunteerRepo.deleteById(id);
//            responseDTO.setContent(null);
//            responseDTO.setResponseMsg("success");
//            responseDTO.setResponseCode("00");
//            responseDTO.setHttpStatus(HttpStatus.ACCEPTED);
//        }catch (Exception e){
//            System.out.println(e);
//            responseDTO.setContent(null);
//            responseDTO.setResponseMsg("Failed");
//            responseDTO.setResponseCode("99");
//            responseDTO.setHttpStatus(HttpStatus.CONFLICT);
//        }
//        return responseDTO;
//    }

