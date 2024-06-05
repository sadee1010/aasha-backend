package com.example.aasha.dto;

import com.example.aasha.entity.Staff;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffEmergencyDTO {
    private Long sepId;
    private String epName;
    private String epAddress;
    private String epMobile;
    private String relationship;
    private StaffDTO staff;
}
