package com.example.aasha.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "Staff Bank")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffBank {
    @Id
    private String accountNo;
    @Column
    private String banker;
    @Column
    private String branch;
    @Column
    private String accountName;
    @OneToOne(mappedBy = "staffBank", fetch = FetchType.LAZY)
    @JsonBackReference
    private Staff staff;

}
