package com.example.aasha.dto;

import com.example.aasha.entity.JobRole;
import com.example.aasha.entity.Staff;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffJobDTO {
    private Long sjid;
    private StaffDTO staff;
    private JobRoleDTO designation;
    private LocalDate startDate;
    private Integer startSalary;
    private String officialEmail;
    private String workPhone;
    private String type;
    private StaffDTO reportingTo;
}
