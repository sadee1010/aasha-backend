package com.example.aasha.service;

import com.example.aasha.dto.ResponseDTO;
import com.example.aasha.dto.StaffBankDTO;
import com.example.aasha.dto.StaffDTO;
import com.example.aasha.entity.StaffBank;
import com.example.aasha.repo.StaffRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.example.aasha.entity.Staff;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public interface StaffService {
    List<Staff> getAllStaffs();

    Staff getStaffById(Long id);

    Staff addStaff(Staff staff);

    Staff updateStaff(Long id, Staff staff);
    void deleteStaff(Long id);

    public StaffDTO convertToDTO (Staff staff);

//    Staff deleteStaff(Long id);

//    @Autowired
//    StaffRepo staffRepo;
//    @Autowired
//    ModelMapper modelMapper;
//
//    public ResponseDTO saveStaff(StaffDTO staffDTO){
//        ResponseDTO responseDTO = new ResponseDTO();
//        try{
//            Staff staff = modelMapper.map(staffDTO, Staff.class);
//
//            staffRepo.save(staff);
//            responseDTO.setContent(staffDTO);
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

//    public ResponseDTO saveBankInfo(StaffBankDTO staffBankDTO){
//        ResponseDTO responseDTO = new ResponseDTO();
//        try{
//            StaffBank staffBank = modelMapper.map(staffBankDTO, StaffBank.class);
//            Staff staff = modelMapper.map(staffBankDTO.getStaff(), Staff.class);
//            StaffBank staffBank = new StaffBank();
//            staff.setStaffBank(modelMapper.map(staffDTO.getStaffBank(), StaffBank.class));
//
//            staffBank.setAccountNo(staffDTO.getStaffBank().getAccountNo());
//            staffBank.setStaff(staff);
//            staffRepo.save(staff);
//            responseDTO.setContent(staffBankDTO);
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

//    public ResponseDTO getStaff (){
//        ResponseDTO responseDTO = new ResponseDTO();
//        try{
//            List<Staff> staff = staffRepo.findAll();
//            List<StaffDTO> staffDTOList = new ArrayList<>();
//            for(Staff staff1: staff){
//                StaffDTO staffDTO = new StaffDTO();
//                StaffBankDTO staffBankDTO = new StaffBankDTO();
//                staffDTO.setSid(staff1.getSid());
//                staffDTO.setSname(staff1.getSname());
//                staffDTO.setAddress(staff1.getAddress());
//                staffDTO.setHomePhone(staff1.getHomePhone());
//                staffDTO.setMobilePhone(staff1.getMobilePhone());
//                staffDTO.setIsMale(staff1.getIsMale());
//                staffDTO.setNicno(staff1.getNicno());
//                staffDTO.setSemail(staff1.getSemail());
//                staffDTO.setSdob(staff1.getSdob());
//                staffDTO.setMaritalState(staff1.getMaritalState());
//                staffDTO.setSpouseName(staff1.getSpouseName());
//                staffDTO.setSpousePhone(staff1.getSpousePhone());
//                staffDTO.setBloodGroup(staff1.getBloodGroup());
//                staffDTO.setAllergicTo(staff1.getAllergicTo());
////                staffBankDTO.setSbid(staff1.getStaffBank().getSbid());
//                staffBankDTO.setBanker(staff1.getStaffBank().getBanker());
//                staffBankDTO.setBranch(staff1.getStaffBank().getBranch());
//                staffBankDTO.setAccountNo(staff1.getStaffBank().getAccountNo());
//                staffBankDTO.setAccountName(staff1.getStaffBank().getAccountName());
//                staffDTO.setStaffBank(staffBankDTO);
//                staffDTOList.add(staffDTO);
//            }
//            responseDTO.setContent(staffDTOList);
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
//
//    public ResponseDTO deleteStaff(Long id){
//        ResponseDTO responseDTO = new ResponseDTO();
//        try{
//            staffRepo.deleteById(id);
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
//
//        return responseDTO;
//    }
//
//    public ResponseDTO updateStaff( StaffDTO staffDTO){
//        ResponseDTO responseDTO = new ResponseDTO();
//        try{
//            Staff staff = modelMapper.map(staffDTO, Staff.class);
//            staff.setSid(staffDTO.getSid());
//            System.out.println(staff.getSid() );
//
//            staffRepo.saveAndFlush(staff);
//            responseDTO.setContent(staffDTO);
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
}
