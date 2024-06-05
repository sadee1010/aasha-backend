package com.example.aasha.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffJob {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sjid;

    @OneToOne(mappedBy = "staffJob", fetch = FetchType.LAZY)
    @JsonBackReference
    private Staff staff;



//    @OneToOne
//    @JoinColumn(name = "Name", referencedColumnName = "sid")
//    private Staff staff;
//    @OneToOne
//    @JoinColumn (name = "Designation", referencedColumnName = "jid")
//    private JobRole designation;

    private LocalDate startDate;
    private Integer startSalary;
    private String officialEmail;
    private String workPhone;
    private String type;

//    @OneToOne
//    @JoinColumn(name = "Reporting To", referencedColumnName = "sid")
//    private Staff reportingTo;



}
