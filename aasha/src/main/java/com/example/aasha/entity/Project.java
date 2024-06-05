package com.example.aasha.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prId;
    private String prName;
    @ManyToOne
    @JoinColumn (name = "category" , referencedColumnName = "pcId")
    private ProjectCategory projectCategory;

    @OneToMany(mappedBy = "project", fetch = FetchType.EAGER)
    private List<ProjectBooking> projectBookings;

}
