package com.example.aasha.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Private Hotel")
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PrivateHotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long phId;
    @Column
    private String phName;
    @OneToMany(mappedBy = "privateHotel" , fetch = FetchType.EAGER)
    @JsonBackReference
    private List<Booking> bookings;
}
