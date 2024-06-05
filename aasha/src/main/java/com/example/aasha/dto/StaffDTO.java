package com.example.aasha.dto;

import com.example.aasha.entity.JobRole;
import com.example.aasha.entity.StaffBank;
import com.example.aasha.entity.StaffEmergency;
import com.example.aasha.entity.StaffJob;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffDTO {
    private Long sid;
    private String sname;
    private String address;
    private String homePhone;
    private String mobilePhone;
    private String nicno;
    private String semail;
    private LocalDate sdob;
    private String maritalState;
    private String spouseName;
    private String spousePhone;
    private Boolean isMale;
    private String bloodGroup;
    private String allergicTo;
    private JobRoleDTO jobRole;
    private StaffBankDTO staffBank;
    private StaffEmergencyDTO staffEmergency;
    private StaffJobDTO staffJob;
}
