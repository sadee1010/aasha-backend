package com.example.aasha.controler;

import com.example.aasha.dto.PrivateHotelDTO;
import com.example.aasha.entity.PrivateHotel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@CrossOrigin(origins = "*")
public interface PrivateHotelController {

    @GetMapping("/privatehotels")
    ResponseEntity<List<PrivateHotelDTO>> getAllPrivateHotels();

    @GetMapping("/privatehotels/{id}")
    ResponseEntity<PrivateHotelDTO> getPrivateHotelById(@PathVariable Long id);

    @PostMapping("/privatehotels")
    ResponseEntity<PrivateHotelDTO> savePrivateHotel(@RequestBody PrivateHotel privateHotel);

    @PutMapping("/privatehotels/{id}")
    ResponseEntity<PrivateHotelDTO> updatePrivateHotel(@PathVariable Long id, @RequestBody PrivateHotel privateHotel);

    @DeleteMapping("/privatehotels/{id}")
    ResponseEntity<Void> deletePrivateHotel(@PathVariable Long id);
}
