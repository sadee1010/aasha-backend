package com.example.aasha.dto.responses;

import lombok.Data;

@Data
public class jwtResponse {
    private String token;
    private Long id;
    private String username;
    private String email;
    private String role;

    public jwtResponse(String token, Long id, String username, String email, String role){
        this.token=token;
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = role;

    }
}
