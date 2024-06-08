package com.example.aasha.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Project")
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prId;
    @Column
    private String prName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "category")
    private ProjectCategory projectCategory;

    @OneToMany(mappedBy = "project", fetch = FetchType.EAGER)
//    @JsonBackReference
    private List<Booking> bookings;

}
