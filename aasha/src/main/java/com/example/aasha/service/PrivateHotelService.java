package com.example.aasha.service;

import com.example.aasha.dto.PrivateHotelDTO;
import com.example.aasha.entity.PrivateHotel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PrivateHotelService {
    List<PrivateHotel> getAllPrivateHotels();

    PrivateHotel getPrivateHotelById(Long id);

    PrivateHotel savePrivateHotel(PrivateHotel privateHotel);

    PrivateHotel updatePrivateHotel(Long id, PrivateHotel privateHotel);

    void deletePrivateHotel(Long id);

    public PrivateHotelDTO convertToDTO(PrivateHotel privateHotel);
}
