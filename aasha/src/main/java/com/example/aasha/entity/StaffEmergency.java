package com.example.aasha.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table (name = "Staff Emergency")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffEmergency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sepId;
    @Column
    private String epName;
    @Column
    private String epAddress;
    @Column
    private String epMobile;
    @Column
    private String relationship;

    @OneToOne(mappedBy = "staffEmergency", fetch = FetchType.LAZY)
    @JsonBackReference
    private Staff staff;

}
