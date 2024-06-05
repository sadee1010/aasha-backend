package com.example.aasha.controler;

import com.example.aasha.dto.ResponseDTO;
import com.example.aasha.dto.StaffDTO;
import com.example.aasha.entity.Staff;
import com.example.aasha.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController

    public class StaffControllerImpl implements StaffController {
        private final StaffService staffService;

        @Autowired
        public StaffControllerImpl(StaffService staffService) {
            this.staffService = staffService;
        }

        @Override
        public ResponseEntity<List<StaffDTO>> getAllStaffs() {
            List<StaffDTO> staffDTOs = staffService.getAllStaffs()
                    .stream()
                    .map(staffService::convertToDTO)
                    .collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.OK).body(staffDTOs);
        }

        @Override
        public ResponseEntity<StaffDTO> getStaffById(@PathVariable Long id) {
            StaffDTO staffDTO = staffService.convertToDTO(staffService.getStaffById(id));
            return ResponseEntity.status(HttpStatus.OK).body(staffDTO);
        }

        @Override
        public ResponseEntity<StaffDTO> saveStaff(@RequestBody Staff staff) {
            Staff newStaff = staffService.addStaff(staff);
            StaffDTO newStaffDTO = staffService.convertToDTO(newStaff);
            return ResponseEntity.status(HttpStatus.CREATED).body(newStaffDTO);
        }

        @Override
        public ResponseEntity<StaffDTO> updateStaff(@PathVariable Long id, @RequestBody Staff staff) {
            Staff updatedStaff = staffService.updateStaff(id, staff);
            StaffDTO updatedStaffDTO = staffService.convertToDTO(updatedStaff);
            return ResponseEntity.status(HttpStatus.OK).body(updatedStaffDTO);
        }

        @Override
        public ResponseEntity<Void> deleteStaff(@PathVariable Long id) {
            staffService.deleteStaff(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
    }
//    @Autowired
//    StaffService staffService;
//
//
//    @PostMapping("/save")
//    public ResponseEntity saveStaff(@RequestBody StaffDTO staffDTO){
//        ResponseDTO responseDTO =  staffService.saveStaff(staffDTO);
//        System.out.println(responseDTO.getContent());
//        return new ResponseEntity(responseDTO,responseDTO.getHttpStatus());
//    }
//
//    @GetMapping( "/get")
//    public ResponseEntity getStaff (){
//        ResponseDTO responseDTO = staffService.getStaff();
//        return new ResponseEntity(responseDTO,responseDTO.getHttpStatus());
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity deleteStaff(@PathVariable Long sId){
//        ResponseDTO responseDTO = staffService.deleteStaff(sId);
//        return new ResponseEntity(responseDTO,responseDTO.getHttpStatus());
//    }
//
//    @PutMapping("/update")
//    public ResponseEntity updateStaffPut(@RequestBody StaffDTO staffDTO){
//        System.out.println("updateStaffPut++++++++++++++++++++++++++++");
//        ResponseDTO responseDTO = staffService.updateStaff(staffDTO);
//        return new ResponseEntity(responseDTO,responseDTO.getHttpStatus());
//    }

