package com.example.aasha.dto;

import com.example.aasha.entity.Staff;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobRoleDTO {
    private Long jid;
    private String jname;
    private List<StaffDTO> staffs;
}
