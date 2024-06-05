package com.example.aasha.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "accountNo")
    @JsonManagedReference
    private StaffBank staffbank;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "sepId")
    @JsonManagedReference
    private StaffEmergency staffEmergency;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "sjid")
    @JsonManagedReference
    private StaffJob staffJob;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "jid")
//    @JsonManagedReference
    private JobRole jobRole;


//    @OneToOne
//    private StaffJob reportingTo;

}
