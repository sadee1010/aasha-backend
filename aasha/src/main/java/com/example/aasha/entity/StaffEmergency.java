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
public class StaffEmergency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sepId;
    private String epName;
    private String epAddress;
    private String epMobile;
    private String relationship;

    @OneToOne(mappedBy = "staffEmergency", fetch = FetchType.LAZY)
    @JsonBackReference
    private Staff staff;

}
