package com.example.aasha.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Job Role")
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class JobRole {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long jid;
    @Column
    private String jname;
    @OneToMany(mappedBy = "jobRole", fetch = FetchType.EAGER)
    @JsonBackReference
    private List<Staff> staffs;
//    @OneToMany(mappedBy = "designation" ,  fetch = FetchType.EAGER)
//    private List<Staff> staffList;
//    @OneToMany(mappedBy = "jobRole" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Staff> staffList;
}
