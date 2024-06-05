package com.example.aasha.service;

import com.example.aasha.dto.*;
import com.example.aasha.entity.Staff;
import com.example.aasha.entity.StaffBank;
import com.example.aasha.entity.StaffEmergency;
import com.example.aasha.entity.StaffJob;
import com.example.aasha.repo.StaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StaffServiceImpl implements StaffService {
    private StaffRepo staffRepo;


    @Autowired
    public StaffServiceImpl(StaffRepo staffRepo) {
        this.staffRepo = staffRepo;
    }

    @Override
    public List<Staff> getAllStaffs() {
        return staffRepo.findAll();
    }

    @Override
    public Staff getStaffById(Long id) {
        return staffRepo.findById(id).orElseThrow(() -> new NoSuchElementException("StaffNotfound" + id));
    }

    @Override
    public Staff addStaff(Staff staff) {
        return staffRepo.save(staff);
    }

    @Override
    public Staff updateStaff(Long id, Staff updatedStaff) {
        // Fetch the existing staff entity from the database
        Staff existingStaff = staffRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Staff not found with id " + id));

        // Update the fields of the existing staff entity with the new values
        existingStaff.setSname(updatedStaff.getSname());
        existingStaff.setAddress(updatedStaff.getAddress());
        existingStaff.setHomePhone(updatedStaff.getHomePhone());
        existingStaff.setMobilePhone(updatedStaff.getMobilePhone());
        existingStaff.setNicno(updatedStaff.getNicno());
        existingStaff.setSemail(updatedStaff.getSemail());
        existingStaff.setSdob(updatedStaff.getSdob());
        existingStaff.setMaritalState(updatedStaff.getMaritalState());
        existingStaff.setSpouseName(updatedStaff.getSpouseName());
        existingStaff.setSpousePhone(updatedStaff.getSpousePhone());
        existingStaff.setIsMale(updatedStaff.getIsMale());
        existingStaff.setBloodGroup(updatedStaff.getBloodGroup());
        existingStaff.setAllergicTo(updatedStaff.getAllergicTo());

        // Update staffBank if it is provided
        if (updatedStaff.getStaffbank() != null) {
            StaffBank existingStaffBank = existingStaff.getStaffbank();
            StaffBank updatedStaffBank = updatedStaff.getStaffbank();

            if (existingStaffBank == null) {
                existingStaff.setStaffbank(updatedStaffBank);
                updatedStaffBank.setStaff(existingStaff);
            } else {
                existingStaffBank.setAccountNo(updatedStaffBank.getAccountNo());
                existingStaffBank.setBanker(updatedStaffBank.getBanker());
                existingStaffBank.setBranch(updatedStaffBank.getBranch());
                existingStaffBank.setAccountName(updatedStaffBank.getAccountName());
            }
        }

        if (updatedStaff.getStaffEmergency() != null) {
            StaffEmergency existingStaffEmergency = existingStaff.getStaffEmergency();
            StaffEmergency updatedStaffEmergency = updatedStaff.getStaffEmergency();

            if (existingStaffEmergency == null) {
                existingStaff.setStaffEmergency(updatedStaffEmergency);
                updatedStaffEmergency.setStaff(existingStaff);
            } else {
                existingStaffEmergency.setEpName(updatedStaffEmergency.getEpName());
                existingStaffEmergency.setEpAddress(updatedStaffEmergency.getEpAddress());
                existingStaffEmergency.setEpMobile(updatedStaffEmergency.getEpMobile());
                existingStaffEmergency.setRelationship(updatedStaffEmergency.getRelationship());
            }
        }

//        if (updatedStaff.getStaffJob() != null) {
//            StaffJob existingStaffJob = existingStaff.getStaffJob();
//            StaffJob updatedStaffJob = updatedStaff.getStaffJob();
//
//            if (existingStaffJob == null) {
//                existingStaff.setStaffJob(updatedStaffJob);
//                updatedStaffJob.setStaff(existingStaff);
//            } else {
//                existingStaffJob.setType (updatedStaffJob.getType());
//                existingStaffJob.setOfficialEmail(updatedStaffJob.getOfficialEmail());
//                existingStaffJob.setStartDate(updatedStaffJob.getStartDate());
//                existingStaffJob.setStartSalary(updatedStaffJob.getStartSalary());
//                existingStaffJob.setWorkPhone(updatedStaffJob.getWorkPhone());
//
//            }


        // Save the updated staff entity back to the database
        return staffRepo.save(existingStaff);
    }

    @Override
    public void deleteStaff(Long id) {
        staffRepo.deleteById(id);
    }

    @Override
    public StaffDTO convertToDTO(Staff staff) {
        StaffDTO staffDTO = new StaffDTO();
        staffDTO.setSid(staff.getSid());
        staffDTO.setSname(staff.getSname());
        staffDTO.setAddress(staff.getAddress());
        staffDTO.setHomePhone(staff.getHomePhone());
        staffDTO.setMobilePhone(staff.getMobilePhone());
        staffDTO.setNicno(staff.getNicno());
        staffDTO.setSemail(staff.getSemail());
        staffDTO.setSdob(staff.getSdob());
        staffDTO.setMaritalState(staff.getMaritalState());
        staffDTO.setSpouseName(staff.getSpouseName());
        staffDTO.setSpousePhone(staff.getSpousePhone());
        staffDTO.setIsMale(staff.getIsMale());
        staffDTO.setBloodGroup(staff.getBloodGroup());
        staffDTO.setAllergicTo(staff.getAllergicTo());

        if (staff.getStaffbank() != null) {
            StaffBank staffBank = staff.getStaffbank();
            StaffBankDTO staffBankDTO = new StaffBankDTO();
            staffBankDTO.setBanker(staffBank.getBanker());
            staffBankDTO.setBranch(staffBank.getBranch());
            staffBankDTO.setAccountNo(staffBank.getAccountNo());
            staffBankDTO.setAccountName(staffBank.getAccountName());
            staffDTO.setStaffBank(staffBankDTO);
        }

        if (staff.getStaffEmergency() != null) {
            StaffEmergency staffEmergency = staff.getStaffEmergency();
            StaffEmergencyDTO staffEmergencyDTO = new StaffEmergencyDTO();
            staffEmergencyDTO.setEpName(staffEmergency.getEpName());
            staffEmergencyDTO.setEpAddress(staffEmergency.getEpAddress());
            staffEmergencyDTO.setEpMobile(staffEmergency.getEpMobile());
            staffEmergencyDTO.setRelationship(staffEmergency.getRelationship());
            staffDTO.setStaffEmergency(staffEmergencyDTO);
        }

        if (staff.getStaffJob() != null) {
            StaffJob staffJob = staff.getStaffJob();
            StaffJobDTO staffJobDTO = new StaffJobDTO();
            staffJobDTO.setType(staffJob.getType());
            staffJobDTO.setOfficialEmail(staffJob.getOfficialEmail());
            staffJobDTO.setStartDate(staffJob.getStartDate());
            staffJobDTO.setStartSalary(staffJob.getStartSalary());
            staffJobDTO.setWorkPhone(staffJob.getWorkPhone());
            staffDTO.setStaffJob(staffJobDTO);
        }

        JobRoleDTO jobRoleDTO = new JobRoleDTO();
        jobRoleDTO.setJid(staff.getJobRole().getJid());
        jobRoleDTO.setJname(staff.getJobRole().getJname());
        staffDTO.setJobRole(jobRoleDTO);

        return staffDTO;
    }
}