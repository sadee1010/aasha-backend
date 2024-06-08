package com.example.aasha.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Staff Job")
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

    @Column
    private LocalDate startDate;
    @Column
    private Integer startSalary;
    @Column
    private String officialEmail;
    @Column
    private String workPhone;
    @Column
    private String type;

//    @OneToOne
//    @JoinColumn(name = "Reporting To", referencedColumnName = "sid")
//    private Staff reportingTo;

}
