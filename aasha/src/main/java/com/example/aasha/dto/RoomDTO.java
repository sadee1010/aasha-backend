package com.example.aasha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomDTO {
    private Long rid;
    private String rname;
    private Integer capacity;
}
