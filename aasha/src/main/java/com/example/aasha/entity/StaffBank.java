package com.example.aasha.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffBank {
    @Id
    private String accountNo;
    private String banker;
    private String branch;
    private String accountName;
    @OneToOne(mappedBy = "staffbank", fetch = FetchType.LAZY)
    @JsonBackReference
    private Staff staff;

}
