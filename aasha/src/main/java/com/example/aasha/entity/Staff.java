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
@Table (name = "Staff")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sid;
    @Column
    private String sname;
    @Column
    private String address;
    @Column
    private String homePhone;
    @Column
    private String mobilePhone;
    @Column
    private String nicno;
    @Column
    private String semail;
    @Column
    private LocalDate sdob;
    @Column
    private String maritalState;
    @Column
    private String spouseName;
    @Column
    private String spousePhone;
    @Column
    private Boolean isMale;
    @Column
    private String bloodGroup;
    @Column
    private String allergicTo;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "accountNo")
    @JsonManagedReference
    private StaffBank staffBank;

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
