package com.example.aasha.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Private Hotel")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PrivateHotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long phId;
    @Column
    private String phName;
}
