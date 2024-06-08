package com.example.aasha.controler;

import com.example.aasha.dto.PrivateHotelDTO;
import com.example.aasha.entity.PrivateHotel;
import com.example.aasha.service.PrivateHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PrivateHotelControllerImpl implements PrivateHotelController{
    private final PrivateHotelService privateHotelService;

    @Autowired
    public PrivateHotelControllerImpl(PrivateHotelService privateHotelService) {
        this.privateHotelService = privateHotelService;
    }

    @Override
    public ResponseEntity<List<PrivateHotelDTO>> getAllPrivateHotels() {
        List<PrivateHotelDTO> privateHotelDTOs = privateHotelService.getAllPrivateHotels()
                .stream()
                .map(privateHotelService::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(privateHotelDTOs);
    }

    @Override
    public ResponseEntity<PrivateHotelDTO> getPrivateHotelById(@PathVariable Long id) {
        PrivateHotelDTO privateHotelDTO = privateHotelService.convertToDTO(privateHotelService.getPrivateHotelById(id));
        return ResponseEntity.status(HttpStatus.OK).body(privateHotelDTO);
    }

    @Override
    public ResponseEntity<PrivateHotelDTO> savePrivateHotel(@RequestBody PrivateHotel privateHotel) {
        PrivateHotel newPrivateHotel = privateHotelService.savePrivateHotel(privateHotel);
        PrivateHotelDTO newPrivateHotelDTO = privateHotelService.convertToDTO(newPrivateHotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPrivateHotelDTO);
    }

    @Override
    public ResponseEntity<PrivateHotelDTO> updatePrivateHotel(@PathVariable Long id, @RequestBody PrivateHotel privateHotel) {
        PrivateHotel updatedPrivateHotel = privateHotelService.updatePrivateHotel(id, privateHotel);
        PrivateHotelDTO updatedPrivateHotelDTO = privateHotelService.convertToDTO(updatedPrivateHotel);
        return ResponseEntity.status(HttpStatus.OK).body(updatedPrivateHotelDTO);
    }

    @Override
    public ResponseEntity<Void> deletePrivateHotel(@PathVariable Long id) {
        privateHotelService.deletePrivateHotel(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
