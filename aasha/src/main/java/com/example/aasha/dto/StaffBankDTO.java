package com.example.aasha.dto;

import com.example.aasha.entity.Staff;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffBankDTO {
    private Long sbid;
    private String banker;
    private String branch;
    private String accountNo;
    private String accountName;
    private StaffDTO staff;

}
