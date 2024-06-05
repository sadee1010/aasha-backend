package com.example.aasha.controler;

import com.example.aasha.dto.StaffDTO;
import com.example.aasha.entity.Staff;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Service
@CrossOrigin(origins = "*")
public interface StaffController {

    @GetMapping("/staffs")
    ResponseEntity<List<StaffDTO>> getAllStaffs();

    @GetMapping("/staffs/{id}")
    ResponseEntity<StaffDTO> getStaffById(@PathVariable Long id);

    @PostMapping("/staffs")
    ResponseEntity<StaffDTO> saveStaff(@RequestBody Staff staffs);

    @PutMapping("staffs/{id}")
    ResponseEntity<StaffDTO> updateStaff(@PathVariable Long id, @RequestBody Staff staffs);

    @DeleteMapping("staffs/{id}")
    ResponseEntity<Void> deleteStaff(@PathVariable Long id);

}